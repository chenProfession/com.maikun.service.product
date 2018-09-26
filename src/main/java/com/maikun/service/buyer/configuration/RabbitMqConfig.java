package com.maikun.service.buyer.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @program: products
 * @Description: RabbitMq配置
 * @author: Mr.Cheng
 * @date: 2018/9/22 上午3:25
 */
@Configuration
public class RabbitMqConfig {

    @Value("${mq.requestProductsQueueRoutingKey}")
    private String requestProductsQueueRoutingKey;

    @Value("${mq.responseProductsQueueRoutingKey}")
    private String responseProductsQueueRoutingKey;

    @Autowired
    private QueueConfig queueConfig;

    @Autowired
    private ExchangeConfig exchangeConfig;

    /**
     * 连接工厂
     */


    /**
     将消息队列1和交换机进行绑定
     */
    @Bean
    public Binding bindingRequestProductsQueue() {
        return BindingBuilder.bind(queueConfig.requestProductsQueue())
                .to(exchangeConfig.productDirectExchange())
                .with(requestProductsQueueRoutingKey);
    }

    /**
     * 将消息队列2和交换机进行绑定
     */
    @Bean
    public Binding bindingResponseProductsQueue() {
        return BindingBuilder.bind(queueConfig.responseProductsQueue())
                .to(exchangeConfig.productDirectExchange())
                .with(responseProductsQueueRoutingKey);
    }

    @Bean
    public CachingConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setAddresses("193.112.35.196:5672");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        cachingConnectionFactory.setChannelCacheSize(10);
        cachingConnectionFactory.setConnectionLimit(3);
        cachingConnectionFactory.setConnectionTimeout(30000);
        cachingConnectionFactory.setPublisherConfirms(true);
        cachingConnectionFactory.setPublisherReturns(true);
        return cachingConnectionFactory;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory containerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer){
        SimpleRabbitListenerContainerFactory factory=new SimpleRabbitListenerContainerFactory();
        factory.setConcurrentConsumers(500);
        factory.setPrefetchCount(5);
        configurer.configure(factory,rabbitConnectionFactory());
        return factory;
    }

    /**
     * 定义rabbit template用于数据的接收和发送
     * @return
     */
    @Bean
    public RabbitTemplate rabbitTemplate() {

        RabbitTemplate template = new RabbitTemplate(rabbitConnectionFactory());

        /**若使用confirm-callback或return-callback，
         * 必须要配置publisherConfirms或publisherReturns为true
         * 每个rabbitTemplate只能有一个confirm-callback和return-callback
         */
        template.setConfirmCallback(msgSendConfirmCallBack());

        /**
         * 使用return-callback时必须设置mandatory为true，或者在配置中设置mandatory-expression的值为true，
         * 可针对每次请求的消息去确定’mandatory’的boolean值，
         * 只能在提供’return -callback’时使用，与mandatory互斥
         */
        template.setReturnCallback(msgSendReturnCallback());
        template.setMandatory(true);

        template.setReplyTimeout(60000);

        return template;
    }

    /**
     * 关于 msgSendConfirmCallBack 和 msgSendReturnCallback 的回调说明：
     * 1.如果消息没有到exchange,则confirm回调,ack=false
     * 2.如果消息到达exchange,则confirm回调,ack=true
     * 3.exchange到queue成功,则不回调return
     * 4.exchange到queue失败,则回调return(需设置mandatory=true,否则不回回调,消息就丢了)
     */

    /**
     * 消息确认机制
     * Confirms给客户端一种轻量级的方式，能够跟踪哪些消息被broker处理，
     * 哪些可能因为broker宕掉或者网络失败的情况而重新发布。
     * 确认并且保证消息被送达，提供了两种方式：发布确认和事务。(两者不可同时使用)
     * 在channel为事务时，不可引入确认模式；同样channel为确认模式下，不可使用事务。
     * @return
     */
    @Bean
    public MsgSendConfirmCallBack msgSendConfirmCallBack(){
        return new MsgSendConfirmCallBack();
    }

    @Bean
    public MsgSendReturnCallback msgSendReturnCallback(){
        return new MsgSendReturnCallback();
    }

    @Bean
    public RabbitAdmin admin() {
        return new RabbitAdmin(rabbitConnectionFactory());
    }
}

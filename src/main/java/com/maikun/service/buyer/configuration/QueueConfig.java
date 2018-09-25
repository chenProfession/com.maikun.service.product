package com.maikun.service.buyer.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: products
 * @Description: 队列配置  可以配置多个队列
 * @author: Mr.Cheng
 * @date: 2018/9/22 上午3:07
 */
@Configuration
public class QueueConfig {

    @Value("${mq.requestProductsQueue}")
    private String requestProductsQueueName;

    @Value("${mq.responseProductsQueue}")
    private String responseProductsQueueName;

    @Bean
    public Queue requestProductsQueue() {
        /**
         durable="true" 持久化 rabbitmq重启的时候不需要创建新的队列
         auto-delete 表示消息队列没有在使用时将被自动删除 默认是false
         exclusive  表示该消息队列是否只在当前connection生效,默认是false
         */

        /** 是否持久化 */
        boolean durable = true;

        /** 仅创建者可以使用的私有队列，断开后自动删除 */
        boolean exclusive = false;

        /** 当所有消费客户端连接断开后，是否自动删除队列 */
        boolean autoDelete = false;

        return new Queue(requestProductsQueueName,durable,exclusive,autoDelete);
    }

    @Bean
    public Queue responseProductsQueue() {
        /** 是否持久化 */
        boolean durable = true;

        /** 仅创建者可以使用的私有队列，断开后自动删除 */
        boolean exclusive = false;

        /** 当所有消费客户端连接断开后，是否自动删除队列 */
        boolean autoDelete = false;

        return new Queue(responseProductsQueueName,durable,exclusive,autoDelete);
    }
}

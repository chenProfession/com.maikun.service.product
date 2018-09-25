package com.maikun.service.buyer.sender;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: products
 * @Description: 消息发送  生产者
 * @author: Mr.Cheng
 * @date: 2018/9/24 下午1:02
 */
@Component
@Slf4j
public class FirstSender {

    @Value("${mq.productDirectExchange}")
    private String productDirectExchangeName;

    @Value("${mq.requestProductsQueueRoutingKey}")
    private String requestProductsQueueRoutingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String uuid,Object message) {
        log.info("Exchange:[{}],Queue Key:[{}]",productDirectExchangeName,requestProductsQueueRoutingKey);
        /** 将 msgId和 CorrelationData绑定 */
        CorrelationData correlationId = new CorrelationData(uuid);

        /** 将 msgId和 message绑定 */
        Gson gson = new Gson();
        String json = gson.toJson(message);
        Message messageSend = MessageBuilder.withBody(json.getBytes())
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setCorrelationId(uuid).build();

        rabbitTemplate.convertAndSend(productDirectExchangeName, requestProductsQueueRoutingKey,
                messageSend, correlationId);

        log.info("it is sent into the queue");
    }
}

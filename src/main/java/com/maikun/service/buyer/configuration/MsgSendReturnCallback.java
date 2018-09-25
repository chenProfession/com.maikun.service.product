package com.maikun.service.buyer.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @program: products
 * @Description:
 * @author: Mr.Cheng
 * @date: 2018/9/24 下午2:38
 */
@Slf4j
public class MsgSendReturnCallback implements RabbitTemplate.ReturnCallback{
    /**
     * Returned message callback.
     *
     * @param message    the returned message.
     * @param replyCode  the reply code.
     * @param replyText  the reply text.
     * @param exchange   the exchange.
     * @param routingKey the routing key.
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("回馈消息：[{}]",message);
    }
}

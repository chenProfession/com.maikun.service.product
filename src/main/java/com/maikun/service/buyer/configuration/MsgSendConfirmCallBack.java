package com.maikun.service.buyer.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;

/**
 * @program: products
 * @Description: 消息发送到交换机确认机制
 * @author: Mr.Cheng
 * @date: 2018/9/22 上午6:34
 */
@Slf4j
public class MsgSendConfirmCallBack implements RabbitTemplate.ConfirmCallback {

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        log.info("MsgSendConfirmCallBack  , return id:" + correlationData);
        if (b) {
            log.info("Consume message successfully");

        } else {
            log.info("Failed to consume message:" + s+"\nsend message again");
        }
    }
}

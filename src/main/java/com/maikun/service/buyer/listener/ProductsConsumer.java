package com.maikun.service.buyer.listener;

import com.maikun.service.buyer.asynctask.DeferredResultService;
import com.maikun.service.buyer.result.ResultService;
import com.maikun.service.buyer.result.ResultVO;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: products
 * @Description: 消息消费者
 * @author: Mr.Cheng
 * @date: 2018/9/24 下午1:17
 */
@Component
@Slf4j
public class ProductsConsumer {

    @Autowired
    private DeferredResultService deferredResultService;

    @Autowired
    private ResultService resultService;

    /**
     * Callback for processing a received Rabbit message.
     * <p>Implementors are supposed to process the given Message,
     * typically sending reply messages through the given Session.
     *
     * @param message the received AMQP message (never <code>null</code>)
     * @param channel the underlying Rabbit Channel (never <code>null</code>)
     * @throws Exception Any.
     */
    @RabbitListener(queues = "requestProductsQueue", containerFactory = "containerFactory")
    public void processMessage(Message message, Channel channel) throws Exception {
        /** 处理消息 */
        log.info("FirstConsumer handleMessage :[{}]",new String(message.getBody()));

        /** 查找对应商店ID的产品列表 */
        ResultVO resultVO = resultService.success();

        /** 获取对应用户的DeferredResult */
        try{
            if(deferredResultService.makeDeferredResult(message.getMessageProperties().getCorrelationId(),resultVO)){
                log.info("set the result");
                /**
                 * 那么当收到消息后，如果要否认，或确认则通过调用channel对象的下面的两个方法即可,
                 * 其中basicAck进行确认,
                 * 而basicNack进行否认.
                 */
                channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            }
        }catch (Exception e){
            log.error("can not receive the message",e);
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
        }

    }
}

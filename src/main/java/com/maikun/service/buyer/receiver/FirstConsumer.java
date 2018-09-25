package com.maikun.service.buyer.receiver;

import com.maikun.service.buyer.asynctask.DeferredResultHolder;
import com.maikun.service.buyer.result.ResultService;
import com.maikun.service.buyer.result.ResultVO;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
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
public class FirstConsumer implements ChannelAwareMessageListener {

    @Autowired
    private DeferredResultHolder deferredResultHolder;

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
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        /** 处理消息 */
        log.info("FirstConsumer handleMessage :[{}]",message);

        /** 查找对应商店ID的产品列表 */
        log.info("根据商店ID查找产品列表 :[{}]");
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("success");

        /** 获取对应用户的DeferredResult */
        log.info("发出请求用户 :[{}]",message.getMessageProperties().getCorrelationId());

        deferredResultHolder.getMap().get(message.getMessageProperties().getCorrelationId())
                .setResult(resultVO);
        /**
         * 那么当收到消息后，如果要否认，或确认则通过调用channel对象的下面的两个方法即可,
         * 其中basicAck进行确认,
         * 而basicNack进行否认.
         */
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}

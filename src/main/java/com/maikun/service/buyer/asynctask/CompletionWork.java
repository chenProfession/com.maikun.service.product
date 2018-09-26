package com.maikun.service.buyer.asynctask;

import com.maikun.service.buyer.result.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @program: products
 * @Description: 完成任务后
 * @author: Mr.Cheng
 * @date: 2018/9/27 上午3:01
 */
@Slf4j
public class CompletionWork implements Runnable{

    private String correlationId;

    private  DeferredResultService deferredResultService;

    public CompletionWork(String correlationId, DeferredResultService deferredResultService) {
        this.correlationId = correlationId;
        this.deferredResultService = deferredResultService;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        deferredResultService.removeDeferredResult(correlationId);
        log.info("release the deferredResult :[{}]",correlationId);
    }
}

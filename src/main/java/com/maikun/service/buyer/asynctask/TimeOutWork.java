package com.maikun.service.buyer.asynctask;

import com.maikun.service.buyer.enums.ResultEnum;
import com.maikun.service.buyer.result.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @program: products
 * @Description: 超时处理任务TimeOutWork
 * @author: Mr.Cheng
 * @date: 2018/9/27 上午2:50
 */
@Slf4j
public class TimeOutWork implements Runnable{

    private DeferredResult<ResultVO> deferredResult;

    public TimeOutWork(DeferredResult<ResultVO> deferredResult) {
        this.deferredResult = deferredResult;
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
        log.warn("Time out!");
        ResultVO msg = new ResultVO();
        msg.setCode(ResultEnum.FAILED.getCode());
        msg.setMsg("Time out!");
        deferredResult.setErrorResult(msg);
    }
}

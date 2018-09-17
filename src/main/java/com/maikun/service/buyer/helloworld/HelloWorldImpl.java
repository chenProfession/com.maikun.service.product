package com.maikun.service.buyer.helloworld;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.TimeUnit;

/**
 * @program: products
 * @Description: to test async thread
 * @author: Mr.Cheng
 * @date: 2018/9/17 下午3:11
 */
@Service
@Slf4j
public class HelloWorldImpl implements HelloWorldService{

    /**
     * @Description: 测试异步无返回值
     * @Param: []
     * @return: void
     * @Author: Mr.Cheng
     * @Date: 2018/9/17 下午3:23
     */
    @Async
    @Override
    public String sayHello() {
        log.info("进入hello service。。。");
        try {
            Thread.sleep(3000);
            log.info("3S后数据开始处理中。。");
        } catch (InterruptedException e) {
            log.error("hello service发生错误", e);
        }
        return "hello";
    }

}

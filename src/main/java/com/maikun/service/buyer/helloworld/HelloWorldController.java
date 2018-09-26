package com.maikun.service.buyer.helloworld;

import com.maikun.service.buyer.asynctask.DeferredResultHolder;
import com.maikun.service.buyer.result.ResultService;
import com.maikun.service.buyer.result.ResultVO;
import com.maikun.service.buyer.sender.FirstSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @program: products
 * @Description: simple api for testing
 * @author: Mr.Cheng
 * @date: 2018/9/5 下午4:34
 */
@RestController
@RequestMapping(value = "/hello")
@Slf4j
public class HelloWorldController {

    private final String TEST_WORDS = "{'content':'Demo for Maikun Restful Web Service, welcome %s !'}";
    private static final String STATUS = "I have written a log file,the level is %s !";

    @Autowired
    private ResultService resultService;

    @Autowired
    private HelloWorldService helloWorldService;

    @Autowired
    private FirstSender firstSender;


    /**
    * @Description: 测试服务是否可以正常运行
    * @Param: [response]
    * @return: java.lang.String
    * @Author: Mr.Cheng
    * @Date: 2018/9/5 下午4:41
    */
    @GetMapping(path = "/sayhello")
    public String sayHello(HttpServletResponse response) {
        log.info(String.format(STATUS, "info"));
        log.debug(String.format(STATUS, "debug"));
        log.warn(String.format(STATUS, "warn"));
        log.error(String.format(STATUS, "error"));
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        return String.format(TEST_WORDS, "everyone");
    }

    @GetMapping(path = "/result")
    public ResultVO getResult(HttpServletResponse response) {
        helloWorldService.sayHello();
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        return resultService.success();
    }

    /**
    * @Description: 测试线程
    * @Param: []
    * @return: void
    * @Author: Mr.Cheng
    * @Date: 2018/9/16 上午1:30
    */ 
    @GetMapping(path = "/sync-order")
    public String syncOrder() throws InterruptedException {
        log.info("The main thread start !");
        Thread.sleep(1000);
        log.info("The main thread start again !");
        return  "success";
    }

    /**
    * @Description: 测试异步
    * @Param: []
    * @return: org.springframework.web.context.request.async.DeferredResult<java.lang.String>
    * @Author: Mr.Cheng
    * @Date: 2018/9/17 下午11:20
    */
    @GetMapping(path = "/async-order")
    public DeferredResult<ResultVO> readList(){
        log.info("外部线程：[{}]",Thread.currentThread().getName());
        /** 模拟用户ID */
        String uuid = UUID.randomUUID().toString();
        log.info("得到用户ID ：[{}]",uuid);

        /** 模拟用户ID */
        String restaurantId = "daWeiWang";
        /** 设置timeout时间 */
        DeferredResult<ResultVO> result = new DeferredResult<>(30000L);

        firstSender.send(uuid,result,restaurantId);

        return result;
    }

    @GetMapping("/send")
    public String send(@RequestParam(name = "message") String message){
        String uuid = UUID.randomUUID().toString();
        firstSender.send(uuid,message);
        return uuid;
    }
}

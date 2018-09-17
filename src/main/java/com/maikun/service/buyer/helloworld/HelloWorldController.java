package com.maikun.service.buyer.helloworld;

import com.maikun.service.buyer.result.ResultService;
import com.maikun.service.buyer.result.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

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

}

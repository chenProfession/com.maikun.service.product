package com.maikun.service.buyer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @program: products
 * @Description: main method of application
 * @author: Mr.Cheng
 * @date: 2018/9/5 下午4:28
 */
@SpringBootApplication
@EnableRabbit
@EnableJpaAuditing
public class BuyerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BuyerApplication.class, args);
    }
}

package com.maikun.service.buyer.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: products
 * @Description: configure the thread pool 配置线程池
 *               EnableAsync来开启Springboot对于异步任务的支持
 * @author: Mr.Cheng
 * @date: 2018/9/17 上午1:57
 */
@Configuration
@EnableAsync
@Slf4j
public class ThreadConfig implements AsyncConfigurer{

    /**
     * The {@link Executor} instance to be used when processing async
     * method invocations.
     */
    @Override
    public Executor getAsyncExecutor() {
        log.info("start asyncServiceExecutor");

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        /** 配置核心线程数 */
        executor.setCorePoolSize(5);

        /** 配置最大线程数 */
        executor.setMaxPoolSize(15);

        /** 配置队列大小 */
        executor.setQueueCapacity(25);

        /** 配置线程池中的线程的名称前缀 */
        executor.setThreadNamePrefix("async-service-");

        /**
         * rejection-policy：当pool已经达到max size的时候，如何处理新任务
         * CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
         */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        /** 执行初始化 */
        executor.initialize();
        return executor;
    }

    /**
     * The {@link AsyncUncaughtExceptionHandler} instance to be used
     * when an exception is thrown during an asynchronous method execution
     * with {@code void} return type.
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

}

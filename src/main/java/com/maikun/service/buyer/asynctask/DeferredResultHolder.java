package com.maikun.service.buyer.asynctask;

import com.maikun.service.buyer.result.ResultVO;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @program: products
 * @Description:
 * @author: Mr.Cheng
 * @date: 2018/9/25 上午12:52
 */
@Component
@Getter
public class DeferredResultHolder {
    private Map<String,DeferredResult<ResultVO>> map;

    public DeferredResultHolder(){
        map = new ConcurrentHashMap<>();
    }
}

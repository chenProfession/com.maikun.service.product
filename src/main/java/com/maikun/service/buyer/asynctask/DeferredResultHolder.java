package com.maikun.service.buyer.asynctask;

import com.maikun.service.buyer.result.ResultVO;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @program: products
 * @Description:
 * @author: Mr.Cheng
 * @date: 2018/9/25 上午12:52
 */
@Component
@Data
public class DeferredResultHolder {
    Map<String,DeferredResult<ResultVO>> map = new HashMap<>();

}

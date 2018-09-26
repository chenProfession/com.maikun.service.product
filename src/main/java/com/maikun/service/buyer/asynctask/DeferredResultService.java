package com.maikun.service.buyer.asynctask;

import com.maikun.service.buyer.result.ResultVO;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @program: products
 * @Description:
 * @author: Mr.Cheng
 * @date: 2018/9/26 下午1:25
 */
public interface DeferredResultService {
    boolean saveDeferredResult(String userId, DeferredResult result);

    boolean makeDeferredResult(String userId, ResultVO result);

    boolean removeDeferredResult(String userId);
}

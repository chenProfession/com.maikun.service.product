package com.maikun.service.buyer.asynctask;

import com.maikun.service.buyer.result.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @program: products
 * @Description:
 * @author: Mr.Cheng
 * @date: 2018/9/26 下午1:29
 */
@Service
@Slf4j
public class DeferredResultImpl implements DeferredResultService{
    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @Override
    public boolean saveDeferredResult(String userId, DeferredResult result) {
        boolean save = false;
        if(deferredResultHolder.getMap().containsKey(userId)){
            log.warn("Please wait ... ,the result is in already holder.");
        }else {
            try {
                deferredResultHolder.getMap().put(userId,result);
                save = true;
            }catch (Exception e){
                log.error("can not save result in holder",e);
            }
        }

        return save;
    }

    @Override
    public boolean makeDeferredResult(String userId,ResultVO result) {
        boolean make = false;
        if(deferredResultHolder.getMap().containsKey(userId)){
            try{
                deferredResultHolder.getMap().get(userId).setResult(result);
                make = true;
            }catch (Exception e){
                log.error("can not get the result from the holder",e);
            }

        }else {
           log.warn("The holder does not contain the result!");
        }
        return make;
    }

    @Override
    public boolean removeDeferredResult(String userId) {
        if(deferredResultHolder.getMap().containsKey(userId)){
            try{
                deferredResultHolder.getMap().remove(userId);
            }catch(Exception e){
                log.error("can not delete the result",e);
            }

        }else {
            log.warn("can not find the result to delete in the holder");
        }

        return false;
    }
}

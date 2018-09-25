package com.maikun.service.buyer.asynctask;

import com.maikun.service.buyer.result.ResultVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @program: products
 * @Description: 任务实体类
 * @author: Mr.Cheng
 * @date: 2018/9/19 下午2:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    private int taskId;
    private DeferredResult<ResultVO> result;

    @Override
    public String toString() {
        return new StringBuffer("Task[")
                .append("taskId=")
                .append(taskId)
                .append(", taskResult")
                .append("{ResultVO=")
                .append(result.getResult())
                .append("} ]").toString();
    }
}

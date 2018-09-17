package com.maikun.service.buyer.result;

import com.maikun.service.buyer.enums.ResultEnum;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @program: products
 * @Description: the implement of the result service
 * @author: Mr.Cheng
 * @date: 2018/9/11 下午4:27
 */
@Service
public class ResultServiceImpl implements ResultService {
    /**
     * @Description: 设置成功信息的内容
     * @Param: object
     * @return: resultVO
     * @Author: Mr.Cheng
     * @Date: 2018/9/11 下午4:20
     */
    @Override
    public ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMsg(ResultEnum.SUCCESS.getMessage());
        return resultVO;
    }

    /**
     * @Description: 设置成功返回信息
     * @Param: []
     * @return: com.maikun.service.buyer.result.ResultVO
     * @Author: Mr.Cheng
     * @Date: 2018/9/11 下午4:25
     */
    @Override
    @Async
    public ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMsg(ResultEnum.SUCCESS.getMessage());
        return resultVO;
    }

    /**
     * @param code
     * @param message
     * @Description: 设置错误信息返回内容
     * @Param: [code, message]
     * @return: com.maikun.service.buyer.result.ResultVO
     * @Author: Mr.Cheng
     * @Date: 2018/9/11 下午4:25
     */
    @Override
    public ResultVO error(Integer code, String message) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(message);
        return resultVO;
    }

}

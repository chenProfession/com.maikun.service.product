package com.maikun.service.buyer.result;

/**
 * @program: products
 * @Description: the interface of setting result
 * @author: Mr.Cheng
 * @date: 2018/9/11 下午4:08
 */
public interface ResultService {

    /**
     * @Description: 设置成功信息的内容
     * @Param: object
     * @return: resultVO
     * @Author: Mr.Cheng
     * @Date: 2018/9/11 下午4:20
     */
    ResultVO success(Object object);

    /**
     * @Description: 设置成功返回信息
     * @Param: []
     * @return: com.maikun.service.buyer.result.ResultVO
     * @Author: Mr.Cheng
     * @Date: 2018/9/11 下午4:25
     */
    ResultVO success();

    /**
     * @Description: 设置错误信息返回内容
     * @Param: [code, message]
     * @return: com.maikun.service.buyer.result.ResultVO
     * @Author: Mr.Cheng
     * @Date: 2018/9/11 下午4:25
     */
    ResultVO error(Integer code, String message);
}

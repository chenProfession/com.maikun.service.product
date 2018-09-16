package com.maikun.service.buyer.productinfo;

import com.maikun.service.buyer.result.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: products
 * @Description: 给商家展示产品列表
 * @author: Mr.Cheng
 * @date: 2018/9/15 下午3:10
 */
@RestController
@RequestMapping(value = "/seller/product")
public class ProductInfoController {

    /**
    * @Description: 查询指定商家所有上架的商品，并返回商品图示
    * @Param: [restaurantId]
    * @return: com.maikun.service.buyer.result.ResultVO
    * @Author: Mr.Cheng
    * @Date: 2018/9/15 下午3:23
    */
    @GetMapping(path = "/list")
    public ResultVO productList(@RequestParam("restaurantId") String restaurantId){

        //1. 查询所有的上架商品



        return null;
    }
}

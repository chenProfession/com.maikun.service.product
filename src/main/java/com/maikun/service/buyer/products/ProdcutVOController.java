package com.maikun.service.buyer.products;

import com.maikun.service.buyer.result.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: products
 * @Description: 查询指定商家的所有上架的产品，并按种类归类，展示给前端
 * @author: Mr.Cheng
 * @date: 2018/9/15 下午3:43
 */
@RestController
@RequestMapping(value = "/buyer/products")
public class ProdcutVOController {

    @GetMapping(path = "/list")
    public ResultVO productVOList(@RequestParam("restaurantId") String restaurantId){

        //1. 查询所有的上架商品

        //2. 查询类目(一次性查询)

        //3. 数据拼装

        return  null;
    }
}

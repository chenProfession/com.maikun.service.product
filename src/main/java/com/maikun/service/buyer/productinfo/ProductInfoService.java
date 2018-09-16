package com.maikun.service.buyer.productinfo;

import java.util.List;

/**
 * @program: products
 * @Description: 产品详情服务
 * @author: Mr.Cheng
 * @date: 2018/9/15 下午4:29
 */
public interface ProductInfoService {

    /**
    * @Description: 获取产品详细列表
    * @Param: []
    * @return: java.util.List<com.maikun.service.buyer.productinfo.ProductInfo>
    * @Author: Mr.Cheng
    * @Date: 2018/9/15 下午4:37
    */
    List<ProductInfo> productInfoList();

    /**
    * @Description: 获取产品详细
    * @Param: []
    * @return: com.maikun.service.buyer.productinfo.ProductInfo
    * @Author: Mr.Cheng
    * @Date: 2018/9/15 下午4:40
    */
    ProductInfo productInfoDetail(String productId);
}

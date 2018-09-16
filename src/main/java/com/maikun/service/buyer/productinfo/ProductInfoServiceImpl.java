package com.maikun.service.buyer.productinfo;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: products
 * @Description: 实习产品详情服务
 * @author: Mr.Cheng
 * @date: 2018/9/15 下午4:53
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    /**
     * @Description: 获取产品详细列表
     * @Param: []
     * @return: java.util.List<com.maikun.service.buyer.productinfo.ProductInfo>
     * @Author: Mr.Cheng
     * @Date: 2018/9/15 下午4:37
     */
    @Override
    public List<ProductInfo> productInfoList() {
        return null;
    }

    /**
     * @param productId
     * @Description: 获取产品详细
     * @Param: []
     * @return: com.maikun.service.buyer.productinfo.ProductInfo
     * @Author: Mr.Cheng
     * @Date: 2018/9/15 下午4:40
     */
    @Override
    public ProductInfo productInfoDetail(String productId) {
        return null;
    }
}

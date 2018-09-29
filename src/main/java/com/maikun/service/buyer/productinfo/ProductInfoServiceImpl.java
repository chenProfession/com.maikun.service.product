package com.maikun.service.buyer.productinfo;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ProductInfoRepository productInfoRepository;

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

    /**
     * @param restaurantId
     * @param categoryType
     * @Description: 获取相关商店产品前端展示列表
     * @Param: [restaurantId, categoryType]
     * @return: java.util.List<com.maikun.service.buyer.productinfo.ProductInfo>
     * @Author: Mr.Cheng
     * @Date: 2018/9/30 上午1:43
     */
    @Override
    public List<ProductInfo> productInfoVOListOfRestaurantByCategory(String restaurantId, Integer categoryType) {
        return productInfoRepository.findProductInfoVOByRestaurantIdAndCategoryType(restaurantId,categoryType);
    }
}

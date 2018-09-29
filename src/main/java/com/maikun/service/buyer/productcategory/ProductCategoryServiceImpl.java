package com.maikun.service.buyer.productcategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: products
 * @Description:
 * @author: Mr.Cheng
 * @date: 2018/9/30 上午12:33
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    /**
     * @param restaurantId
     * @Description: 获取对应商店的产品类别列表
     * @Param: [restaurantId]
     * @return: java.util.List<com.maikun.service.buyer.productcategory.ProductCategory>
     * @Author: Mr.Cheng
     * @Date: 2018/9/30 上午12:31
     */
    @Override
    public List<ProductCategory> readCategoryListOfRestaurant(String restaurantId) {
        return productCategoryRepository.findAllByRestaurantId(restaurantId);
    }
}

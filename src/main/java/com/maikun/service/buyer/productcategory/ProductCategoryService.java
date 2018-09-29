package com.maikun.service.buyer.productcategory;

import java.util.List;

public interface ProductCategoryService {
    /**
    * @Description: 获取对应商店的产品类别列表
    * @Param: [restaurantId]
    * @return: java.util.List<com.maikun.service.buyer.productcategory.ProductCategory>
    * @Author: Mr.Cheng
    * @Date: 2018/9/30 上午12:31
    */
    List<ProductCategory> readCategoryListOfRestaurant(String restaurantId);
}

package com.maikun.service.buyer.productcategory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author chengchen
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    /**
    * @Description: 根据商店查询产品类别
    * @Param: [restaurantId]
    * @return: java.util.List<com.maikun.service.buyer.productcategory.ProductCategory>
    * @Author: Mr.Cheng
    * @Date: 2018/9/30 上午2:14
    */
    List<ProductCategory> findAllByRestaurantId(String restaurantId);
}

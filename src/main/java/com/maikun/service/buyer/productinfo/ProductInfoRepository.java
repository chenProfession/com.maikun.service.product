package com.maikun.service.buyer.productinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author chengchen
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findAllByProductId(String productId);

    List<ProductInfo> findAllByRestaurantId(String restaurantId);

    List<ProductInfo> findAllByRestaurantIdAndCategoryType(String restaurantId,Integer categoryType);

    @Transactional(timeout = 10)
    @Query(value = "select new ProductInfo(p.productId,p.productName,p.productPrice,p.productDescription,p.productIcon) from ProductInfo p where p.restaurantId=?1 and p.categoryType=?2")
    List<ProductInfo> findProductInfoVOByRestaurantIdAndCategoryType(String restaurantId, Integer categoryType);

    ProductInfo findTopByRestaurantIdOrderByCategoryType(String restaurantId);
}

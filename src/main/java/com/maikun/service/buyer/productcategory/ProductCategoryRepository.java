package com.maikun.service.buyer.productcategory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author chengchen
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findAllByRestaurantId(String restaurantId);
}

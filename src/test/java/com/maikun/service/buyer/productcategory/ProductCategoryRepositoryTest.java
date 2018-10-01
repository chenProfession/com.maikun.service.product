package com.maikun.service.buyer.productcategory;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void testFindAllByRestaurantId() throws Exception {
        List<ProductCategory> productCategoryList = productCategoryRepository.findAllByRestaurantId("baiyun-01");
        log.info(productCategoryList.toString());
        Assert.assertNotNull(productCategoryList);
    }

    @Test
    public void testSaveCategory() throws Exception {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("木桶饭");
        productCategory.setRestaurantId("jiao-xin-mu-tong");
        productCategory.setCategoryType(0);
        Assert.assertNotNull(productCategoryRepository.saveAndFlush(productCategory));
    }

    @Test
    public void testFindTopByOrOrderByRestaurantId() throws Exception {
        ProductCategory productCategory = productCategoryRepository
                .findTopByRestaurantIdOrderByCategoryType("baiyun-01");
        log.info(productCategory.toString());
        Assert.assertNotNull(productCategory);

        ProductCategory productCategoryNull = productCategoryRepository
                .findTopByRestaurantIdOrderByCategoryType("baiyun-null");
        Assert.assertNull(productCategoryNull);
    }
}
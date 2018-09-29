package com.maikun.service.buyer.products;

import com.maikun.service.buyer.productcategory.ProductCategory;
import com.maikun.service.buyer.productcategory.ProductCategoryService;
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
public class ProductVOServiceImplTest {

    @Autowired
    private ProductVOService productVOService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void makeProductInfoVOFromProductInfo() throws Exception {
    }

    @Test
    public void makeProductInfoVOListFromProductInfo() throws Exception {
    }

    @Test
    public void makeProductInfoVOListByCategory() throws Exception {
        List<ProductCategory> productCategoryList = productCategoryService
                .readCategoryListOfRestaurant("baiyun-01");
        List<ProductVO> productVOList = productVOService.makeProductVOList(productCategoryList);
        log.info(productVOList.toString());
        Assert.assertNotNull(productVOList);
    }

    @Test
    public void makeProductVOList() throws Exception {
    }

}
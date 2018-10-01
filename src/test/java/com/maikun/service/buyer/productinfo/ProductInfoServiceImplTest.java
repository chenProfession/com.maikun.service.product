package com.maikun.service.buyer.productinfo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductInfoServiceImplTest {

    @Autowired
    ProductInfoService productInfoService;

    @Test
    public void productInfoList() throws Exception {
    }

    @Test
    public void productInfoDetail() throws Exception {
    }

    @Test
    public void productInfoVOListOfRestaurantByCategory() throws Exception {
    }

    @Test
    public void testCheckRestaurantViaProductInfo() throws Exception {
        Integer productCount = productInfoService.checkRestaurantViaProductInfo("baiyun-01");
        log.info(productCount.toString());
        Assert.assertEquals("1",productCount.toString());
    }

}
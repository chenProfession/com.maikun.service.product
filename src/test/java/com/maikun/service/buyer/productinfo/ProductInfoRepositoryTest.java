package com.maikun.service.buyer.productinfo;

import com.maikun.service.buyer.products.ProductInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductId() throws Exception {
    }

    @Test
    public void testFindByRestaurantIdAndCategoryType() throws Exception {
       List<ProductInfo> productInfoList = productInfoRepository
               .findAllByRestaurantIdAndCategoryType("baiyun-01",0);
       log.info(productInfoList.toString());
       Assert.assertNotNull(productInfoList);
    }

    @Test
    public void testFindProductInfoVOByRestaurantIdAndCategoryType() throws Exception {
        List<ProductInfo> productInfoList = productInfoRepository
                .findProductInfoVOByRestaurantIdAndCategoryType("baiyun-01",0);
        log.info(productInfoList.get(0).toString());
        log.info(productInfoList.get(1).toString());
        Assert.assertNotNull(productInfoList);
    }

    @Test
    public void testSaveProductInfo() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("jiaoxin-02");
        productInfo.setRestaurantId("baiyun-01");
        productInfo.setProductName("红萝卜炒鸡蛋");
        productInfo.setCategoryType(0);
        productInfo.setProductDescription("窖心木桶饭-红萝卜炒鸡蛋");
        productInfo.setProductIcon("http://jiaoxin");
        productInfo.setProductPrice(new BigDecimal(13));
        //productInfo.setProductStatus(0);
        productInfo.setProductStock(30);
        Assert.assertNotNull(productInfoRepository.saveAndFlush(productInfo));
    }

    @Test
    public void testFindTopByRestaurantIdOrderByCategoryType() throws Exception {
        ProductInfo productInfo = productInfoRepository
                .findTopByRestaurantIdOrderByCategoryType("baiyun-01");
        Assert.assertNotNull(productInfo);
        ProductInfo productInfoNull = productInfoRepository
                .findTopByRestaurantIdOrderByCategoryType("baiyun-null");
        Assert.assertNull(productInfoNull);
    }

}
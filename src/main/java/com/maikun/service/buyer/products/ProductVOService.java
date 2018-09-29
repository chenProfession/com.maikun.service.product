package com.maikun.service.buyer.products;

import com.maikun.service.buyer.productcategory.ProductCategory;
import com.maikun.service.buyer.productinfo.ProductInfo;

import java.util.List;

/**
 * @program: products
 * @Description: 提供产品图示逻辑服务
 * @author: Mr.Cheng
 * @date: 2018/9/15 下午3:43
 */
public interface ProductVOService {

    /**
    * @Description: 从产品详情转换成产品图示
    * @Param: [productInfo]
    * @return: com.maikun.service.buyer.products.ProductInfoVO
    * @Author: Mr.Cheng
    * @Date: 2018/9/15 下午4:28
    */
    ProductInfoVO makeProductInfoVOFromProductInfo(ProductInfo productInfo);

    /**
    * @Description: 从产品详情列表转换成产品图示列表
    * @Param: [productInfoList]
    * @return: java.util.List<com.maikun.service.buyer.products.ProductInfoVO>
    * @Author: Mr.Cheng
    * @Date: 2018/9/15 下午4:28
    */
    List<ProductInfoVO> makeProductInfoVOListFromProductInfo(List<ProductInfo> productInfoList);

    /**
    * @Description: 根据产品类别产生产品列表
    * @Param: [productCategory]
    * @return: java.util.List<com.maikun.service.buyer.products.ProductInfoVO>
    * @Author: Mr.Cheng
    * @Date: 2018/9/15 下午9:39
    */
    List<ProductInfoVO> makeProductInfoVOListByCategory(Integer categoryId);

    /**
    * @Description: 给用户展示产品列表
    * @Param: [productCategoryList, productInfoVOList]
    * @return: java.util.List<com.maikun.service.buyer.products.ProductVO>
    * @Author: Mr.Cheng
    * @Date: 2018/9/15 下午9:16
    */
    List<ProductVO> makeProductVOList(List<ProductCategory> productCategoryList,List<ProductInfoVO> productInfoVOList);

}

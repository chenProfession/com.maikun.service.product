package com.maikun.service.buyer.products;

import com.maikun.service.buyer.productcategory.ProductCategory;
import com.maikun.service.buyer.productcategory.ProductCategoryService;
import com.maikun.service.buyer.productinfo.ProductInfo;
import com.maikun.service.buyer.productinfo.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program: products
 * @Description: 实现产品图示服务
 * @author: Mr.Cheng
 * @date: 2018/9/15 下午4:43
 */
@Service
public class ProductVOServiceImpl implements ProductVOService {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * @param productInfo
     * @Description: 从产品详情转换成产品图示
     * @Param: [productInfo]
     * @return: com.maikun.service.buyer.products.ProductInfoVO
     * @Author: Mr.Cheng
     * @Date: 2018/9/15 下午4:28
     */
    @Override
    public ProductInfoVO makeProductInfoVOFromProductInfo(ProductInfo productInfo) {

        ProductInfoVO productInfoVO = new ProductInfoVO();
        productInfoVO.setProductId(productInfo.getProductId());
        productInfoVO.setProductName(productInfo.getProductName());
        productInfoVO.setProductDescription(productInfo.getProductDescription());
        productInfoVO.setProductPrice(productInfo.getProductPrice());
        productInfoVO.setProductIcon(productInfo.getProductIcon());

        return productInfoVO;
    }

    /**
     * @param productInfoList
     * @Description: 从产品详情列表转换成产品图示列表
     * @Param: [productInfoList]
     * @return: java.util.List<com.maikun.service.buyer.products.ProductInfoVO>
     * @Author: Mr.Cheng
     * @Date: 2018/9/15 下午4:28
     */
    @Override
    public List<ProductInfoVO> makeProductInfoVOListFromProductInfo(List<ProductInfo> productInfoList) {
        List<ProductInfoVO> productInfoVOList = new ArrayList();
        Iterator<ProductInfo> productInfoIterator = productInfoList.iterator();
        while(productInfoIterator.hasNext()){
            ProductInfo productInfoItem = productInfoIterator.next();
            productInfoVOList.add(makeProductInfoVOFromProductInfo(productInfoItem));
        }
        return productInfoVOList;
    }

    /**
     * @param categoryId
     * @Description: 根据产品类别产生产品列表
     * @Param: [productCategory]
     * @return: java.util.List<com.maikun.service.buyer.products.ProductInfoVO>
     * @Author: Mr.Cheng
     * @Date: 2018/9/15 下午9:39
     */
    @Override
    public List<ProductInfoVO> makeProductInfoVOListByCategory(Integer categoryId) {
        return null;
    }

    /**
     * @param productCategoryList
     * @Description: 给用户展示产品列表
     * @Param: [productCategoryList, productInfoVOList]
     * @return: java.util.List<com.maikun.service.buyer.products.ProductVO>
     * @Author: Mr.Cheng
     * @Date: 2018/9/15 下午9:16
     */
    @Override
    public List<ProductVO> makeProductVOList(List<ProductCategory> productCategoryList) {
        List<ProductVO> productVOList = new ArrayList();
        Iterator<ProductCategory> iteratorProductCategory = productCategoryList.iterator();
        while(iteratorProductCategory.hasNext()){
            ProductCategory productCategory = iteratorProductCategory.next();
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = makeProductInfoVOListFromProductInfo(productInfoService
                    .productInfoVOListOfRestaurantByCategory(productCategory.getRestaurantId(),
                            productCategory.getCategoryType()));
            productVO.setProductInfoVOList(productInfoVOList);

            productVOList.add(productVO);
        }

        return productVOList;
    }
}

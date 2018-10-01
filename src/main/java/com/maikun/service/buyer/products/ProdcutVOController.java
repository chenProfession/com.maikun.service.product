package com.maikun.service.buyer.products;

import com.maikun.service.buyer.enums.ResultEnum;
import com.maikun.service.buyer.productcategory.ProductCategory;
import com.maikun.service.buyer.productcategory.ProductCategoryService;
import com.maikun.service.buyer.productinfo.ProductInfoService;
import com.maikun.service.buyer.result.ResultService;
import com.maikun.service.buyer.result.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @program: products
 * @Description: 查询指定商家的所有上架的产品，并按种类归类，展示给前端
 * @author: Mr.Cheng
 * @date: 2018/9/15 下午3:43
 */
@RestController
@RequestMapping(value = "/buyer/products")
public class ProdcutVOController {

    @Autowired
    ProductVOService productVOService;

    @Autowired
    ProductCategoryService productCategoryService;

    @Autowired
    ProductInfoService productInfoService;

    @Autowired
    ResultService resultService;

    @GetMapping(path = "/list")
    @Cacheable(cacheNames = "product",key = "#restaurantId")
    public ResultVO productVOList(
            @Valid
            @NotBlank
            @RequestParam("restaurantId") String restaurantId){
        /** 判断一下产品类别和产品详细里是否有这家店 */
        ResultVO resultVO = resultService.error(ResultEnum.PRODUCT_NOT_EXIST.getCode(),
                ResultEnum.PRODUCT_NOT_EXIST.getMessage());
        if(productInfoService.checkRestaurantViaProductInfo(restaurantId) == 1){
            List<ProductCategory> productCategoryList = productCategoryService
                    .readCategoryListOfRestaurant(restaurantId);
            List<ProductVO> productVOList = productVOService.makeProductVOList(productCategoryList);
            resultVO = resultService.success(productVOList);
        }
        return resultVO;
    }
}

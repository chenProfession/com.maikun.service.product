package com.maikun.service.buyer.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: products
 * @Description: the view of the products list
 * @author: Mr.Cheng
 * @date: 2018/9/11 下午3:58
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = 7360896644410585816L;

    /** 类型名称. */
    @JsonProperty("name")
    private String categoryName;

    /** 类型代码. */
    @JsonProperty("type")
    private Integer categoryType;

    /** 产品集合. */
    @JsonProperty("products")
    private List<ProductInfoVO> productInfoVOList;
}

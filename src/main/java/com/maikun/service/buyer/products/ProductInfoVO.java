package com.maikun.service.buyer.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: products
 * @Description: 产品详细前端展示
 * @author: Mr.Cheng
 * @date: 2018/9/5 下午5:16
 */
@Data
public class ProductInfoVO implements Serializable {

    @JsonProperty("id")
    private String productId;

    /** 名字. */
    @JsonProperty("name")
    private String productName;

    /** 价格. */
    @JsonProperty("price")
    private BigDecimal productPrice;

    /** 产品描述. */
    @JsonProperty("description")
    private String productDescription;

    /** 产品缩略图. */
    @JsonProperty("icon")
    private String productIcon;

}

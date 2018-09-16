package com.maikun.service.buyer.productinfo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: products
 * @Description: 产品详情描述
 * @author: Mr.Cheng
 * @date: 2018/9/5 下午5:00
 */
@Data
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = -7036934411439011965L;

    private String productId;

    /** 名字. */
    private String productName;

    /** 饭店Id. */
    private String restaurantId;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 状态, 0正常1下架. */
    private Integer productStatus;

    /** 类目编号. */
    private Integer categoryType;

    /** 产品创建时间. */
    private Date createTime;

    /** 产品更新时间. */
    private Date updateTime;
}

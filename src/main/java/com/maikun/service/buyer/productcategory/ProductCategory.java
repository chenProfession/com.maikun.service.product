package com.maikun.service.buyer.productcategory;

import lombok.Data;

import java.util.Date;

/**
 * @program: products
 * @Description: 产品类别
 * @author: Mr.Cheng
 * @date: 2018/9/6 下午4:43
 */
@Data
public class ProductCategory {

    /** 类目id 自增. */
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    /** 创建时间. */
    private Date createTime;

    /** 更新时间. */
    private Date updateTime;
}

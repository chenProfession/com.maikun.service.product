package com.maikun.service.buyer.productinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: products
 * @Description: 产品详情描述
 * @author: Mr.Cheng
 * @date: 2018/9/5 下午5:00
 */
@Entity
@Data
@Table(name = "product_info")
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = -7036934411439011965L;

    @Id
    @Column(name = "product_id",nullable = false)
    private String productId;

    /** 名字. */
    @Column(name = "product_name",nullable = false)
    private String productName;

    /** 饭店Id. */
    @Column(name = "restaurant_id",nullable = false)
    private String restaurantId;

    /** 单价. */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /** 库存. */
    @Column(name = "product_stock")
    private Integer productStock;

    /** 描述. */
    @Column(name = "product_description")
    private String productDescription;

    /** 小图. */
    @Column(name = "product_icon")
    private String productIcon;

    /** 状态, 0正常1下架. */
    @Column(name = "product_status",columnDefinition = "INT default 0")
    private Integer productStatus = 0;

    /** 类目编号. */
    @Column(name = "product_category_type" ,nullable = false)
    private Integer categoryType;

    /** 产品创建时间. */
    @CreatedDate
    @Column(name = "product_create_time")
    private Date createTime;

    /** 产品更新时间. */
    @Column(name = "product_update_time")
    @LastModifiedDate
    private Date updateTime;

    public ProductInfo() {
    }

    public ProductInfo(String productId, String productName, BigDecimal productPrice, String productDescription, String productIcon) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productIcon = productIcon;
    }
}

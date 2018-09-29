package com.maikun.service.buyer.restaurant;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: products
 * @Description: 饭店详细信息
 * @author: Mr.Cheng
 * @date: 2018/9/5 下午5:29
 */
@Data
@Table(name = "product_category")
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 4756892740316205407L;

    @Column(name = "restaurant_id",nullable = false)
    private String restaurantId;

    /** 餐厅名字. */
    @Column(name = "restaurant_name",nullable = false)
    private String restaurantName;

    /** 餐厅描述. */
    @Column(name = "restaurant_description",nullable = false)
    private String restaurantDescription;

    /** 餐厅缩略图. */
    @Column(name = "restaurant_icon")
    private String restaurantIcon;

    /** 餐厅地址. */
    @Column(name = "restaurant_address")
    private String restaurantAddress;

    /** 餐厅营业时间. */
    @Column(name = "restaurant_hours")
    private String shopHours;

    /** 餐厅联系方式. */
    @Column(name = "restaurant_phone")
    private String phone;

    /** 餐厅周围环境. */
    @Column(name = "restaurant_environment")
    private List<String> restaurantEnvironment;

    /** 餐厅资质. */
    @Column(name = "restaurant_credentials")
    private List<String> restaurantCredentials;

    /** 创建时间. */
    @CreatedDate
    @Column(name = "restaurant_create_time")
    private Date createTime;

    /** 更新时间. */
    @LastModifiedDate
    @Column(name = "restaurant_update_time")
    private Date updateTime;
}

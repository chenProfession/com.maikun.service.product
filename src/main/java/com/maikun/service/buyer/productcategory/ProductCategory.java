package com.maikun.service.buyer.productcategory;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @program: products
 * @Description: 产品类别
 * @author: Mr.Cheng
 * @date: 2018/9/6 下午4:43
 */
@Data
@Entity
@Table(name = "product_category")
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
public class ProductCategory {

    /** 类目id 自增. */
    @Id
    @GeneratedValue
    @Column(name = "category_id", unique = true, length = 10)
    private Integer categoryId;

    /** 饭店Id. */
    @Column(name = "restaurant_id",nullable = false)
    private String restaurantId;

    /** 类目名字. */
    @Column(name = "category_name")
    private String categoryName;

    /** 类目编号. */
    @Column(name = "category_type")
    private Integer categoryType;

    /** 创建时间. */
    @CreatedDate
    @Column(name = "category_create_time")
    private Date createTime;

    /** 更新时间. */
    @LastModifiedDate
    @Column(name = "category_update_time")
    private Date updateTime;
}

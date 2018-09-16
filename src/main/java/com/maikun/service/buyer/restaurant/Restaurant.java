package com.maikun.service.buyer.restaurant;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: products
 * @Description: 饭店详细信息
 * @author: Mr.Cheng
 * @date: 2018/9/5 下午5:29
 */
@Data
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 4756892740316205407L;

    private String restaurantId;

    /** 餐厅名字. */
    private String restaurantName;

    /** 餐厅描述. */
    private String restaurantDescription;

    /** 餐厅缩略图. */
    private String restaurantIcon;

    /** 餐厅地址. */
    private String restaurantAddress;

    /** 餐厅营业时间. */
    private String shopHours;

    /** 餐厅联系方式. */
    private String phone;

    /** 餐厅周围环境. */
    private List<String> restaurantEnvironment;

    /** 餐厅资质. */
    private List<String> restaurantCredentials;
}

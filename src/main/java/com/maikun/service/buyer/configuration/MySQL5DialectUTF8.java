package com.maikun.service.buyer.configuration;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * @program: products
 * @Description: Configure database设置数据库字符集
 * @author: Mr.Cheng
 * @date: 2018/9/29 下午9:47
 */
public class MySQL5DialectUTF8 extends MySQL5InnoDBDialect {
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}

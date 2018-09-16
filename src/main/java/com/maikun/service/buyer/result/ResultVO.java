package com.maikun.service.buyer.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: products
 * @Description: 前端返回查询或者操作结果
 * @author: Mr.Cheng
 * @date: 2018/9/5 下午5:49
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 6841499285242429811L;

    /** 错误码. */
    @JsonProperty("code")
    private Integer code;

    /** 提示信息. */
    @JsonProperty("message")
    private String msg;

    /** 具体内容. */
    @JsonProperty("details")
    private T data;

    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVO(){

    }
}

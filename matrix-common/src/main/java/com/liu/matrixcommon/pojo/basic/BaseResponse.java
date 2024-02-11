package com.liu.matrixcommon.pojo.basic;

import com.liu.matrixcommon.enums.HttpStatus;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回类
 * @author liuweizhong
 * @since 2024-01-28
 * @param <T>
 */
@Data
public class BaseResponse<T> implements Serializable {

    private int code;

    private T data;

    private String message;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(int code, T data) {
        this(code, data, "");
    }

    public BaseResponse(HttpStatus httpStatus, T data){
        this(httpStatus.getCode(), data, httpStatus.getMessage());
    }

    public BaseResponse(HttpStatus httpStatus) {
        this(httpStatus.getCode(), null, httpStatus.getMessage());
    }

}

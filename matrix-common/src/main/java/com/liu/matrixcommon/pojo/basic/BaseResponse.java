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

    /**
     * 成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(HttpStatus.SUCCESS, data);
    }

    /**
     * 成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> success(HttpStatus httpStatus, T data) {
        return new BaseResponse<>(httpStatus, data);
    }

    /**
     * 自己构建结果集
     * @param code
     * @param message
     * @param data
     * @return
     * @param <T>
     */
    public static <T> BaseResponse<T> build(Integer code, String message, T data) {
        return new BaseResponse<>(code, data, message);
    }

    /**
     * 成功
     *
     * @param code
     * @param message
     * @return
     */
    public static BaseResponse success(int code, String message) {
        return new BaseResponse<>(code, null, message);
    }

    /**
     * 失败
     *
     * @param httpStatus
     * @return
     */
    public static BaseResponse error(HttpStatus httpStatus) {
        return new BaseResponse<>(httpStatus);
    }

    /**
     * 失败
     *
     * @param code
     * @param message
     * @return
     */
    public static BaseResponse error(int code, String message) {
        return new BaseResponse<>(code, null, message);
    }

}

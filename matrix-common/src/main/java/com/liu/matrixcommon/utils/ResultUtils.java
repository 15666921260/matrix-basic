package com.liu.matrixcommon.utils;


import com.liu.matrixcommon.enums.HttpStatus;
import com.liu.matrixcommon.pojo.basic.BaseResponse;

/**
 * @author liuweizhong
 * @since 2024-01-30
 */
public class ResultUtils {

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

package com.matrix.common.vo.basic.response;

import com.matrix.common.enums.system.HttpStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回类
 * @author liuweizhong
 * @since 2024-01-28
 * @param <T>
 */
@Data
@Schema(name = "BaseResponse", description = "通用返回对象")
public class BaseResponse<T> implements Serializable {

    @Schema(name = "code", description = "状态码")
    private int code;

    @Schema(name = "data", description = "数据封装")
    private T data;

    @Schema(name = "message", description = "提示信息")
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
     * @param data 返回的数据
     * @param <T> 类型
     * @return 返回
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(HttpStatus.SUCCESS, data);
    }

    /**
     * 成功
     *
     * @param data 返回的数据
     * @param <T> 类型
     * @return 返回
     */
    public static <T> BaseResponse<T> success(HttpStatus httpStatus, T data) {
        return new BaseResponse<>(httpStatus, data);
    }

    /**
     * 自己构建结果集
     * @param code 返回的code
     * @param message 返回的message
     * @param data 返回的数据
     * @return 返回
     * @param <T> 类型
     */
    public static <T> BaseResponse<T> build(Integer code, String message, T data) {
        return new BaseResponse<>(code, data, message);
    }

    /**
     * 构建自定义结果集
     * 返回值 400 就是客户端参数列表错误（缺少，格式不匹配）
     * @param message 返回的message
     * @param data 返回的数据
     * @return 返回
     * @param <T> 类型
     */
    public static <T> BaseResponse<T> buildCustom(String message, T data) {
        return new BaseResponse<>(HttpStatus.BAD_REQUEST.getCode(), data, message);
    }

    /**
     * 构建自定义结果集 只有消息
     * 返回值 400 就是客户端参数列表错误（缺少，格式不匹配）
     * @param message 返回的message
     * @return 返回
     */
    public static BaseResponse<String> buildCustom(String message) {
        return new BaseResponse<>(HttpStatus.BAD_REQUEST.getCode(), message, message);
    }

    /**
     * 成功
     *
     * @param code 返回的code
     * @param message 返回的message
     * @return 返回
     */
    public static BaseResponse<String> success(int code, String message) {
        return new BaseResponse<>(code, null, message);
    }

    /**
     * 失败
     *
     * @param httpStatus 返回的http枚举类型
     * @return 返回
     */
    public static BaseResponse<String> error(HttpStatus httpStatus) {
        return new BaseResponse<>(httpStatus);
    }

    /**
     * 失败
     *
     * @param httpStatus 返回的http枚举类型
     * @return 返回
     */
    public static <T> BaseResponse<T> error(HttpStatus httpStatus, T data) {
        return new BaseResponse<>(httpStatus, data);
    }

    /**
     * 失败
     *
     * @param code 返回的code
     * @param message 返回的message
     * @return 返回
     */
    public static BaseResponse<String> error(int code, String message) {
        return new BaseResponse<>(code, null, message);
    }

}

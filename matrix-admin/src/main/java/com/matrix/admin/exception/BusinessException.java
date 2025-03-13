package com.matrix.admin.exception;

import lombok.Getter;

/**
 * 自定义业务异常类
 * @author liuweizhong
 * @since 2025-03-08 02:57
 */
@Getter
public class BusinessException extends RuntimeException {

    /**
     * 异常码
     */
    private final int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }
}

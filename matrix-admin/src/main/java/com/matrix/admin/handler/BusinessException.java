package com.matrix.admin.handler;

import com.matrix.common.enums.system.HttpStatus;
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

    public BusinessException(HttpStatus errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
    }

    public BusinessException(HttpStatus errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }

    public BusinessException(String message) {
        super(message);
        this.code = HttpStatus.ERROR.getCode();
    }
}

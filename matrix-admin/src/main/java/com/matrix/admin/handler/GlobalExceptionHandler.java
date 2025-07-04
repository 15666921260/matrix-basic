package com.matrix.admin.handler;

import com.matrix.common.enums.system.HttpStatus;
import com.matrix.common.exception.BusinessException;
import com.matrix.common.vo.basic.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

/**
 * 全局异常处理
 * @author liuweizhong
 * @since 2024-03-11
 */
@Slf4j
@Order(Integer.MIN_VALUE)
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 业务异常处理器, 捕获业务异常, 并返回错误信息
     * @param e 业务异常
     * @return 错误信息
     */
    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> businessExceptionHandler(BusinessException e) {
        log.error("业务异常: ", e);
        return BaseResponse.error(e.getCode(), e.getMessage());
    }

    /**
     * 运行时异常处理器, 捕获运行时异常, 并返回错误信息
     * @param e 运行时异常
     * @return 错误信息
     */
    @ExceptionHandler(RuntimeException.class)
    public BaseResponse<?> businessExceptionHandler(RuntimeException e) {
        log.error("运行时异常: ", e);
        return BaseResponse.error(HttpStatus.ERROR.getCode(), e.getMessage());
    }
}

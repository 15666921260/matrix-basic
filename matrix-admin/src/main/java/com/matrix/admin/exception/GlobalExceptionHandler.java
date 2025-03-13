package com.matrix.admin.exception;

import cn.dev33.satoken.exception.NotLoginException;
import com.matrix.common.vo.basic.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 * @author liuweizhong
 * @since 2025-03-10 01:04
 */
@RestControllerAdvice // 声明一个控制器增强器(AOP)
@Slf4j
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
        return BaseResponse.error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "系统内部异常");
    }

    @ExceptionHandler(NotLoginException.class)
    public BaseResponse<?> exceptionHandler(Exception e) {
        log.error("未登录异常: ", e);
        return BaseResponse.error(HttpStatus.SC_UNAUTHORIZED, "请先登录");
    }

}

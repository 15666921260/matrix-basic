package com.matrix.admin.handler;

import cn.dev33.satoken.exception.NotLoginException;
import com.matrix.common.enums.system.HttpStatus;
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
@RestControllerAdvice // 声明一个控制器增强器(AOP)
public class GlobalExceptionHandler {

    /**
     * 捕获sa-token异常，返回自定义结果
     */
    @ExceptionHandler(NotLoginException.class)
    public BaseResponse<String> handleException(NotLoginException e) {
        log.info("捕获SaTokenException异常：{}", e.getMessage());
        return BaseResponse.error(HttpStatus.FORBIDDEN, "token失效");
    }
}

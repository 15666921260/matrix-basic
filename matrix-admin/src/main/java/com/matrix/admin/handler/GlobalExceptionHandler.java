package com.matrix.admin.handler;

import cn.dev33.satoken.exception.SaTokenException;
import com.matrix.common.enums.system.HttpStatus;
import com.matrix.common.vo.basic.response.BaseResponse;
import org.springframework.web.bind.annotation.*;

/**
 * 全局异常处理
 * @author liuweizhong
 * @since 2024-03-11
 */
//@Slf4j
//@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 不同异常返回不同结果
     */
    @ResponseBody
    @ExceptionHandler(SaTokenException.class)
    public BaseResponse<String> handleException(SaTokenException e) {
        return BaseResponse.error(HttpStatus.ERROR, "token失效");
    }
}

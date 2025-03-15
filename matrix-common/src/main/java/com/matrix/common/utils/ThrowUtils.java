package com.matrix.common.utils;

import com.matrix.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

/**
 * 异常抛出工具类
 * @author liuweizhong
 * @since 2025-03-15 10:44
 */
@Slf4j
public class ThrowUtils {
    
    public static void throwIfNull(Object object, String message) {
        if (object == null) {
            throwException(message);
        }
    }

    public static void throwIfEmpty(String str, String message) {
        if (str == null || str.isEmpty()) {
            throwException(message);
        }
    }
    
    public static void throwIf(boolean condition, String message) {
        if (condition) {
            throw new BusinessException(message);
        }
    }

    public static void throwLogIfNull(Object object, String message) {
        if (object == null) {
            log.error(message);
            throw new BusinessException(message);
        }
    }

    public static void throwLogIfEmpty(String str, String message) {
        if (str == null || str.isEmpty()) {
            log.error(message);
            throw new BusinessException(message);
        }
    }

    public static void throwLogIf(boolean condition, String message) {
        if (condition) {
            log.error(message);
            throw new BusinessException(message);
        }
    }

    public static void throwLogIfNull(Object object, String message, String logMsg) {
        if (object == null) {
            log.error(logMsg);
            throw new BusinessException(message);
        }
    }

    public static void throwLogIfEmpty(String str, String message, String logMsg) {
        if (str == null || str.isEmpty()) {
            log.error(logMsg);
            throw new BusinessException(message);
        }
    }

    public static void throwLogIf(boolean condition, String message, String logMsg) {
        if (condition) {
            log.error(logMsg);
            throw new BusinessException(message);
        }
    }
    
    private static void throwException(String message) {
        if (message == null || message.isEmpty()) {
            throw new BusinessException("系统内部，空指针异常");
        } else {
            throw new BusinessException(message);
        }
    }
    
}

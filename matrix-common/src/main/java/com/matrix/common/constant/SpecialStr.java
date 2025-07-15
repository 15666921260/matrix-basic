package com.matrix.common.constant;

/**
 * 特殊字符常量
 * @author liuweizhong
 * @since 2025-06-26 23:09
 */
public interface SpecialStr {

    /**
     * 点
     */
    String POINT = ".";

    /**
     * split 方法使用 点
     */
    String POINT_SPLIT = "\\.";

    /**
     * 字符串0，如果restfull风格有的值为空，先传0替代
     */
    String ZERO = "0";

    /**
     * 星号
     */
    String ASTERISK = "*";

    /**
     * 路由忽略
     */
    String ROUTE_IGNORED = "/**";

    /**
     * 逗号
     */
    String COMMA = ",";
}

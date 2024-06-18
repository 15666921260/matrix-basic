package com.martix.util;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;

import java.util.Random;

/**
 * 生成 ID 工具类
 * @author liuweizhong
 * @since 2024-06-15
 */
public class RandomNumberUtil {
    private static final char[] NUMBERS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * 生成 唯一的 ID
     * @return 返回结果包含字母、数字、下划线
     */
    public static String newId() {
        return NanoIdUtils.randomNanoId();
    }

    /**
     * 生成 随机的数字 字符串
     * @return 返回结果只包含数字 默认长度为 16
     */
    public static String newNumId() {
        return NanoIdUtils.randomNanoId(new Random(), NUMBERS, 16);
    }

    /**
     * 生成 随机的数字 字符串
     * @return 返回结果只包含数字 指定长度
     */
    public static String newNumId(int size) {
        return NanoIdUtils.randomNanoId(new Random(), NUMBERS, size);
    }
}

package com.martix.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * @author liuweizhong
 * @since 2024-03-21
 */
public class DateUtils {

    /**
     * 安装格式转换日期为字符串
     * @param date 要转换的日期
     * @param format 格式
     * @return 返回的转换结果
     */
    public static String date2StrFormat(Date date, String format) {
        SimpleDateFormat sdf1 = new SimpleDateFormat(format);
        return sdf1.format(date);
    }
}

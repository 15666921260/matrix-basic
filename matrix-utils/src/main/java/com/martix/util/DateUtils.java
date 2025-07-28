package com.martix.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.WeekFields;
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

    /**
     * 目标日期是否是本周
     * @param targetDateTime 目标日期
     * @return 是否为本周
     */
    public static boolean isSameWeekAsNow(LocalDateTime targetDateTime) {
        LocalDateTime now = LocalDateTime.now(); // 当前时间（带时区）

        // 获取基于周的年份和周数（ISO标准：周一开始）
        WeekFields weekFields = WeekFields.ISO;
        int currentWeekYear = now.get(weekFields.weekBasedYear());
        int targetWeekYear = targetDateTime.get(weekFields.weekBasedYear());
        int currentWeek = now.get(weekFields.weekOfWeekBasedYear());
        int targetWeek = targetDateTime.get(weekFields.weekOfWeekBasedYear());

        return currentWeekYear == targetWeekYear && currentWeek == targetWeek;
    }
}

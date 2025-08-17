package net.doge.util;

import cn.hutool.core.date.DateUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author Doge
 * @Description 时间转换工具类
 * @Date 2020/12/15
 */
public class TimeUtil {
    private static final DateFormat dateShortTimeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static final DateFormat shortDateShortTimeFormatter = new SimpleDateFormat("MM-dd HH:mm");

    /**
     * 转换毫秒为时间短语
     *
     * @param ms 毫秒数
     * @return
     */
    public static String msToPhrase(long ms) {
        TimeUnit unit = TimeUnit.MILLISECONDS;
        long now = System.currentTimeMillis();
        long l = now - ms;

        long seconds = unit.toSeconds(l);
        if (seconds < 30) return "刚刚";
        if (seconds < 60) return seconds + "秒前";
        long minutes = unit.toMinutes(l);
        if (minutes < 60) return minutes + "分钟前";
        long hours = unit.toHours(l);
        if (hours < 24) return hours + "小时前";
        long days = unit.toDays(l);
        if (days < 7) return days + "天前";
        // 同一年份省掉年的显示
        if (msToYear(ms) == msToYear(now)) return msToShortDateShortTime(ms);
        return msToDateShortTime(ms);
    }

    /**
     * 转换毫秒为日期短时间
     *
     * @param ms 毫秒数
     * @return
     */
    public static String msToDateShortTime(long ms) {
        if (ms < 0) return null;
        return dateShortTimeFormatter.format(new Date(ms));
    }

    /**
     * 转换毫秒为短日期短时间
     *
     * @param ms 毫秒数
     * @return
     */
    public static String msToShortDateShortTime(long ms) {
        if (ms < 0) return null;
        return shortDateShortTimeFormatter.format(new Date(ms));
    }

    /**
     * 转换毫秒为年
     *
     * @param ms 毫秒数
     * @return
     */
    public static long msToYear(long ms) {
        return DateUtil.year(new Date(ms));
    }
}

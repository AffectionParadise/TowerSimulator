package net.doge.util;

/**
 * @Author Doge
 * @Description 字符串工具类
 * @Date 2020/12/15
 */
public class StrUtil {
    public static String formatValue(int value) {
        if (value < 10000) return String.valueOf(value);
        else if (value < 1000000) return String.format("%.1fK", (double) value / 1000 - 0.05);
        else if (value < 1000000000) return String.format("%.1fM", (double) value / 1000000 - 0.05);
        return String.format("%.1fB", (double) value / 1000000000 - 0.05);
    }
}
package net.doge.util;

import java.text.DecimalFormat;

/**
 * @Author Doge
 * @Description 字符串工具类
 * @Date 2020/12/15
 */
public class StrUtil {
    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##%");

    public static String formatValue(int value) {
        if (value < 10000) return String.valueOf(value);
        else if (value < 1000000) return String.format("%.1fK", (double) value / 1000 - 0.05);
        else if (value < 1000000000) return String.format("%.1fM", (double) value / 1000000 - 0.05);
        return String.format("%.1fB", (double) value / 1000000000 - 0.05);
    }

    // 格式化百分比
    public static String formatPercentage(double value) {
        return decimalFormat.format(value);
    }
}
package net.doge.util;

/**
 * @Author Doge
 * @Description 时长工具类
 * @Date 2020/12/15
 */
public class DurationUtil {
    /**
     * 转换秒为 xx(m):xx(s) 格式
     *
     * @param s
     * @return
     */
    public static String format(int s) {
        StringBuilder sb = new StringBuilder();
        int minute = s / 60, second = s % 60;
        if (minute < 10) sb.append("0");
        sb.append(minute).append(":");
        if (second < 10) sb.append("0");
        sb.append(second);
        return sb.toString();
    }
}

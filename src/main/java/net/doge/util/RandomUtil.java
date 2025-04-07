package net.doge.util;

import org.apache.commons.math3.random.MersenneTwister;

/**
 * @Author Doge
 * @Description 随机工具类
 * @Date 2020/12/15
 */
public class RandomUtil {
    private static final MersenneTwister random = new MersenneTwister();

    public static double nextDouble() {
        return random.nextDouble();
    }

    public static int nextInt(int min, int max) {
        return min + random.nextInt(max - min);
    }
}
package net.doge.util;

import org.apache.commons.math3.random.MersenneTwister;

import java.util.Arrays;
import java.util.List;

/**
 * 好运连连
 */
public class GoodLuck {
    public static void main(String[] args) {
//        Integer[] g = {1, 2, 3, 4};
        // 1234 单双 3下 063
        // 单双 1234 3下 111
        Integer[] g = {1, 2, 3};
        List<Integer> list = Arrays.asList(g);

        for (int j = 1, t = 4; j <= t; j++) {
            shuffle(list);
//            if(list.get(2) == rnd.nextInt(3)+1) System.out.print("中 ");
//            else System.out.print("补 ");
            System.out.printf("第 %s 个：", j);
            for (int i = 0, s = list.size() - 1; i < s; i++) System.out.print(list.get(i) + " ");
            System.out.println();
        }
    }

    // 使用 Fisher-Yates 算法打乱列表
    public static <T> void shuffle(List<T> list) {
        MersenneTwister rnd = new MersenneTwister();
        for (int i = list.size() - 1; i > 0; i--) {
            // 生成[0, i]范围内的随机索引
            int j = rnd.nextInt(i + 1);
            // 交换当前位置 i 和随机位置 j 的元素
            T temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }
}

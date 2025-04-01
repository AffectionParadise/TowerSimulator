package net.doge.util;

import java.awt.*;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Doge
 * @Description 列表工具类
 * @Date 2020/12/15
 */
public class ListUtil {
    public static List<Integer> ofRange(int min, int max) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = min; i <= max; i++) list.add(i);
        return list;
    }
}
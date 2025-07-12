package net.doge.util;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Doge
 * @Description 列表工具类
 * @Date 2020/12/15
 */
public class ListUtil {
    public static List<Integer> ofRange(int start, int end) {
        LinkedList<Integer> list = new LinkedList<>();
        if (start < end) for (int i = start; i <= end; i++) list.add(i);
        else for (int i = start; i >= end; i--) list.add(i);
        return list;
    }
}
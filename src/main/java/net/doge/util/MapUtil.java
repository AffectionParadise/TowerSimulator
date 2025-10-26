package net.doge.util;

import java.util.*;

/**
 * @Author Doge
 * @Description 映射工具类
 * @Date 2020/12/15
 */
public class MapUtil {
    public static <K, V> void shuffle(Map<K, V> map) {
        // 将 Map 的 Entry 转换为 List
        List<Map.Entry<K, V>> entries = new ArrayList<>(map.entrySet());
        // 打乱顺序
        Collections.shuffle(entries);
        map.clear();
        for (Map.Entry<K, V> entry : entries) map.put(entry.getKey(), entry.getValue());
    }
}
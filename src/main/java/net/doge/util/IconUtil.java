package net.doge.util;

import net.doge.constant.IconKey;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Doge
 * @Description 图标工具类
 * @Date 2020/12/15
 */
public class IconUtil {
    private static Map<IconKey, ImageIcon> iconCache = new HashMap<>();

    /**
     * 获取图标
     *
     * @param key
     * @return
     */
    public static ImageIcon getIcon(IconKey key) {
        try {
            if (iconCache.containsKey(key)) return iconCache.get(key);
            ImageIcon icon = new ImageIcon(ImageIO.read(new File(String.format("icon/%s.png", key.getValue()))));
            iconCache.put(key, icon);
            return icon;
        } catch (Exception e) {
            return null;
        }
    }
}
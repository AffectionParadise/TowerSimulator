package net.doge.util;

import java.awt.*;
import java.io.FileInputStream;

/**
 * @Author Doge
 * @Description 字体工具类
 * @Date 2020/12/15
 */
public class FontUtil {
    public static Font getFont(float size) {
        try {
            FileInputStream in = new FileInputStream("font/MiSans.ttf");
            Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, in);
            Font dynamicFontPt = dynamicFont.deriveFont(size);
            in.close();
            return dynamicFontPt;
        } catch (Exception e) {
            return null;
        }
    }
}
package net.doge.ui.widget.color;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.awt.*;

@Data
public class GColor {
    public static final GColor TRANSPARENT = new GColor(0, 0, 0, 0);
    public static final GColor DEFAULT = new GColor(51, 51, 51);

    public static final GColor BLACK = new GColor(0, 0, 0);
    public static final GColor WHITE = new GColor(255, 255, 255);
    public static final GColor LIGHT_GRAY = new GColor(192, 192, 192);
    public static final GColor LIGHT_BLUE = new GColor(18, 150, 219);
    public static final GColor LIGHT_GREEN = new GColor(221, 255, 207);
    public static final GColor BORDER_GREEN = new GColor(95, 109, 10);
    public static final GColor DEEP_GREEN = new GColor(34, 139, 34);
    public static final GColor DARK_RED = new GColor(224, 58, 60);
    public static final GColor DARK_ORANGE = new GColor(240, 163, 35);
    public static final GColor DARK_PURPLE = new GColor(143, 18, 253);

    // 塔
    public static final GColor REGULAR_TOWER_BRIGHT = new GColor(177, 220, 198);
    public static final GColor REGULAR_TOWER_HIGHLIGHT = new GColor(66,156,150);
    public static final GColor ADVANCED_TOWER_BRIGHT = new GColor(221, 255, 207);
    public static final GColor ADVANCED_TOWER_HIGHLIGHT = new GColor(34, 139, 34);
    public static final GColor TREASURE_TOWER_BRIGHT = new GColor(234, 218, 171);
    public static final GColor TREASURE_TOWER_HIGHLIGHT = new GColor(240, 163, 35);

    // 贵族
    public static final GColor NOBLE5_HIGHLIGHT = new GColor(106, 5, 206);
    public static final GColor NOBLE6_HIGHLIGHT = new GColor(106, 5, 206);
    public static final GColor NOBLE7_HIGHLIGHT = new GColor(255, 210, 0);

    // vip
    public static final GColor VIP1_BRIGHT = new GColor(161, 198, 218);
    public static final GColor VIP1_HIGHLIGHT = new GColor(18, 150, 219);
    public static final GColor VIP2_BRIGHT = new GColor(205, 157, 151);
    public static final GColor VIP2_HIGHLIGHT = new GColor(196, 39, 11);
    public static final GColor VIP3_BRIGHT = new GColor(211, 168, 248);
    public static final GColor VIP3_HIGHLIGHT = new GColor(143, 18, 253);

    public static final GColor BASIC_QUALITY = new GColor(133, 236, 105);
    public static final GColor REGULAR_QUALITY = new GColor(117, 211, 222);
    public static final GColor ADVANCED_QUALITY = new GColor(239, 140, 253);
    public static final GColor DELUXE_QUALITY = new GColor(247, 228, 44);
    public static final GColor ULTIMATE_QUALITY = new GColor(240, 163, 35);

    private int r;
    private int g;
    private int b;
    private int a;
    @JSONField(serialize = false)
    private Color awtColor;

    public GColor(int r, int g, int b) {
        this(r, g, b, 255);
    }

    public GColor(int r, int g, int b, int a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public Color getAwtColor() {
        if (awtColor == null) awtColor = new Color(r, g, b, a);
        return awtColor;
    }

    public static GColor of(Color color) {
        return new GColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }
}

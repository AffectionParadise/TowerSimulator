package net.doge.ui.widget.color;

import java.awt.*;

public class GColor {
    public static final GColor TRANSPARENT = new GColor(0, 0, 0, 0);
    public static final GColor DEFAULT = new GColor(51, 51, 51);

    public static final GColor BLACK = new GColor(0, 0, 0);
    public static final GColor WHITE = new GColor(255, 255, 255);
    public static final GColor LIGHT_GRAY = new GColor(192, 192, 192);
    public static final GColor LIGHT_BLUE = new GColor(18, 150, 219);
    public static final GColor DEEP_GREEN = new GColor(34, 139, 34);
    public static final GColor DARK_RED = new GColor(224, 58, 60);
    public static final GColor DARK_ORANGE = new GColor(240, 163, 35);
    public static final GColor DARK_PURPLE = new GColor(143, 18, 253);

    public static final GColor BASIC_QUALITY = new GColor(133, 236, 105);
    public static final GColor REGULAR_QUALITY = new GColor(117, 211, 222);
    public static final GColor ADVANCED_QUALITY = new GColor(239, 140, 253);
    public static final GColor DELUXE_QUALITY = new GColor(247, 228, 44);
    public static final GColor ULTIMATE_QUALITY = new GColor(240, 163, 35);

    private Color awtColor;

    public GColor(int r, int g, int b) {
        this(r, g, b, 255);
    }

    public GColor(int r, int g, int b, int alpha) {
        awtColor = new Color(r, g, b, alpha);
    }

    public Color getAWTColor() {
        return awtColor;
    }

    public static GColor of(Color color) {
        return new GColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }
}

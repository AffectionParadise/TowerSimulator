package net.doge.data;

import net.doge.util.FontUtil;

import java.awt.*;

public class FontData {
    private static float UI_SIZE = 17;
    private static float TIP_SIZE = 24;

    public static Font UI_FONT = FontUtil.getFont(UI_SIZE);
    public static Font TIP_FONT = UI_FONT.deriveFont(TIP_SIZE);
}

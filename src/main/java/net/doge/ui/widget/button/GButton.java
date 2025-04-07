package net.doge.ui.widget.button;

import net.doge.data.FontData;
import net.doge.ui.widget.color.GColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @Author yzx
 * @Description 对话框中的按钮自定义 UI
 * @Date 2020/12/13
 */
public class GButton extends JButton implements MouseListener {
    // 绘制时使用的颜色
    private GColor backgroundColor;
    private GColor disabledColor;

    private GColor originBgColor;

    public GButton(String text) {
        this(text, GColor.LIGHT_BLUE);
    }

    public GButton(GColor color) {
        this(null, color);
    }

    public GButton(String text, GColor color) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setForeground(GColor.WHITE.getAWTColor());
        setFont(FontData.UI_FONT);
        originBgColor = color;
        disabledColor = GColor.LIGHT_GRAY;
        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        int w = getWidth(), h = getHeight();
        Graphics2D g2d = (Graphics2D) g;
        // 画背景
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (backgroundColor == null) backgroundColor = originBgColor;
        g2d.setColor(isEnabled() ? backgroundColor.getAWTColor() : disabledColor.getAWTColor());
        g2d.fillRoundRect(0, 0, w, h, 10, 10);

        super.paintComponent(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        backgroundColor = GColor.of(originBgColor.getAWTColor().darker());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (getVisibleRect().contains(e.getPoint())) backgroundColor = GColor.of(originBgColor.getAWTColor().brighter());
        else backgroundColor = originBgColor;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        backgroundColor = GColor.of(originBgColor.getAWTColor().brighter());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        backgroundColor = originBgColor;
    }
}

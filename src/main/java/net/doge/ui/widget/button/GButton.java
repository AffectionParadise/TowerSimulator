package net.doge.ui.widget.button;

import net.doge.constant.Colors;
import net.doge.data.FontData;

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
    private Color backgroundColor;
    private Color disabledColor;

    private Color originBgColor;

    public GButton(String text) {
        this(text, Colors.LIGHT_BLUE);
    }

    public GButton(Color color) {
        this(null, color);
    }

    public GButton(String text, Color color) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setForeground(Color.WHITE);
        setFont(FontData.UI_FONT);
        originBgColor = color;
        disabledColor = Color.LIGHT_GRAY;
        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        int w = getWidth(), h = getHeight();
        Graphics2D g2d = (Graphics2D) g;
        // 画背景
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (backgroundColor == null) backgroundColor = originBgColor;
        g2d.setColor(isEnabled() ? backgroundColor : disabledColor);
        g2d.fillRoundRect(0, 0, w, h, 10, 10);

        super.paintComponent(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        backgroundColor = originBgColor.darker();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (getVisibleRect().contains(e.getPoint())) backgroundColor = originBgColor.brighter();
        else backgroundColor = originBgColor;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        backgroundColor = originBgColor.brighter();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        backgroundColor = originBgColor;
    }
}

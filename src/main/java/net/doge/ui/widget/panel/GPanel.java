package net.doge.ui.widget.panel;

import lombok.Setter;
import net.doge.ui.widget.color.GColor;

import javax.swing.*;
import java.awt.*;

public class GPanel extends JPanel {
    private GColor bgColor;
    @Setter
    private boolean gradientPaint;

    public GPanel() {
    }

    public GPanel(LayoutManager layout) {
        super(layout);
    }

    public void setBgColor(GColor bgColor) {
        this.bgColor = bgColor;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (bgColor != null) {
            int w = getWidth(), h = getHeight();
            Graphics2D g2d = (Graphics2D) g;
            // 画背景
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (gradientPaint)
                g2d.setPaint(new GradientPaint(0, 0, GColor.TRANSPARENT.getAwtColor(), 0, h, bgColor.getAwtColor()));
            else g2d.setColor(bgColor.getAwtColor());
            g2d.fillRoundRect(0, 0, w, h, 10, 10);
        }

        super.paintComponent(g);
    }
}

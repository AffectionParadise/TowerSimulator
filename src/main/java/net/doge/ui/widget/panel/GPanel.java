package net.doge.ui.widget.panel;

import javax.swing.*;
import java.awt.*;

public class GPanel extends JPanel {
    private Color bgColor;

    public GPanel() {
    }

    public GPanel(LayoutManager layout) {
        super(layout);
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(bgColor !=null) {
            int w = getWidth(), h = getHeight();
            Graphics2D g2d = (Graphics2D) g;
            // 画背景
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(bgColor);
            g2d.fillRoundRect(0, 0, w, h, 10, 10);
        }

        super.paintComponent(g);
    }
}

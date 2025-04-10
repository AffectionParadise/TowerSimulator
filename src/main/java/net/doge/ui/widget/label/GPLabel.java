package net.doge.ui.widget.label;

import lombok.Setter;
import net.doge.ui.widget.color.GColor;

import java.awt.*;

@Setter
public class GPLabel extends GLabel {
    private boolean useGradientPaint;
    private GColor c1;
    private GColor c2;

    public GPLabel() {
        super(null);
    }

    public GPLabel(String text) {
        super(text);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (c1 != null) {
            int w = getWidth(), h = getHeight();
            Graphics2D g2d = (Graphics2D) g;
            g2d.setPaint(useGradientPaint ? new GradientPaint(0, 0, c1.getAwtColor(), w, h, c2.getAwtColor()) : c1.getAwtColor());
            g2d.fillRect(0, 0, w, h);
        }
        super.paintComponent(g);
    }
}

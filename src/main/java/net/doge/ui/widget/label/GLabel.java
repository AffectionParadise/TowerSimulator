package net.doge.ui.widget.label;

import net.doge.data.FontData;

import javax.swing.*;

public class GLabel extends JLabel {

    public GLabel() {
        this(null);
    }

    public GLabel(String text) {
        super(text);
        setFont(FontData.UI_FONT);
        setHorizontalAlignment(CENTER);
    }
}

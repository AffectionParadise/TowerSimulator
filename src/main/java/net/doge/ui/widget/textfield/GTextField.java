package net.doge.ui.widget.textfield;

import net.doge.data.FontData;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GTextField extends JTextField {

    public GTextField() {
        this(null);
    }

    public GTextField(String text) {
        super(text);
        setFont(FontData.UI_FONT);
        setHorizontalAlignment(SwingConstants.CENTER);
        setPreferredSize(new Dimension(100, 30));
    }
}

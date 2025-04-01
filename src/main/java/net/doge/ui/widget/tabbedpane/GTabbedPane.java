package net.doge.ui.widget.tabbedpane;

import net.doge.data.FontData;

import javax.swing.*;

public class GTabbedPane extends JTabbedPane {
    public GTabbedPane() {
        setFont(FontData.UI_FONT);
        setTabPlacement(LEFT);
    }
}

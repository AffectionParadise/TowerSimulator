package net.doge.ui.widget.scroller;

import javax.swing.*;
import java.awt.*;

public class GScroller extends JScrollPane {

    public GScroller() {
        this(null);
    }

    public GScroller(Component view) {
        super(view);
        getHorizontalScrollBar().setUnitIncrement(50);
        getVerticalScrollBar().setUnitIncrement(50);
    }
}

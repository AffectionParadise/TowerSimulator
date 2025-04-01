package net.doge.ui.widget.list;

import javax.swing.*;
import java.util.List;

public class GList<E> extends JList<E> {

    public GList(ListModel<E> model) {
        super(model);
    }
}

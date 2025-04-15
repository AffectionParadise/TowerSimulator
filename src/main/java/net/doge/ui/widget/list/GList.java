package net.doge.ui.widget.list;

import javax.swing.*;

public class GList<E> extends JList<E> {
    public GList(ListModel<E> model) {
        super(model);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}

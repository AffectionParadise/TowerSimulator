package net.doge.ui.widget.dialog;

import lombok.Getter;
import net.doge.constant.Colors;
import net.doge.constant.IconKey;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.list.GList;
import net.doge.ui.widget.panel.GPanel;
import net.doge.ui.widget.scroller.GScroller;
import net.doge.util.IconUtil;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GDialog<E> extends JDialog {
    protected final Border BORDER_SELECTED = BorderFactory.createLineBorder(Colors.DEEP_GREEN, 5, true);
    protected final Border EMPTY_BORDER = BorderFactory.createEmptyBorder(10, 10, 10, 10);

    protected TowerUI ui;
    protected DefaultListModel<E> listModel = new DefaultListModel<>();
    protected GList<E> list = new GList<>(listModel);
    protected GScroller scroller = new GScroller(list);

    @Getter
    private boolean selectable;

    public GDialog(TowerUI ui) {
        this(ui, true);
    }

    public GDialog(TowerUI ui, boolean selectable) {
        super(ui, true);
        this.ui = ui;
        this.selectable = selectable;

        // 横向滚动时自适应高度
        list.setVisibleRowCount(0);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setEnabled(selectable);
        list.setCellRenderer(createCellRenderer());
        add(scroller, BorderLayout.CENTER);

        setSize(1000, 600);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    protected DefaultListCellRenderer createCellRenderer() {
        return null;
    }

    protected GPanel createCellPanel(String itemText, IconKey itemIconKey, String bottomText, boolean isSelected) {
        return createCellPanel(itemText, itemIconKey, bottomText, null, isSelected);
    }

    protected GPanel createCellPanel(String itemText, IconKey itemIconKey, String bottomText, IconKey bottomIconKey, boolean isSelected) {
        GPanel cellPanel = new GPanel(new BorderLayout());

        GPanel itemPanel = new GPanel();
        GLabel itemLabel = new GLabel();
        itemLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        itemLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        itemLabel.setText(itemText);
        itemLabel.setIcon(IconUtil.getIcon(itemIconKey));
        itemPanel.add(itemLabel);
        cellPanel.add(itemPanel, BorderLayout.CENTER);

        GPanel bottomPanel = new GPanel();
        GLabel bottomLabel = new GLabel();
        bottomLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        bottomLabel.setText(bottomText);
        bottomLabel.setIcon(IconUtil.getIcon(bottomIconKey));
        bottomPanel.add(bottomLabel);
        cellPanel.add(bottomPanel, BorderLayout.SOUTH);

        cellPanel.setBorder(isSelected ? BORDER_SELECTED : EMPTY_BORDER);

        return cellPanel;
    }
}

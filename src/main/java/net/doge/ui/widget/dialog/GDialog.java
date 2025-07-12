package net.doge.ui.widget.dialog;

import lombok.Getter;
import net.doge.constant.IconKey;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.color.GColor;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.list.GList;
import net.doge.ui.widget.panel.GPanel;
import net.doge.ui.widget.scroller.GScroller;
import net.doge.util.IconUtil;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GDialog<E> extends JDialog {
    protected final Border BORDER_SELECTED = BorderFactory.createLineBorder(GColor.DEEP_GREEN.getAwtColor(), 5, true);
    protected final Border EMPTY_BORDER = BorderFactory.createEmptyBorder(10, 10, 10, 10);

    protected TowerUI ui;
    protected DefaultListModel<E> listModel = new DefaultListModel<>();
    protected GList<E> list = new GList<>(listModel);
    protected GScroller scroller = new GScroller(list);

    protected GPanel cellPanel = new GPanel(new BorderLayout());
    protected GPanel itemPanel = new GPanel();
    protected GLabel itemLabel = new GLabel();
    protected GPanel bottomPanel = new GPanel();
    protected GLabel bottomLabel = new GLabel();

    @Getter
    private boolean gradientPaint;

    public GDialog(TowerUI ui) {
        this(ui, false);
    }

    public GDialog(TowerUI ui, boolean gradientPaint) {
        super(ui, true);
        this.ui = ui;
        this.gradientPaint = gradientPaint;

        // 横向滚动时自适应高度
        list.setVisibleRowCount(0);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setCellRenderer(createCellRenderer());
        add(scroller, BorderLayout.CENTER);

        setSize(1000, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        initCellPanel();
    }

    private void initCellPanel() {
        if (gradientPaint) {
            cellPanel.setOpaque(false);
            cellPanel.setGradientPaint(true);
            itemPanel.setOpaque(false);
            bottomPanel.setOpaque(false);
        }

        itemLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        itemLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        itemPanel.add(itemLabel);
        cellPanel.add(itemPanel, BorderLayout.CENTER);

        bottomLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        bottomPanel.add(bottomLabel);
        cellPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    protected DefaultListCellRenderer createCellRenderer() {
        return null;
    }

    protected GPanel createCellPanel(String itemText, IconKey itemIconKey, String bottomText, boolean isSelected) {
        return createCellPanel(itemText, itemIconKey, null, bottomText, null, null, isSelected);
    }

    protected GPanel createCellPanel(String itemText, IconKey itemIconKey, GColor itemTextForeColor, String bottomText, boolean isSelected) {
        return createCellPanel(itemText, itemIconKey, itemTextForeColor, bottomText, null, null, isSelected);
    }

    protected GPanel createCellPanel(String itemText, IconKey itemIconKey, String bottomText, GColor bgColor, boolean isSelected) {
        return createCellPanel(itemText, itemIconKey, null, bottomText, null, bgColor, isSelected);
    }

    protected GPanel createCellPanel(String itemText, IconKey itemIconKey, String bottomText, IconKey bottomIconKey, boolean isSelected) {
        return createCellPanel(itemText, itemIconKey, null, bottomText, bottomIconKey, null, isSelected);
    }

    protected GPanel createCellPanel(String itemText, IconKey itemIconKey, GColor itemTextForeColor,
                                     String bottomText, IconKey bottomIconKey, GColor bgColor, boolean isSelected) {
        cellPanel.setBgColor(bgColor);

        itemLabel.setText(itemText);
        itemLabel.setIcon(IconUtil.getIcon(itemIconKey));
        if (itemTextForeColor != null) itemLabel.setForeground(itemTextForeColor.getAwtColor());

        bottomLabel.setText(bottomText);
        bottomLabel.setIcon(IconUtil.getIcon(bottomIconKey));

        cellPanel.setBorder(isSelected ? BORDER_SELECTED : EMPTY_BORDER);

        return cellPanel;
    }
}

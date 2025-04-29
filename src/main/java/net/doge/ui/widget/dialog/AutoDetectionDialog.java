package net.doge.ui.widget.dialog;

import lombok.Getter;
import net.doge.data.TowerData;
import net.doge.model.Item;
import net.doge.model.SampleModel;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.button.GButton;
import net.doge.ui.widget.color.GColor;
import net.doge.ui.widget.panel.GPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AutoDetectionDialog extends GDialog<Item> {
    private GPanel bottomPanel = new GPanel();
    private GButton okBtn = new GButton("开始探索", GColor.DEEP_GREEN);

    @Getter
    private boolean confirmed;

    public AutoDetectionDialog(TowerUI ui) {
        super(ui, true);
        init();
    }

    @Override
    protected DefaultListCellRenderer createCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Item item = (Item) value;
                return createCellPanel(item.getName(), item.getIconKey(), "", item.getHighlightColor(), isSelected);
            }
        };
    }

    public void init() {
        for (SampleModel<Item> sm : TowerData.currTower.getItemSampler().getModels())
            listModel.addElement(sm.getItem());

        okBtn.addActionListener(e -> {
            confirmed = true;
            dispose();
        });

        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomPanel.add(okBtn);

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Item item = list.getSelectedValue();
                if (item == null || e.getClickCount() != 2) return;
                new ItemDetailDialog(ui, item);
            }
        });

        setTitle("自动探索");

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}

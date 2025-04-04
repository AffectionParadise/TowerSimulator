package net.doge.ui.widget.dialog;

import lombok.Getter;
import net.doge.constant.Colors;
import net.doge.data.DataStorage;
import net.doge.data.TowerData;
import net.doge.model.GiftRecord;
import net.doge.model.Item;
import net.doge.model.Tower;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.button.GButton;
import net.doge.ui.widget.color.GColor;
import net.doge.ui.widget.panel.GPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TowerDialog extends GDialog<Tower> {
    private Box topBox = new Box(BoxLayout.X_AXIS);
    private GPanel bottomPanel = new GPanel();
    private GButton enterBtn = new GButton("进入", GColor.DEEP_GREEN);
    private GButton quitBtn = new GButton("放弃", GColor.DARK_RED);

    @Getter
    private boolean confirmed;

    public TowerDialog(TowerUI ui) {
        super(ui);
        this.ui = ui;
        init();
    }

    @Override
    protected DefaultListCellRenderer createCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Tower tower = (Tower) value;
                Item stepItem = tower.getStepItem();
                return createCellPanel(tower.getName(), tower.getIconKey(), String.format("门票：%s", DataStorage.get(stepItem.getStorageKey())), stepItem.getIconThumbKey(), isSelected);
            }
        };
    }

    public void init() {
        for (Tower tower : TowerData.towers) {
            if (!tower.isVisible()) continue;
            listModel.addElement(tower);
        }

        enterBtn.addActionListener(e -> {
            Tower tower = list.getSelectedValue();
            if (tower == null) return;
            confirmed = true;
            dispose();
        });
        quitBtn.addActionListener(e -> {
            Tower tower = list.getSelectedValue();
            if (tower == null) return;
            listModel.removeElement(tower);
            ui.finishTreasure(tower);
        });
        quitBtn.setVisible(false);

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Tower tower = list.getSelectedValue();
                if (tower == null) return;
                quitBtn.setVisible(tower.isOptional());
            }
        });

        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomPanel.add(enterBtn);
        bottomPanel.add(quitBtn);

        setTitle("塔群");

        add(topBox, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public Tower getSelectedTower() {
        return list.getSelectedValue();
    }
}

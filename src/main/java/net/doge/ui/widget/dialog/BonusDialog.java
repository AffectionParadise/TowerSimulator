package net.doge.ui.widget.dialog;

import lombok.Getter;
import net.doge.constant.Colors;
import net.doge.data.BonusData;
import net.doge.model.Bonus;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.button.GButton;
import net.doge.ui.widget.panel.GPanel;

import javax.swing.*;
import java.awt.*;

public class BonusDialog extends GDialog<Bonus> {
    private Box topBox = new Box(BoxLayout.X_AXIS);
    private GPanel bottomPanel = new GPanel();
    private GButton okBtn = new GButton("确认", Colors.DEEP_GREEN);

    @Getter
    private boolean confirmed;

    public BonusDialog(TowerUI ui) {
        super(ui);
        init();
    }

    @Override
    protected DefaultListCellRenderer createCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Bonus bonus = (Bonus) value;
                return createCellPanel(String.format("%s~%s倍", bonus.getMinRate(), bonus.getMaxRate()), bonus.getIconKey(), String.format("每步消耗：%s", bonus.getStepCost()), isSelected);
            }
        };
    }

    public void init() {
        for (Bonus bonus : BonusData.getBonuses()) listModel.addElement(bonus);

        okBtn.addActionListener(e -> {
            Bonus bonus = list.getSelectedValue();
            if (bonus == null) return;
            confirmed = true;
            dispose();
        });

        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bottomPanel.add(okBtn);

        setTitle("礼物翻倍");

        add(topBox, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public Bonus getSelectedBonus() {
        return list.getSelectedValue();
    }
}

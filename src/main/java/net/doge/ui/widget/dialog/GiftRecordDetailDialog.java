package net.doge.ui.widget.dialog;

import net.doge.model.*;
import net.doge.ui.TowerUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GiftRecordDetailDialog extends GDialog<GiftResult> {
    private GiftRecord record;

    public GiftRecordDetailDialog(TowerUI ui, GiftRecord record) {
        super(ui);
        this.record = record;
        init();
    }

    @Override
    protected DefaultListCellRenderer createCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                GiftResult res = (GiftResult) value;
                Item it = res.getItem();
                int n = res.getNum();
                return createCellPanel(it.getName(), it.getIconKey(), String.format("%s个", n), isSelected);
            }
        };
    }

    public void init() {
        for (GiftResult result : record.getResults()) listModel.addElement(result);

        setTitle("礼物记录详情");

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                GiftResult result = list.getSelectedValue();
                if (result == null || e.getClickCount() != 2) return;
                new GiftDetailDialog(ui, result.getItem());
            }
        });

        setVisible(true);
    }
}

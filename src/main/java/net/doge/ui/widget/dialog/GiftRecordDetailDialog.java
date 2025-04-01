package net.doge.ui.widget.dialog;

import net.doge.model.*;
import net.doge.ui.TowerUI;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class GiftRecordDetailDialog extends GDialog<GiftResult> {
    private GiftRecord record;

    public GiftRecordDetailDialog(TowerUI ui, GiftRecord record) {
        super(ui, false);
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
        for (Map.Entry<Item, Integer> entry : record.getSubItems().entrySet()) listModel.addElement(new GiftResult(entry.getKey(), entry.getValue()));

        setTitle("礼物记录");

        setVisible(true);
    }
}

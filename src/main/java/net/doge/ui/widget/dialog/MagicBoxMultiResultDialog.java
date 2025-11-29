package net.doge.ui.widget.dialog;

import net.doge.model.*;
import net.doge.ui.TowerUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Map;

public class MagicBoxMultiResultDialog extends GDialog<GiftResult> {
    private MagicBoxDialog d;
    private Compound compound;
    private int num;

    public MagicBoxMultiResultDialog(TowerUI ui, MagicBoxDialog d, Compound compound, int num) {
        super(ui);
        this.d = d;
        this.compound = compound;
        this.num = num;
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
        // 开出
        Sampler<Item> itemSampler = compound.getItemSampler();
        Map<Item, Integer> res = new LinkedHashMap<>();
        for (int i = 0; i < num; i++) {
            Item itemReceived = itemSampler.lottery().getItem();
            int numReceived = itemReceived.hasNumSampler() ? itemReceived.getNumSampler().lottery().getItem() : 1;
            res.put(itemReceived, res.getOrDefault(itemReceived, 0) + numReceived);
        }
        for (Map.Entry<Item, Integer> entry : res.entrySet()) {
            Item item = entry.getKey();
            int num = entry.getValue();
            ui.updateItemAmountAndView(item, num);
            listModel.addElement(new GiftResult(item, num));
        }

        setTitle("魔盒奖励");

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                GiftResult result = list.getSelectedValue();
                if (result == null || e.getClickCount() != 2) return;
                new ItemDetailDialog(ui, result.getItem());
            }
        });

        setVisible(true);
    }
}

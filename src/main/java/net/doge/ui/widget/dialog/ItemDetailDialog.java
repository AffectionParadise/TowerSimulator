package net.doge.ui.widget.dialog;

import net.doge.constant.IconKey;
import net.doge.model.Item;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.panel.GPanel;
import net.doge.util.IconUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ItemDetailDialog extends GDialog<Item> {
    private GPanel centerPanel = new GPanel();
    private GPanel itemPanel = new GPanel();
    private GLabel itemLabel = new GLabel();
    private GPanel detailPanel = new GPanel();
    private GPanel tipPanel = new GPanel();
    private GLabel tipLabel = new GLabel();
    private GLabel valueLabel = new GLabel();
    private GLabel giftPointsLabel = new GLabel();
    private GLabel exchangeNumLabel = new GLabel();

    private Item item;

    public ItemDetailDialog(TowerUI ui, Item item) {
        super(ui);
        this.item = item;
        init();
    }

    @Override
    protected DefaultListCellRenderer createCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Item item = (Item) value;
                return createCellPanel(item.getName(), item.getIconKey(), "", isSelected);
            }
        };
    }

    public void init() {
        itemLabel.setText(item.getName());
        itemLabel.setIcon(IconUtil.getIcon(item.getIconKey()));
        itemLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        itemLabel.setVerticalTextPosition(SwingConstants.BOTTOM);

        itemPanel.setLayout(new BorderLayout());
        itemPanel.add(itemLabel, BorderLayout.CENTER);

        int sh = 30;
        if (item.isBox()) {
            item.getSubItemSampler().getModels().forEach(model -> listModel.addElement(model.getItem()));

            tipLabel.setText("开启该盲盒有机会送出以下礼物：");

            tipPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            tipPanel.add(tipLabel);

            detailPanel.add(Box.createVerticalGlue());
            detailPanel.add(tipPanel);
            detailPanel.add(Box.createVerticalStrut(sh));
            detailPanel.add(scroller);
            detailPanel.add(Box.createVerticalGlue());
        } else if (item.isPresent()) {
            valueLabel.setText(String.valueOf(item.getValue()));
            valueLabel.setIcon(IconUtil.getIcon(IconKey.ADVANCED_COIN_THUMB));

            giftPointsLabel.setText(String.valueOf(item.getGiftPoints()));
            giftPointsLabel.setIcon(IconUtil.getIcon(IconKey.GIFT_POINTS));

            exchangeNumLabel.setText(String.format("送出可兑换：%d", (int) (item.getGiftPoints() / 7.5)));
            exchangeNumLabel.setIcon(IconUtil.getIcon(IconKey.ADVANCED_COIN_THUMB));
            exchangeNumLabel.setHorizontalTextPosition(SwingConstants.LEFT);

            detailPanel.add(Box.createVerticalGlue());
            detailPanel.add(valueLabel);
            detailPanel.add(Box.createVerticalStrut(sh));
            detailPanel.add(giftPointsLabel);
            detailPanel.add(Box.createVerticalStrut(sh));
            detailPanel.add(exchangeNumLabel);
            detailPanel.add(Box.createVerticalGlue());
        } else {
            tipLabel.setText("游戏内的一种货币");

            detailPanel.add(Box.createVerticalGlue());
            detailPanel.add(tipLabel);
            detailPanel.add(Box.createVerticalGlue());
        }

        detailPanel.setLayout(new BoxLayout(detailPanel, BoxLayout.Y_AXIS));

        centerPanel.setLayout(new GridLayout(1, 2));
        centerPanel.add(itemPanel);
        centerPanel.add(detailPanel);

        add(centerPanel, BorderLayout.CENTER);

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Item item = list.getSelectedValue();
                if (item == null || e.getClickCount() != 2) return;
                new ItemDetailDialog(ui, item);
            }
        });

        setTitle("物品详情");

        setVisible(true);
    }
}

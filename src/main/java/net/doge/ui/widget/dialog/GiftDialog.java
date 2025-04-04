package net.doge.ui.widget.dialog;

import net.doge.constant.Colors;
import net.doge.constant.IconKey;
import net.doge.constant.StorageKey;
import net.doge.data.DataStorage;
import net.doge.data.ItemData;
import net.doge.data.GiftCensusStorage;
import net.doge.model.GiftRecord;
import net.doge.model.Item;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.button.GButton;
import net.doge.ui.widget.color.GColor;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.panel.GPanel;
import net.doge.util.IconUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class GiftDialog extends GDialog<Item> {
    private GPanel topPanel = new GPanel();
    private GButton giftStorageBtn = new GButton("赠送礼物", GColor.DARK_RED);
    private GLabel giftPointsLabel = new GLabel();
    private GButton gpExchangeBtn = new GButton("积分兑换", GColor.DEEP_GREEN);
    private GButton giftRecordBtn = new GButton("礼物记录", GColor.DEEP_GREEN);

    public GiftDialog(TowerUI ui) {
        super(ui);
        init();
    }

    @Override
    protected DefaultListCellRenderer createCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Item item = (Item) value;
                return createCellPanel(item.getName(), item.getIconKey(), String.format("已送出：%s", GiftCensusStorage.get(item.getStorageKey())), isSelected);
            }
        };
    }

    // 更新礼物积分
    public void updateGiftPoints(int amount) {
        DataStorage.add(StorageKey.GIFT_POINTS, amount);
        giftPointsLabel.setText(String.valueOf(DataStorage.get(StorageKey.GIFT_POINTS)));
    }

    public void addItemNonRepetitive(Item item) {
        // 存在该种礼物，刷新数量即可
        if (listModel.contains(item)) list.repaint();
        else listModel.addElement(item);
    }

    private void init() {
        for (Item item : ItemData.items) {
            if (!item.isPresent()) continue;
            int num = GiftCensusStorage.get(item.getStorageKey());
            if (num < 1) continue;
            listModel.addElement(item);
        }

        giftStorageBtn.addActionListener(e -> new GiftPresentDialog(ui, this));
        giftPointsLabel.setIcon(IconUtil.getIcon(IconKey.GIFT_POINTS));
        gpExchangeBtn.addActionListener(e -> new GPExchangeDialog(ui, this));
        giftRecordBtn.addActionListener(e -> new GiftRecordDialog(ui));

        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        topPanel.add(giftStorageBtn);
        topPanel.add(giftPointsLabel);
        topPanel.add(gpExchangeBtn);
        topPanel.add(giftRecordBtn);

        updateGiftPoints(0);

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Item item = list.getSelectedValue();
                if (item == null || e.getClickCount() != 2) return;
                new GiftDetailDialog(ui, item);
            }
        });

        setTitle("礼物");

        add(topPanel, BorderLayout.NORTH);
        setVisible(true);
    }
}

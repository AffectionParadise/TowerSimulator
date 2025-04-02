package net.doge.ui.widget.dialog;

import net.doge.constant.Colors;
import net.doge.constant.IconKey;
import net.doge.constant.StorageKey;
import net.doge.data.AccountData;
import net.doge.data.DataStorage;
import net.doge.data.GiftRecordStorage;
import net.doge.model.Account;
import net.doge.model.GiftRecord;
import net.doge.model.GiftResult;
import net.doge.model.Item;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.button.GButton;
import net.doge.ui.widget.label.GLabel;
import net.doge.util.IconUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class GiftRecordDialog extends GDialog<GiftRecord> {
    private Box topBox = new Box(BoxLayout.X_AXIS);
    private GLabel totalValueLabel = new GLabel();

    public GiftRecordDialog(TowerUI ui) {
        super(ui);
        init();
    }

    @Override
    protected DefaultListCellRenderer createCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                GiftRecord record = (GiftRecord) value;
                return createGiftRecordBox(record);
            }
        };
    }

    private Box createGiftRecordBox(GiftRecord record) {
        Box recordBox = new Box(BoxLayout.X_AXIS);
        Account account = AccountData.ACCOUNT;
        GLabel accountLabel = new GLabel();
        accountLabel.setForeground(Colors.DARK_RED);
        accountLabel.setText(account.getName());
        accountLabel.setIcon(IconUtil.getIcon(account.getAvatar()));
        recordBox.add(accountLabel);

        GLabel descLabel = new GLabel();
        descLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        recordBox.add(descLabel);
        Item itemPresented = record.getItemPresented();
        List<GiftResult> results = record.getResults();
        if (results != null) {
            if (results.size() == 1) {
                results.forEach(result -> {
                    descLabel.setText(String.format("使用%s赠送了 %s 个珍贵礼物：%s", itemPresented.getName(), result.getNum(), result.getItem().getName()));
                    descLabel.setIcon(IconUtil.getIcon(result.getItem().getIconKey()));
                });
            } else {
                descLabel.setText(String.format("赠送了 %s 个%s", record.getNumPresented(), itemPresented.getName()));
                descLabel.setIcon(IconUtil.getIcon(itemPresented.getIconKey()));
                recordBox.add(Box.createHorizontalStrut(20));
                GButton detailBtn = new GButton("详情", Colors.DEEP_GREEN);
                detailBtn.addActionListener(e -> new GiftRecordDetailDialog(ui, record));
                recordBox.add(detailBtn);
            }
        } else {
            descLabel.setText(String.format("赠送了 %s 个%s", record.getNumPresented(), itemPresented.getName()));
            descLabel.setIcon(IconUtil.getIcon(itemPresented.getIconKey()));
        }

        recordBox.add(Box.createHorizontalGlue());

        GLabel valueLabel = new GLabel();
        valueLabel.setText(String.valueOf(record.getTotalValue()));
        valueLabel.setIcon(IconUtil.getIcon(IconKey.ADVANCED_COIN_THUMB));
        recordBox.add(valueLabel);

        recordBox.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        return recordBox;
    }

    public void init() {
        for (GiftRecord record : GiftRecordStorage.getStorage()) listModel.addElement(record);

        totalValueLabel.setText(String.format("已送出总价值 %s 的礼物", formatValue(DataStorage.get(StorageKey.TOTAL_VALUE))));
        totalValueLabel.setIcon(IconUtil.getIcon(IconKey.ADVANCED_COIN_THUMB));

        list.setLayoutOrientation(JList.VERTICAL);
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                GiftRecord record = list.getSelectedValue();
                if (record == null || record.isOneKind()) return;
                new GiftRecordDetailDialog(ui, record);
            }
        });

        setTitle("礼物记录");
        setLocationRelativeTo(null);

        topBox.add(Box.createHorizontalGlue());
        topBox.add(totalValueLabel);
        topBox.add(Box.createHorizontalGlue());

        add(topBox, BorderLayout.NORTH);

        setVisible(true);
    }

    private String formatValue(int value) {
        if (value < 10000) return String.valueOf(value);
        else if (value < 1000000) return String.format("%.1fK", (double) value / 1000);
        else if (value < 1000000000) return String.format("%.1fM", (double) value / 1000000);
        return String.format("%.1fB", (double) value / 1000000000);
    }
}

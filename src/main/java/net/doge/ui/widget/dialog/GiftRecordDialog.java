package net.doge.ui.widget.dialog;

import net.doge.constant.IconKey;
import net.doge.constant.StorageKey;
import net.doge.data.AccountData;
import net.doge.data.storage.DataStorage;
import net.doge.data.storage.GiftRecordStorage;
import net.doge.model.Account;
import net.doge.model.GiftRecord;
import net.doge.model.GiftResult;
import net.doge.model.Item;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.button.GButton;
import net.doge.ui.widget.color.GColor;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.panel.GPanel;
import net.doge.util.IconUtil;
import net.doge.util.StrUtil;
import net.doge.util.TimeUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class GiftRecordDialog extends GDialog<GiftRecord> {
    private Box topBox = new Box(BoxLayout.X_AXIS);
    private GLabel totalValueLabel = new GLabel();

    private Box recordBox = new Box(BoxLayout.X_AXIS);
    private GLabel accountLabel = new GLabel();
    private GLabel descLabel = new GLabel();
    private Component hs = Box.createHorizontalStrut(20);
    private GButton detailBtn = new GButton("详情", GColor.DEEP_GREEN);
    private Box valueBox = new Box(BoxLayout.Y_AXIS);
    private GPanel timePanel = new GPanel();
    private GLabel timeLabel = new GLabel();
    private GPanel valuePanel = new GPanel();
    private GLabel valueLabel = new GLabel();

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

    private void initGiftRecordBox() {
        Account account = AccountData.account;

        accountLabel.setForeground(account.getTextColor().getAwtColor());
        accountLabel.setText(account.getName());
        accountLabel.setIcon(IconUtil.getIcon(account.getAvatar()));
        recordBox.add(accountLabel);

        descLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        recordBox.add(descLabel);

        recordBox.add(hs);

//        detailBtn.addActionListener(e -> new GiftRecordDetailDialog(ui, record));
        recordBox.add(detailBtn);

        recordBox.add(Box.createHorizontalGlue());

        FlowLayout fl = new FlowLayout(FlowLayout.RIGHT);
        timePanel.setOpaque(false);
        timePanel.setLayout(fl);
        timePanel.add(timeLabel);

        valueLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        valuePanel.setOpaque(false);
        valuePanel.setLayout(fl);
        valuePanel.add(valueLabel);

        valueBox.add(timePanel);
        valueBox.add(valuePanel);

        recordBox.add(valueBox);

        recordBox.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

    private Box createGiftRecordBox(GiftRecord record) {
        Item itemPresented = record.getItemPresented();
        List<GiftResult> results = record.getResults();
        if (results != null) {
            if (results.size() == 1) {
                GiftResult result = results.get(0);
                descLabel.setText(String.format("使用%s赠送了 %s 个珍贵礼物：%s", itemPresented.getName(), result.getNum(), result.getItem().getName()));
                descLabel.setIcon(IconUtil.getIcon(result.getItem().getIconKey()));
                hs.setVisible(false);
                detailBtn.setVisible(false);
            } else {
                descLabel.setText(String.format("赠送了 %s 个%s", record.getNumPresented(), itemPresented.getName()));
                descLabel.setIcon(IconUtil.getIcon(itemPresented.getIconKey()));
                hs.setVisible(true);
                detailBtn.setVisible(true);
            }
        } else {
            descLabel.setText(String.format("赠送了 %s 个%s", record.getNumPresented(), itemPresented.getName()));
            descLabel.setIcon(IconUtil.getIcon(itemPresented.getIconKey()));
            hs.setVisible(false);
            detailBtn.setVisible(false);
        }

        timeLabel.setText(TimeUtil.msToPhrase(record.getTimestamp()));
        valueLabel.setText(String.format("价值：%s", record.getTotalValue()));
        valueLabel.setIcon(IconUtil.getIcon(IconKey.ADVANCED_COIN_THUMB));

        return recordBox;
    }

    public void init() {
        for (GiftRecord record : GiftRecordStorage.getStorage()) listModel.addElement(record);

        totalValueLabel.setText(String.format("已送出总价值 %s 的礼物", StrUtil.formatValue(DataStorage.get(StorageKey.TOTAL_VALUE))));
        totalValueLabel.setIcon(IconUtil.getIcon(IconKey.ADVANCED_COIN_THUMB));

        initGiftRecordBox();

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
}

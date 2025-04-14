package net.doge.ui.widget.dialog;

import net.doge.constant.IconKey;
import net.doge.constant.ItemType;
import net.doge.constant.StorageKey;
import net.doge.data.storage.DataStorage;
import net.doge.data.ItemData;
import net.doge.model.Item;
import net.doge.model.Transaction;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.button.GButton;
import net.doge.ui.widget.color.GColor;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.panel.GPanel;
import net.doge.ui.widget.slider.GSlider;
import net.doge.util.IconUtil;

import javax.swing.*;
import java.awt.*;

public class GPExchangeDialog extends GDialog<Transaction> {
    private GiftDialog d;
    private Box topBox = new Box(BoxLayout.X_AXIS);
    private GLabel currencyLabel = new GLabel();
    // 物品
    private GPanel centerPanel = new GPanel();
    private GPanel itemPanel = new GPanel();
    private GLabel itemLabel = new GLabel();
    private GPanel costPanel = new GPanel();
    private GLabel costLabel = new GLabel();
    // 底部
    private GPanel bottomPanel = new GPanel();
    private GPanel totalReceivedPanel = new GPanel();
    private GLabel totalReceivedLabel = new GLabel("兑换 0 次，获得 0");
    private GPanel controlPanel = new GPanel();
    private GButton minusBtn = new GButton("-", GColor.DEEP_GREEN);
    private GSlider numSlider = new GSlider();
    private GButton plusBtn = new GButton("+", GColor.DEEP_GREEN);
    private GButton maxBtn = new GButton("最大", GColor.LIGHT_BLUE);
    private GButton exchangeBtn = new GButton("兑换", GColor.DEEP_GREEN);

    private Transaction transaction;

    public GPExchangeDialog(TowerUI ui, GiftDialog d) {
        super(ui, false);
        this.d = d;
        this.ui = ui;
        init();
    }

    public void init() {
        Item giftPoints = new Item("礼物积分", ItemType.CURRENCY, null, StorageKey.GIFT_POINTS);
        giftPoints.setIconThumbKey(IconKey.GIFT_POINTS);
        transaction = new Transaction(IconKey.ADVANCED_COIN, ItemData.ADVANCED_COIN, 200, giftPoints, 1500);

        Item currency = transaction.getItemConsumed();
        int total = DataStorage.get(currency.getStorageKey());
        currencyLabel.setText(String.valueOf(total));
        currencyLabel.setIcon(IconUtil.getIcon(currency.getIconThumbKey()));
        topBox.add(Box.createHorizontalGlue());
        topBox.add(currencyLabel);
        topBox.add(Box.createHorizontalStrut(20));

        itemLabel.setText(String.valueOf(transaction.getNumReceived()));
        itemLabel.setIcon(IconUtil.getIcon(transaction.getIconKey()));
        itemLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        itemLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        itemPanel.add(itemLabel);

        costLabel.setText(String.format("花费：%s", transaction.getCost()));
        costLabel.setIcon(IconUtil.getIcon(transaction.getItemConsumed().getIconThumbKey()));
        costLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        costPanel.add(costLabel);

        minusBtn.addActionListener(e -> numSlider.setValue(numSlider.getValue() - 1));

        numSlider.setMaximum(total / transaction.getCost());
        numSlider.addChangeListener(e -> {
            int num = numSlider.getValue();
            totalReceivedLabel.setText(String.format("兑换 %s 次，获得 %s", num, num * transaction.getNumReceived()));
        });

        plusBtn.addActionListener(e -> numSlider.setValue(numSlider.getValue() + 1));

        totalReceivedLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        totalReceivedLabel.setIcon(IconUtil.getIcon(transaction.getItemReceived().getIconThumbKey()));

        maxBtn.addActionListener(e -> numSlider.setValue(numSlider.getMaximum()));

        exchangeBtn.addActionListener(e -> {
            int num = numSlider.getValue();
            int totalCost = num * transaction.getCost();
            StorageKey csk = currency.getStorageKey();
            // 货币不足
            if (totalCost > DataStorage.get(csk)) {
                new TipDialog(this, String.format("%s不足", currency.getName()));
                return;
            }
            // 扣除货币数量并回显
            DataStorage.add(csk, -totalCost);
            int nt = DataStorage.get(csk);
            currencyLabel.setText(String.valueOf(nt));
            d.updateGiftPoints(0);
            numSlider.setMaximum(nt / transaction.getCost());
            // 兑换物品增加
            DataStorage.add(transaction.getItemReceived().getStorageKey(), num * transaction.getNumReceived());
        });

        totalReceivedPanel.add(totalReceivedLabel);

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(itemPanel);
        centerPanel.add(costPanel);
        centerPanel.add(Box.createVerticalGlue());

        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        controlPanel.add(minusBtn);
        controlPanel.add(numSlider);
        controlPanel.add(plusBtn);
        controlPanel.add(maxBtn);
        controlPanel.add(exchangeBtn);

        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.add(totalReceivedPanel);
        bottomPanel.add(controlPanel);

        setTitle("积分兑换");

        add(topBox, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}

package net.doge.ui.widget.dialog;

import net.doge.data.DataStorage;
import net.doge.constant.Colors;
import net.doge.constant.StorageKey;
import net.doge.data.TransactionData;
import net.doge.model.Item;
import net.doge.model.Transaction;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.button.GButton;
import net.doge.ui.widget.color.GColor;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.panel.GPanel;
import net.doge.util.IconUtil;

import javax.swing.*;
import java.awt.*;

public class TransactionDialog extends GDialog<Transaction> {
    private Box topBox = new Box(BoxLayout.X_AXIS);
    private GLabel currencyLabel = new GLabel();
    private GPanel bottomPanel = new GPanel();
    private GButton buyBtn = new GButton("购买", GColor.DEEP_GREEN);

    public TransactionDialog(TowerUI ui) {
        super(ui);
        init();
    }

    @Override
    protected DefaultListCellRenderer createCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Transaction transaction = (Transaction) value;
                return createCellPanel(String.valueOf(transaction.getNumReceived()), transaction.getIconKey(), String.format("花费：%s", transaction.getCost()),
                        transaction.getItemConsumed().getIconThumbKey(), isSelected);
            }
        };
    }

    private void init() {
        for (Transaction transaction : TransactionData.transactions) {
            if (transaction.getItemReceived().equals(ui.currTower.getStepItem())) listModel.addElement(transaction);
        }

        buyBtn.addActionListener(e -> {
            Transaction transaction = list.getSelectedValue();
            if (transaction == null) return;
            int cost = transaction.getCost();
            Item itemConsumed = transaction.getItemConsumed();
            StorageKey csk = itemConsumed.getStorageKey();
            // 货币不足
            if (cost > DataStorage.get(csk)) {
                new TipDialog(this, String.format("%s不足", transaction.getItemConsumed().getName()));
                return;
            }
            // 扣除货币数量并回显
            DataStorage.add(csk, -cost);
            int nn = DataStorage.get(csk);
            currencyLabel.setText(String.valueOf(nn));
            // 获得物品
            ui.updateItemAmountAndView(transaction.getItemReceived(), transaction.getNumReceived());
        });

        Item currency = TransactionData.transactions.get(0).getItemConsumed();
        currencyLabel.setText(String.valueOf(DataStorage.get(currency.getStorageKey())));
        currencyLabel.setIcon(IconUtil.getIcon(currency.getIconThumbKey()));
        topBox.add(Box.createHorizontalGlue());
        topBox.add(currencyLabel);
        topBox.add(Box.createHorizontalStrut(20));

        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomPanel.add(Box.createHorizontalGlue());
        bottomPanel.add(buyBtn);
        bottomPanel.add(Box.createHorizontalGlue());

        setTitle("购买步数");

        add(topBox, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}

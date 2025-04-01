package net.doge.ui.widget.dialog;

import net.doge.constant.IconKey;
import net.doge.data.DataStorage;
import net.doge.constant.Colors;
import net.doge.constant.StorageKey;
import net.doge.data.ItemData;
import net.doge.model.Item;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.button.GButton;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.panel.GPanel;
import net.doge.ui.widget.textfield.NumTextField;
import net.doge.util.IconUtil;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.List;

public class CoinExchangeDialog extends GDialog<Item> {
    private Box topBox = new Box(BoxLayout.X_AXIS);
    private GLabel currencyLabel = new GLabel();
    private GPanel bottomPanel = new GPanel();
    private GPanel totalCostPanel = new GPanel();
    private GLabel totalCostLabel = new GLabel("0");
    private GPanel controlPanel = new GPanel();
    private NumTextField numTextField = new NumTextField();
    private GButton maxBtn = new GButton("最大", Colors.LIGHT_BLUE);
    private GButton exchangeBtn = new GButton("兑换", Colors.DEEP_GREEN);

    private Item currency;

    public CoinExchangeDialog(TowerUI ui, Item currency) {
        super(ui);
        this.currency = currency;
        init();
    }

    @Override
    protected DefaultListCellRenderer createCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Item item = (Item) value;
                return createCellPanel(item.getName(), item.getIconKey(), String.format("花费：%s", item.getExchangeCost()), currency.getIconThumbKey(), isSelected);
            }
        };
    }

    public void init() {
        List<Item> items = ItemData.getItems();
        for (Item item : items) {
            if (!item.isExchangeable()) continue;
            listModel.addElement(item);
        }

        numTextField.getDocument().addDocumentListener(new DocumentListener() {
            private void update() {
                try {
                    Item item = list.getSelectedValue();
                    if (item == null) return;
                    String text = numTextField.getText();
                    if (text.isEmpty()) return;
                    int num = Integer.parseInt(text);
                    int totalCost = num * item.getExchangeCost();
                    totalCostLabel.setText(String.valueOf(totalCost));
                } catch (NumberFormatException ex) {
                    totalCostLabel.setText(null);
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        currencyLabel.setText(String.valueOf(DataStorage.get(currency.getStorageKey())));
        currencyLabel.setIcon(IconUtil.getIcon(currency.getIconThumbKey()));
        topBox.add(Box.createHorizontalGlue());
        topBox.add(currencyLabel);

        totalCostLabel.setIcon(IconUtil.getIcon(currency.getIconThumbKey()));

        maxBtn.addActionListener(e -> {
            Item item = list.getSelectedValue();
            if (item == null) return;
            int maxNum = DataStorage.get(currency.getStorageKey()) / item.getExchangeCost();
            numTextField.setText(String.valueOf(maxNum));
        });

        exchangeBtn.addActionListener(e -> {
            Item item = list.getSelectedValue();
            if (item == null) return;
            String text = numTextField.getText();
            if (text.isEmpty()) return;
            int num = Integer.parseInt(text);
            int totalCost = num * item.getExchangeCost();
            StorageKey csk = currency.getStorageKey();
            // 货币不足
            if (totalCost > DataStorage.get(csk)) return;
            // 扣除货币数量并回显
            DataStorage.add(csk, -totalCost);
            int nn = DataStorage.get(csk);
            currencyLabel.setText(String.valueOf(nn));
            // 兑换物品增加
            DataStorage.add(item.getStorageKey(), num);
        });

        totalCostPanel.add(totalCostLabel);

        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        controlPanel.add(numTextField);
        controlPanel.add(maxBtn);
        controlPanel.add(exchangeBtn);

        bottomPanel.add(totalCostPanel);
        bottomPanel.add(controlPanel);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        setTitle("宝藏商店");

        add(topBox, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}

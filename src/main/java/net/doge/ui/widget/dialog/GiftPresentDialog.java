package net.doge.ui.widget.dialog;

import net.doge.data.DataStorage;
import net.doge.constant.Colors;
import net.doge.constant.StorageKey;
import net.doge.data.ItemData;
import net.doge.model.Item;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.button.GButton;
import net.doge.ui.widget.panel.GPanel;
import net.doge.ui.widget.textfield.NumTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class GiftPresentDialog extends GDialog<Item> {
    private GiftDialog d;
    private GPanel bottomPanel = new GPanel();
    private GButton minusBtn = new GButton("-", Colors.DEEP_GREEN);
    private NumTextField numTextField = new NumTextField("1");
    private GButton plusBtn = new GButton("+", Colors.DEEP_GREEN);
    private GButton presentBtn = new GButton("赠送", Colors.DEEP_GREEN);

    private final int[] nums = {1314, 520, 99, 66, 33, 10, 1};

    public GiftPresentDialog(TowerUI ui, GiftDialog d) {
        super(ui);
        this.d = d;
        init();
    }

    @Override
    protected DefaultListCellRenderer createCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Item item = (Item) value;
                return createCellPanel(item.getName(), item.getIconKey(), String.format("数量：%s", DataStorage.get(item.getStorageKey())), isSelected);
            }
        };
    }

    private void init() {
        List<Item> items = ItemData.getItems();
        for (Item item : items) {
            if (!item.isPresent()) continue;
            int num = DataStorage.get(item.getStorageKey());
            if (num < 1) continue;
            listModel.addElement(item);
        }

        minusBtn.addActionListener(e -> {
            String text = numTextField.getText();
            int num = 2;
            if (!text.isEmpty()) num = Integer.parseInt(text);
            numTextField.setText(String.valueOf(num - 1));
        });
        plusBtn.addActionListener(e -> {
            String text = numTextField.getText();
            int num = 0;
            if (!text.isEmpty()) num = Integer.parseInt(text);
            numTextField.setText(String.valueOf(num + 1));
        });
        presentBtn.addActionListener(e -> {
            Item selectedItem = list.getSelectedValue();
            if (selectedItem == null) return;
            String text = numTextField.getText();
            if (text.isEmpty()) return;
            int num = Integer.parseInt(text);
            if (num < 1) return;
            StorageKey sk = selectedItem.getStorageKey();
            // 礼物库存不足
            if (num > DataStorage.get(sk)) return;
            // 扣除礼物数量并回显
            DataStorage.add(sk, -num);
            int nn = DataStorage.get(sk);
            if (nn < 1) listModel.removeElement(selectedItem);
            else list.repaint();
            new GiftResultDialog(ui, d,selectedItem, num);
        });

        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        for (int num : nums) {
            String nt = String.valueOf(num);
            GButton numBtn = new GButton(nt, Colors.LIGHT_BLUE);
            numBtn.addActionListener(e -> numTextField.setText(nt));
            numBtn.setHorizontalAlignment(SwingConstants.CENTER);
            bottomPanel.add(numBtn);
        }
        bottomPanel.add(minusBtn);
        bottomPanel.add(numTextField);
        bottomPanel.add(plusBtn);
        bottomPanel.add(presentBtn);

        setTitle("赠送礼物");

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}

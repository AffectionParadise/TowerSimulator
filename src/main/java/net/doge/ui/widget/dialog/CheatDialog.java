package net.doge.ui.widget.dialog;

import net.doge.constant.StorageKey;
import net.doge.data.AccountData;
import net.doge.data.storage.DataStorage;
import net.doge.data.ItemData;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.button.GButton;
import net.doge.ui.widget.color.GColor;
import net.doge.ui.widget.panel.GPanel;
import net.doge.ui.widget.textfield.GTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CheatDialog extends GDialog {
    private GPanel centerPanel = new GPanel();
    private GPanel ctrlPanel = new GPanel();
    private GTextField tf = new GTextField();
    private GButton okBtn = new GButton("确定", GColor.DEEP_GREEN);

    public CheatDialog(TowerUI ui) {
        super(ui);
        init();
    }

    public void init() {
        tf.setPreferredSize(new Dimension(300, 30));
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() != KeyEvent.VK_ENTER) return;
                okBtn.doClick();
            }
        });
        okBtn.addActionListener(e -> {
            String text = tf.getText();
            if (!text.matches("\\w+ \\d+")) return;
            String[] sp = text.split(" ");
            String keyword = sp[0].toLowerCase();
            int num = Integer.parseInt(sp[1]);
            switch (keyword) {
                case "bstep":
                    ui.updateItemAmountAndView(ItemData.BASIC_STEP, num);
                    break;
                case "rstep":
                    ui.updateItemAmountAndView(ItemData.REGULAR_STEP, num);
                    break;
                case "astep":
                    ui.updateItemAmountAndView(ItemData.ADVANCED_STEP, num);
                    break;
                case "dstep":
                    ui.updateItemAmountAndView(ItemData.DELUXE_STEP, num);
                    break;
                case "acoin":
                    DataStorage.add(StorageKey.ADVANCED_COIN_NUM, num);
                    break;
                case "amti":
                    ui.autoMoveTimer.setInitialDelay(num);
                    ui.autoMoveTimer.setDelay(num);
                    break;
                case "vstep":
                    AccountData.account.addVipStepLeft(num);
                    break;
                case "sil":
                    ui.silent = num != 0;
                    break;
            }
            dispose();
        });

        ctrlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        ctrlPanel.add(tf);
        ctrlPanel.add(okBtn);

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(ctrlPanel);
        centerPanel.add(Box.createVerticalGlue());

        setTitle("神秘领域");
        setSize(500, 200);
        setLocationRelativeTo(null);

        add(centerPanel, BorderLayout.CENTER);
        remove(scroller);

        setVisible(true);
    }
}

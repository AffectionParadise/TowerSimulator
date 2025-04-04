package net.doge.ui.widget.dialog;

import net.doge.constant.Colors;
import net.doge.constant.StorageKey;
import net.doge.data.DataStorage;
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
            if (text.matches("bstep \\d+"))
                ui.updateItemAmountAndView(ItemData.BASIC_STEP, Integer.parseInt(text.split(" ")[1]));
            else if (text.matches("rstep \\d+"))
                ui.updateItemAmountAndView(ItemData.REGULAR_STEP, Integer.parseInt(text.split(" ")[1]));
            else if (text.matches("astep \\d+"))
                ui.updateItemAmountAndView(ItemData.ADVANCED_STEP, Integer.parseInt(text.split(" ")[1]));
            else if (text.matches("dstep \\d+"))
                ui.updateItemAmountAndView(ItemData.DELUXE_STEP, Integer.parseInt(text.split(" ")[1]));
            else if (text.matches("acoin \\d+"))
                DataStorage.add(StorageKey.ADVANCED_COIN_NUM, Integer.parseInt(text.split(" ")[1]));
            dispose();
        });

        ctrlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
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

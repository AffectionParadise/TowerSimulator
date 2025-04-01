package net.doge.ui.widget.dialog;

import lombok.Getter;
import net.doge.constant.Colors;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.button.GButton;
import net.doge.ui.widget.textfield.GTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CheatDialog extends GDialog {
    private Box box = new Box(BoxLayout.X_AXIS);
    private GTextField tf = new GTextField();
    private GButton okBtn = new GButton("确定", Colors.DEEP_GREEN);

    @Getter
    private String result = "";

    public CheatDialog(TowerUI ui) {
        super(ui);
        this.ui = ui;
        init();
    }

    public void init() {
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() != KeyEvent.VK_ENTER) return;
                okBtn.doClick();
            }
        });
        okBtn.addActionListener(e -> {
            result = tf.getText();
            dispose();
        });

        box.add(tf);
        box.add(okBtn);

        setTitle("神秘领域");

        add(box, BorderLayout.CENTER);

        setVisible(true);
    }
}

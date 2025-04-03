package net.doge.ui.widget.dialog;

import net.doge.constant.Colors;
import net.doge.data.FontData;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.panel.GPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @Author Doge
 * @Description 自定义淡入淡出式对话框
 * @Date 2021/1/5
 */
public class TipDialog extends JDialog {
    private int ms;
    private boolean closing;

    private String message;
    private GPanel globalPanel = new GPanel();
    private GLabel messageLabel = new GLabel(message);

    private Timer showTimer;
    private Timer closeTimer;


    public TipDialog(Frame frame, String message) {
        this(frame, message, 1000);
    }

    public TipDialog(Dialog dialog, String message) {
        this(dialog, message, 1000);
    }

    public TipDialog(Frame frame, String message, int ms) {
        super(frame, false);
        this.message = message;
        this.ms = ms;
        init();
    }

    public TipDialog(Dialog dialog, String message, int ms) {
        super(dialog, false);
        this.message = message;
        this.ms = ms;
        init();
    }

    public void updateSize() {
        FontMetrics metrics = messageLabel.getFontMetrics(FontData.UI_FONT);
        int sw = metrics.stringWidth(message), sh = metrics.getHeight();
        setSize(new Dimension(sw + 40, sh + 20));
    }

    private void init() {
        setUndecorated(true);
        // Dialog 背景透明
        setBackground(Colors.TRANSPARENT);

        messageLabel.setForeground(Color.WHITE);
        messageLabel.setText(message);
        globalPanel.setLayout(new BorderLayout());
        globalPanel.setOpaque(false);
        globalPanel.setBgColor(Colors.DARK_RED);
        globalPanel.add(messageLabel, BorderLayout.CENTER);

        setContentPane(globalPanel);

        initTimer();

        updateSize();
        setLocationRelativeTo(getOwner());

        setOpacity(0);
        setVisible(true);
        closing = false;
        showTimer.start();
    }

    private void initTimer() {
        showTimer = new Timer(2, e -> {
            // 渐隐效果
            float opacity = getOpacity();
            if (closing) opacity = Math.max(0, opacity - 0.03f);
            else opacity = Math.min(1, opacity + 0.03f);
            setOpacity(opacity);
            if (closing && opacity <= 0 || !closing && opacity >= 1) {
                showTimer.stop();
                if (closing) dispose();
                else if (ms > 0) closeTimer.start();
            }
        });
        // 停留时间
        closeTimer = new Timer(ms, ev -> {
            close();
            closeTimer.stop();
        });
    }

    public void close() {
        closing = true;
        showTimer.start();
    }

//    public static void main(String[] args) {
//        new TipDialog(null, "你好");
//    }
}
package net.doge.ui.widget.panel;

import net.doge.constant.TussleStatus;
import net.doge.data.FontData;
import net.doge.data.TussleData;
import net.doge.model.Tussle;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.button.GButton;
import net.doge.ui.widget.color.GColor;
import net.doge.ui.widget.dialog.ActivityDialog;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.progressbar.GProgressBar;
import net.doge.util.DurationUtil;
import net.doge.util.IconUtil;
import net.doge.util.StrUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class TusslePanel extends GPanel {
    private ActivityDialog d;
    private TowerUI ui;

    private Timer viewTimer;

    // 标题
    private GPanel centerPanel = new GPanel();
    private GPanel titlePanel = new GPanel();
    private GLabel titleLabel = new GLabel();
    private GPanel timePanel = new GPanel();
    private GLabel timeLabel = new GLabel();
    private GPanel progressPanel = new GPanel();
    private GProgressBar progress = new GProgressBar();
    private GPanel rewardPanel = new GPanel();
    private GLabel rewardLabel = new GLabel();
    // 开始
    private GPanel ctrlPanel = new GPanel();
    private GButton startBtn = new GButton("开始", GColor.DEEP_GREEN);
    private GButton receiveBtn = new GButton("领取", GColor.DARK_ORANGE);
    private GButton nextTurnBtn = new GButton("下一轮", GColor.DARK_RED);

    public TusslePanel(TowerUI ui, ActivityDialog d) {
        this.ui = ui;
        this.d = d;
        init();
    }

    private void updateTussleView() {
        Tussle tussle = TussleData.currTussle;

        titleLabel.setText(String.format("%s 内收集累计价值 %s 的礼物", DurationUtil.format(tussle.getDuration()), StrUtil.formatValue(tussle.getTargetValue())));

        int targetValue = tussle.getTargetValue(), currValue = tussle.getCurrValue();
        progress.setMaximum(targetValue);
        progress.setValue(currValue);
        progress.setString(String.format("%s / %s", StrUtil.formatValue(Math.min(currValue, targetValue)), StrUtil.formatValue(targetValue)));
        progress.setStringPainted(true);

        TussleStatus status = tussle.getStatus();
        switch (status) {
            case SPARE:
                rewardLabel.setText(String.format("完成后可获得奖励：%s", tussle.getNumReceived()));
                rewardLabel.setIcon(IconUtil.getIcon(tussle.getItemReceived().getIconThumbKey()));
                break;
            case PROGRESSING:
                rewardLabel.setText(String.format("完成后可获得奖励：%s", tussle.getNumReceived()));
                rewardLabel.setIcon(IconUtil.getIcon(tussle.getItemReceived().getIconThumbKey()));
                if (!viewTimer.isRunning()) viewTimer.start();
                break;
            case OVER:
                if (tussle.isSuccess()) {
                    timeLabel.setText("已结束，恭喜达成目标！");
                    rewardLabel.setText(String.format("已完成，请领取奖励：%s", tussle.getNumReceived()));
                    rewardLabel.setIcon(IconUtil.getIcon(tussle.getItemReceived().getIconThumbKey()));
                } else {
                    int valueLeft = tussle.getTargetValue() - tussle.getCurrValue();
                    timeLabel.setText(String.format("已结束，还差累计价值 %s 的礼物获胜", StrUtil.formatValue(valueLeft)));
                    rewardLabel.setText("未完成，请再接再厉");
                    rewardLabel.setIcon(null);
                }
                break;
        }

        timeLabel.setVisible(status != TussleStatus.SPARE);
        progress.setVisible(status != TussleStatus.SPARE);
        startBtn.setVisible(status == TussleStatus.SPARE);
        receiveBtn.setVisible(status == TussleStatus.OVER && tussle.isSuccess());
        nextTurnBtn.setVisible(status == TussleStatus.OVER && !tussle.isSuccess());
    }

    private void updateTimeView() {
        Tussle tussle = TussleData.currTussle;
        long currTs = System.currentTimeMillis();
        int secondLeft = Math.toIntExact(tussle.getDuration() - (currTs - tussle.getStartTs()) / 1000);
        int valueLeft = tussle.getTargetValue() - tussle.getCurrValue();
        if (secondLeft > 0 && valueLeft > 0)
            timeLabel.setText(String.format("剩余时间：%s，还需收集累计价值 %s 的礼物", DurationUtil.format(secondLeft), StrUtil.formatValue(valueLeft)));
        else {
            viewTimer.stop();
            tussle.setStatus(TussleStatus.OVER);
            updateTussleView();
        }
    }

    private void init() {
        viewTimer = new Timer(1000, e -> updateTimeView());
        viewTimer.setInitialDelay(0);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                updateTussleView();
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                viewTimer.stop();
            }
        });

        titleLabel.setFont(FontData.TIP_FONT);
        titleLabel.setForeground(GColor.DEEP_GREEN.getAwtColor());
        titlePanel.add(titleLabel);

        timeLabel.setForeground(GColor.DARK_RED.getAwtColor());
        timePanel.add(timeLabel);

        progress.setPreferredSize(new Dimension(600, 50));
        progressPanel.add(progress);

        rewardLabel.setFont(FontData.TIP_FONT);
        rewardLabel.setForeground(GColor.DARK_RED.getAwtColor());
        rewardLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        rewardPanel.add(rewardLabel);

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(titlePanel);
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(timePanel);
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(progressPanel);
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(rewardPanel);
        centerPanel.add(Box.createVerticalGlue());

        startBtn.addActionListener(e -> {
            Tussle tussle = TussleData.currTussle;
            tussle.setStatus(TussleStatus.PROGRESSING);
            updateTussleView();
        });
        receiveBtn.addActionListener(e -> {
            Tussle tussle = TussleData.currTussle;
            ui.updateItemAmountAndView(tussle.getItemReceived(), tussle.getNumReceived());
            TussleData.refresh();
            updateTussleView();
        });
        nextTurnBtn.addActionListener(e -> {
            TussleData.refresh();
            updateTussleView();
        });

        ctrlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        ctrlPanel.add(startBtn);
        ctrlPanel.add(receiveBtn);
        ctrlPanel.add(nextTurnBtn);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalGlue());
        add(centerPanel);
        add(Box.createVerticalGlue());
        add(ctrlPanel);
        add(Box.createVerticalGlue());
    }
}

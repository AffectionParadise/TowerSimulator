package net.doge.ui.widget.panel;

import net.doge.constant.IconKey;
import net.doge.constant.StorageKey;
import net.doge.data.DataStorage;
import net.doge.data.FontData;
import net.doge.data.TrickData;
import net.doge.model.Item;
import net.doge.model.SampleModel;
import net.doge.model.Trick;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.button.GButton;
import net.doge.ui.widget.color.GColor;
import net.doge.ui.widget.label.GLabel;
import net.doge.util.IconUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TrickPanel extends GPanel {
    private TowerUI ui;

    // 标题
    private GPanel titlePanel = new GPanel();
    private GLabel titleLabel = new GLabel();
    // 选择
    private GPanel choicePanel = new GPanel();
    // 提示
    private GPanel tipPanel = new GPanel();
    private GLabel tipLabel = new GLabel();
    // 开始
    private GPanel ctrlPanel = new GPanel();
    private GButton receiveBtn = new GButton(GColor.DARK_ORANGE);
    private GButton refreshBtn = new GButton("刷新", GColor.DEEP_GREEN);
    private GLabel costLabel = new GLabel();

    public TrickPanel(TowerUI ui) {
        this.ui = ui;
        init();
    }

    private void updateTrickView() {
        Trick trick = TrickData.currTrick;
        titleLabel.setText(trick.getTitle());
        tipLabel.setIcon(IconUtil.getIcon(trick.getItemRewarded().getIconThumbKey()));
        boolean accepted = trick.isAccepted();
        if (accepted) {
            tipLabel.setText(String.format("已完成，请领取奖励：%s", trick.getNumRewarded()));
            receiveBtn.setText("领取");
            receiveBtn.setEnabled(true);
        } else {
            if (trick.isChoice()) {
                if (trick.isItemChosen())
                    tipLabel.setText(String.format("我的选择：%s，选中后可获得奖励：%s", trick.getItemChosen().getName(), trick.getNumRewarded()));
                else {
                    tipLabel.setText(String.format("完成后可获得奖励：%s", trick.getNumRewarded()));
                    choicePanel.removeAll();
                    List<SampleModel<Item>> models = trick.getItemExpected().getSubItemSampler().getModels();
                    for (SampleModel<Item> model : models) {
                        Item item = model.getItem();
                        if (!item.isBoxRegular()) continue;
                        GButton btn = new GButton(item.getName(), GColor.LIGHT_BLUE);
                        btn.addActionListener(e -> {
                            trick.setItemChosen(item);
                            tipLabel.setText(String.format("我的选择：%s，选中后可获得奖励：%s", item.getName(), trick.getNumRewarded()));
                            choicePanel.removeAll();
                        });
                        choicePanel.add(btn);
                    }
                }
            } else {
                tipLabel.setText(String.format("完成后可获得奖励：%s", trick.getNumRewarded()));
            }
            receiveBtn.setText("未达成");
            receiveBtn.setEnabled(false);
        }
        refreshBtn.setVisible(!accepted);
        costLabel.setVisible(!accepted);
    }

    private void init() {
        titleLabel.setFont(FontData.TIP_FONT);
        titleLabel.setForeground(GColor.DEEP_GREEN.getAwtColor());
        titlePanel.add(titleLabel);

        choicePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        tipLabel.setFont(FontData.TIP_FONT);
        tipLabel.setForeground(GColor.DARK_RED.getAwtColor());
        tipLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        tipPanel.add(tipLabel);

        receiveBtn.addActionListener(e -> {
            Trick trick = TrickData.currTrick;
            ui.updateItemAmountAndView(trick.getItemRewarded(), trick.getNumRewarded());
            TrickData.refresh();
            updateTrickView();
        });
        int cost = 688;
        refreshBtn.addActionListener(e -> {
            if (cost > DataStorage.get(StorageKey.ADVANCED_COIN_NUM)) return;
            DataStorage.add(StorageKey.ADVANCED_COIN_NUM, -cost);
            TrickData.refresh();
            updateTrickView();
        });
        costLabel.setText(String.format("花费：%s", cost));
        costLabel.setIcon(IconUtil.getIcon(IconKey.ADVANCED_COIN_THUMB));
        costLabel.setHorizontalTextPosition(SwingConstants.LEFT);

        ctrlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        ctrlPanel.add(receiveBtn);
        ctrlPanel.add(refreshBtn);
        ctrlPanel.add(costLabel);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalGlue());
        add(titlePanel);
        add(Box.createVerticalGlue());
        add(choicePanel);
        add(Box.createVerticalGlue());
        add(tipPanel);
        add(Box.createVerticalGlue());
        add(ctrlPanel);
        add(Box.createVerticalGlue());

        updateTrickView();
    }
}

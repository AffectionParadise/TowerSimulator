package net.doge.ui.widget.dialog;

import net.doge.ui.TowerUI;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.panel.*;
import net.doge.ui.widget.tabbedpane.GTabbedPane;

import javax.swing.*;
import java.awt.*;

public class ActivityDialog extends GDialog {
    private GTabbedPane tabbedPane = new GTabbedPane();

    public ActivityDialog(TowerUI ui) {
        super(ui);
        init();
    }

    public void init() {
        Component[] cs = {new TusslePanel(ui, this), new QuizPanel(ui, this), new TrickPanel(ui), new StepConsumptionRewardPanel(ui), new GiftExpRewardPanel(ui),
                new VipPanel(ui, this), new AdvancedStepExpRewardPanel(ui), new AdvancedTowerClearRewardPanel(ui), new DeluxeTowerClearRewardPanel(ui)};
        for (Component c : cs) tabbedPane.addTab(null, c);

        String[] ts = {"走塔角逐", "走塔竞猜", "盲盒福利", "走塔返利", "送礼通行证", "会员特权", "走塔通行证", "三塔赏金令", "金塔赏金令"};
        for (int i = 0, len = ts.length; i < len; i++) tabbedPane.setTabComponentAt(i, createTabPanel(ts[i]));

        add(tabbedPane, BorderLayout.CENTER);

        setTitle("活动");
        setVisible(true);
    }

    private GPanel createTabPanel(String title) {
        GPanel tabPanel = new GPanel();
        tabPanel.setOpaque(false);
        tabPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GLabel tabLabel = new GLabel(title);
        tabPanel.add(tabLabel);
        return tabPanel;
    }
}

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
        tabbedPane.addTab(null, new QuizPanel(ui, this));
        tabbedPane.addTab(null, new StepConsumptionRewardPanel(ui));
        tabbedPane.addTab(null, new TrickPanel(ui));
        tabbedPane.addTab(null, new GiftExpRewardPanel(ui));
        tabbedPane.addTab(null, new VipPanel(ui, this));

        tabbedPane.setTabComponentAt(0, createTabPanel("爬塔竞猜"));
        tabbedPane.setTabComponentAt(1, createTabPanel("赏金令"));
        tabbedPane.setTabComponentAt(2, createTabPanel("盲盒福利"));
        tabbedPane.setTabComponentAt(3, createTabPanel("送礼通行证"));
        tabbedPane.setTabComponentAt(4, createTabPanel("会员特权"));

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

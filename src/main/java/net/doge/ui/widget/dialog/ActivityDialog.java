package net.doge.ui.widget.dialog;

import net.doge.ui.TowerUI;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.panel.GPanel;
import net.doge.ui.widget.panel.QuizPanel;
import net.doge.ui.widget.panel.RewardPanel;
import net.doge.ui.widget.panel.TrickPanel;
import net.doge.ui.widget.tabbedpane.GTabbedPane;

import javax.swing.*;
import java.awt.*;

public class ActivityDialog extends GDialog {
    private GTabbedPane tabbedPane = new GTabbedPane();

    public ActivityDialog(TowerUI ui) {
        super(ui, false);
        init();
    }

    public void init() {
        tabbedPane.addTab(null, new QuizPanel(ui));
        tabbedPane.addTab(null, new RewardPanel(ui));
        tabbedPane.addTab(null, new TrickPanel(ui));

        tabbedPane.setTabComponentAt(0, createTabPanel("爬塔竞猜"));
        tabbedPane.setTabComponentAt(1, createTabPanel("赏金令"));
        tabbedPane.setTabComponentAt(2, createTabPanel("盲盒福利"));

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

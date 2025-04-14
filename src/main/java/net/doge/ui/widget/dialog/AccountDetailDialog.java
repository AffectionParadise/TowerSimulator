package net.doge.ui.widget.dialog;

import net.doge.constant.StorageKey;
import net.doge.data.AccountData;
import net.doge.data.storage.DataStorage;
import net.doge.data.NobleData;
import net.doge.model.Account;
import net.doge.model.Noble;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.panel.GPanel;
import net.doge.ui.widget.progressbar.GProgressBar;
import net.doge.util.IconUtil;

import javax.swing.*;
import java.awt.*;

public class AccountDetailDialog extends GDialog {
    private GPanel centerPanel = new GPanel();
    private GPanel infoPanel = new GPanel();
    private GPanel headPanel = new GPanel();
    private GLabel headLabel = new GLabel();
    private GPanel idPanel = new GPanel();
    private GLabel idLabel = new GLabel();
    private GPanel detailPanel = new GPanel();
    private GLabel showLabel = new GLabel();
    private GProgressBar showProgress = new GProgressBar();
    private GLabel nobleLabel = new GLabel();
    private GProgressBar nobleProgress = new GProgressBar();

    public AccountDetailDialog(TowerUI ui) {
        super(ui);
        init();
    }

    public void init() {
        Account account = AccountData.account;
        headLabel.setText(account.getName());
        headLabel.setIcon(IconUtil.getIcon(account.getAvatar()));
        headLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        headLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        headPanel.setLayout(new GridLayout(1, 1));
        headPanel.add(headLabel);

        idLabel.setText(String.format("账号：%s", account.getId()));
        idPanel.add(idLabel);

        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.add(Box.createVerticalGlue());
        infoPanel.add(headPanel);
        infoPanel.add(Box.createVerticalStrut(20));
        infoPanel.add(idPanel);
        infoPanel.add(Box.createVerticalGlue());

        account.updateShowLevel();
        int showLevel = account.getShowLevel();
        int showExpRequired = account.getShowExpRequired();
        int showExpGained = account.getShowExpGained();
        if (account.isMaxShowLevel()) {
            showLabel.setText(String.format("SHOW等级：%s，已达最大等级", showLevel));
            showProgress.setMaximum(1);
            showProgress.setValue(1);
            showProgress.setString("0 / 0");
        } else {
            showLabel.setText(String.format("SHOW等级：%s，再获得 %s 点经验可升下一级", showLevel, showExpRequired - showExpGained));
            showProgress.setMaximum(showExpRequired);
            showProgress.setValue(showExpGained);
            showProgress.setString(String.format("%s / %s", showExpGained, showExpRequired));
        }
        showProgress.setStringPainted(true);
        Dimension d = new Dimension(850, 40);
        showProgress.setPreferredSize(d);
        showProgress.setMaximumSize(d);

        account.updateNoble();
        int numConsumed = DataStorage.get(StorageKey.ADVANCED_COIN_CONSUMED);
        if (account.isNoble()) {
            Noble noble = account.getNoble();
            if (NobleData.isLast(noble)) {
                nobleLabel.setText(String.format("当前贵族：%s，已是最大等级", noble.getName()));
                nobleLabel.setIcon(IconUtil.getIcon(noble.getIconKey()));
                nobleLabel.setForeground(noble.getHighlightColor().getAwtColor());
                nobleProgress.setMaximum(1);
                nobleProgress.setValue(1);
                nobleProgress.setString("0 / 0");
            } else {
                Noble nextNoble = NobleData.nobles.get(NobleData.find(noble) + 1);
                int numRequired = nextNoble.getNumRequired();
                nobleLabel.setText(String.format("当前贵族：%s，再消耗 %s 金蘑菇可升下一级", noble.getName(), numRequired - numConsumed));
                nobleLabel.setIcon(IconUtil.getIcon(noble.getIconKey()));
                nobleLabel.setForeground(noble.getHighlightColor().getAwtColor());
                nobleProgress.setMaximum(numRequired);
                nobleProgress.setValue(numConsumed);
                nobleProgress.setString(String.format("%s / %s", numConsumed, numRequired));
            }
        } else {
            int numRequired = NobleData.nobles.get(0).getNumRequired();
            nobleLabel.setText(String.format("暂未解锁贵族，消耗 %s 金蘑菇可成为贵族", numRequired - numConsumed));
            nobleProgress.setMaximum(numRequired);
            nobleProgress.setValue(numConsumed);
            nobleProgress.setString(String.format("%s / %s", numConsumed, numRequired));
        }
        nobleProgress.setStringPainted(true);
        nobleProgress.setPreferredSize(d);
        nobleProgress.setMaximumSize(d);

        detailPanel.add(Box.createVerticalGlue());
        detailPanel.add(showLabel);
        detailPanel.add(Box.createVerticalStrut(20));
        detailPanel.add(showProgress);
        detailPanel.add(Box.createVerticalStrut(40));
        detailPanel.add(nobleLabel);
        detailPanel.add(Box.createVerticalStrut(20));
        detailPanel.add(nobleProgress);
        detailPanel.add(Box.createVerticalGlue());

        detailPanel.setLayout(new BoxLayout(detailPanel, BoxLayout.Y_AXIS));

        centerPanel.setLayout(new GridLayout(1, 2));
        centerPanel.add(infoPanel);
        centerPanel.add(detailPanel);

        add(centerPanel, BorderLayout.CENTER);

        setTitle("账号信息");

        setVisible(true);
    }
}

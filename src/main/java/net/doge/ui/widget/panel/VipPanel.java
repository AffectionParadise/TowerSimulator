package net.doge.ui.widget.panel;

import net.doge.constant.StorageKey;
import net.doge.constant.TowerBlockStatus;
import net.doge.data.*;
import net.doge.model.Account;
import net.doge.model.Item;
import net.doge.model.Tower;
import net.doge.model.Vip;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.button.GButton;
import net.doge.ui.widget.color.GColor;
import net.doge.ui.widget.dialog.ActivityDialog;
import net.doge.ui.widget.dialog.TipDialog;
import net.doge.ui.widget.label.GLabel;
import net.doge.util.IconUtil;

import javax.swing.*;
import java.awt.*;

public class VipPanel extends GPanel {
    private TowerUI ui;
    private ActivityDialog d;
    private Box topBox = new Box(BoxLayout.X_AXIS);
    private GLabel vipLabel = new GLabel();
    private GLabel currencyLabel = new GLabel();
    // 标题
    private GPanel titlePanel = new GPanel();
    private GLabel titleLabel = new GLabel();
    private GPanel tipPanel = new GPanel();
    private GLabel tipLabel = new GLabel();
    // 选择
    private GPanel choicePanel = new GPanel();

    public VipPanel(TowerUI ui, ActivityDialog d) {
        this.ui = ui;
        this.d = d;
        init();
    }

    private GPanel createVipPanel(Vip vip) {
        GPanel vipPanel = new GPanel();

        GPanel itemPanel = new GPanel();
        GLabel itemLabel = new GLabel();
        itemLabel.setText(vip.getName());
        itemLabel.setIcon(IconUtil.getIcon(vip.getIconKey()));
        itemLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        itemLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        itemPanel.add(itemLabel);

        GPanel stepPanel = new GPanel();
        GLabel stepLabel = new GLabel();
        stepLabel.setText(String.format("%s 步", vip.getDuration()));
        stepPanel.add(stepLabel);

        GPanel effectPanel = new GPanel();
        GLabel effectLabel = new GLabel();
        effectLabel.setForeground(vip.getHighlightColor().getAWTColor());
        effectLabel.setText(String.format("%s可转化为%s", vip.getSourceItem().getName(), vip.getTargetItem().getName()));
        effectPanel.add(effectLabel);

        GPanel costPanel = new GPanel();
        GLabel costLabel = new GLabel();
        costLabel.setText(String.format("花费：%s", vip.getCost()));
        costLabel.setIcon(IconUtil.getIcon(vip.getItemConsumed().getIconThumbKey()));
        costLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        costPanel.add(costLabel);

        GPanel buyPanel = new GPanel();
        GButton buyBtn = new GButton("购买", GColor.DEEP_GREEN);
        buyBtn.addActionListener(e -> {
            Account account = AccountData.account;
            if (account.isVip() && !vip.equals(account.getVip())) {
                new TipDialog(d, "已拥有其他会员，不可重复购买");
                return;
            }
            int cost = vip.getCost();
            Item itemConsumed = vip.getItemConsumed();
            StorageKey csk = itemConsumed.getStorageKey();
            // 货币不足
            if (cost > DataStorage.get(csk)) {
                new TipDialog(d, String.format("%s不足", itemConsumed.getName()));
                return;
            }
            // 扣除货币数量并回显
            DataStorage.add(csk, -cost);
            int nn = DataStorage.get(csk);
            currencyLabel.setText(String.valueOf(nn));
            // 获得会员
            account.setVip(vip);
            Tower tower = ui.currTower;
            tower.blocks[tower.x][tower.y].setStatus(TowerBlockStatus.ME);
            updateVipView();
        });
        buyPanel.add(buyBtn);

        vipPanel.setLayout(new BoxLayout(vipPanel, BoxLayout.Y_AXIS));
        vipPanel.add(Box.createVerticalGlue());
        vipPanel.add(itemPanel);
        vipPanel.add(Box.createVerticalGlue());
        vipPanel.add(stepPanel);
        vipPanel.add(Box.createVerticalGlue());
        vipPanel.add(effectPanel);
        vipPanel.add(Box.createVerticalGlue());
        vipPanel.add(costPanel);
        vipPanel.add(Box.createVerticalGlue());
        vipPanel.add(buyPanel);
        vipPanel.add(Box.createVerticalGlue());

        return vipPanel;
    }

    private void updateVipView() {
        Account account = AccountData.account;
        Vip vip = account.getVip();
        if (vip == null) {
            vipLabel.setText("我的特权：无");
            vipLabel.setForeground(null);
        } else {
            vipLabel.setText(String.format("我的特权：%s，剩余步数：%s", vip.getName(), account.getVipStepLeft()));
            vipLabel.setForeground(vip.getHighlightColor().getAWTColor());
        }
    }

    private void init() {
        tipLabel.setForeground(GColor.DARK_RED.getAWTColor());
        tipLabel.setText("以上只能同时选择一项购买(可续费)，请慎重考虑");
        tipPanel.add(tipLabel);

        titleLabel.setForeground(GColor.DEEP_GREEN.getAWTColor());
        titlePanel.add(titleLabel);

        for (Vip vip : VipData.vips) choicePanel.add(createVipPanel(vip));
        choicePanel.setLayout(new GridLayout(1, VipData.vips.size()));

        Item currency = VipData.vips.get(0).getItemConsumed();
        currencyLabel.setText(String.valueOf(DataStorage.get(currency.getStorageKey())));
        currencyLabel.setIcon(IconUtil.getIcon(currency.getIconThumbKey()));
        int sw = 20;
        topBox.add(Box.createHorizontalStrut(sw));
        topBox.add(vipLabel);
        topBox.add(Box.createHorizontalGlue());
        topBox.add(currencyLabel);
        topBox.add(Box.createHorizontalStrut(sw));

        setLayout(new BorderLayout());
        add(topBox, BorderLayout.NORTH);
        add(choicePanel, BorderLayout.CENTER);
        add(tipPanel, BorderLayout.SOUTH);

        updateVipView();
    }
}

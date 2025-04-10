package net.doge.ui.widget.dialog;

import net.doge.data.AccountData;
import net.doge.data.FontData;
import net.doge.model.Item;
import net.doge.model.Vip;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.color.GColor;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.panel.GPanel;
import net.doge.util.IconUtil;

import javax.swing.*;
import java.awt.*;

public class ConversionDialog extends GDialog {
    private GPanel descPanel = new GPanel();
    private GLabel descLabel = new GLabel();
    private GPanel centerPanel = new GPanel();
    private GLabel sourceItemLabel = new GLabel();
    private GLabel conversionLabel = new GLabel("转化为");
    private GLabel targetItemLabel = new GLabel();

    public ConversionDialog(TowerUI ui) {
        super(ui);
        init();
    }

    public void init() {
        Vip vip = AccountData.account.getVip();

        descLabel.setFont(FontData.TIP_FONT);
        descLabel.setForeground(vip.getHighlightColor().getAwtColor());
        descLabel.setText(vip.getDesc());
        descLabel.setIcon(IconUtil.getIcon(vip.getIconKey()));
        descPanel.add(descLabel);

        Item sourceItem = vip.getSourceItem();
        sourceItemLabel.setText(sourceItem.getName());
        sourceItemLabel.setIcon(IconUtil.getIcon(sourceItem.getIconKey()));
        sourceItemLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        sourceItemLabel.setVerticalTextPosition(SwingConstants.BOTTOM);

        conversionLabel.setFont(FontData.TIP_FONT);
        conversionLabel.setForeground(GColor.DARK_RED.getAwtColor());

        Item targetItem = vip.getTargetItem();
        targetItemLabel.setText(targetItem.getName());
        targetItemLabel.setIcon(IconUtil.getIcon(targetItem.getIconKey()));
        targetItemLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        targetItemLabel.setVerticalTextPosition(SwingConstants.BOTTOM);

        centerPanel.setLayout(new GridLayout(1, 3));
        centerPanel.add(sourceItemLabel);
        centerPanel.add(conversionLabel);
        centerPanel.add(targetItemLabel);

        setTitle("礼物转化");

        add(descPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}

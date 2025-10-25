package net.doge.ui.widget.dialog;

import net.doge.data.FontData;
import net.doge.model.Compound;
import net.doge.model.Item;
import net.doge.model.Sampler;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.color.GColor;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.panel.GPanel;
import net.doge.util.IconUtil;

import javax.swing.*;
import java.awt.*;

public class MagicBoxResultDialog extends GDialog {
    private GPanel centerPanel = new GPanel();
    private GLabel sourceItemLabel = new GLabel();
    private GLabel conversionLabel = new GLabel("开出了");
    private GLabel targetItemLabel = new GLabel();

    private TowerUI ui;
    private MagicBoxDialog d;
    private Compound compound;

    public MagicBoxResultDialog(TowerUI ui, MagicBoxDialog d, Compound compound) {
        super(ui);
        this.ui = ui;
        this.d = d;
        this.compound = compound;
        init();
    }

    public void init() {
        Item sourceItem = compound.getItemRequired();
        sourceItemLabel.setText(String.format("%s * %s", sourceItem.getName(), compound.getNumRequired()));
        sourceItemLabel.setIcon(IconUtil.getIcon(sourceItem.getIconKey()));
        sourceItemLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        sourceItemLabel.setVerticalTextPosition(SwingConstants.BOTTOM);

        conversionLabel.setFont(FontData.TIP_FONT);
        conversionLabel.setForeground(GColor.DARK_RED.getAwtColor());

        // 开出
        Sampler<Item> itemSampler = compound.getItemSampler();
        Item itemReceived = itemSampler.lottery().getItem();
        int numReceived = itemReceived.hasNumSampler() ? itemReceived.getNumSampler().lottery().getItem() : 1;
        ui.updateItemAmountAndView(itemReceived, numReceived);

        targetItemLabel.setText(String.format("%s * %s", itemReceived.getName(), numReceived));
        targetItemLabel.setIcon(IconUtil.getIcon(itemReceived.getIconKey()));
        targetItemLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        targetItemLabel.setVerticalTextPosition(SwingConstants.BOTTOM);

        centerPanel.setLayout(new GridLayout(1, 3));
        centerPanel.add(sourceItemLabel);
        centerPanel.add(conversionLabel);
        centerPanel.add(targetItemLabel);

        // 刷新魔盒页面视图
        d.list.repaint();

        setTitle("魔盒奖励");

        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}

package net.doge.ui.widget.dialog;

import lombok.Getter;
import net.doge.data.FontData;
import net.doge.model.Tower;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.button.GButton;
import net.doge.ui.widget.color.GColor;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.panel.GPanel;
import net.doge.util.IconUtil;

import javax.swing.*;
import java.awt.*;

public class TreasureDialog extends GDialog {
    private GPanel tipPanel = new GPanel();
    private GLabel tipLabel = new GLabel();
    private GPanel bottomPanel = new GPanel();
    private GButton enterBtn = new GButton("进入", GColor.DEEP_GREEN);

    @Getter
    private boolean confirmed;

    public TreasureDialog(TowerUI ui) {
        super(ui);
        init();
    }

    public void init() {
        tipLabel.setFont(FontData.TIP_FONT);
        tipLabel.setForeground(GColor.DARK_RED.getAwtColor());
        tipLabel.setVerticalAlignment(SwingConstants.CENTER);
        Tower tower = ui.currEvent.getTower();
        tipLabel.setText(tower.getDesc());
        tipLabel.setIcon(IconUtil.getIcon(tower.getIconKey()));
        tipPanel.setLayout(new BorderLayout());
        tipPanel.add(tipLabel, BorderLayout.CENTER);

        enterBtn.addActionListener(e -> {
            confirmed = true;
            dispose();
        });

        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomPanel.add(enterBtn);

        setTitle("特殊关卡开启");

        add(tipPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}

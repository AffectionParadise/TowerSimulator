package net.doge.ui.widget.panel;

import net.doge.data.ActivityData;
import net.doge.data.DataStorage;
import net.doge.model.Item;
import net.doge.model.Reward;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.color.GColor;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.list.GList;
import net.doge.ui.widget.scroller.GScroller;
import net.doge.util.IconUtil;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StepConsumptionRewardPanel extends GPanel {
    private TowerUI ui;

    protected final Border BORDER_SELECTED = BorderFactory.createLineBorder(GColor.DEEP_GREEN.getAWTColor(), 5, true);
    protected final Border EMPTY_BORDER = BorderFactory.createEmptyBorder(10, 10, 10, 10);

    protected DefaultListModel<Reward> listModel = new DefaultListModel<>();
    protected GList<Reward> list = new GList<>(listModel);
    protected GScroller scroller = new GScroller(list);
    // 标题
    private GPanel titlePanel = new GPanel();
    private GLabel titleLabel = new GLabel();

    public StepConsumptionRewardPanel(TowerUI ui) {
        this.ui = ui;
        init();
    }

    private void init() {
        for (Reward reward : ActivityData.stepConsumptionRewards) {
            listModel.addElement(reward);
        }
        titleLabel.setText(String.format("消耗%s，获得丰厚奖励！", ActivityData.stepConsumptionRewards.get(0).getItemReceived().getName()));
        titlePanel.add(titleLabel);

        // 横向滚动时自适应高度
        list.setVisibleRowCount(0);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setCellRenderer(createCellRenderer());
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Reward reward = list.getSelectedValue();
                if (reward == null || reward.isReceived() || !reward.isSatisfied()) return;
                reward.setReceived(true);
                ui.updateItemAmountAndView(reward.getItemReceived(), reward.getNumReceived());
                list.repaint();
            }
        });

        setLayout(new BorderLayout());
        add(titlePanel, BorderLayout.NORTH);
        add(scroller, BorderLayout.CENTER);
    }

    protected DefaultListCellRenderer createCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Reward reward = (Reward) value;
                Item itemReceived = reward.getItemReceived();
                Item itemRequired = reward.getItemRequired();

                GPanel cellPanel = new GPanel();
                cellPanel.setLayout(new BoxLayout(cellPanel, BoxLayout.Y_AXIS));

                GPanel itemPanel = new GPanel();
                GLabel itemLabel = new GLabel();
                itemLabel.setHorizontalTextPosition(SwingConstants.CENTER);
                itemLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
                itemLabel.setText(String.valueOf(reward.getNumReceived()));
                itemLabel.setIcon(IconUtil.getIcon(itemReceived.getIconKey()));
                itemPanel.add(itemLabel);
                cellPanel.add(itemPanel);

                GPanel censusPanel = new GPanel();
                GLabel censusLabel = new GLabel();
                int sn = DataStorage.get(itemRequired.getStorageKey());
                int numRequired = reward.getNumRequired();
                censusLabel.setText(String.format("%s / %s", Math.min(sn, numRequired), numRequired));
                censusPanel.add(censusLabel);
                cellPanel.add(censusPanel);

                GPanel bottomPanel = new GPanel();
                GLabel bottomLabel = new GLabel();
                bottomLabel.setForeground(reward.getStatusColor().getAWTColor());
                bottomLabel.setText(reward.getStatusText());
                bottomPanel.add(bottomLabel);
                cellPanel.add(bottomPanel);

                cellPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                cellPanel.setBorder(isSelected ? BORDER_SELECTED : EMPTY_BORDER);

                return cellPanel;
            }
        };
    }
}

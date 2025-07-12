package net.doge.ui.widget.panel;

import net.doge.data.storage.DataStorage;
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
import java.util.List;

public class RewardPanel extends GPanel {
    private TowerUI ui;

    protected final Border BORDER_SELECTED = BorderFactory.createLineBorder(GColor.DEEP_GREEN.getAwtColor(), 5, true);
    protected final Border EMPTY_BORDER = BorderFactory.createEmptyBorder(10, 10, 10, 10);

    protected DefaultListModel<Reward> listModel = new DefaultListModel<>();
    protected GList<Reward> list = new GList<>(listModel);
    protected GScroller scroller = new GScroller(list);
    // 标题
    protected GPanel titlePanel = new GPanel();
    protected GLabel titleLabel = new GLabel();

    protected GPanel cellPanel = new GPanel();
    protected GPanel itemPanel = new GPanel();
    protected GLabel itemLabel = new GLabel();
    protected GPanel censusPanel = new GPanel();
    protected GLabel censusLabel = new GLabel();
    protected GPanel bottomPanel = new GPanel();
    protected GLabel bottomLabel = new GLabel();

    public RewardPanel(TowerUI ui, List<Reward> rewards, String title) {
        this.ui = ui;
        init(rewards, title);
    }

    private void init(List<Reward> rewards, String title) {
        for (Reward reward : rewards) {
            listModel.addElement(reward);
        }
        titleLabel.setText(title);
        titlePanel.add(titleLabel);

        initCellPanel();

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

    private void initCellPanel() {
        cellPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cellPanel.setLayout(new BoxLayout(cellPanel, BoxLayout.Y_AXIS));

        itemLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        itemLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        itemPanel.add(itemLabel);
        cellPanel.add(itemPanel);

        censusPanel.add(censusLabel);
        cellPanel.add(censusPanel);

        bottomPanel.add(bottomLabel);
        cellPanel.add(bottomPanel);
    }

    protected DefaultListCellRenderer createCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Reward reward = (Reward) value;
                Item itemReceived = reward.getItemReceived();
                Item itemRequired = reward.getItemRequired();

                itemLabel.setText(String.valueOf(reward.getNumReceived()));
                itemLabel.setIcon(IconUtil.getIcon(itemReceived.getIconKey()));

                int sn = DataStorage.get(itemRequired.getStorageKey());
                int numRequired = reward.getNumRequired();
                censusLabel.setForeground(reward.getStatusColor().getAwtColor());
                censusLabel.setText(String.format("%s / %s", Math.min(sn, numRequired), numRequired));

                bottomLabel.setForeground(reward.getStatusColor().getAwtColor());
                bottomLabel.setText(reward.getStatusText());

                cellPanel.setBorder(isSelected ? BORDER_SELECTED : EMPTY_BORDER);

                return cellPanel;
            }
        };
    }
}

package net.doge.ui.widget.dialog;

import net.doge.constant.IconKey;
import net.doge.data.CompoundData;
import net.doge.data.storage.DataStorage;
import net.doge.model.Compound;
import net.doge.model.Item;
import net.doge.model.SampleModel;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.button.GButton;
import net.doge.ui.widget.color.GColor;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.list.GList;
import net.doge.ui.widget.panel.GPanel;
import net.doge.ui.widget.scroller.GScroller;
import net.doge.util.IconUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class CompoundDialog extends GDialog<Compound> {
    protected DefaultListModel<Item> infoListModel = new DefaultListModel<>();
    protected GList<Item> infoList = new GList<>(infoListModel);
    protected GScroller infoScroller = new GScroller(infoList);

    private GPanel infoPanel = new GPanel();
    private GPanel tipPanel = new GPanel();
    private GLabel tipLabel = new GLabel();

    private GPanel centerPanel = new GPanel();
    private GPanel bottomPanel = new GPanel();
    private GButton compundBtn = new GButton("合成", GColor.DEEP_GREEN);

    private GPanel infoCellPanel = new GPanel(new BorderLayout());
    private GPanel infoItemPanel = new GPanel();
    private GLabel infoItemLabel = new GLabel();

    public CompoundDialog(TowerUI ui) {
        super(ui);
        init();
    }

    @Override
    protected DefaultListCellRenderer createCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Compound compound = (Compound) value;
                Item itemRequired = compound.getItemRequired();
                String censusText = String.format("%s / %s", DataStorage.get(itemRequired.getStorageKey()), compound.getNumRequired());
                return createCellPanel(censusText, itemRequired.getIconKey(), compound.getStatusColor(), "", isSelected);
            }
        };
    }

    private DefaultListCellRenderer createInfoCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Item item = (Item) value;
                return createInfoCellPanel(item.getName(), item.getIconKey(), isSelected);
            }
        };
    }

    private GPanel createInfoCellPanel(String itemText, IconKey itemIconKey, boolean isSelected) {
        infoItemLabel.setText(itemText);
        infoItemLabel.setIcon(IconUtil.getIcon(itemIconKey));

        infoCellPanel.setBorder(isSelected ? BORDER_SELECTED : EMPTY_BORDER);

        return infoCellPanel;
    }

    private void initInfoCellPanel() {
        infoItemLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        infoItemLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        infoItemPanel.add(infoItemLabel);
        infoCellPanel.add(infoItemPanel, BorderLayout.CENTER);
    }

    private void init() {
        for (Compound compound : CompoundData.compounds) listModel.addElement(compound);

        initInfoCellPanel();
        // 横向滚动时自适应高度
        infoList.setVisibleRowCount(0);
        infoList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        infoList.setCellRenderer(createInfoCellRenderer());

        tipLabel.setText("有机会合成以下物品：");
        tipPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        tipPanel.add(tipLabel);
        infoPanel.setLayout(new BorderLayout());
        infoPanel.add(tipPanel, BorderLayout.NORTH);
        infoPanel.add(infoScroller, BorderLayout.CENTER);

        centerPanel.setLayout(new GridLayout(1, 2));
        centerPanel.add(scroller);
        centerPanel.add(infoPanel);

        compundBtn.addActionListener(e -> {
            Compound compound = list.getSelectedValue();
            if (compound == null) return;
            Item itemRequired = compound.getItemRequired();
            if (!compound.isSatisfied()) {
                new TipDialog(this, String.format("%s不足", itemRequired.getName()));
                return;
            }
            // 扣除
            DataStorage.add(itemRequired.getStorageKey(), -compound.getNumRequired());
            // 生成
            new CompoundResultDialog(ui, this, compound);
        });
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomPanel.add(compundBtn);

        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        list.addListSelectionListener(e -> {
            Compound compound = list.getSelectedValue();
            if (compound == null) return;
            List<SampleModel<Item>> models = compound.getItemSampler().getModels();
            infoListModel.clear();
            for (SampleModel<Item> model : models) infoListModel.addElement(model.getItem());
        });
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Compound compound = list.getSelectedValue();
                if (compound == null || e.getClickCount() != 2) return;
                new ItemDetailDialog(ui, compound.getItemRequired());
            }
        });

        infoList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Item item = infoList.getSelectedValue();
                if (item == null || e.getClickCount() != 2) return;
                new ItemDetailDialog(ui, item);
            }
        });

        setTitle("礼物合成");

        setVisible(true);
    }
}

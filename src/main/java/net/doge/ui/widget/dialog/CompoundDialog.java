package net.doge.ui.widget.dialog;

import net.doge.constant.IconKey;
import net.doge.data.CompoundData;
import net.doge.data.storage.DataStorage;
import net.doge.model.*;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.button.GButton;
import net.doge.ui.widget.color.GColor;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.list.GList;
import net.doge.ui.widget.panel.GPanel;
import net.doge.ui.widget.scroller.GScroller;
import net.doge.util.IconUtil;
import net.doge.util.StrUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class CompoundDialog extends GDialog<Compound> {
    protected DefaultListModel<ItemProbabilityModel<Item>> infoListModel = new DefaultListModel<>();
    protected GList<ItemProbabilityModel<Item>> infoList = new GList<>(infoListModel);
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
    private GPanel infoBottomPanel = new GPanel();
    private GLabel infoBottomLabel = new GLabel();

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
                ItemProbabilityModel<Item> model = (ItemProbabilityModel<Item>) value;
                Item item = model.getItem();
                // 物品显示概率
                String bottomText = StrUtil.formatPercentage(model.getProbability());
                return createInfoCellPanel(item.getName(), item.getIconKey(), bottomText, isSelected);
            }
        };
    }

    private GPanel createInfoCellPanel(String itemText, IconKey itemIconKey, String bottomText, boolean isSelected) {
        infoItemLabel.setText(itemText);
        infoItemLabel.setIcon(IconUtil.getIcon(itemIconKey));

        infoBottomLabel.setText(bottomText);

        infoCellPanel.setBorder(isSelected ? BORDER_SELECTED : EMPTY_BORDER);

        return infoCellPanel;
    }

    private void initInfoCellPanel() {
        infoItemLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        infoItemLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        infoItemPanel.add(infoItemLabel);
        infoCellPanel.add(infoItemPanel, BorderLayout.CENTER);

        infoBottomPanel.add(infoBottomLabel);
        infoCellPanel.add(infoBottomPanel, BorderLayout.SOUTH);
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
            Sampler<Item> itemSampler = compound.getItemSampler();
            double weightSum = itemSampler.getWeightSum();
            List<SampleModel<Item>> models = itemSampler.getModels();
            infoListModel.clear();
            for (SampleModel<Item> model : models)
                infoListModel.addElement(new ItemProbabilityModel<>(model.getItem(), model.getWeight() / weightSum));
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
                ItemProbabilityModel<Item> model = infoList.getSelectedValue();
                if (model == null || e.getClickCount() != 2) return;
                new ItemDetailDialog(ui, model.getItem());
            }
        });

        setTitle("礼物合成");

        setVisible(true);
    }
}

package net.doge.ui.widget.dialog;

import net.doge.constant.IconKey;
import net.doge.data.ItemData;
import net.doge.data.MagicBoxData;
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

public class MagicBoxDialog extends GDialog<Compound> {
    private GPanel topPanel = new GPanel();
    private GLabel topLabel = new GLabel();

    protected DefaultListModel<Item> infoListModel = new DefaultListModel<>();
    protected GList<Item> infoList = new GList<>(infoListModel);
    protected GScroller infoScroller = new GScroller(infoList);

    private GPanel infoPanel = new GPanel();
    private GPanel tipPanel = new GPanel();
    private GLabel tipLabel = new GLabel();

    private GPanel globalPanel = new GPanel();
    private GPanel centerPanel = new GPanel();
    private GPanel bottomPanel = new GPanel();
    private GButton compundBtn = new GButton("开启", GColor.DEEP_GREEN);

    private GPanel infoCellPanel = new GPanel(new BorderLayout());
    private GPanel infoItemPanel = new GPanel();
    private GLabel infoItemLabel = new GLabel();

    public MagicBoxDialog(TowerUI ui) {
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
        for (Compound compound : MagicBoxData.compounds) listModel.addElement(compound);

        initInfoCellPanel();
        // 横向滚动时自适应高度
        infoList.setVisibleRowCount(0);
        infoList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        infoList.setCellRenderer(createInfoCellRenderer());

        updateMagicBoxAmountView(0);
        topLabel.setIcon(IconUtil.getIcon(IconKey.MAGIC_BOX));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        topPanel.setLayout(new BorderLayout());
        topPanel.add(topLabel, BorderLayout.CENTER);

        tipLabel.setText("有机会开出以下物品：");
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
            // 检查魔盒数量
            int magicBoxNum = DataStorage.get(ItemData.MAGIC_BOX.getStorageKey());
            if (magicBoxNum < 1) {
                new TipDialog(this, String.format("%s不足", ItemData.MAGIC_BOX.getName()));
                return;
            }
            // 扣除钥匙和魔盒
            DataStorage.add(itemRequired.getStorageKey(), -compound.getNumRequired());
            updateMagicBoxAmountView(-1);
            // 生成
            new MagicBoxResultDialog(ui, this, compound);
        });
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomPanel.add(compundBtn);

        globalPanel.setLayout(new BorderLayout());
        globalPanel.add(topPanel, BorderLayout.NORTH);
        globalPanel.add(centerPanel, BorderLayout.CENTER);
        globalPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(globalPanel, BorderLayout.CENTER);

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

        setTitle("应龙珍宝魔盒");

        setVisible(true);
    }

    private void updateMagicBoxAmountView(int amount) {
        DataStorage.add(ItemData.MAGIC_BOX.getStorageKey(), amount);
        topLabel.setText(String.format("已拥有：%s", DataStorage.get(ItemData.MAGIC_BOX.getStorageKey())));
    }
}

package net.doge.ui.widget.dialog;

import net.doge.model.BackpackStorage;
import net.doge.data.ItemData;
import net.doge.model.Item;
import net.doge.ui.TowerUI;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BackpackDialog extends GDialog<Item> {
    private BackpackStorage backpackStorage;

    public BackpackDialog(TowerUI ui) {
        super(ui, false);
        backpackStorage = ui.currTower.getBackpackStorage();
        init();
    }

    @Override
    protected DefaultListCellRenderer createCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Item item = (Item) value;
                return createCellPanel(item.getName(), item.getIconKey(), String.format("数量：%s", backpackStorage.get(item.getStorageKey())), isSelected);
            }
        };
    }

    public void init() {
        List<Item> items = ItemData.getItems();
        for (Item item : items) {
            int num = backpackStorage.get(item.getStorageKey());
            if (num < 1) continue;
            listModel.addElement(item);
        }

        setTitle("探险背包");

        setVisible(true);
    }
}

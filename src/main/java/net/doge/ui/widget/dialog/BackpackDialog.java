package net.doge.ui.widget.dialog;

import net.doge.data.ItemData;
import net.doge.data.TowerData;
import net.doge.model.BackpackStorage;
import net.doge.model.Item;
import net.doge.ui.TowerUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BackpackDialog extends GDialog<Item> {
    private BackpackStorage backpackStorage;

    public BackpackDialog(TowerUI ui) {
        super(ui);
        backpackStorage = TowerData.currTower.getBackpackStorage();
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
        for (Item item : ItemData.items) {
            int num = backpackStorage.get(item.getStorageKey());
            if (num < 1) continue;
            listModel.addElement(item);
        }

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Item item = list.getSelectedValue();
                if (item == null || e.getClickCount() != 2) return;
                new ItemDetailDialog(ui, item);
            }
        });

        setTitle("探险背包");

        setVisible(true);
    }
}

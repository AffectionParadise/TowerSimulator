package net.doge.ui.widget.dialog;

import net.doge.constant.StorageKey;
import net.doge.data.storage.DataStorage;
import net.doge.data.storage.GiftRecordStorage;
import net.doge.data.storage.GiftCensusStorage;
import net.doge.data.TrickData;
import net.doge.model.*;
import net.doge.ui.TowerUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GiftResultDialog extends GDialog<GiftResult> {
    private GiftDialog d;
    private Item item;
    private int num;

    public GiftResultDialog(TowerUI ui, GiftDialog d, Item item, int num) {
        super(ui);
        this.d = d;
        this.item = item;
        this.num = num;
        init();
    }

    @Override
    protected DefaultListCellRenderer createCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                GiftResult res = (GiftResult) value;
                Item it = res.getItem();
                int n = res.getNum();
                return createCellPanel(it.getName(), it.getIconKey(), String.format("%s个", n), isSelected);
            }
        };
    }

    public void init() {
        int totalValue = 0, totalGiftPoints = 0;
        List<GiftResult> results = null;
        if (item.isBox()) {
            Sampler<Item> subItemSampler = item.getSubItemSampler();
            Map<SampleModel<Item>, Integer> res = subItemSampler.lotteryMap(num);
            results = new LinkedList<>();
            for (Map.Entry<SampleModel<Item>, Integer> entry : res.entrySet()) {
                Item k = entry.getKey().getItem();
                Integer v = entry.getValue();

                GiftCensusStorage.add(k.getStorageKey(), v);
                totalValue += v * k.getValue();
                totalGiftPoints += v * k.getGiftPoints();

                GiftResult result = new GiftResult(k, v);
                results.add(result);
                listModel.addElement(result);
                d.addItemNonRepetitive(k);
            }
        } else {
            GiftCensusStorage.add(item.getStorageKey(), num);
            totalValue += num * item.getValue();
            totalGiftPoints += num * item.getGiftPoints();

            listModel.addElement(new GiftResult(item, num));
            d.addItemNonRepetitive(item);
        }
        // 增加礼物积分 总价值 礼物经验
        d.updateGiftPoints(totalGiftPoints);
        DataStorage.add(StorageKey.TOTAL_VALUE, totalValue);
        DataStorage.add(StorageKey.GIFT_EXP, num * item.getGiftExp());
        // 礼物记录
        GiftRecord record = new GiftRecord(item, num, results, totalValue, System.currentTimeMillis());
        GiftRecordStorage.add(record);
        // 判断盲盒福利
        TrickData.currTrick.accept(record);

        setTitle("恭喜你，送出以下礼物");

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                GiftResult result = list.getSelectedValue();
                if (result == null || e.getClickCount() != 2) return;
                new ItemDetailDialog(ui, result.getItem());
            }
        });

        setVisible(true);
    }
}

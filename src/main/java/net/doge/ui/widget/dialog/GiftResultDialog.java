package net.doge.ui.widget.dialog;

import net.doge.constant.StorageKey;
import net.doge.data.DataStorage;
import net.doge.data.GiftRecordStorage;
import net.doge.data.TrickData;
import net.doge.model.*;
import net.doge.ui.TowerUI;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GiftResultDialog extends GDialog<GiftResult> {
    private Item item;
    private int num;

    public GiftResultDialog(TowerUI ui, Item item, int num) {
        super(ui, false);
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

                results.add(new GiftResult(k, v));
                totalValue += v * k.getValue();
                totalGiftPoints += v * k.getGiftPoints();

                listModel.addElement(new GiftResult(k, v));
            }
        } else {
            totalValue += num * item.getValue();
            totalGiftPoints += num * item.getGiftPoints();

            listModel.addElement(new GiftResult(item, num));
        }
        // 增加礼物积分和总价值
        ui.updateGiftPoints(totalGiftPoints);
        DataStorage.add(StorageKey.TOTAL_VALUE, totalValue);
        // 礼物记录
        GiftRecord record = new GiftRecord(item, num, results, totalValue);
        GiftRecordStorage.add(record);
        // 判断盲盒福利
        TrickData.currTrick.accept(record);

        setTitle("恭喜你，送出以下礼物");

        setVisible(true);
    }
}

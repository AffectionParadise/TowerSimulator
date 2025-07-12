package net.doge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.doge.data.storage.DataStorage;
import net.doge.ui.widget.color.GColor;

@Data
@AllArgsConstructor
public class Compound {
    // 要求的物品
    private Item itemRequired;
    // 要求数量
    private int numRequired;
    // 物品抽取器
    private Sampler<Item> itemSampler;

    public boolean isSatisfied() {
        return DataStorage.get(itemRequired.getStorageKey()) >= numRequired;
    }

    public GColor getStatusColor() {
        return isSatisfied() ? GColor.DEEP_GREEN : GColor.DARK_RED;
    }
}

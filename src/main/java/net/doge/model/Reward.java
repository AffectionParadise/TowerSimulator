package net.doge.model;

import lombok.Data;
import net.doge.data.storage.DataStorage;
import net.doge.ui.widget.color.GColor;

@Data
public class Reward {
    // 得到的物品
    private Item itemReceived;
    // 获得数量
    private int numReceived;
    // 要求的物品
    private Item itemRequired;
    // 要求数量
    private int numRequired;
    // 是否已领取
    private boolean received;

    public Reward(Item itemReceived, int numReceived, Item itemRequired, int numRequired) {
        this.itemReceived = itemReceived;
        this.numReceived = numReceived;
        this.itemRequired = itemRequired;
        this.numRequired = numRequired;
    }

    public boolean isSatisfied() {
        return DataStorage.get(itemRequired.getStorageKey()) >= numRequired;
    }

    public String getStatusText() {
        return received ? "已领取" : isSatisfied() ? "可领取" : "未达成";
    }

    public GColor getStatusColor() {
        return isReceived() ? GColor.DEEP_GREEN : isSatisfied() ? GColor.DARK_ORANGE : GColor.DARK_RED;
    }
}

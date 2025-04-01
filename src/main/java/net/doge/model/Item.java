package net.doge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.doge.constant.StorageKey;
import net.doge.constant.IconKey;
import net.doge.constant.ItemType;

import java.awt.*;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Item {
    // 名称
    private String name;
    // 类型
    private ItemType type;
    // 图标 key
    private IconKey iconKey;
    // 缩略图 key
    private IconKey iconThumbKey;
    // 数据 key
    private StorageKey storageKey;
    // 高亮颜色
    private Color highlightColor;
    // 礼物价值
    private int value;
    // 礼物积分
    private int giftPoints;
    // 是否可兑换
    private boolean exchangeable;
    // 兑换消耗
    private int exchangeCost;
    // 是否可竞猜
    private boolean guessable;

    // 数量生成器
    private Sampler<Integer> numSampler;
    // 保底的子物品
    private List<Item> fixedSubItems;
    // 子物品生成器
    private Sampler<Item> subItemSampler;

    public Item(String name, ItemType type, IconKey iconKey, StorageKey storageKey) {
        this.name = name;
        this.type = type;
        this.iconKey = iconKey;
        this.storageKey = storageKey;
    }

    // 是否可赠送
    public boolean isPresent() {
        return type == ItemType.GIFT || type == ItemType.BOX;
    }

    // 是否为盲盒礼物
    public boolean isBox() {
        return type == ItemType.BOX;
    }

    // 是否有数量生成器，若无则默认数量为 1
    public boolean hasNumSampler() {
        return numSampler != null;
    }

    // 是否有子物品生成器
    public boolean hasSubItemSampler() {
        return subItemSampler != null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return hashCode() == item.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, storageKey);
    }
}

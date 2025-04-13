package net.doge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.doge.constant.IconKey;
import net.doge.constant.ItemType;
import net.doge.constant.StorageKey;
import net.doge.ui.widget.color.GColor;

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
    private GColor highlightColor;
    // show 经验
    private int showExp;
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
    // 是否属于盒子中的常见礼物
    private boolean boxRegular;
    // 礼物经验
    private int giftExp;

    // 数量生成器
    private Sampler<Integer> numSampler;
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

    // 是否为皮肤
    public boolean isSkin() {
        return type == ItemType.SKIN;
    }

    // 是否有数量生成器，若无则默认数量为 1
    public boolean hasNumSampler() {
        return numSampler != null;
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

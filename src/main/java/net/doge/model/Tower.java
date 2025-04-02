package net.doge.model;

import lombok.Data;
import net.doge.constant.IconKey;

@Data
public class Tower {
    // 名称
    private String name;
    // 标题
    private String title;
    // 图标 key
    private IconKey iconKey;
    // 步数物品
    private Item stepItem;
    // 每步消耗
    private int stepCost;
    // 是否可购买步数物品
    private boolean purchasable;
    // 是否可见
    private boolean visible;
    // 是否可选择
    private boolean optional;
    // 描述
    private String desc;
    // 背包数据
    private BackpackStorage backpackStorage = new BackpackStorage();
    // 行数
    public int r = 8;
    // 列数
    public int c = 16;
    // 格子
    public TowerBlock[][] blocks = new TowerBlock[r][c];
    // 坐标
    public int x;
    public int y;

    public Tower(String name, String title, IconKey iconKey, Item stepItem, int stepCost, boolean purchasable, boolean visible, boolean optional) {
        this.name = name;
        this.title = title;
        this.iconKey = iconKey;
        this.stepItem = stepItem;
        this.stepCost = stepCost;
        this.purchasable = purchasable;
        this.visible = visible;
        this.optional = optional;
    }

    public boolean isEmpty() {
        return blocks[0][0] == null;
    }
}

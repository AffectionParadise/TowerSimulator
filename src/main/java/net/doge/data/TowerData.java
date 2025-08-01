package net.doge.data;

import net.doge.constant.IconKey;
import net.doge.model.*;
import net.doge.ui.widget.color.GColor;

import java.util.LinkedList;
import java.util.List;

/**
 * 塔数据
 */
public class TowerData {
    // 塔
    public static List<Tower> towers;
    public static Tower currTower;

    // 一塔
    public static final Tower BASIC_TOWER = new Tower("一塔", "", IconKey.BASIC_TOWER, ItemData.BASIC_STEP, 1, 0.25f, 0.5f,
            ItemData.basicTowerItemSampler, true, true, false, GColor.ADVANCED_TOWER_HIGHLIGHT, GColor.ADVANCED_TOWER_BRIGHT);
    // 二塔
    public static final Tower REGULAR_TOWER = new Tower("二塔", "", IconKey.REGULAR_TOWER, ItemData.REGULAR_STEP, 1, 0.25f, 0.5f,
            ItemData.regularTowerItemSampler, true, true, false, GColor.REGULAR_TOWER_HIGHLIGHT, GColor.REGULAR_TOWER_BRIGHT);
    // 三塔
    public static final Tower ADVANCED_TOWER = new Tower("三塔", "", IconKey.ADVANCED_TOWER, ItemData.ADVANCED_STEP, 1, 0.25f, 0.5f,
            ItemData.advancedTowerItemSampler, true, true, false, GColor.ADVANCED_TOWER_HIGHLIGHT, GColor.ADVANCED_TOWER_BRIGHT);
    public static final Tower ADVANCED_TOWER_2 = new Tower("张家界", "", IconKey.ADVANCED_TOWER_2, ItemData.ADVANCED_STEP, 1, 0.25f, 0.5f,
            ItemData.advancedTower2ItemSampler, true, true, false, GColor.ADVANCED_TOWER_HIGHLIGHT, GColor.ADVANCED_TOWER_BRIGHT);
    // 金塔
    public static final Tower DELUXE_TOWER = new Tower("金塔", "", IconKey.DELUXE_TOWER, ItemData.DELUXE_STEP, 1, 0.25f, 0.5f,
            ItemData.deluxeTowerItemSampler, false, true, false, GColor.TREASURE_TOWER_HIGHLIGHT, GColor.TREASURE_TOWER_BRIGHT);
    // 中级密藏
    public static final Tower REGULAR_TREASURE = new Tower("中级密藏", "中级密藏", IconKey.TREASURE, ItemData.ADVANCED_STEP, 2, 0.4f, 0.6f,
            ItemData.regularTreasureItemSampler, true, false, true, GColor.TREASURE_TOWER_HIGHLIGHT, GColor.TREASURE_TOWER_BRIGHT);
    public static final Tower REGULAR_TREASURE_2 = new Tower("中级密藏", "中级密藏", IconKey.TREASURE, ItemData.ADVANCED_STEP, 2, 0.4f, 0.6f,
            ItemData.regularTreasure2ItemSampler, true, false, true, GColor.TREASURE_TOWER_HIGHLIGHT, GColor.TREASURE_TOWER_BRIGHT);
    // 高级密藏
    public static final Tower ADVANCED_TREASURE = new Tower("高级密藏", "高级密藏", IconKey.TREASURE, ItemData.ADVANCED_STEP, 5, 0.4f, 0.6f,
            ItemData.advancedTreasureItemSampler, true, false, true, GColor.TREASURE_TOWER_HIGHLIGHT, GColor.TREASURE_TOWER_BRIGHT);
    public static final Tower ADVANCED_TREASURE_2 = new Tower("高级密藏", "高级密藏", IconKey.TREASURE, ItemData.ADVANCED_STEP, 5, 0.4f, 0.6f,
            ItemData.advancedTreasure2ItemSampler, true, false, true, GColor.TREASURE_TOWER_HIGHLIGHT, GColor.TREASURE_TOWER_BRIGHT);
    // 超级密藏
    public static final Tower DELUXE_TREASURE = new Tower("超级密藏", "超级密藏", IconKey.TREASURE, ItemData.ADVANCED_STEP, 10, 0.4f, 0.6f,
            ItemData.deluxeTreasureItemSampler, true, false, true, GColor.TREASURE_TOWER_HIGHLIGHT, GColor.TREASURE_TOWER_BRIGHT);
    public static final Tower DELUXE_TREASURE_2 = new Tower("超级密藏", "超级密藏", IconKey.TREASURE, ItemData.ADVANCED_STEP, 10, 0.4f, 0.6f,
            ItemData.deluxeTreasure2ItemSampler, true, false, true, GColor.TREASURE_TOWER_HIGHLIGHT, GColor.TREASURE_TOWER_BRIGHT);
    // 究极密藏
    public static final Tower ULTIMATE_TREASURE = new Tower("究级密藏", "究级密藏", IconKey.TREASURE, ItemData.ADVANCED_STEP, 1, 0.5f, 0.6f,
            ItemData.ultimateTreasureItemSampler, true, false, true, GColor.TREASURE_TOWER_HIGHLIGHT, GColor.TREASURE_TOWER_BRIGHT);
    public static final Tower ULTIMATE_TREASURE_2 = new Tower("究级密藏", "究级密藏", IconKey.TREASURE, ItemData.ADVANCED_STEP, 1, 0.5f, 0.6f,
            ItemData.ultimateTreasure2ItemSampler, true, false, true, GColor.TREASURE_TOWER_HIGHLIGHT, GColor.TREASURE_TOWER_BRIGHT);
    // 蘑菇金库
    public static final Tower MR_TREASURE = new Tower("蘑菇金库", "蘑菇金库", IconKey.MR_TREASURE, ItemData.ADVANCED_STEP, 1, 0.4f, 0.6f,
            ItemData.mrTreasureItemSampler, true, false, true, GColor.TREASURE_TOWER_HIGHLIGHT, GColor.TREASURE_TOWER_BRIGHT);

    static {
        initData();
    }

    private static void initData() {
        towers = new LinkedList<>();

        REGULAR_TREASURE.setDesc("1000% 超高倍率关卡开启！");
        REGULAR_TREASURE_2.setDesc("1000% 超高倍率关卡开启！");
        ADVANCED_TREASURE.setDesc("2000% 超高倍率关卡开启！");
        ADVANCED_TREASURE_2.setDesc("2000% 超高倍率关卡开启！");
        DELUXE_TREASURE.setDesc("5000% 超高倍率关卡开启！");
        DELUXE_TREASURE_2.setDesc("5000% 超高倍率关卡开启！");
        ULTIMATE_TREASURE.setDesc("25000% 超高倍率关卡开启！");
        ULTIMATE_TREASURE_2.setDesc("25000% 超高倍率关卡开启！");
        MR_TREASURE.setDesc("超多蘑菇的金库开启！");

        ADVANCED_TOWER.setEventSampler(EventData.eventSampler);
        ADVANCED_TOWER_2.setEventSampler(EventData.event2Sampler);

        towers.add(BASIC_TOWER);
        towers.add(REGULAR_TOWER);
        towers.add(ADVANCED_TOWER);
        towers.add(ADVANCED_TOWER_2);
        towers.add(DELUXE_TOWER);
        towers.add(REGULAR_TREASURE);
        towers.add(ADVANCED_TREASURE);
        towers.add(DELUXE_TREASURE);
        towers.add(ULTIMATE_TREASURE);
        towers.add(MR_TREASURE);

        currTower = ADVANCED_TOWER;
    }

    public static boolean isAdvancedTower(Tower tower) {
        return tower == ADVANCED_TOWER || tower == ADVANCED_TOWER_2;
    }

    public static boolean isDeluxeTower(Tower tower) {
        return tower == DELUXE_TOWER;
    }

    // 是否为密藏
    public static boolean isTreasure(Tower tower) {
        return tower == REGULAR_TREASURE
                || tower == REGULAR_TREASURE_2
                || tower == ADVANCED_TREASURE
                || tower == ADVANCED_TREASURE_2
                || tower == DELUXE_TREASURE
                || tower == DELUXE_TREASURE_2
                || tower == ULTIMATE_TREASURE
                || tower == ULTIMATE_TREASURE_2
                || tower == MR_TREASURE;
    }
}

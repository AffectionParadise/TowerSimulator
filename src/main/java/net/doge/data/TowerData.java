package net.doge.data;

import net.doge.constant.IconKey;
import net.doge.model.*;

import java.util.LinkedList;
import java.util.List;

/**
 * 塔数据
 */
public class TowerData {
    // 塔
    public static List<Tower> towers;

    // 一塔
    public static final Tower BASIC_TOWER = new Tower("一塔", "", IconKey.BASIC_TOWER, ItemData.BASIC_STEP, 1, true, true, false);
    // 二塔
    public static final Tower REGULAR_TOWER = new Tower("二塔", "", IconKey.REGULAR_TOWER, ItemData.REGULAR_STEP, 1, true, true, false);
    // 三塔
    public static final Tower ADVANCED_TOWER = new Tower("三塔", "", IconKey.ADVANCED_TOWER, ItemData.ADVANCED_STEP, 1, true, true, false);
    // 金塔
    public static final Tower DELUXE_TOWER = new Tower("金塔", "", IconKey.DELUXE_TOWER, ItemData.DELUXE_STEP, 1, false, true, false);
    // 中级密藏
    public static final Tower REGULAR_TREASURE = new Tower("中级密藏", "中级密藏", IconKey.TREASURE, ItemData.ADVANCED_STEP, 2, true, false, true);
    // 高级密藏
    public static final Tower ADVANCED_TREASURE = new Tower("高级密藏", "高级密藏", IconKey.TREASURE, ItemData.ADVANCED_STEP, 5, true, false, true);
    // 超级密藏
    public static final Tower DELUXE_TREASURE = new Tower("超级密藏", "超级密藏", IconKey.TREASURE, ItemData.ADVANCED_STEP, 10, true, false, true);
    // 究极密藏
    public static final Tower ULTIMATE_TREASURE = new Tower("究级密藏", "究级密藏", IconKey.TREASURE, ItemData.ADVANCED_STEP, 1, true, false, true);
    // 蘑菇金库
    public static final Tower MR_TREASURE = new Tower("蘑菇金库", "蘑菇金库", IconKey.MR_TREASURE, ItemData.ADVANCED_STEP, 1, true, false, true);

    static {
        initData();
    }

    private static void initData() {
        towers = new LinkedList<>();

        REGULAR_TREASURE.setDesc("1000% 超高倍率关卡开启！");
        ADVANCED_TREASURE.setDesc("2000% 超高倍率关卡开启！");
        DELUXE_TREASURE.setDesc("5000% 超高倍率关卡开启！");
        ULTIMATE_TREASURE.setDesc("25000% 超高倍率关卡开启！");
        MR_TREASURE.setDesc("超多蘑菇的金库开启！");

        towers.add(BASIC_TOWER);
        towers.add(REGULAR_TOWER);
        towers.add(ADVANCED_TOWER);
        towers.add(DELUXE_TOWER);
        towers.add(REGULAR_TREASURE);
        towers.add(ADVANCED_TREASURE);
        towers.add(DELUXE_TREASURE);
        towers.add(ULTIMATE_TREASURE);
        towers.add(MR_TREASURE);
    }

    public static boolean isAdvancedTower(Tower tower) {
        return tower == ADVANCED_TOWER;
    }

    // 是否为密藏
    public static boolean isTreasure(Tower tower) {
        return tower == REGULAR_TREASURE
                || tower == ADVANCED_TREASURE
                || tower == DELUXE_TREASURE
                || tower == ULTIMATE_TREASURE
                || tower == MR_TREASURE;
    }
}

package net.doge.data;

import net.doge.constant.ItemType;
import net.doge.constant.StorageKey;
import net.doge.model.Item;
import net.doge.model.Quiz;
import net.doge.model.Reward;

import java.util.LinkedList;
import java.util.List;

public class ActivityData {
    public static Quiz quiz = new Quiz("%s%s的生成数量：%s", ItemData.ADVANCED_STEP);
    public static List<Reward> rewards = new LinkedList<>();

    static {
        initData();
    }

    public static void initData() {
        Item gatheredItem = new Item("", ItemType.CURRENCY, null, StorageKey.GATHERED_STEP_NUM);
        rewards.add(new Reward(ItemData.ADVANCED_STEP, 1, gatheredItem, 10));
        rewards.add(new Reward(ItemData.ADVANCED_STEP, 2, gatheredItem, 30));
        rewards.add(new Reward(ItemData.ADVANCED_STEP, 5, gatheredItem, 80));
        rewards.add(new Reward(ItemData.ADVANCED_STEP, 12, gatheredItem, 200));
        rewards.add(new Reward(ItemData.ADVANCED_STEP, 28, gatheredItem, 500));
        rewards.add(new Reward(ItemData.ADVANCED_STEP, 68, gatheredItem, 1200));
        rewards.add(new Reward(ItemData.ADVANCED_STEP, 168, gatheredItem, 3000));
        rewards.add(new Reward(ItemData.ADVANCED_STEP, 328, gatheredItem, 8000));
        rewards.add(new Reward(ItemData.ADVANCED_STEP, 648, gatheredItem, 20000));
    }
}

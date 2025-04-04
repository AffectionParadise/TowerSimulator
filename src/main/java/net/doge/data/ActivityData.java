package net.doge.data;

import net.doge.constant.ItemType;
import net.doge.constant.StorageKey;
import net.doge.model.*;

import java.util.LinkedList;
import java.util.List;

public class ActivityData {
    public static Quiz quiz = new Quiz("%s%s的生成数量：%s", ItemData.ADVANCED_STEP);
    public static List<Reward> stepConsumptionRewards = new LinkedList<>();
    public static List<Reward> giftExpRewards = new LinkedList<>();

    static {
        initData();
    }

    public static void initData() {
        Item gatheredItem = new Item("", ItemType.CURRENCY, null, StorageKey.GATHERED_STEP_NUM);
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 1, gatheredItem, 10));
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 2, gatheredItem, 30));
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 5, gatheredItem, 80));
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 12, gatheredItem, 200));
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 28, gatheredItem, 500));
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 68, gatheredItem, 1200));
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 168, gatheredItem, 3000));
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 328, gatheredItem, 8000));
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 648, gatheredItem, 20000));
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 1288, gatheredItem, 50000));

        Item giftExpItem = new Item("", ItemType.CURRENCY, null, StorageKey.GIFT_EXP);
        giftExpRewards.add(new Reward(ItemData.DELUXE_STEP, 1, giftExpItem, 400));
        giftExpRewards.add(new Reward(ItemData.REGULAR_GIFT, 3, giftExpItem, 800));
        giftExpRewards.add(new Reward(ItemData.REGULAR_GIFT, 4, giftExpItem, 1600));
        giftExpRewards.add(new Reward(ItemData.REGULAR_GIFT, 2, giftExpItem, 2800));
        giftExpRewards.add(new Reward(ItemData.BASIC_BOX, 3, giftExpItem, 5200));
        giftExpRewards.add(new Reward(ItemData.REGULAR_GIFT, 3, giftExpItem, 9400));
        giftExpRewards.add(new Reward(ItemData.REGULAR_BOX, 1, giftExpItem, 15400));
        giftExpRewards.add(new Reward(ItemData.REGULAR_BOX, 1, giftExpItem, 24400));
        giftExpRewards.add(new Reward(ItemData.REGULAR_BOX, 2, giftExpItem, 33400));
        giftExpRewards.add(new Reward(ItemData.DELUXE_STEP, 1, giftExpItem, 42400));
        giftExpRewards.add(new Reward(ItemData.REGULAR_BOX, 2, giftExpItem, 51400));
        giftExpRewards.add(new Reward(ItemData.REGULAR_BOX, 4, giftExpItem, 60400));
        giftExpRewards.add(new Reward(ItemData.REGULAR_BOX, 2, giftExpItem, 69400));
        giftExpRewards.add(new Reward(ItemData.REGULAR_BOX, 2, giftExpItem, 78400));
        giftExpRewards.add(new Reward(ItemData.REGULAR_BOX, 4, giftExpItem, 87400));
        giftExpRewards.add(new Reward(ItemData.REGULAR_BOX, 2, giftExpItem, 96400));
        giftExpRewards.add(new Reward(ItemData.REGULAR_BOX, 2, giftExpItem, 105400));
        giftExpRewards.add(new Reward(ItemData.REGULAR_BOX, 4, giftExpItem, 114400));
        giftExpRewards.add(new Reward(ItemData.REGULAR_BOX, 2, giftExpItem, 123400));
        giftExpRewards.add(new Reward(ItemData.REGULAR_BOX, 2, giftExpItem, 132400));
        giftExpRewards.add(new Reward(ItemData.REGULAR_BOX, 4, giftExpItem, 141400));
        giftExpRewards.add(new Reward(ItemData.REGULAR_BOX, 2, giftExpItem, 150400));
        giftExpRewards.add(new Reward(ItemData.REGULAR_BOX, 2, giftExpItem, 159400));
        giftExpRewards.add(new Reward(ItemData.REGULAR_BOX, 4, giftExpItem, 168400));
        giftExpRewards.add(new Reward(ItemData.REGULAR_BOX, 3, giftExpItem, 177400));
    }
}

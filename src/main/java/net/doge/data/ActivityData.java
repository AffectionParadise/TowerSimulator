package net.doge.data;

import net.doge.constant.ItemType;
import net.doge.constant.StorageKey;
import net.doge.model.*;

import java.util.LinkedList;
import java.util.List;

public class ActivityData {
    public static int ADVANCED_STEP_EXP = 100;
    public static Quiz quiz = new Quiz("%s%s的生成数量：%s", ItemData.ADVANCED_STEP, 2000);
    public static List<Reward> stepConsumptionRewards = new LinkedList<>();
    public static List<Reward> giftExpRewards = new LinkedList<>();
    public static List<Reward> advancedStepExpRewards = new LinkedList<>();
    public static List<Reward> advancedTowerClearRewards = new LinkedList<>();
    public static List<Reward> deluxeTowerClearRewards = new LinkedList<>();

    static {
        initData();
    }

    public static void initData() {
        Item gatheredItem = new Item("三塔牌子消耗", ItemType.CURRENCY, null, StorageKey.GATHERED_STEP_NUM);
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 1, gatheredItem, 10));
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 2, gatheredItem, 30));
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 5, gatheredItem, 80));
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 12, gatheredItem, 200));
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 28, gatheredItem, 500));
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 48, gatheredItem, 1200));
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 68, gatheredItem, 2800));
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 128, gatheredItem, 6000));
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 168, gatheredItem, 12800));
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 328, gatheredItem, 26600));
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 648, gatheredItem, 54400));
        stepConsumptionRewards.add(new Reward(ItemData.ADVANCED_STEP, 1288, gatheredItem, 110200));

        Item giftExpItem = new Item("送礼经验", ItemType.CURRENCY, null, StorageKey.GIFT_EXP);
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
        giftExpRewards.add(new Reward(ItemData.REGULAR_BOX, 3, giftExpItem, 186400));
        giftExpRewards.add(new Reward(ItemData.REGULAR_BOX, 3, giftExpItem, 195400));
        giftExpRewards.add(new Reward(ItemData.REGULAR_BOX, 4, giftExpItem, 204400));

        Item advancedStepExpItem = new Item("三塔牌子经验", ItemType.CURRENCY, null, StorageKey.ADVANCED_STEP_EXP);
        advancedStepExpRewards.add(new Reward(ItemData.DELUXE_STEP, 1, advancedStepExpItem, 500));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_STEP, 1, advancedStepExpItem, 1000));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_STEP, 1, advancedStepExpItem, 1500));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_STEP, 1, advancedStepExpItem, 2000));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_STEP, 1, advancedStepExpItem, 2500));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_STEP, 1, advancedStepExpItem, 3000));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_STEP, 1, advancedStepExpItem, 3500));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_STEP, 1, advancedStepExpItem, 4000));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_STEP, 1, advancedStepExpItem, 4500));
        advancedStepExpRewards.add(new Reward(ItemData.DELUXE_STEP, 1, advancedStepExpItem, 5500));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_STEP, 2, advancedStepExpItem, 6500));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_STEP, 2, advancedStepExpItem, 7500));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_STEP, 2, advancedStepExpItem, 8500));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_STEP, 2, advancedStepExpItem, 9500));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_STEP, 2, advancedStepExpItem, 11500));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_STEP, 3, advancedStepExpItem, 13500));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_STEP, 3, advancedStepExpItem, 15500));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_STEP, 3, advancedStepExpItem, 17500));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_STEP, 3, advancedStepExpItem, 19500));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_BOX, 1, advancedStepExpItem, 23500));
        advancedStepExpRewards.add(new Reward(ItemData.REGULAR_BOX, 4, advancedStepExpItem, 27500));
        advancedStepExpRewards.add(new Reward(ItemData.REGULAR_BOX, 4, advancedStepExpItem, 31500));
        advancedStepExpRewards.add(new Reward(ItemData.REGULAR_BOX, 4, advancedStepExpItem, 35500));
        advancedStepExpRewards.add(new Reward(ItemData.REGULAR_BOX, 4, advancedStepExpItem, 39500));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_BOX, 1, advancedStepExpItem, 47500));
        advancedStepExpRewards.add(new Reward(ItemData.REGULAR_BOX, 5, advancedStepExpItem, 55500));
        advancedStepExpRewards.add(new Reward(ItemData.REGULAR_BOX, 5, advancedStepExpItem, 63500));
        advancedStepExpRewards.add(new Reward(ItemData.REGULAR_BOX, 5, advancedStepExpItem, 71500));
        advancedStepExpRewards.add(new Reward(ItemData.REGULAR_BOX, 5, advancedStepExpItem, 79500));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_BOX, 1, advancedStepExpItem, 89500));
        advancedStepExpRewards.add(new Reward(ItemData.REGULAR_BOX, 6, advancedStepExpItem, 99500));
        advancedStepExpRewards.add(new Reward(ItemData.REGULAR_BOX, 6, advancedStepExpItem, 109500));
        advancedStepExpRewards.add(new Reward(ItemData.REGULAR_BOX, 6, advancedStepExpItem, 119500));
        advancedStepExpRewards.add(new Reward(ItemData.REGULAR_BOX, 6, advancedStepExpItem, 129500));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_BOX, 2, advancedStepExpItem, 149500));
        advancedStepExpRewards.add(new Reward(ItemData.REGULAR_BOX, 7, advancedStepExpItem, 169500));
        advancedStepExpRewards.add(new Reward(ItemData.REGULAR_BOX, 7, advancedStepExpItem, 189500));
        advancedStepExpRewards.add(new Reward(ItemData.REGULAR_BOX, 7, advancedStepExpItem, 209500));
        advancedStepExpRewards.add(new Reward(ItemData.REGULAR_BOX, 7, advancedStepExpItem, 229500));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_BOX, 2, advancedStepExpItem, 269500));
        advancedStepExpRewards.add(new Reward(ItemData.REGULAR_BOX, 8, advancedStepExpItem, 309500));
        advancedStepExpRewards.add(new Reward(ItemData.REGULAR_BOX, 8, advancedStepExpItem, 349500));
        advancedStepExpRewards.add(new Reward(ItemData.REGULAR_BOX, 8, advancedStepExpItem, 389500));
        advancedStepExpRewards.add(new Reward(ItemData.REGULAR_BOX, 8, advancedStepExpItem, 429500));
        advancedStepExpRewards.add(new Reward(ItemData.ADVANCED_BOX, 3, advancedStepExpItem, 509500));

        Item advancedTowerClearItem = new Item("三塔通关次数", ItemType.CURRENCY, null, StorageKey.ADVANCED_TOWER_CLEARED);
        advancedTowerClearRewards.add(new Reward(ItemData.REGULAR_STEP, 1, advancedTowerClearItem, 0));
        advancedTowerClearRewards.add(new Reward(ItemData.DELUXE_STEP, 1, advancedTowerClearItem, 1));
        advancedTowerClearRewards.add(new Reward(ItemData.ADVANCED_STEP, 12, advancedTowerClearItem, 3));
        advancedTowerClearRewards.add(new Reward(ItemData.ADVANCED_STEP, 12, advancedTowerClearItem, 7));
        advancedTowerClearRewards.add(new Reward(ItemData.ADVANCED_STEP, 12, advancedTowerClearItem, 13));
        advancedTowerClearRewards.add(new Reward(ItemData.ADVANCED_STEP, 12, advancedTowerClearItem, 21));
        advancedTowerClearRewards.add(new Reward(ItemData.ADVANCED_STEP, 12, advancedTowerClearItem, 31));
        advancedTowerClearRewards.add(new Reward(ItemData.ADVANCED_STEP, 12, advancedTowerClearItem, 43));
        advancedTowerClearRewards.add(new Reward(ItemData.DELUXE_STEP, 2, advancedTowerClearItem, 57));
        advancedTowerClearRewards.add(new Reward(ItemData.ADVANCED_STEP, 18, advancedTowerClearItem, 73));
        advancedTowerClearRewards.add(new Reward(ItemData.ADVANCED_STEP, 18, advancedTowerClearItem, 91));
        advancedTowerClearRewards.add(new Reward(ItemData.ADVANCED_STEP, 18, advancedTowerClearItem, 111));
        advancedTowerClearRewards.add(new Reward(ItemData.ADVANCED_STEP, 18, advancedTowerClearItem, 133));
        advancedTowerClearRewards.add(new Reward(ItemData.ADVANCED_STEP, 18, advancedTowerClearItem, 157));
        advancedTowerClearRewards.add(new Reward(ItemData.ADVANCED_STEP, 18, advancedTowerClearItem, 183));
        advancedTowerClearRewards.add(new Reward(ItemData.DELUXE_STEP, 3, advancedTowerClearItem, 211));

        Item deluxeTowerClearItem = new Item("金塔通关次数", ItemType.CURRENCY, null, StorageKey.DELUXE_TOWER_CLEARED);
        deluxeTowerClearRewards.add(new Reward(ItemData.DELUXE_STEP, 1, deluxeTowerClearItem, 1));
        deluxeTowerClearRewards.add(new Reward(ItemData.DELUXE_STEP, 2, deluxeTowerClearItem, 4));
        deluxeTowerClearRewards.add(new Reward(ItemData.DELUXE_STEP, 5, deluxeTowerClearItem, 10));
        deluxeTowerClearRewards.add(new Reward(ItemData.DELUXE_STEP, 18, deluxeTowerClearItem, 19));
        deluxeTowerClearRewards.add(new Reward(ItemData.DELUXE_STEP, 25, deluxeTowerClearItem, 31));
        deluxeTowerClearRewards.add(new Reward(ItemData.DELUXE_BOX, 3, deluxeTowerClearItem, 46));
        deluxeTowerClearRewards.add(new Reward(ItemData.DELUXE_STEP, 34, deluxeTowerClearItem, 64));
        deluxeTowerClearRewards.add(new Reward(ItemData.DELUXE_STEP, 45, deluxeTowerClearItem, 85));
        deluxeTowerClearRewards.add(new Reward(ItemData.DELUXE_STEP, 58, deluxeTowerClearItem, 109));
        deluxeTowerClearRewards.add(new Reward(ItemData.DELUXE_STEP, 73, deluxeTowerClearItem, 136));
        deluxeTowerClearRewards.add(new Reward(ItemData.DELUXE_STEP, 90, deluxeTowerClearItem, 166));
        deluxeTowerClearRewards.add(new Reward(ItemData.DELUXE_BOX, 5, deluxeTowerClearItem, 199));
    }
}

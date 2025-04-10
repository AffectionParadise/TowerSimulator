package net.doge.data;

import net.doge.constant.IconKey;
import net.doge.constant.ItemType;
import net.doge.constant.StorageKey;
import net.doge.model.Item;
import net.doge.model.SampleModel;
import net.doge.model.Sampler;
import net.doge.model.Tower;
import net.doge.ui.widget.color.GColor;
import net.doge.util.ListUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * 物品数据
 */
public class ItemData {
    // 一塔物品生成器
    public static Sampler<Item> basicTowerItemSampler = new Sampler<>();
    // 二塔物品生成器
    public static Sampler<Item> regularTowerItemSampler = new Sampler<>();
    // 三塔物品生成器
    public static Sampler<Item> advancedTowerItemSampler = new Sampler<>();
    // 金塔物品生成器
    public static Sampler<Item> deluxeTowerItemSampler = new Sampler<>();
    // 中级密藏物品生成器
    public static Sampler<Item> regularItemSampler = new Sampler<>();
    // 高级密藏物品生成器
    public static Sampler<Item> advancedItemSampler = new Sampler<>();
    // 超级密藏物品生成器
    public static Sampler<Item> deluxeItemSampler = new Sampler<>();
    // 究级密藏物品生成器
    public static Sampler<Item> ultimateItemSampler = new Sampler<>();
    // 蘑菇金库物品生成器
    public static Sampler<Item> mrItemSampler = new Sampler<>();

    // 小盒子子物品生成器
    private static Sampler<Item> bbSubItemSampler = new Sampler<>();
    // 大盒子子物品生成器
    private static Sampler<Item> rbSubItemSampler = new Sampler<>();
    // 全屏子物品生成器
    private static Sampler<Item> abSubItemSampler = new Sampler<>();
    // 辉煌子物品生成器
    private static Sampler<Item> dbSubItemSampler = new Sampler<>();

    // 物品列表
    public static List<Item> items = new LinkedList<>();

    // 币
    public static Item COIN;
    // 送花小狗
    public static Item REGULAR_GIFT;
    // 金蘑菇
    public static Item ADVANCED_COIN;
    // 一塔牌子
    public static Item BASIC_STEP;
    // 二塔牌子
    public static Item REGULAR_STEP;
    // 三塔牌子
    public static Item ADVANCED_STEP;
    // 金塔牌子
    public static Item DELUXE_STEP;
    // 小盒子
    public static Item BASIC_BOX;
    // 大盒子
    public static Item REGULAR_BOX;
    // 全屏
    public static Item ADVANCED_BOX;
    // 辉煌
    public static Item DELUXE_BOX;
    // 青花瓷跑车
    public static Item DELUXE_GIFT_3;
    // 玫瑰跑车
    public static Item DELUXE_GIFT_4;
    // 玫瑰跑车-神龙
    public static Item DELUXE_GIFT_5;
    // 玫瑰跑车-银河
    public static Item DELUXE_GIFT_6;

    static {
        initData();
    }

    public static Sampler<Item> getItemSampler(Tower tower) {
        if (tower == TowerData.BASIC_TOWER) return basicTowerItemSampler;
        else if (tower == TowerData.REGULAR_TOWER) return regularTowerItemSampler;
        else if (tower == TowerData.DELUXE_TOWER) return deluxeTowerItemSampler;
        else if (tower == TowerData.REGULAR_TREASURE) return regularItemSampler;
        else if (tower == TowerData.ADVANCED_TREASURE) return advancedItemSampler;
        else if (tower == TowerData.DELUXE_TREASURE) return deluxeItemSampler;
        else if (tower == TowerData.ULTIMATE_TREASURE) return ultimateItemSampler;
        else if (tower == TowerData.MR_TREASURE) return mrItemSampler;
        return advancedTowerItemSampler;
    }

    private static void initData() {
        initAdvancedTowerItemSampler();
        initDeluxeTowerItemSampler();
        initRegularTowerItemSampler();
        initBasicTowerItemSampler();
        initRegularItemSampler();
        initAdvancedItemSampler();
        initDeluxeItemSampler();
        initUltimateItemSampler();
        initMRItemSampler();

        initBBSubItemSampler();
        initRBSubItemSampler();
        initABSubItemSampler();
        initDBSubItemSampler();
    }

    // 一塔物品
    private static void initBasicTowerItemSampler() {
        Sampler<Integer> basicGiftNS = new Sampler<>();
        basicGiftNS.addModel(new SampleModel<>(1, 2000));
        basicGiftNS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 100, 10);
        Item basicGift = new Item("小情书", ItemType.GIFT, IconKey.BASIC_GIFT, StorageKey.BASIC_GIFT_NUM);
        basicGift.setHighlightColor(GColor.BASIC_QUALITY);
        basicGift.setNumSampler(basicGiftNS);
        basicTowerItemSampler.addModel(new SampleModel<>(basicGift, 1000));

        Sampler<Integer> regularGiftNS = new Sampler<>();
        regularGiftNS.addModelsLinearWeights(ListUtil.ofRange(1, 2), 200, 10);
        Item regularGift = new Item("送花小狗", ItemType.GIFT, IconKey.REGULAR_GIFT, StorageKey.REGULAR_GIFT_NUM);
        regularGift.setHighlightColor(GColor.BASIC_QUALITY);
        regularGift.setNumSampler(regularGiftNS);
        basicTowerItemSampler.addModel(new SampleModel<>(regularGift, 50));

        Sampler<Integer> regularCoinNS = new Sampler<>();
        regularCoinNS.addModelsLinearWeights(ListUtil.ofRange(10, 40), 200, 10);
        Item regularCoin = new Item("赠送金蘑菇", ItemType.CURRENCY, IconKey.REGULAR_COIN, StorageKey.REGULAR_COIN_NUM);
        regularCoin.setHighlightColor(GColor.BASIC_QUALITY);
        regularCoin.setNumSampler(regularCoinNS);
        basicTowerItemSampler.addModel(new SampleModel<>(regularCoin, 2000));

        Sampler<Integer> basicShardNS = new Sampler<>();
        basicShardNS.addModelsLinearWeights(ListUtil.ofRange(1, 2), 2000, 1000);
        basicShardNS.addModelsLinearWeights(ListUtil.ofRange(3, 5), 100, 100);
        Item basicShard = new Item("引航碎片", ItemType.CURRENCY, IconKey.BASIC_SHARD, StorageKey.BASIC_SHARD_NUM);
        basicShard.setHighlightColor(GColor.BASIC_QUALITY);
        basicShard.setNumSampler(basicShardNS);
        items.add(basicShard);
        basicTowerItemSampler.addModel(new SampleModel<>(basicShard, 1500));

        Sampler<Integer> commonShardNS = new Sampler<>();
        commonShardNS.addModel(new SampleModel<>(1, 2000));
        commonShardNS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 100, 10);
        Item commonShard = new Item("神圣星核", ItemType.CURRENCY, IconKey.COMMON_SHARD, StorageKey.COMMON_SHARD_NUM);
        commonShard.setHighlightColor(GColor.BASIC_QUALITY);
        commonShard.setNumSampler(commonShardNS);
        items.add(commonShard);
        basicTowerItemSampler.addModel(new SampleModel<>(commonShard, 1000));

        Item basicStep = new Item("一塔牌子", ItemType.CURRENCY, IconKey.BASIC_STEP, StorageKey.BASIC_STEP_NUM);
        BASIC_STEP = basicStep;
        basicStep.setIconThumbKey(IconKey.BASIC_STEP_THUMB);
        basicStep.setHighlightColor(GColor.BASIC_QUALITY);
        items.add(basicStep);
        basicTowerItemSampler.addModel(new SampleModel<>(basicStep, 100));

        Item regularStep = new Item("二塔牌子", ItemType.CURRENCY, IconKey.REGULAR_STEP, StorageKey.REGULAR_STEP_NUM);
        regularStep.setHighlightColor(GColor.REGULAR_QUALITY);
        basicTowerItemSampler.addModel(new SampleModel<>(regularStep, 10));
    }

    // 二塔物品
    private static void initRegularTowerItemSampler() {
        Sampler<Integer> coinNS = new Sampler<>();
        coinNS.addModelsLinearWeights(ListUtil.ofRange(1, 3), 2000, 1000);
        coinNS.addModelsLinearWeights(ListUtil.ofRange(4, 10), 100, 10);
        Item coin = new Item("金币", ItemType.CURRENCY, IconKey.COIN, StorageKey.COIN_NUM);
        coin.setHighlightColor(GColor.REGULAR_QUALITY);
        coin.setNumSampler(coinNS);
        regularTowerItemSampler.addModel(new SampleModel<>(coin, 1500));

        Sampler<Integer> basicGiftNS = new Sampler<>();
        basicGiftNS.addModelsLinearWeights(ListUtil.ofRange(1, 3), 2000, 1000);
        basicGiftNS.addModelsLinearWeights(ListUtil.ofRange(4, 10), 100, 10);
        Item basicGift = new Item("小情书", ItemType.GIFT, IconKey.BASIC_GIFT, StorageKey.BASIC_GIFT_NUM);
        basicGift.setHighlightColor(GColor.BASIC_QUALITY);
        basicGift.setNumSampler(basicGiftNS);
        regularTowerItemSampler.addModel(new SampleModel<>(basicGift, 2000));

        Sampler<Integer> regularGiftNS = new Sampler<>();
        regularGiftNS.addModel(new SampleModel<>(1, 2000));
        regularGiftNS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 100, 100);
        Item regularGift = new Item("送花小狗", ItemType.GIFT, IconKey.REGULAR_GIFT, StorageKey.REGULAR_GIFT_NUM);
        regularGift.setHighlightColor(GColor.BASIC_QUALITY);
        regularGift.setNumSampler(regularGiftNS);
        regularTowerItemSampler.addModel(new SampleModel<>(regularGift, 500));

        Sampler<Integer> regularCoinNS = new Sampler<>();
        regularCoinNS.addModelsLinearWeights(ListUtil.ofRange(30, 60), 200, 10);
        Item regularCoin = new Item("赠送金蘑菇", ItemType.CURRENCY, IconKey.REGULAR_COIN, StorageKey.REGULAR_COIN_NUM);
        regularCoin.setHighlightColor(GColor.BASIC_QUALITY);
        regularCoin.setNumSampler(regularCoinNS);
        regularTowerItemSampler.addModel(new SampleModel<>(regularCoin, 2000));

        Sampler<Integer> regularShardNS = new Sampler<>();
        regularShardNS.addModelsLinearWeights(ListUtil.ofRange(1, 4), 2000, 1000);
        regularShardNS.addModelsLinearWeights(ListUtil.ofRange(5, 10), 100, 10);
        Item regularShard = new Item("星门碎片", ItemType.CURRENCY, IconKey.REGULAR_SHARD, StorageKey.REGULAR_SHARD_NUM);
        regularShard.setHighlightColor(GColor.BASIC_QUALITY);
        regularShard.setNumSampler(regularShardNS);
        items.add(regularShard);
        regularTowerItemSampler.addModel(new SampleModel<>(regularShard, 1500));

        Sampler<Integer> commonShardNS = new Sampler<>();
        commonShardNS.addModelsLinearWeights(ListUtil.ofRange(1, 3), 2000, 1000);
        commonShardNS.addModelsLinearWeights(ListUtil.ofRange(4, 10), 100, 10);
        Item commonShard = new Item("神圣星核", ItemType.CURRENCY, IconKey.COMMON_SHARD, StorageKey.COMMON_SHARD_NUM);
        commonShard.setHighlightColor(GColor.BASIC_QUALITY);
        commonShard.setNumSampler(commonShardNS);
        regularTowerItemSampler.addModel(new SampleModel<>(commonShard, 1500));

        Item regularGift2 = new Item("居士汪", ItemType.GIFT, IconKey.REGULAR_GIFT_2, StorageKey.REGULAR_GIFT_2_NUM);
        regularGift2.setHighlightColor(GColor.DELUXE_QUALITY);
        regularTowerItemSampler.addModel(new SampleModel<>(regularGift2, 50));

        Item deluxeStep = new Item("金塔牌子", ItemType.CURRENCY, IconKey.DELUXE_STEP, StorageKey.DELUXE_STEP_NUM);
        deluxeStep.setHighlightColor(GColor.DELUXE_QUALITY);
        regularTowerItemSampler.addModel(new SampleModel<>(deluxeStep, 3));

        Item advancedBox = new Item("全屏", ItemType.BOX, IconKey.ADVANCED_BOX, StorageKey.ADVANCED_BOX_NUM);
        advancedBox.setHighlightColor(GColor.ULTIMATE_QUALITY);
        advancedBox.setSubItemSampler(abSubItemSampler);
        regularTowerItemSampler.addModel(new SampleModel<>(advancedBox, 2));
    }

    // 三塔物品
    private static void initAdvancedTowerItemSampler() {
        Sampler<Integer> coinNS = new Sampler<>();
        coinNS.addModelsLinearWeights(ListUtil.ofRange(10, 30), 200, 100);
        coinNS.addModelsLinearWeights(ListUtil.ofRange(31, 40), 50, 10);
        coinNS.addModel(new SampleModel<>(66, 50));
        coinNS.addModel(new SampleModel<>(99, 30));
        coinNS.addModel(new SampleModel<>(199, 10));
        Item coin = new Item("金币", ItemType.CURRENCY, IconKey.COIN, StorageKey.COIN_NUM);
        COIN = coin;
        coin.setIconThumbKey(IconKey.COIN_THUMB);
        coin.setHighlightColor(GColor.REGULAR_QUALITY);
        coin.setGuessable(true);
        coin.setNumSampler(coinNS);
        items.add(coin);
        advancedTowerItemSampler.addModel(new SampleModel<>(coin, 2000));

        Sampler<Integer> basicGiftNS = new Sampler<>();
        basicGiftNS.addModelsLinearWeights(ListUtil.ofRange(3, 6), 2000, 1000);
        basicGiftNS.addModelsLinearWeights(ListUtil.ofRange(7, 10), 100, 10);
        Item basicGift = new Item("小情书", ItemType.GIFT, IconKey.BASIC_GIFT, StorageKey.BASIC_GIFT_NUM);
        basicGift.setHighlightColor(GColor.BASIC_QUALITY);
        basicGift.setValue(30);
        basicGift.setExchangeable(true);
        basicGift.setExchangeCost(1);
        basicGift.setGuessable(true);
        basicGift.setNumSampler(basicGiftNS);
        items.add(basicGift);
        advancedTowerItemSampler.addModel(new SampleModel<>(basicGift, 1500));

        Sampler<Integer> regularGiftNS = new Sampler<>();
        regularGiftNS.addModelsLinearWeights(ListUtil.ofRange(1, 3), 2000, 1000);
        regularGiftNS.addModelsLinearWeights(ListUtil.ofRange(4, 10), 100, 10);
        Item regularGift = new Item("送花小狗", ItemType.GIFT, IconKey.REGULAR_GIFT, StorageKey.REGULAR_GIFT_NUM);
        REGULAR_GIFT = regularGift;
        regularGift.setHighlightColor(GColor.BASIC_QUALITY);
        regularGift.setValue(300);
        regularGift.setGiftPoints(48);
        regularGift.setExchangeable(true);
        regularGift.setExchangeCost(5);
        regularGift.setGuessable(true);
        regularGift.setNumSampler(regularGiftNS);
        items.add(regularGift);
        advancedTowerItemSampler.addModel(new SampleModel<>(regularGift, 2000));

        Sampler<Integer> regularCoinNS = new Sampler<>();
        regularCoinNS.addModel(new SampleModel<>(333, 60));
        regularCoinNS.addModel(new SampleModel<>(666, 40));
        Item regularCoin = new Item("赠送金蘑菇", ItemType.CURRENCY, IconKey.REGULAR_COIN, StorageKey.REGULAR_COIN_NUM);
        regularCoin.setHighlightColor(GColor.BASIC_QUALITY);
        regularCoin.setGuessable(true);
        regularCoin.setNumSampler(regularCoinNS);
        items.add(regularCoin);
        advancedTowerItemSampler.addModel(new SampleModel<>(regularCoin, 1500));

        Sampler<Integer> statueNS = new Sampler<>();
        statueNS.addModelsLinearWeights(ListUtil.ofRange(2, 5), 2000, 1000);
        statueNS.addModelsLinearWeights(ListUtil.ofRange(6, 8), 100, 10);
        Item statue = new Item("初代塔坦王雕像", ItemType.CURRENCY, IconKey.STATUE, StorageKey.STATUE_NUM);
        statue.setHighlightColor(GColor.ADVANCED_QUALITY);
        statue.setGuessable(true);
        statue.setNumSampler(statueNS);
        items.add(statue);
        advancedTowerItemSampler.addModel(new SampleModel<>(statue, 1000));

        Item regularStep = new Item("二塔牌子", ItemType.CURRENCY, IconKey.REGULAR_STEP, StorageKey.REGULAR_STEP_NUM);
        REGULAR_STEP = regularStep;
        regularStep.setIconThumbKey(IconKey.REGULAR_STEP_THUMB);
        regularStep.setHighlightColor(GColor.REGULAR_QUALITY);
        regularStep.setGuessable(true);
        items.add(regularStep);
        advancedTowerItemSampler.addModel(new SampleModel<>(regularStep, 450));

        Item advancedStep = new Item("三塔牌子", ItemType.CURRENCY, IconKey.ADVANCED_STEP, StorageKey.ADVANCED_STEP_NUM);
        ADVANCED_STEP = advancedStep;
        advancedStep.setIconThumbKey(IconKey.ADVANCED_STEP_THUMB);
        advancedStep.setHighlightColor(GColor.ADVANCED_QUALITY);
        advancedStep.setGuessable(true);
        items.add(advancedStep);
        advancedTowerItemSampler.addModel(new SampleModel<>(advancedStep, 250));

        Item deluxeStep = new Item("金塔牌子", ItemType.CURRENCY, IconKey.DELUXE_STEP, StorageKey.DELUXE_STEP_NUM);
        DELUXE_STEP = deluxeStep;
        deluxeStep.setIconThumbKey(IconKey.DELUXE_STEP_THUMB);
        deluxeStep.setHighlightColor(GColor.DELUXE_QUALITY);
        items.add(deluxeStep);
        advancedTowerItemSampler.addModel(new SampleModel<>(deluxeStep, 30));

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModel(new SampleModel<>(9999, 990));
        advancedCoinNS.addModel(new SampleModel<>(99999, 10));
        Item advancedCoin = new Item("金蘑菇", ItemType.CURRENCY, IconKey.ADVANCED_COIN, StorageKey.ADVANCED_COIN_NUM);
        ADVANCED_COIN = advancedCoin;
        advancedCoin.setIconThumbKey(IconKey.ADVANCED_COIN_THUMB);
        advancedCoin.setHighlightColor(GColor.DELUXE_QUALITY);
        advancedCoin.setNumSampler(advancedCoinNS);
        items.add(advancedCoin);
        advancedTowerItemSampler.addModel(new SampleModel<>(advancedCoin, 3));

        Sampler<Integer> basicBoxNS = new Sampler<>();
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 3), 2000, 1000);
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(4, 10), 100, 10);
        Item basicBox = new Item("小盒子", ItemType.BOX, IconKey.BASIC_BOX, StorageKey.BASIC_BOX_NUM);
        BASIC_BOX = basicBox;
        basicBox.setHighlightColor(GColor.REGULAR_QUALITY);
        basicBox.setExchangeable(true);
        basicBox.setExchangeCost(15);
        basicBox.setGuessable(true);
        basicBox.setGiftExp(20);
        basicBox.setNumSampler(basicBoxNS);
        basicBox.setSubItemSampler(bbSubItemSampler);
        items.add(basicBox);
        advancedTowerItemSampler.addModel(new SampleModel<>(basicBox, 800));

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModel(new SampleModel<>(1, 2000));
        regularBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 100, 1);
        Item regularBox = new Item("大盒子", ItemType.BOX, IconKey.REGULAR_BOX, StorageKey.REGULAR_BOX_NUM);
        REGULAR_BOX = regularBox;
        regularBox.setHighlightColor(GColor.DELUXE_QUALITY);
        regularBox.setExchangeable(true);
        regularBox.setExchangeCost(120);
        regularBox.setGuessable(true);
        regularBox.setGiftExp(150);
        regularBox.setNumSampler(regularBoxNS);
        regularBox.setSubItemSampler(rbSubItemSampler);
        items.add(regularBox);
        advancedTowerItemSampler.addModel(new SampleModel<>(regularBox, 200));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModel(new SampleModel<>(1, 2000));
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 80, 1);
        Item advancedBox = new Item("全屏", ItemType.BOX, IconKey.ADVANCED_BOX, StorageKey.ADVANCED_BOX_NUM);
        ADVANCED_BOX = advancedBox;
        advancedBox.setHighlightColor(GColor.ULTIMATE_QUALITY);
        advancedBox.setExchangeable(true);
        advancedBox.setExchangeCost(1500);
        advancedBox.setGuessable(true);
        advancedBox.setGiftExp(1500);
        advancedBox.setNumSampler(advancedBoxNS);
        advancedBox.setSubItemSampler(abSubItemSampler);
        items.add(advancedBox);
        advancedTowerItemSampler.addModel(new SampleModel<>(advancedBox, 40));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModel(new SampleModel<>(1, 2000));
        deluxeBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 5), 40, 1);
        Item deluxeBox = new Item("辉煌", ItemType.BOX, IconKey.DELUXE_BOX, StorageKey.DELUXE_BOX_NUM);
        DELUXE_BOX = deluxeBox;
        deluxeBox.setHighlightColor(GColor.ULTIMATE_QUALITY);
        deluxeBox.setNumSampler(deluxeBoxNS);
        deluxeBox.setSubItemSampler(dbSubItemSampler);
        items.add(deluxeBox);
        advancedTowerItemSampler.addModel(new SampleModel<>(deluxeBox, 15));

        Sampler<Integer> advancedGiftNS = new Sampler<>();
        advancedGiftNS.addModel(new SampleModel<>(1, 2000));
        advancedGiftNS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 15, 1);
        Item advancedGift = new Item("无暇天使", ItemType.GIFT, IconKey.ADVANCED_GIFT, StorageKey.ADVANCED_GIFT_NUM);
        advancedGift.setValue(1000000);
        advancedGift.setGiftPoints(160000);
        advancedGift.setHighlightColor(GColor.ULTIMATE_QUALITY);
        advancedGift.setNumSampler(advancedGiftNS);
        items.add(advancedGift);
        advancedTowerItemSampler.addModel(new SampleModel<>(advancedGift, 5));

        Sampler<Integer> advancedGift2NS = new Sampler<>();
        advancedGift2NS.addModel(new SampleModel<>(1, 2000));
        advancedGift2NS.addModelsLinearWeights(ListUtil.ofRange(2, 5), 30, 1);
        Item advancedGift2 = new Item("白炽龙裔", ItemType.GIFT, IconKey.ADVANCED_GIFT_2, StorageKey.ADVANCED_GIFT_2_NUM);
        advancedGift2.setHighlightColor(GColor.ULTIMATE_QUALITY);
        advancedGift2.setValue(500000);
        advancedGift2.setGiftPoints(80000);
        advancedGift2.setNumSampler(advancedGift2NS);
        items.add(advancedGift2);
        advancedTowerItemSampler.addModel(new SampleModel<>(advancedGift2, 8));

        Item deluxeGift = new Item("情定爱琴海", ItemType.GIFT, IconKey.DELUXE_GIFT, StorageKey.DELUXE_GIFT_NUM);
        deluxeGift.setHighlightColor(GColor.ULTIMATE_QUALITY);
        deluxeGift.setValue(1888888);
        deluxeGift.setGiftPoints(666666);
        items.add(deluxeGift);
        advancedTowerItemSampler.addModel(new SampleModel<>(deluxeGift, 2));

        Item deluxeGift2 = new Item("爱之天使号", ItemType.GIFT, IconKey.DELUXE_GIFT_2, StorageKey.DELUXE_GIFT_2_NUM);
        deluxeGift2.setHighlightColor(GColor.ULTIMATE_QUALITY);
        deluxeGift2.setValue(1888888);
        deluxeGift2.setGiftPoints(566666);
        items.add(deluxeGift2);
        advancedTowerItemSampler.addModel(new SampleModel<>(deluxeGift2, 2));

        Item deluxeGift4 = new Item("玫瑰跑车", ItemType.GIFT, IconKey.DELUXE_GIFT_4, StorageKey.DELUXE_GIFT_4_NUM);
        DELUXE_GIFT_4 = deluxeGift4;
        deluxeGift4.setHighlightColor(GColor.ULTIMATE_QUALITY);
        deluxeGift4.setValue(1888888);
        deluxeGift4.setGiftPoints(299999);
        items.add(deluxeGift4);
        advancedTowerItemSampler.addModel(new SampleModel<>(deluxeGift4, 2));

        Item deluxeGift5 = new Item("玫瑰跑车-神龙", ItemType.GIFT, IconKey.DELUXE_GIFT_5, StorageKey.DELUXE_GIFT_5_NUM);
        DELUXE_GIFT_5 = deluxeGift5;
        deluxeGift5.setValue(1888888);
        deluxeGift5.setGiftPoints(666666);
        items.add(deluxeGift5);

        Item ultimateGift = new Item("起源·应龙", ItemType.GIFT, IconKey.ULTIMATE_GIFT, StorageKey.ULTIMATE_GIFT_NUM);
        ultimateGift.setHighlightColor(GColor.ULTIMATE_QUALITY);
        ultimateGift.setValue(2888888);
        ultimateGift.setGiftPoints(888888);
        items.add(ultimateGift);
        advancedTowerItemSampler.addModel(new SampleModel<>(ultimateGift, 2));

        Item ultimateGift2 = new Item("起源·黑洞", ItemType.GIFT, IconKey.ULTIMATE_GIFT_2, StorageKey.ULTIMATE_GIFT_2_NUM);
        ultimateGift2.setHighlightColor(GColor.ULTIMATE_QUALITY);
        ultimateGift2.setValue(2888888);
        ultimateGift2.setGiftPoints(888888);
        items.add(ultimateGift2);
        advancedTowerItemSampler.addModel(new SampleModel<>(ultimateGift2, 2));

        Item ticket = new Item("嘉年华孢子兑换券", ItemType.CURRENCY, IconKey.TICKET, StorageKey.TICKET);
        ticket.setHighlightColor(GColor.ULTIMATE_QUALITY);
        items.add(ticket);
        advancedTowerItemSampler.addModel(new SampleModel<>(ticket, 1));

        Item skin1 = new Item("好吃的骨头", ItemType.CURRENCY, IconKey.SKIN1, StorageKey.SKIN1_NUM);
        skin1.setHighlightColor(GColor.ULTIMATE_QUALITY);
        items.add(skin1);
        advancedTowerItemSampler.addModel(new SampleModel<>(skin1, 1));

        Item skin2 = new Item("丘比特", ItemType.CURRENCY, IconKey.SKIN2, StorageKey.SKIN2_NUM);
        skin2.setHighlightColor(GColor.ULTIMATE_QUALITY);
        items.add(skin2);
        advancedTowerItemSampler.addModel(new SampleModel<>(skin2, 1));

        Item skin3 = new Item("王子", ItemType.CURRENCY, IconKey.SKIN3, StorageKey.SKIN3_NUM);
        skin3.setHighlightColor(GColor.ULTIMATE_QUALITY);
        items.add(skin3);
        advancedTowerItemSampler.addModel(new SampleModel<>(skin3, 1));

        Item skin4 = new Item("公主", ItemType.CURRENCY, IconKey.SKIN4, StorageKey.SKIN4_NUM);
        skin4.setHighlightColor(GColor.ULTIMATE_QUALITY);
        items.add(skin4);
        advancedTowerItemSampler.addModel(new SampleModel<>(skin4, 1));
    }

    // 金塔物品
    private static void initDeluxeTowerItemSampler() {
        Sampler<Integer> coinNS = new Sampler<>();
        coinNS.addModel(new SampleModel<>(99, 400));
        coinNS.addModel(new SampleModel<>(199, 500));
        coinNS.addModel(new SampleModel<>(899, 300));
        coinNS.addModel(new SampleModel<>(999, 200));
        Item coin = new Item("金币", ItemType.CURRENCY, IconKey.COIN, StorageKey.COIN_NUM);
        coin.setHighlightColor(GColor.REGULAR_QUALITY);
        coin.setNumSampler(coinNS);
        deluxeTowerItemSampler.addModel(new SampleModel<>(coin, 2000));

        Sampler<Integer> statueNS = new Sampler<>();
        statueNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 2000, 1000);
        statueNS.addModelsLinearWeights(ListUtil.ofRange(11, 16), 100, 10);
        Item statue = new Item("初代塔坦王雕像", ItemType.CURRENCY, IconKey.STATUE, StorageKey.STATUE_NUM);
        statue.setHighlightColor(GColor.ADVANCED_QUALITY);
        statue.setNumSampler(statueNS);
        deluxeTowerItemSampler.addModel(new SampleModel<>(statue, 1000));

        Sampler<Integer> advancedShardNS = new Sampler<>();
        advancedShardNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 2000, 1000);
        advancedShardNS.addModelsLinearWeights(ListUtil.ofRange(11, 16), 100, 10);
        Item advancedShard = new Item("圣殿碎片", ItemType.CURRENCY, IconKey.ADVANCED_SHARD, StorageKey.ADVANCED_SHARD_NUM);
        advancedShard.setHighlightColor(GColor.BASIC_QUALITY);
        advancedShard.setNumSampler(advancedShardNS);
        items.add(advancedShard);
        deluxeTowerItemSampler.addModel(new SampleModel<>(advancedShard, 800));

        Sampler<Integer> commonShardNS = new Sampler<>();
        commonShardNS.addModelsLinearWeights(ListUtil.ofRange(30, 100), 2000, 1000);
        commonShardNS.addModelsLinearWeights(ListUtil.ofRange(101, 200), 100, 10);
        Item commonShard = new Item("神圣星核", ItemType.CURRENCY, IconKey.COMMON_SHARD, StorageKey.COMMON_SHARD_NUM);
        commonShard.setHighlightColor(GColor.BASIC_QUALITY);
        commonShard.setNumSampler(commonShardNS);
        deluxeTowerItemSampler.addModel(new SampleModel<>(commonShard, 800));

        Sampler<Integer> basicBoxNS = new Sampler<>();
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 3), 2000, 1000);
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(4, 10), 100, 10);
        Item basicBox = new Item("小盒子", ItemType.BOX, IconKey.BASIC_BOX, StorageKey.BASIC_BOX_NUM);
        basicBox.setHighlightColor(GColor.REGULAR_QUALITY);
        basicBox.setSubItemSampler(bbSubItemSampler);
        deluxeTowerItemSampler.addModel(new SampleModel<>(basicBox, 1000));

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModel(new SampleModel<>(1, 2000));
        regularBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 100, 1);
        Item regularBox = new Item("大盒子", ItemType.BOX, IconKey.REGULAR_BOX, StorageKey.REGULAR_BOX_NUM);
        regularBox.setHighlightColor(GColor.DELUXE_QUALITY);
        regularBox.setNumSampler(regularBoxNS);
        regularBox.setSubItemSampler(rbSubItemSampler);
        deluxeTowerItemSampler.addModel(new SampleModel<>(regularBox, 200));

        Sampler<Integer> regularGift2NS = new Sampler<>();
        regularGift2NS.addModel(new SampleModel<>(1, 2000));
        regularGift2NS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 100, 1);
        Item regularGift2 = new Item("居士汪", ItemType.GIFT, IconKey.REGULAR_GIFT_2, StorageKey.REGULAR_GIFT_2_NUM);
        regularGift2.setHighlightColor(GColor.DELUXE_QUALITY);
        regularGift2.setValue(10000);
        regularGift2.setGiftPoints(1600);
        regularGift2.setExchangeable(true);
        regularGift2.setExchangeCost(100);
        regularGift2.setNumSampler(regularGift2NS);
        items.add(regularGift2);
        deluxeTowerItemSampler.addModel(new SampleModel<>(regularGift2, 500));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModel(new SampleModel<>(1, 2000));
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 80, 1);
        Item advancedBox = new Item("全屏", ItemType.BOX, IconKey.ADVANCED_BOX, StorageKey.ADVANCED_BOX_NUM);
        advancedBox.setHighlightColor(GColor.ULTIMATE_QUALITY);
        advancedBox.setSubItemSampler(abSubItemSampler);
        deluxeTowerItemSampler.addModel(new SampleModel<>(advancedBox, 20));

        Item deluxeGift3 = new Item("玫瑰跑车-青花瓷", ItemType.GIFT, IconKey.DELUXE_GIFT_3, StorageKey.DELUXE_GIFT_3_NUM);
        DELUXE_GIFT_3 = deluxeGift3;
        deluxeGift3.setHighlightColor(GColor.ULTIMATE_QUALITY);
        deluxeGift3.setValue(1888888);
        deluxeGift3.setGiftPoints(666666);
        items.add(deluxeGift3);
        deluxeTowerItemSampler.addModel(new SampleModel<>(deluxeGift3, 2));

        Item deluxeGift6 = new Item("玫瑰跑车-银河", ItemType.GIFT, IconKey.DELUXE_GIFT_6, StorageKey.DELUXE_GIFT_6_NUM);
        DELUXE_GIFT_6 = deluxeGift6;
        deluxeGift6.setValue(5200000);
        deluxeGift6.setGiftPoints(1688888);
        deluxeGift6.setHighlightColor(GColor.ULTIMATE_QUALITY);
        items.add(deluxeGift6);
        deluxeTowerItemSampler.addModel(new SampleModel<>(deluxeGift6, 1));

        Item ultimateGift = new Item("起源·应龙", ItemType.GIFT, IconKey.ULTIMATE_GIFT, StorageKey.ULTIMATE_GIFT_NUM);
        ultimateGift.setHighlightColor(GColor.ULTIMATE_QUALITY);
        ultimateGift.setValue(2888888);
        ultimateGift.setGiftPoints(888888);
        deluxeTowerItemSampler.addModel(new SampleModel<>(ultimateGift, 2));

        Item ultimateGift2 = new Item("起源·黑洞", ItemType.GIFT, IconKey.ULTIMATE_GIFT_2, StorageKey.ULTIMATE_GIFT_2_NUM);
        ultimateGift2.setHighlightColor(GColor.ULTIMATE_QUALITY);
        ultimateGift2.setValue(2888888);
        ultimateGift2.setGiftPoints(888888);
        deluxeTowerItemSampler.addModel(new SampleModel<>(ultimateGift2, 2));
    }

    // 中级密藏物品
    private static void initRegularItemSampler() {
        Sampler<Integer> coinNS = new Sampler<>();
        coinNS.addModel(new SampleModel<>(199, 200));
        coinNS.addModel(new SampleModel<>(399, 20));
        coinNS.addModel(new SampleModel<>(699, 2));
        Item coin = new Item("金币", ItemType.CURRENCY, IconKey.COIN, StorageKey.COIN_NUM);
        coin.setHighlightColor(GColor.DELUXE_QUALITY);
        coin.setNumSampler(coinNS);
        regularItemSampler.addModel(new SampleModel<>(coin, 2000));

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModel(new SampleModel<>(1, 100));
        regularBoxNS.addModel(new SampleModel<>(2, 80));
        regularBoxNS.addModel(new SampleModel<>(4, 10));
        Item regularBox = new Item("大盒子", ItemType.BOX, IconKey.REGULAR_BOX, StorageKey.REGULAR_BOX_NUM);
        regularBox.setHighlightColor(GColor.DELUXE_QUALITY);
        regularBox.setNumSampler(regularBoxNS);
        regularBox.setSubItemSampler(rbSubItemSampler);
        regularItemSampler.addModel(new SampleModel<>(regularBox, 2000));

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModel(new SampleModel<>(1888, 980));
        advancedCoinNS.addModel(new SampleModel<>(6666, 20));
        Item advancedCoin = new Item("金蘑菇", ItemType.CURRENCY, IconKey.ADVANCED_COIN, StorageKey.ADVANCED_COIN_NUM);
        advancedCoin.setHighlightColor(GColor.DELUXE_QUALITY);
        advancedCoin.setNumSampler(advancedCoinNS);
        regularItemSampler.addModel(new SampleModel<>(advancedCoin, 40));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModel(new SampleModel<>(1, 2000));
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 85, 1);
        Item advancedBox = new Item("全屏", ItemType.BOX, IconKey.ADVANCED_BOX, StorageKey.ADVANCED_BOX_NUM);
        advancedBox.setHighlightColor(GColor.ULTIMATE_QUALITY);
        advancedBox.setNumSampler(advancedBoxNS);
        advancedBox.setSubItemSampler(abSubItemSampler);
        regularItemSampler.addModel(new SampleModel<>(advancedBox, 60));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModel(new SampleModel<>(1, 2000));
        deluxeBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 45, 1);
        Item deluxeBox = new Item("辉煌", ItemType.BOX, IconKey.DELUXE_BOX, StorageKey.DELUXE_BOX_NUM);
        deluxeBox.setHighlightColor(GColor.ULTIMATE_QUALITY);
        deluxeBox.setNumSampler(deluxeBoxNS);
        deluxeBox.setSubItemSampler(dbSubItemSampler);
        regularItemSampler.addModel(new SampleModel<>(deluxeBox, 20));

        Sampler<Integer> advancedGiftNS = new Sampler<>();
        advancedGiftNS.addModel(new SampleModel<>(1, 2000));
        advancedGiftNS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 20, 1);
        Item advancedGift = new Item("无暇天使", ItemType.GIFT, IconKey.ADVANCED_GIFT, StorageKey.ADVANCED_GIFT_NUM);
        advancedGift.setHighlightColor(GColor.ULTIMATE_QUALITY);
        advancedGift.setNumSampler(advancedGiftNS);
        regularItemSampler.addModel(new SampleModel<>(advancedGift, 5));

        Sampler<Integer> advancedGift2NS = new Sampler<>();
        advancedGift2NS.addModel(new SampleModel<>(1, 2000));
        advancedGift2NS.addModelsLinearWeights(ListUtil.ofRange(2, 5), 35, 1);
        Item advancedGift2 = new Item("白炽龙裔", ItemType.GIFT, IconKey.ADVANCED_GIFT_2, StorageKey.ADVANCED_GIFT_2_NUM);
        advancedGift2.setHighlightColor(GColor.ULTIMATE_QUALITY);
        advancedGift2.setNumSampler(advancedGift2NS);
        regularItemSampler.addModel(new SampleModel<>(advancedGift2, 10));

        Item deluxeGift3 = new Item("玫瑰跑车-青花瓷", ItemType.GIFT, IconKey.DELUXE_GIFT_3, StorageKey.DELUXE_GIFT_3_NUM);
        deluxeGift3.setHighlightColor(GColor.ULTIMATE_QUALITY);
        regularItemSampler.addModel(new SampleModel<>(deluxeGift3, 1));
    }

    // 高级密藏物品
    private static void initAdvancedItemSampler() {
        Sampler<Integer> coinNS = new Sampler<>();
        coinNS.addModel(new SampleModel<>(199, 20));
        coinNS.addModel(new SampleModel<>(399, 200));
        coinNS.addModel(new SampleModel<>(699, 50));
        Item coin = new Item("金币", ItemType.CURRENCY, IconKey.COIN, StorageKey.COIN_NUM);
        coin.setHighlightColor(GColor.DELUXE_QUALITY);
        coin.setNumSampler(coinNS);
        advancedItemSampler.addModel(new SampleModel<>(coin, 2000));

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModel(new SampleModel<>(2, 200));
        regularBoxNS.addModel(new SampleModel<>(4, 150));
        regularBoxNS.addModel(new SampleModel<>(8, 20));
        Item regularBox = new Item("大盒子", ItemType.BOX, IconKey.REGULAR_BOX, StorageKey.REGULAR_BOX_NUM);
        regularBox.setHighlightColor(GColor.DELUXE_QUALITY);
        regularBox.setNumSampler(regularBoxNS);
        regularBox.setSubItemSampler(rbSubItemSampler);
        advancedItemSampler.addModel(new SampleModel<>(regularBox, 2000));

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModel(new SampleModel<>(1888, 920));
        advancedCoinNS.addModel(new SampleModel<>(6666, 60));
        advancedCoinNS.addModel(new SampleModel<>(9999, 20));
        Item advancedCoin = new Item("金蘑菇", ItemType.CURRENCY, IconKey.ADVANCED_COIN, StorageKey.ADVANCED_COIN_NUM);
        advancedCoin.setHighlightColor(GColor.DELUXE_QUALITY);
        advancedCoin.setNumSampler(advancedCoinNS);
        advancedItemSampler.addModel(new SampleModel<>(advancedCoin, 50));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModel(new SampleModel<>(1, 2000));
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 90, 1);
        Item advancedBox = new Item("全屏", ItemType.BOX, IconKey.ADVANCED_BOX, StorageKey.ADVANCED_BOX_NUM);
        advancedBox.setHighlightColor(GColor.ULTIMATE_QUALITY);
        advancedBox.setNumSampler(advancedBoxNS);
        advancedBox.setSubItemSampler(abSubItemSampler);
        advancedItemSampler.addModel(new SampleModel<>(advancedBox, 70));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModel(new SampleModel<>(1, 2000));
        deluxeBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 50, 1);
        Item deluxeBox = new Item("辉煌", ItemType.BOX, IconKey.DELUXE_BOX, StorageKey.DELUXE_BOX_NUM);
        deluxeBox.setHighlightColor(GColor.ULTIMATE_QUALITY);
        deluxeBox.setNumSampler(deluxeBoxNS);
        deluxeBox.setSubItemSampler(dbSubItemSampler);
        advancedItemSampler.addModel(new SampleModel<>(deluxeBox, 25));

        Sampler<Integer> advancedGiftNS = new Sampler<>();
        advancedGiftNS.addModel(new SampleModel<>(1, 2000));
        advancedGiftNS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 25, 1);
        Item advancedGift = new Item("无暇天使", ItemType.GIFT, IconKey.ADVANCED_GIFT, StorageKey.ADVANCED_GIFT_NUM);
        advancedGift.setHighlightColor(GColor.ULTIMATE_QUALITY);
        advancedGift.setNumSampler(advancedGiftNS);
        advancedItemSampler.addModel(new SampleModel<>(advancedGift, 8));

        Sampler<Integer> advancedGift2NS = new Sampler<>();
        advancedGift2NS.addModel(new SampleModel<>(1, 2000));
        advancedGift2NS.addModelsLinearWeights(ListUtil.ofRange(2, 5), 40, 1);
        Item advancedGift2 = new Item("白炽龙裔", ItemType.GIFT, IconKey.ADVANCED_GIFT_2, StorageKey.ADVANCED_GIFT_2_NUM);
        advancedGift2.setHighlightColor(GColor.ULTIMATE_QUALITY);
        advancedGift2.setNumSampler(advancedGift2NS);
        advancedItemSampler.addModel(new SampleModel<>(advancedGift2, 16));

        Item deluxeGift3 = new Item("玫瑰跑车-青花瓷", ItemType.GIFT, IconKey.DELUXE_GIFT_3, StorageKey.DELUXE_GIFT_3_NUM);
        deluxeGift3.setHighlightColor(GColor.ULTIMATE_QUALITY);
        advancedItemSampler.addModel(new SampleModel<>(deluxeGift3, 2));
    }

    // 超级密藏物品
    private static void initDeluxeItemSampler() {
        Sampler<Integer> coinNS = new Sampler<>();
        coinNS.addModel(new SampleModel<>(199, 20));
        coinNS.addModel(new SampleModel<>(399, 200));
        coinNS.addModel(new SampleModel<>(699, 100));
        Item coin = new Item("金币", ItemType.CURRENCY, IconKey.COIN, StorageKey.COIN_NUM);
        coin.setHighlightColor(GColor.DELUXE_QUALITY);
        coin.setNumSampler(coinNS);
        deluxeItemSampler.addModel(new SampleModel<>(coin, 2000));

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModel(new SampleModel<>(4, 200));
        regularBoxNS.addModel(new SampleModel<>(8, 40));
        Item regularBox = new Item("大盒子", ItemType.BOX, IconKey.REGULAR_BOX, StorageKey.REGULAR_BOX_NUM);
        regularBox.setHighlightColor(GColor.DELUXE_QUALITY);
        regularBox.setNumSampler(regularBoxNS);
        regularBox.setSubItemSampler(rbSubItemSampler);
        deluxeItemSampler.addModel(new SampleModel<>(regularBox, 2000));

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModel(new SampleModel<>(1888, 900));
        advancedCoinNS.addModel(new SampleModel<>(6666, 80));
        advancedCoinNS.addModel(new SampleModel<>(9999, 20));
        Item advancedCoin = new Item("金蘑菇", ItemType.CURRENCY, IconKey.ADVANCED_COIN, StorageKey.ADVANCED_COIN_NUM);
        advancedCoin.setHighlightColor(GColor.DELUXE_QUALITY);
        advancedCoin.setNumSampler(advancedCoinNS);
        deluxeItemSampler.addModel(new SampleModel<>(advancedCoin, 60));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModel(new SampleModel<>(1, 2000));
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 95, 1);
        Item advancedBox = new Item("全屏", ItemType.BOX, IconKey.ADVANCED_BOX, StorageKey.ADVANCED_BOX_NUM);
        advancedBox.setHighlightColor(GColor.ULTIMATE_QUALITY);
        advancedBox.setNumSampler(advancedBoxNS);
        advancedBox.setSubItemSampler(abSubItemSampler);
        deluxeItemSampler.addModel(new SampleModel<>(advancedBox, 80));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModel(new SampleModel<>(1, 2000));
        deluxeBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 55, 1);
        Item deluxeBox = new Item("辉煌", ItemType.BOX, IconKey.DELUXE_BOX, StorageKey.DELUXE_BOX_NUM);
        deluxeBox.setHighlightColor(GColor.ULTIMATE_QUALITY);
        deluxeBox.setNumSampler(deluxeBoxNS);
        deluxeBox.setSubItemSampler(dbSubItemSampler);
        deluxeItemSampler.addModel(new SampleModel<>(deluxeBox, 30));

        Sampler<Integer> advancedGiftNS = new Sampler<>();
        advancedGiftNS.addModel(new SampleModel<>(1, 2000));
        advancedGiftNS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 30, 1);
        Item advancedGift = new Item("无暇天使", ItemType.GIFT, IconKey.ADVANCED_GIFT, StorageKey.ADVANCED_GIFT_NUM);
        advancedGift.setHighlightColor(GColor.ULTIMATE_QUALITY);
        advancedGift.setNumSampler(advancedGiftNS);
        deluxeItemSampler.addModel(new SampleModel<>(advancedGift, 10));

        Sampler<Integer> advancedGift2NS = new Sampler<>();
        advancedGift2NS.addModel(new SampleModel<>(1, 2000));
        advancedGift2NS.addModelsLinearWeights(ListUtil.ofRange(2, 5), 45, 1);
        Item advancedGift2 = new Item("白炽龙裔", ItemType.GIFT, IconKey.ADVANCED_GIFT_2, StorageKey.ADVANCED_GIFT_2_NUM);
        advancedGift2.setHighlightColor(GColor.ULTIMATE_QUALITY);
        advancedGift2.setNumSampler(advancedGift2NS);
        deluxeItemSampler.addModel(new SampleModel<>(advancedGift2, 20));

        Item deluxeGift3 = new Item("玫瑰跑车-青花瓷", ItemType.GIFT, IconKey.DELUXE_GIFT_3, StorageKey.DELUXE_GIFT_3_NUM);
        deluxeGift3.setHighlightColor(GColor.ULTIMATE_QUALITY);
        deluxeItemSampler.addModel(new SampleModel<>(deluxeGift3, 3));
    }

    // 究级密藏物品
    private static void initUltimateItemSampler() {
        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModel(new SampleModel<>(30, 60));
        regularBoxNS.addModel(new SampleModel<>(50, 100));
        regularBoxNS.addModel(new SampleModel<>(80, 40));
        Item regularBox = new Item("大盒子", ItemType.BOX, IconKey.REGULAR_BOX, StorageKey.REGULAR_BOX_NUM);
        regularBox.setHighlightColor(GColor.DELUXE_QUALITY);
        regularBox.setNumSampler(regularBoxNS);
        regularBox.setSubItemSampler(rbSubItemSampler);
        ultimateItemSampler.addModel(new SampleModel<>(regularBox, 2000));

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModel(new SampleModel<>(9999, 900));
        advancedCoinNS.addModel(new SampleModel<>(99999, 100));
        Item advancedCoin = new Item("金蘑菇", ItemType.CURRENCY, IconKey.ADVANCED_COIN, StorageKey.ADVANCED_COIN_NUM);
        advancedCoin.setHighlightColor(GColor.DELUXE_QUALITY);
        advancedCoin.setNumSampler(advancedCoinNS);
        ultimateItemSampler.addModel(new SampleModel<>(advancedCoin, 2000));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModel(new SampleModel<>(3, 200));
        advancedBoxNS.addModel(new SampleModel<>(5, 500));
        advancedBoxNS.addModel(new SampleModel<>(8, 150));
        advancedBoxNS.addModel(new SampleModel<>(10, 100));
        Item advancedBox = new Item("全屏", ItemType.BOX, IconKey.ADVANCED_BOX, StorageKey.ADVANCED_BOX_NUM);
        advancedBox.setHighlightColor(GColor.ULTIMATE_QUALITY);
        advancedBox.setNumSampler(advancedBoxNS);
        advancedBox.setSubItemSampler(abSubItemSampler);
        ultimateItemSampler.addModel(new SampleModel<>(advancedBox, 2000));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModel(new SampleModel<>(1, 100));
        deluxeBoxNS.addModel(new SampleModel<>(2, 500));
        deluxeBoxNS.addModel(new SampleModel<>(3, 300));
        Item deluxeBox = new Item("辉煌", ItemType.BOX, IconKey.DELUXE_BOX, StorageKey.DELUXE_BOX_NUM);
        deluxeBox.setHighlightColor(GColor.ULTIMATE_QUALITY);
        deluxeBox.setNumSampler(deluxeBoxNS);
        deluxeBox.setSubItemSampler(dbSubItemSampler);
        ultimateItemSampler.addModel(new SampleModel<>(deluxeBox, 2000));

        Sampler<Integer> advancedGiftNS = new Sampler<>();
        advancedGiftNS.addModel(new SampleModel<>(1, 900));
        advancedGiftNS.addModel(new SampleModel<>(2, 100));
        Item advancedGift = new Item("无暇天使", ItemType.GIFT, IconKey.ADVANCED_GIFT, StorageKey.ADVANCED_GIFT_NUM);
        advancedGift.setHighlightColor(GColor.ULTIMATE_QUALITY);
        advancedGift.setNumSampler(advancedGiftNS);
        ultimateItemSampler.addModel(new SampleModel<>(advancedGift, 600));

        Sampler<Integer> advancedGift2NS = new Sampler<>();
        advancedGift2NS.addModel(new SampleModel<>(1, 500));
        advancedGift2NS.addModel(new SampleModel<>(2, 200));
        advancedGift2NS.addModel(new SampleModel<>(3, 20));
        Item advancedGift2 = new Item("白炽龙裔", ItemType.GIFT, IconKey.ADVANCED_GIFT_2, StorageKey.ADVANCED_GIFT_2_NUM);
        advancedGift2.setHighlightColor(GColor.ULTIMATE_QUALITY);
        advancedGift2.setNumSampler(advancedGift2NS);
        ultimateItemSampler.addModel(new SampleModel<>(advancedGift2, 1200));

        Item deluxeGift = new Item("情定爱琴海", ItemType.GIFT, IconKey.DELUXE_GIFT, StorageKey.DELUXE_GIFT_NUM);
        deluxeGift.setHighlightColor(GColor.ULTIMATE_QUALITY);
        ultimateItemSampler.addModel(new SampleModel<>(deluxeGift, 200));

        Item deluxeGift2 = new Item("爱之天使号", ItemType.GIFT, IconKey.DELUXE_GIFT_2, StorageKey.DELUXE_GIFT_2_NUM);
        deluxeGift2.setHighlightColor(GColor.ULTIMATE_QUALITY);
        ultimateItemSampler.addModel(new SampleModel<>(deluxeGift2, 300));

        Item deluxeGift3 = new Item("玫瑰跑车-青花瓷", ItemType.GIFT, IconKey.DELUXE_GIFT_3, StorageKey.DELUXE_GIFT_3_NUM);
        deluxeGift3.setHighlightColor(GColor.ULTIMATE_QUALITY);
        ultimateItemSampler.addModel(new SampleModel<>(deluxeGift3, 200));

        Item ultimateGift = new Item("起源·应龙", ItemType.GIFT, IconKey.ULTIMATE_GIFT, StorageKey.ULTIMATE_GIFT_NUM);
        ultimateGift.setHighlightColor(GColor.ULTIMATE_QUALITY);
        ultimateItemSampler.addModel(new SampleModel<>(ultimateGift, 100));

        Item ultimateGift2 = new Item("起源·黑洞", ItemType.GIFT, IconKey.ULTIMATE_GIFT_2, StorageKey.ULTIMATE_GIFT_2_NUM);
        ultimateGift2.setHighlightColor(GColor.ULTIMATE_QUALITY);
        ultimateItemSampler.addModel(new SampleModel<>(ultimateGift2, 100));

        Item deluxeGift6 = new Item("玫瑰跑车-银河", ItemType.GIFT, IconKey.DELUXE_GIFT_6, StorageKey.DELUXE_GIFT_6_NUM);
        deluxeGift6.setHighlightColor(GColor.ULTIMATE_QUALITY);
        ultimateItemSampler.addModel(new SampleModel<>(deluxeGift6, 30));
    }

    // 蘑菇金库物品
    private static void initMRItemSampler() {
        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModelsLinearWeights(ListUtil.ofRange(98, 398), 200, 100);
        advancedCoinNS.addModel(new SampleModel<>(1888, 180));
        advancedCoinNS.addModel(new SampleModel<>(6666, 120));
        advancedCoinNS.addModel(new SampleModel<>(9999, 60));
        advancedCoinNS.addModel(new SampleModel<>(99999, 10));
        Item advancedCoin = new Item("金蘑菇", ItemType.CURRENCY, IconKey.ADVANCED_COIN, StorageKey.ADVANCED_COIN_NUM);
        advancedCoin.setHighlightColor(GColor.DELUXE_QUALITY);
        advancedCoin.setNumSampler(advancedCoinNS);
        mrItemSampler.addModel(new SampleModel<>(advancedCoin, 2000));
    }

    private static void initBBSubItemSampler() {
        Item bb1Gift = new Item("爱心飞艇", ItemType.GIFT, IconKey.RB1_GIFT, StorageKey.RB1_GIFT_NUM);
        bb1Gift.setValue(10000);
        bb1Gift.setGiftPoints(1600);
        bbSubItemSampler.addModel(new SampleModel<>(bb1Gift, 80));

        Item bb2Gift = new Item("爱心电话亭", ItemType.GIFT, IconKey.RB2_GIFT, StorageKey.RB2_GIFT_NUM);
        bb2Gift.setValue(10000);
        bb2Gift.setGiftPoints(1600);
        bbSubItemSampler.addModel(new SampleModel<>(bb2Gift, 80));

        Item bb3Gift = new Item("爱心魔法棒", ItemType.GIFT, IconKey.RB3_GIFT, StorageKey.RB3_GIFT_NUM);
        bb3Gift.setValue(10000);
        bb3Gift.setGiftPoints(1600);
        bbSubItemSampler.addModel(new SampleModel<>(bb3Gift, 80));

        Item bb4Gift = new Item("胡萝卜软糖", ItemType.GIFT, IconKey.BB4_GIFT, StorageKey.BB4_GIFT_NUM);
        bb4Gift.setValue(400);
        bb4Gift.setGiftPoints(64);
        bb4Gift.setBoxRegular(true);
        items.add(bb4Gift);
        bbSubItemSampler.addModel(new SampleModel<>(bb4Gift, 3000));

        Item bb5Gift = new Item("爱心信号枪", ItemType.GIFT, IconKey.BB5_GIFT, StorageKey.BB5_GIFT_NUM);
        bb5Gift.setValue(400);
        bb5Gift.setGiftPoints(64);
        bb5Gift.setBoxRegular(true);
        items.add(bb5Gift);
        bbSubItemSampler.addModel(new SampleModel<>(bb5Gift, 3000));

        Item bb6Gift = new Item("甜蜜小熊", ItemType.GIFT, IconKey.BB6_GIFT, StorageKey.BB6_GIFT_NUM);
        bb6Gift.setValue(1000);
        bb6Gift.setGiftPoints(160);
        bb6Gift.setBoxRegular(true);
        items.add(bb6Gift);
        bbSubItemSampler.addModel(new SampleModel<>(bb6Gift, 3000));

        Item bb7Gift = new Item("星愿熊熊", ItemType.GIFT, IconKey.BB7_GIFT, StorageKey.BB7_GIFT_NUM);
        bb7Gift.setValue(1000);
        bb7Gift.setGiftPoints(160);
        bb7Gift.setBoxRegular(true);
        items.add(bb7Gift);
        bbSubItemSampler.addModel(new SampleModel<>(bb7Gift, 3000));

        Item bb8Gift = new Item("玫瑰小熊", ItemType.GIFT, IconKey.BB8_GIFT, StorageKey.BB8_GIFT_NUM);
        bb8Gift.setValue(2000);
        bb8Gift.setGiftPoints(320);
        items.add(bb8Gift);
        bbSubItemSampler.addModel(new SampleModel<>(bb8Gift, 300));

        Item bb9Gift = new Item("樱花伞", ItemType.GIFT, IconKey.BB9_GIFT, StorageKey.BB9_GIFT_NUM);
        bb9Gift.setValue(4000);
        bb9Gift.setGiftPoints(640);
        items.add(bb9Gift);
        bbSubItemSampler.addModel(new SampleModel<>(bb9Gift, 150));

        Item bb10Gift = new Item("理想国", ItemType.GIFT, IconKey.RB8_GIFT, StorageKey.RB8_GIFT_NUM);
        bb10Gift.setValue(100000);
        bb10Gift.setGiftPoints(16000);
        bbSubItemSampler.addModel(new SampleModel<>(bb10Gift, 1));
    }

    private static void initRBSubItemSampler() {
        Item rb1Gift = new Item("爱心飞艇", ItemType.GIFT, IconKey.RB1_GIFT, StorageKey.RB1_GIFT_NUM);
        rb1Gift.setValue(10000);
        rb1Gift.setGiftPoints(1600);
        rb1Gift.setBoxRegular(true);
        items.add(rb1Gift);
        rbSubItemSampler.addModel(new SampleModel<>(rb1Gift, 3000));

        Item rb2Gift = new Item("爱心电话亭", ItemType.GIFT, IconKey.RB2_GIFT, StorageKey.RB2_GIFT_NUM);
        rb2Gift.setValue(10000);
        rb2Gift.setGiftPoints(1600);
        rb2Gift.setBoxRegular(true);
        items.add(rb2Gift);
        rbSubItemSampler.addModel(new SampleModel<>(rb2Gift, 3000));

        Item rb3Gift = new Item("爱心魔法棒", ItemType.GIFT, IconKey.RB3_GIFT, StorageKey.RB3_GIFT_NUM);
        rb3Gift.setValue(10000);
        rb3Gift.setGiftPoints(1600);
        rb3Gift.setBoxRegular(true);
        items.add(rb3Gift);
        rbSubItemSampler.addModel(new SampleModel<>(rb3Gift, 3000));

        Item rb4Gift = new Item("金丝雀爱巢", ItemType.GIFT, IconKey.RB4_GIFT, StorageKey.RB4_GIFT_NUM);
        rb4Gift.setValue(10000);
        rb4Gift.setGiftPoints(1600);
        items.add(rb4Gift);
        rbSubItemSampler.addModel(new SampleModel<>(rb4Gift, 500));

        Item rb5Gift = new Item("游艇", ItemType.GIFT, IconKey.RB5_GIFT, StorageKey.RB5_GIFT_NUM);
        rb5Gift.setValue(20000);
        rb5Gift.setGiftPoints(3200);
        items.add(rb5Gift);
        rbSubItemSampler.addModel(new SampleModel<>(rb5Gift, 300));

        Item rb6Gift = new Item("钻石手表", ItemType.GIFT, IconKey.RB6_GIFT, StorageKey.RB6_GIFT_NUM);
        rb6Gift.setValue(30000);
        rb6Gift.setGiftPoints(3200);
        items.add(rb6Gift);
        rbSubItemSampler.addModel(new SampleModel<>(rb6Gift, 300));

        Item rb7Gift = new Item("水晶竖琴", ItemType.GIFT, IconKey.RB7_GIFT, StorageKey.RB7_GIFT_NUM);
        rb7Gift.setValue(30000);
        rb7Gift.setGiftPoints(4800);
        items.add(rb7Gift);
        rbSubItemSampler.addModel(new SampleModel<>(rb7Gift, 200));

        Item rb8Gift = new Item("理想国", ItemType.GIFT, IconKey.RB8_GIFT, StorageKey.RB8_GIFT_NUM);
        rb8Gift.setValue(100000);
        rb8Gift.setGiftPoints(16000);
        items.add(rb8Gift);
        rbSubItemSampler.addModel(new SampleModel<>(rb8Gift, 180));
    }

    private static void initABSubItemSampler() {
        Item ab1Gift = new Item("陪你去看流星雨", ItemType.GIFT, IconKey.AB1_GIFT, StorageKey.AB1_GIFT_NUM);
        ab1Gift.setValue(100000);
        ab1Gift.setGiftPoints(16000);
        ab1Gift.setBoxRegular(true);
        items.add(ab1Gift);
        abSubItemSampler.addModel(new SampleModel<>(ab1Gift, 3000));

        Item ab2Gift = new Item("倾城绝恋", ItemType.GIFT, IconKey.AB2_GIFT, StorageKey.AB2_GIFT_NUM);
        ab2Gift.setValue(100000);
        ab2Gift.setGiftPoints(30000);
        ab2Gift.setBoxRegular(true);
        items.add(ab2Gift);
        abSubItemSampler.addModel(new SampleModel<>(ab2Gift, 3000));

        Item ab3Gift = new Item("倾世一诺", ItemType.GIFT, IconKey.AB3_GIFT, StorageKey.AB3_GIFT_NUM);
        ab3Gift.setValue(100000);
        ab3Gift.setGiftPoints(16000);
        ab3Gift.setBoxRegular(true);
        items.add(ab3Gift);
        abSubItemSampler.addModel(new SampleModel<>(ab3Gift, 3000));

        Item ab4Gift = new Item("理想国", ItemType.GIFT, IconKey.RB8_GIFT, StorageKey.RB8_GIFT_NUM);
        ab4Gift.setValue(100000);
        ab4Gift.setGiftPoints(16000);
        abSubItemSampler.addModel(new SampleModel<>(ab4Gift, 500));

        Item ab5Gift = new Item("战争女王", ItemType.GIFT, IconKey.AB5_GIFT, StorageKey.AB5_GIFT_NUM);
        ab5Gift.setValue(300000);
        ab5Gift.setGiftPoints(48000);
        items.add(ab5Gift);
        abSubItemSampler.addModel(new SampleModel<>(ab5Gift, 50));

        Item ab6Gift = new Item("招福舞狮", ItemType.GIFT, IconKey.AB6_GIFT, StorageKey.AB6_GIFT_NUM);
        ab6Gift.setValue(50000);
        ab6Gift.setGiftPoints(8000);
        items.add(ab6Gift);
        abSubItemSampler.addModel(new SampleModel<>(ab6Gift, 500));
    }

    private static void initDBSubItemSampler() {
        Item db1Gift = new Item("命乾无极", ItemType.GIFT, IconKey.DB1_GIFT, StorageKey.DB1_GIFT_NUM);
        db1Gift.setValue(500000);
        db1Gift.setGiftPoints(80000);
        items.add(db1Gift);
        dbSubItemSampler.addModel(new SampleModel<>(db1Gift, 80));

        Item db2Gift = new Item("嘉年星港", ItemType.GIFT, IconKey.DB2_GIFT, StorageKey.DB2_GIFT_NUM);
        db2Gift.setValue(300000);
        db2Gift.setGiftPoints(48000);
        db2Gift.setBoxRegular(true);
        items.add(db2Gift);
        dbSubItemSampler.addModel(new SampleModel<>(db2Gift, 3000));

        Item db3Gift = new Item("战争女王", ItemType.GIFT, IconKey.AB5_GIFT, StorageKey.AB5_GIFT_NUM);
        db3Gift.setValue(300000);
        db3Gift.setGiftPoints(48000);
        dbSubItemSampler.addModel(new SampleModel<>(db3Gift, 500));

        Item db4Gift = new Item("锦绣山河", ItemType.GIFT, IconKey.DB4_GIFT, StorageKey.DB4_GIFT_NUM);
        db4Gift.setValue(300000);
        db4Gift.setGiftPoints(48000);
        db4Gift.setBoxRegular(true);
        items.add(db4Gift);
        dbSubItemSampler.addModel(new SampleModel<>(db4Gift, 3000));

        Item db5Gift = new Item("魔灵古堡", ItemType.GIFT, IconKey.DB5_GIFT, StorageKey.DB5_GIFT_NUM);
        db5Gift.setValue(188888);
        db5Gift.setGiftPoints(30000);
        items.add(db5Gift);
        dbSubItemSampler.addModel(new SampleModel<>(db5Gift, 500));
    }
}

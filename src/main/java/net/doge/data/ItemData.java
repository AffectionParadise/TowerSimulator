package net.doge.data;

import lombok.Getter;
import net.doge.constant.*;
import net.doge.model.*;
import net.doge.util.ListUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * 物品数据
 */
public class ItemData {
    // 一塔物品生成器
    public static Sampler<Item> basicTowerItemSampler;
    // 二塔物品生成器
    public static Sampler<Item> regularTowerItemSampler;
    // 三塔物品生成器
    public static Sampler<Item> advancedTowerItemSampler;
    // 金塔物品生成器
    public static Sampler<Item> deluxeTowerItemSampler;
    // 中级密藏物品生成器
    public static Sampler<Item> regularItemSampler;
    // 高级密藏物品生成器
    public static Sampler<Item> advancedItemSampler;
    // 超级密藏物品生成器
    public static Sampler<Item> deluxeItemSampler;
    // 究级密藏物品生成器
    public static Sampler<Item> ultimateItemSampler;
    // 蘑菇金库物品生成器
    public static Sampler<Item> mrItemSampler;
    // 竞猜物品生成器
    public static Sampler<Item> quizItemSampler;

    // 小盒子子物品生成器
    private static Sampler<Item> bbSubItemSampler;
    // 大盒子子物品生成器
    private static Sampler<Item> rbSubItemSampler;
    // 全屏子物品生成器
    private static Sampler<Item> abSubItemSampler;
    // 辉煌子物品生成器
    private static Sampler<Item> dbSubItemSampler;
    // 物品列表
    @Getter
    private static List<Item> items;

    // 币
    public static Item COIN;
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
        initQuizItemSampler();
    }

    // 一塔物品
    private static void initBasicTowerItemSampler() {
        basicTowerItemSampler = new Sampler<>();

        Sampler<Integer> basicGiftNS = new Sampler<>();
        basicGiftNS.addModelsLinearWeights(ListUtil.ofRange(1, 3), 2000, 10);
        Item basicGift = new Item("小情书", ItemType.GIFT, IconKey.BASIC_GIFT, StorageKey.BASIC_GIFT_NUM);
        basicGift.setHighlightColor(Colors.BASIC_QUALITY);
        basicGift.setNumSampler(basicGiftNS);
        basicTowerItemSampler.addModel(new SampleModel<>(basicGift, 1000));

        Sampler<Integer> regularGiftNS = new Sampler<>();
        regularGiftNS.addModelsLinearWeights(ListUtil.ofRange(1, 2), 2000, 10);
        Item regularGift = new Item("送花小狗", ItemType.GIFT, IconKey.REGULAR_GIFT, StorageKey.REGULAR_GIFT_NUM);
        regularGift.setHighlightColor(Colors.BASIC_QUALITY);
        regularGift.setNumSampler(regularGiftNS);
        basicTowerItemSampler.addModel(new SampleModel<>(regularGift, 50));

        Sampler<Integer> regularCoinNS = new Sampler<>();
        regularCoinNS.addModelsLinearWeights(ListUtil.ofRange(10, 30), 2000, 10);
        Item regularCoin = new Item("赠送金蘑菇", ItemType.CURRENCY, IconKey.REGULAR_COIN, StorageKey.REGULAR_COIN_NUM);
        regularCoin.setHighlightColor(Colors.BASIC_QUALITY);
        regularCoin.setNumSampler(regularCoinNS);
        basicTowerItemSampler.addModel(new SampleModel<>(regularCoin, 2000));

        Item basicStep = new Item("一塔牌子", ItemType.CURRENCY, IconKey.BASIC_STEP, StorageKey.BASIC_STEP_NUM);
        BASIC_STEP = basicStep;
        basicStep.setIconThumbKey(IconKey.BASIC_STEP_THUMB);
        basicStep.setHighlightColor(Colors.BASIC_QUALITY);
        items.add(basicStep);
        basicTowerItemSampler.addModel(new SampleModel<>(basicStep, 100));

        Item regularStep = new Item("二塔牌子", ItemType.CURRENCY, IconKey.REGULAR_STEP, StorageKey.REGULAR_STEP_NUM);
        regularStep.setHighlightColor(Colors.REGULAR_QUALITY);
        basicTowerItemSampler.addModel(new SampleModel<>(regularStep, 10));
    }

    // 二塔物品
    private static void initRegularTowerItemSampler() {
        regularTowerItemSampler = new Sampler<>();

        Sampler<Integer> coinNS = new Sampler<>();
        coinNS.addModelsLinearWeights(ListUtil.ofRange(1, 10), 2000, 10);
        Item coin = new Item("币", ItemType.CURRENCY, IconKey.COIN, StorageKey.COIN_NUM);
        coin.setHighlightColor(Colors.REGULAR_QUALITY);
        coin.setNumSampler(coinNS);
        regularTowerItemSampler.addModel(new SampleModel<>(coin, 1500));

        Sampler<Integer> basicGiftNS = new Sampler<>();
        basicGiftNS.addModelsLinearWeights(ListUtil.ofRange(1, 5), 2000, 10);
        Item basicGift = new Item("小情书", ItemType.GIFT, IconKey.BASIC_GIFT, StorageKey.BASIC_GIFT_NUM);
        basicGift.setHighlightColor(Colors.BASIC_QUALITY);
        basicGift.setNumSampler(basicGiftNS);
        regularTowerItemSampler.addModel(new SampleModel<>(basicGift, 2000));

        Sampler<Integer> regularGiftNS = new Sampler<>();
        regularGiftNS.addModelsLinearWeights(ListUtil.ofRange(1, 3), 2000, 10);
        Item regularGift = new Item("送花小狗", ItemType.GIFT, IconKey.REGULAR_GIFT, StorageKey.REGULAR_GIFT_NUM);
        regularGift.setHighlightColor(Colors.BASIC_QUALITY);
        regularGift.setNumSampler(regularGiftNS);
        regularTowerItemSampler.addModel(new SampleModel<>(regularGift, 500));

        Sampler<Integer> regularCoinNS = new Sampler<>();
        regularCoinNS.addModelsLinearWeights(ListUtil.ofRange(30, 60), 2000, 10);
        Item regularCoin = new Item("赠送金蘑菇", ItemType.CURRENCY, IconKey.REGULAR_COIN, StorageKey.REGULAR_COIN_NUM);
        regularCoin.setHighlightColor(Colors.BASIC_QUALITY);
        regularCoin.setNumSampler(regularCoinNS);
        regularTowerItemSampler.addModel(new SampleModel<>(regularCoin, 2000));

        Sampler<Integer> statueNS = new Sampler<>();
        statueNS.addModelsLinearWeights(ListUtil.ofRange(1, 5), 2000, 10);
        Item statue = new Item("初代塔坦王雕像", ItemType.CURRENCY, IconKey.STATUE, StorageKey.STATUE_NUM);
        statue.setHighlightColor(Colors.ADVANCED_QUALITY);
        statue.setNumSampler(statueNS);
        regularTowerItemSampler.addModel(new SampleModel<>(statue, 1000));

        Item regularGift2 = new Item("居士汪", ItemType.GIFT, IconKey.REGULAR_GIFT_2, StorageKey.REGULAR_GIFT_2_NUM);
        regularGift2.setHighlightColor(Colors.DELUXE_QUALITY);
        regularTowerItemSampler.addModel(new SampleModel<>(regularGift2, 50));

        Item deluxeStep = new Item("金塔牌子", ItemType.CURRENCY, IconKey.DELUXE_STEP, StorageKey.DELUXE_STEP_NUM);
        deluxeStep.setHighlightColor(Colors.DELUXE_QUALITY);
        regularTowerItemSampler.addModel(new SampleModel<>(deluxeStep, 3));

        Item advancedBox = new Item("全屏", ItemType.BOX, IconKey.ADVANCED_BOX, StorageKey.ADVANCED_BOX_NUM);
        advancedBox.setHighlightColor(Colors.ULTIMATE_QUALITY);
        advancedBox.setSubItemSampler(abSubItemSampler);
        regularTowerItemSampler.addModel(new SampleModel<>(advancedBox, 2));
    }

    // 三塔物品
    private static void initAdvancedTowerItemSampler() {
        advancedTowerItemSampler = new Sampler<>();
        items = new LinkedList<>();

        Sampler<Integer> coinNS = new Sampler<>();
        coinNS.addModelsLinearWeights(ListUtil.ofRange(10, 33), 1000, 10);
        coinNS.addModel(new SampleModel<>(66, 10));
        coinNS.addModel(new SampleModel<>(99, 5));
        coinNS.addModel(new SampleModel<>(199, 2));
        Item coin = new Item("币", ItemType.CURRENCY, IconKey.COIN, StorageKey.COIN_NUM);
        COIN = coin;
        coin.setIconThumbKey(IconKey.COIN_THUMB);
        coin.setHighlightColor(Colors.REGULAR_QUALITY);
        coin.setGuessable(true);
        coin.setNumSampler(coinNS);
        items.add(coin);
        advancedTowerItemSampler.addModel(new SampleModel<>(coin, 2000));

        Sampler<Integer> basicGiftNS = new Sampler<>();
        basicGiftNS.addModelsLinearWeights(ListUtil.ofRange(1, 10), 1000, 10);
        Item basicGift = new Item("小情书", ItemType.GIFT, IconKey.BASIC_GIFT, StorageKey.BASIC_GIFT_NUM);
        basicGift.setHighlightColor(Colors.BASIC_QUALITY);
        basicGift.setValue(30);
        basicGift.setExchangeable(true);
        basicGift.setExchangeCost(1);
        basicGift.setGuessable(true);
        basicGift.setNumSampler(basicGiftNS);
        items.add(basicGift);
        advancedTowerItemSampler.addModel(new SampleModel<>(basicGift, 1000));

        Sampler<Integer> regularGiftNS = new Sampler<>();
        regularGiftNS.addModelsLinearWeights(ListUtil.ofRange(1, 8), 1000, 10);
        Item regularGift = new Item("送花小狗", ItemType.GIFT, IconKey.REGULAR_GIFT, StorageKey.REGULAR_GIFT_NUM);
        regularGift.setHighlightColor(Colors.BASIC_QUALITY);
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
        regularCoin.setHighlightColor(Colors.BASIC_QUALITY);
        regularCoin.setGuessable(true);
        regularCoin.setNumSampler(regularCoinNS);
        items.add(regularCoin);
        advancedTowerItemSampler.addModel(new SampleModel<>(regularCoin, 1500));

        Sampler<Integer> statueNS = new Sampler<>();
        statueNS.addModelsLinearWeights(ListUtil.ofRange(2, 8), 1000, 10);
        Item statue = new Item("初代塔坦王雕像", ItemType.CURRENCY, IconKey.STATUE, StorageKey.STATUE_NUM);
        statue.setHighlightColor(Colors.ADVANCED_QUALITY);
        statue.setGuessable(true);
        statue.setNumSampler(statueNS);
        items.add(statue);
        advancedTowerItemSampler.addModel(new SampleModel<>(statue, 1000));

        Item regularStep = new Item("二塔牌子", ItemType.CURRENCY, IconKey.REGULAR_STEP, StorageKey.REGULAR_STEP_NUM);
        REGULAR_STEP = regularStep;
        regularStep.setIconThumbKey(IconKey.REGULAR_STEP_THUMB);
        regularStep.setHighlightColor(Colors.REGULAR_QUALITY);
        regularStep.setGuessable(true);
        items.add(regularStep);
        advancedTowerItemSampler.addModel(new SampleModel<>(regularStep, 350));

        Item advancedStep = new Item("三塔牌子", ItemType.CURRENCY, IconKey.ADVANCED_STEP, StorageKey.ADVANCED_STEP_NUM);
        ADVANCED_STEP = advancedStep;
        advancedStep.setIconThumbKey(IconKey.ADVANCED_STEP_THUMB);
        advancedStep.setHighlightColor(Colors.ADVANCED_QUALITY);
        advancedStep.setGuessable(true);
        items.add(advancedStep);
        advancedTowerItemSampler.addModel(new SampleModel<>(advancedStep, 150));

        Item deluxeStep = new Item("金塔牌子", ItemType.CURRENCY, IconKey.DELUXE_STEP, StorageKey.DELUXE_STEP_NUM);
        DELUXE_STEP = deluxeStep;
        deluxeStep.setIconThumbKey(IconKey.DELUXE_STEP_THUMB);
        deluxeStep.setHighlightColor(Colors.DELUXE_QUALITY);
        items.add(deluxeStep);
        advancedTowerItemSampler.addModel(new SampleModel<>(deluxeStep, 30));

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModel(new SampleModel<>(9999, 990));
        advancedCoinNS.addModel(new SampleModel<>(99999, 10));
        Item advancedCoin = new Item("金蘑菇", ItemType.CURRENCY, IconKey.ADVANCED_COIN, StorageKey.ADVANCED_COIN_NUM);
        ADVANCED_COIN = advancedCoin;
        advancedCoin.setIconThumbKey(IconKey.ADVANCED_COIN_THUMB);
        advancedCoin.setHighlightColor(Colors.DELUXE_QUALITY);
        advancedCoin.setNumSampler(advancedCoinNS);
        items.add(advancedCoin);
        advancedTowerItemSampler.addModel(new SampleModel<>(advancedCoin, 3));

        Sampler<Integer> basicBoxNS = new Sampler<>();
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 5), 2000, 10);
        Item basicBox = new Item("小盒子", ItemType.BOX, IconKey.BASIC_BOX, StorageKey.BASIC_BOX_NUM);
        BASIC_BOX = basicBox;
        basicBox.setHighlightColor(Colors.REGULAR_QUALITY);
        basicBox.setExchangeable(true);
        basicBox.setExchangeCost(15);
        basicBox.setGuessable(true);
        basicBox.setNumSampler(basicBoxNS);
        initBBSubItemSampler();
        basicBox.setSubItemSampler(bbSubItemSampler);
        items.add(basicBox);
        advancedTowerItemSampler.addModel(new SampleModel<>(basicBox, 800));

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModel(new SampleModel<>(1, 2000));
        regularBoxNS.addModel(new SampleModel<>(2, 100));
        regularBoxNS.addModel(new SampleModel<>(3, 30));
        regularBoxNS.addModel(new SampleModel<>(4, 3));
        regularBoxNS.addModel(new SampleModel<>(5, 1));
        Item regularBox = new Item("大盒子", ItemType.BOX, IconKey.REGULAR_BOX, StorageKey.REGULAR_BOX_NUM);
        REGULAR_BOX = regularBox;
        regularBox.setHighlightColor(Colors.DELUXE_QUALITY);
        regularBox.setExchangeable(true);
        regularBox.setExchangeCost(120);
        regularBox.setGuessable(true);
        regularBox.setNumSampler(regularBoxNS);
        initRBSubItemSampler();
        regularBox.setSubItemSampler(rbSubItemSampler);
        items.add(regularBox);
        advancedTowerItemSampler.addModel(new SampleModel<>(regularBox, 300));

//        Sampler<Integer> basicGiftInGroupNS = new Sampler<>();
//        basicGiftInGroupNS.addModel(new SampleModel<>(3, 1));
//        Item basicGiftInGroup = new Item("小情书", ItemType.GIFT, IconKey.BASIC_GIFT, DataStorageKey.BASIC_GIFT_NUM);
//        basicGiftInGroup.setNumSampler(basicGiftInGroupNS);
//        Sampler<Integer> regularBoxInGroupNS = new Sampler<>();
//        regularBoxInGroupNS.addModel(new SampleModel<>(1, 1));
//        Item regularBoxInGroup = new Item("大盒子", ItemType.BOX, IconKey.REGULAR_BOX, DataStorageKey.REGULAR_BOX_NUM);
//        regularBoxInGroup.setNumSampler(regularBoxInGroupNS);
//        Item randomGiftGroup = new Item("大礼物宝盒", ItemType.GROUP, IconKey.RANDOM_GIFT_GROUP, null);
//        List<Item> fsi = new LinkedList<>();
//        fsi.add(basicGiftInGroup);
//        fsi.add(regularBoxInGroup);
//        randomGiftGroup.setFixedSubItems(fsi);
//        randomGiftGroup.setSubItemSampler(fsi);
//        items.add(randomGiftGroup);
//        itemSampler.addModel(new SampleModel<>(randomGiftGroup, 100));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModel(new SampleModel<>(1, 950));
        advancedBoxNS.addModel(new SampleModel<>(2, 48));
        advancedBoxNS.addModel(new SampleModel<>(3, 2));
        Item advancedBox = new Item("全屏", ItemType.BOX, IconKey.ADVANCED_BOX, StorageKey.ADVANCED_BOX_NUM);
        ADVANCED_BOX = advancedBox;
        advancedBox.setHighlightColor(Colors.ULTIMATE_QUALITY);
        advancedBox.setExchangeable(true);
        advancedBox.setExchangeCost(1500);
        advancedBox.setGuessable(true);
        advancedBox.setNumSampler(advancedBoxNS);
        initABSubItemSampler();
        advancedBox.setSubItemSampler(abSubItemSampler);
        items.add(advancedBox);
        advancedTowerItemSampler.addModel(new SampleModel<>(advancedBox, 40));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModel(new SampleModel<>(1, 980));
        deluxeBoxNS.addModel(new SampleModel<>(2, 20));
        Item deluxeBox = new Item("辉煌", ItemType.BOX, IconKey.DELUXE_BOX, StorageKey.DELUXE_BOX_NUM);
        DELUXE_BOX = deluxeBox;
        deluxeBox.setHighlightColor(Colors.ULTIMATE_QUALITY);
        deluxeBox.setNumSampler(deluxeBoxNS);
        initDBSubItemSampler();
        deluxeBox.setSubItemSampler(dbSubItemSampler);
        items.add(deluxeBox);
        advancedTowerItemSampler.addModel(new SampleModel<>(deluxeBox, 10));

        Sampler<Integer> advancedGiftNS = new Sampler<>();
        advancedGiftNS.addModel(new SampleModel<>(1, 998));
        advancedGiftNS.addModel(new SampleModel<>(2, 2));
        Item advancedGift = new Item("无暇天使", ItemType.GIFT, IconKey.ADVANCED_GIFT, StorageKey.ADVANCED_GIFT_NUM);
        advancedGift.setValue(1000000);
        advancedGift.setGiftPoints(160000);
        advancedGift.setHighlightColor(Colors.ULTIMATE_QUALITY);
        advancedGift.setNumSampler(advancedGiftNS);
        items.add(advancedGift);
        advancedTowerItemSampler.addModel(new SampleModel<>(advancedGift, 5));

        Sampler<Integer> advancedGift2NS = new Sampler<>();
        advancedGift2NS.addModel(new SampleModel<>(1, 990));
        advancedGift2NS.addModel(new SampleModel<>(2, 10));
        Item advancedGift2 = new Item("白炽龙裔", ItemType.GIFT, IconKey.ADVANCED_GIFT_2, StorageKey.ADVANCED_GIFT_2_NUM);
        advancedGift2.setHighlightColor(Colors.ULTIMATE_QUALITY);
        advancedGift2.setValue(500000);
        advancedGift2.setGiftPoints(80000);
        advancedGift2.setNumSampler(advancedGift2NS);
        items.add(advancedGift2);
        advancedTowerItemSampler.addModel(new SampleModel<>(advancedGift2, 8));

        Item deluxeGift = new Item("情定爱琴海", ItemType.GIFT, IconKey.DELUXE_GIFT, StorageKey.DELUXE_GIFT_NUM);
        deluxeGift.setHighlightColor(Colors.ULTIMATE_QUALITY);
        deluxeGift.setValue(1888888);
        deluxeGift.setGiftPoints(666666);
        items.add(deluxeGift);
        advancedTowerItemSampler.addModel(new SampleModel<>(deluxeGift, 2));

        Item deluxeGift2 = new Item("爱之天使号", ItemType.GIFT, IconKey.DELUXE_GIFT_2, StorageKey.DELUXE_GIFT_2_NUM);
        deluxeGift2.setHighlightColor(Colors.ULTIMATE_QUALITY);
        deluxeGift2.setValue(1888888);
        deluxeGift2.setGiftPoints(566666);
        items.add(deluxeGift2);
        advancedTowerItemSampler.addModel(new SampleModel<>(deluxeGift2, 2));

        Item deluxeGift4 = new Item("玫瑰跑车", ItemType.GIFT, IconKey.DELUXE_GIFT_4, StorageKey.DELUXE_GIFT_4_NUM);
        deluxeGift4.setHighlightColor(Colors.ULTIMATE_QUALITY);
        deluxeGift4.setValue(1888888);
        deluxeGift4.setGiftPoints(299999);
        items.add(deluxeGift4);
        advancedTowerItemSampler.addModel(new SampleModel<>(deluxeGift4, 2));

        Item ultimateGift = new Item("起源·应龙", ItemType.GIFT, IconKey.ULTIMATE_GIFT, StorageKey.ULTIMATE_GIFT_NUM);
        ultimateGift.setHighlightColor(Colors.ULTIMATE_QUALITY);
        ultimateGift.setValue(2888888);
        ultimateGift.setGiftPoints(888888);
        items.add(ultimateGift);
        advancedTowerItemSampler.addModel(new SampleModel<>(ultimateGift, 2));

        Item ticket = new Item("嘉年华孢子兑换券", ItemType.CURRENCY, IconKey.TICKET, StorageKey.TICKET);
        ticket.setHighlightColor(Colors.ULTIMATE_QUALITY);
        items.add(ticket);
        advancedTowerItemSampler.addModel(new SampleModel<>(ticket, 1));
    }

    // 金塔物品
    private static void initDeluxeTowerItemSampler() {
        deluxeTowerItemSampler = new Sampler<>();

        Sampler<Integer> coinNS = new Sampler<>();
        coinNS.addModel(new SampleModel<>(99, 500));
        coinNS.addModel(new SampleModel<>(199, 500));
        coinNS.addModel(new SampleModel<>(899, 250));
        coinNS.addModel(new SampleModel<>(999, 125));
        Item coin = new Item("币", ItemType.CURRENCY, IconKey.COIN, StorageKey.COIN_NUM);
        coin.setHighlightColor(Colors.REGULAR_QUALITY);
        coin.setNumSampler(coinNS);
        deluxeTowerItemSampler.addModel(new SampleModel<>(coin, 2000));

        Sampler<Integer> statueNS = new Sampler<>();
        statueNS.addModelsLinearWeights(ListUtil.ofRange(2, 16), 2000, 10);
        Item statue = new Item("初代塔坦王雕像", ItemType.CURRENCY, IconKey.STATUE, StorageKey.STATUE_NUM);
        statue.setHighlightColor(Colors.ADVANCED_QUALITY);
        statue.setNumSampler(statueNS);
        deluxeTowerItemSampler.addModel(new SampleModel<>(statue, 1000));

        Sampler<Integer> basicBoxNS = new Sampler<>();
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 5), 2000, 10);
        Item basicBox = new Item("小盒子", ItemType.BOX, IconKey.BASIC_BOX, StorageKey.BASIC_BOX_NUM);
        basicBox.setHighlightColor(Colors.REGULAR_QUALITY);
        basicBox.setSubItemSampler(bbSubItemSampler);
        deluxeTowerItemSampler.addModel(new SampleModel<>(basicBox, 800));

        Sampler<Integer> regularGift2NS = new Sampler<>();
        regularGift2NS.addModelsLinearWeights(ListUtil.ofRange(1, 5), 2000, 10);
        Item regularGift2 = new Item("居士汪", ItemType.GIFT, IconKey.REGULAR_GIFT_2, StorageKey.REGULAR_GIFT_2_NUM);
        regularGift2.setHighlightColor(Colors.DELUXE_QUALITY);
        regularGift2.setValue(10000);
        regularGift2.setGiftPoints(1600);
        regularGift2.setExchangeable(true);
        regularGift2.setExchangeCost(100);
        regularGift2.setNumSampler(regularGift2NS);
        items.add(regularGift2);
        deluxeTowerItemSampler.addModel(new SampleModel<>(regularGift2, 400));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModel(new SampleModel<>(1, 950));
        advancedBoxNS.addModel(new SampleModel<>(2, 48));
        advancedBoxNS.addModel(new SampleModel<>(3, 2));
        Item advancedBox = new Item("全屏", ItemType.BOX, IconKey.ADVANCED_BOX, StorageKey.ADVANCED_BOX_NUM);
        advancedBox.setHighlightColor(Colors.ULTIMATE_QUALITY);
        advancedBox.setSubItemSampler(abSubItemSampler);
        deluxeTowerItemSampler.addModel(new SampleModel<>(advancedBox, 20));
    }

    // 中级密藏物品
    private static void initRegularItemSampler() {
        regularItemSampler = new Sampler<>();

        Sampler<Integer> coinNS = new Sampler<>();
        coinNS.addModel(new SampleModel<>(199, 200));
        coinNS.addModel(new SampleModel<>(399, 10));
        coinNS.addModel(new SampleModel<>(699, 1));
        Item coin = new Item("币", ItemType.CURRENCY, IconKey.COIN, StorageKey.COIN_NUM);
        coin.setHighlightColor(Colors.DELUXE_QUALITY);
        coin.setNumSampler(coinNS);
        regularItemSampler.addModel(new SampleModel<>(coin, 2000));

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModel(new SampleModel<>(1, 100));
        regularBoxNS.addModel(new SampleModel<>(2, 80));
        regularBoxNS.addModel(new SampleModel<>(4, 5));
        Item regularBox = new Item("大盒子", ItemType.BOX, IconKey.REGULAR_BOX, StorageKey.REGULAR_BOX_NUM);
        regularBox.setHighlightColor(Colors.DELUXE_QUALITY);
        regularBox.setNumSampler(regularBoxNS);
        regularBox.setSubItemSampler(rbSubItemSampler);
        regularItemSampler.addModel(new SampleModel<>(regularBox, 2000));

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModel(new SampleModel<>(1888, 990));
        advancedCoinNS.addModel(new SampleModel<>(6666, 10));
        Item advancedCoin = new Item("金蘑菇", ItemType.CURRENCY, IconKey.ADVANCED_COIN, StorageKey.ADVANCED_COIN_NUM);
        advancedCoin.setHighlightColor(Colors.DELUXE_QUALITY);
        advancedCoin.setNumSampler(advancedCoinNS);
        regularItemSampler.addModel(new SampleModel<>(advancedCoin, 30));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModel(new SampleModel<>(1, 950));
        advancedBoxNS.addModel(new SampleModel<>(2, 49));
        advancedBoxNS.addModel(new SampleModel<>(4, 1));
        Item advancedBox = new Item("全屏", ItemType.BOX, IconKey.ADVANCED_BOX, StorageKey.ADVANCED_BOX_NUM);
        advancedBox.setHighlightColor(Colors.ULTIMATE_QUALITY);
        advancedBox.setNumSampler(advancedBoxNS);
        advancedBox.setSubItemSampler(abSubItemSampler);
        regularItemSampler.addModel(new SampleModel<>(advancedBox, 40));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModel(new SampleModel<>(1, 990));
        deluxeBoxNS.addModel(new SampleModel<>(2, 10));
        Item deluxeBox = new Item("辉煌", ItemType.BOX, IconKey.DELUXE_BOX, StorageKey.DELUXE_BOX_NUM);
        deluxeBox.setHighlightColor(Colors.ULTIMATE_QUALITY);
        deluxeBox.setNumSampler(deluxeBoxNS);
        deluxeBox.setSubItemSampler(dbSubItemSampler);
        regularItemSampler.addModel(new SampleModel<>(deluxeBox, 10));

        Sampler<Integer> advancedGiftNS = new Sampler<>();
        advancedGiftNS.addModel(new SampleModel<>(1, 1));
        Item advancedGift = new Item("无暇天使", ItemType.GIFT, IconKey.ADVANCED_GIFT, StorageKey.ADVANCED_GIFT_NUM);
        advancedGift.setHighlightColor(Colors.ULTIMATE_QUALITY);
        advancedGift.setNumSampler(advancedGiftNS);
        regularItemSampler.addModel(new SampleModel<>(advancedGift, 3));

        Sampler<Integer> advancedGift2NS = new Sampler<>();
        advancedGift2NS.addModel(new SampleModel<>(1, 990));
        advancedGift2NS.addModel(new SampleModel<>(2, 10));
        Item advancedGift2 = new Item("白炽龙裔", ItemType.GIFT, IconKey.ADVANCED_GIFT_2, StorageKey.ADVANCED_GIFT_2_NUM);
        advancedGift2.setHighlightColor(Colors.ULTIMATE_QUALITY);
        advancedGift2.setNumSampler(advancedGift2NS);
        regularItemSampler.addModel(new SampleModel<>(advancedGift2, 6));

        Item deluxeGift3 = new Item("玫瑰跑车-青花瓷", ItemType.GIFT, IconKey.DELUXE_GIFT_3, StorageKey.DELUXE_GIFT_3_NUM);
        deluxeGift3.setHighlightColor(Colors.ULTIMATE_QUALITY);
        deluxeGift3.setValue(1888888);
        deluxeGift3.setGiftPoints(666666);
        items.add(deluxeGift3);
        regularItemSampler.addModel(new SampleModel<>(deluxeGift3, 1));
    }

    // 高级密藏物品
    private static void initAdvancedItemSampler() {
        advancedItemSampler = new Sampler<>();

        Sampler<Integer> coinNS = new Sampler<>();
        coinNS.addModel(new SampleModel<>(199, 10));
        coinNS.addModel(new SampleModel<>(399, 200));
        coinNS.addModel(new SampleModel<>(699, 50));
        Item coin = new Item("币", ItemType.CURRENCY, IconKey.COIN, StorageKey.COIN_NUM);
        coin.setHighlightColor(Colors.DELUXE_QUALITY);
        coin.setNumSampler(coinNS);
        advancedItemSampler.addModel(new SampleModel<>(coin, 2000));

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModel(new SampleModel<>(2, 200));
        regularBoxNS.addModel(new SampleModel<>(4, 150));
        regularBoxNS.addModel(new SampleModel<>(8, 20));
        Item regularBox = new Item("大盒子", ItemType.BOX, IconKey.REGULAR_BOX, StorageKey.REGULAR_BOX_NUM);
        regularBox.setHighlightColor(Colors.DELUXE_QUALITY);
        regularBox.setNumSampler(regularBoxNS);
        regularBox.setSubItemSampler(rbSubItemSampler);
        advancedItemSampler.addModel(new SampleModel<>(regularBox, 2000));

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModel(new SampleModel<>(1888, 950));
        advancedCoinNS.addModel(new SampleModel<>(6666, 45));
        advancedCoinNS.addModel(new SampleModel<>(9999, 5));
        Item advancedCoin = new Item("金蘑菇", ItemType.CURRENCY, IconKey.ADVANCED_COIN, StorageKey.ADVANCED_COIN_NUM);
        advancedCoin.setHighlightColor(Colors.DELUXE_QUALITY);
        advancedCoin.setNumSampler(advancedCoinNS);
        advancedItemSampler.addModel(new SampleModel<>(advancedCoin, 10));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModel(new SampleModel<>(1, 900));
        advancedBoxNS.addModel(new SampleModel<>(2, 90));
        advancedBoxNS.addModel(new SampleModel<>(4, 10));
        Item advancedBox = new Item("全屏", ItemType.BOX, IconKey.ADVANCED_BOX, StorageKey.ADVANCED_BOX_NUM);
        advancedBox.setHighlightColor(Colors.ULTIMATE_QUALITY);
        advancedBox.setNumSampler(advancedBoxNS);
        advancedBox.setSubItemSampler(abSubItemSampler);
        advancedItemSampler.addModel(new SampleModel<>(advancedBox, 60));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModel(new SampleModel<>(1, 990));
        deluxeBoxNS.addModel(new SampleModel<>(2, 10));
        Item deluxeBox = new Item("辉煌", ItemType.BOX, IconKey.DELUXE_BOX, StorageKey.DELUXE_BOX_NUM);
        deluxeBox.setHighlightColor(Colors.ULTIMATE_QUALITY);
        deluxeBox.setNumSampler(deluxeBoxNS);
        deluxeBox.setSubItemSampler(dbSubItemSampler);
        advancedItemSampler.addModel(new SampleModel<>(deluxeBox, 8));

        Sampler<Integer> advancedGiftNS = new Sampler<>();
        advancedGiftNS.addModel(new SampleModel<>(1, 1));
        Item advancedGift = new Item("无暇天使", ItemType.GIFT, IconKey.ADVANCED_GIFT, StorageKey.ADVANCED_GIFT_NUM);
        advancedGift.setHighlightColor(Colors.ULTIMATE_QUALITY);
        advancedGift.setNumSampler(advancedGiftNS);
        advancedItemSampler.addModel(new SampleModel<>(advancedGift, 2));

        Sampler<Integer> advancedGift2NS = new Sampler<>();
        advancedGift2NS.addModel(new SampleModel<>(1, 990));
        advancedGift2NS.addModel(new SampleModel<>(2, 10));
        Item advancedGift2 = new Item("白炽龙裔", ItemType.GIFT, IconKey.ADVANCED_GIFT_2, StorageKey.ADVANCED_GIFT_2_NUM);
        advancedGift2.setHighlightColor(Colors.ULTIMATE_QUALITY);
        advancedGift2.setNumSampler(advancedGift2NS);
        advancedItemSampler.addModel(new SampleModel<>(advancedGift2, 4));

        Item deluxeGift3 = new Item("玫瑰跑车-青花瓷", ItemType.GIFT, IconKey.DELUXE_GIFT_3, StorageKey.DELUXE_GIFT_3_NUM);
        deluxeGift3.setHighlightColor(Colors.ULTIMATE_QUALITY);
        advancedItemSampler.addModel(new SampleModel<>(deluxeGift3, 2));
    }

    // 超级密藏物品
    private static void initDeluxeItemSampler() {
        deluxeItemSampler = new Sampler<>();

        Sampler<Integer> coinNS = new Sampler<>();
        coinNS.addModel(new SampleModel<>(199, 20));
        coinNS.addModel(new SampleModel<>(399, 200));
        coinNS.addModel(new SampleModel<>(699, 100));
        Item coin = new Item("币", ItemType.CURRENCY, IconKey.COIN, StorageKey.COIN_NUM);
        coin.setHighlightColor(Colors.DELUXE_QUALITY);
        coin.setNumSampler(coinNS);
        deluxeItemSampler.addModel(new SampleModel<>(coin, 2000));

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModel(new SampleModel<>(4, 200));
        regularBoxNS.addModel(new SampleModel<>(8, 100));
        Item regularBox = new Item("大盒子", ItemType.BOX, IconKey.REGULAR_BOX, StorageKey.REGULAR_BOX_NUM);
        regularBox.setHighlightColor(Colors.DELUXE_QUALITY);
        regularBox.setNumSampler(regularBoxNS);
        regularBox.setSubItemSampler(rbSubItemSampler);
        deluxeItemSampler.addModel(new SampleModel<>(regularBox, 2000));

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModel(new SampleModel<>(1888, 900));
        advancedCoinNS.addModel(new SampleModel<>(6666, 90));
        advancedCoinNS.addModel(new SampleModel<>(9999, 10));
        Item advancedCoin = new Item("金蘑菇", ItemType.CURRENCY, IconKey.ADVANCED_COIN, StorageKey.ADVANCED_COIN_NUM);
        advancedCoin.setHighlightColor(Colors.DELUXE_QUALITY);
        advancedCoin.setNumSampler(advancedCoinNS);
        deluxeItemSampler.addModel(new SampleModel<>(advancedCoin, 50));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModel(new SampleModel<>(1, 950));
        advancedBoxNS.addModel(new SampleModel<>(2, 45));
        advancedBoxNS.addModel(new SampleModel<>(4, 5));
        Item advancedBox = new Item("全屏", ItemType.BOX, IconKey.ADVANCED_BOX, StorageKey.ADVANCED_BOX_NUM);
        advancedBox.setHighlightColor(Colors.ULTIMATE_QUALITY);
        advancedBox.setNumSampler(advancedBoxNS);
        advancedBox.setSubItemSampler(abSubItemSampler);
        deluxeItemSampler.addModel(new SampleModel<>(advancedBox, 50));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModel(new SampleModel<>(1, 980));
        deluxeBoxNS.addModel(new SampleModel<>(2, 20));
        Item deluxeBox = new Item("辉煌", ItemType.BOX, IconKey.DELUXE_BOX, StorageKey.DELUXE_BOX_NUM);
        deluxeBox.setHighlightColor(Colors.ULTIMATE_QUALITY);
        deluxeBox.setNumSampler(deluxeBoxNS);
        deluxeBox.setSubItemSampler(dbSubItemSampler);
        deluxeItemSampler.addModel(new SampleModel<>(deluxeBox, 10));

        Sampler<Integer> advancedGiftNS = new Sampler<>();
        advancedGiftNS.addModel(new SampleModel<>(1, 1));
        Item advancedGift = new Item("无暇天使", ItemType.GIFT, IconKey.ADVANCED_GIFT, StorageKey.ADVANCED_GIFT_NUM);
        advancedGift.setHighlightColor(Colors.ULTIMATE_QUALITY);
        advancedGift.setNumSampler(advancedGiftNS);
        deluxeItemSampler.addModel(new SampleModel<>(advancedGift, 3));

        Sampler<Integer> advancedGift2NS = new Sampler<>();
        advancedGift2NS.addModel(new SampleModel<>(1, 980));
        advancedGift2NS.addModel(new SampleModel<>(2, 20));
        Item advancedGift2 = new Item("白炽龙裔", ItemType.GIFT, IconKey.ADVANCED_GIFT_2, StorageKey.ADVANCED_GIFT_2_NUM);
        advancedGift2.setHighlightColor(Colors.ULTIMATE_QUALITY);
        advancedGift2.setNumSampler(advancedGift2NS);
        deluxeItemSampler.addModel(new SampleModel<>(advancedGift2, 6));

        Item deluxeGift3 = new Item("玫瑰跑车-青花瓷", ItemType.GIFT, IconKey.DELUXE_GIFT_3, StorageKey.DELUXE_GIFT_3_NUM);
        deluxeGift3.setHighlightColor(Colors.ULTIMATE_QUALITY);
        deluxeItemSampler.addModel(new SampleModel<>(deluxeGift3, 1));
    }

    // 究级密藏物品
    private static void initUltimateItemSampler() {
        ultimateItemSampler = new Sampler<>();

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModel(new SampleModel<>(30, 60));
        regularBoxNS.addModel(new SampleModel<>(50, 100));
        regularBoxNS.addModel(new SampleModel<>(80, 40));
        Item regularBox = new Item("大盒子", ItemType.BOX, IconKey.REGULAR_BOX, StorageKey.REGULAR_BOX_NUM);
        regularBox.setHighlightColor(Colors.DELUXE_QUALITY);
        regularBox.setNumSampler(regularBoxNS);
        regularBox.setSubItemSampler(rbSubItemSampler);
        ultimateItemSampler.addModel(new SampleModel<>(regularBox, 2000));

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModel(new SampleModel<>(9999, 950));
        advancedCoinNS.addModel(new SampleModel<>(99999, 50));
        Item advancedCoin = new Item("金蘑菇", ItemType.CURRENCY, IconKey.ADVANCED_COIN, StorageKey.ADVANCED_COIN_NUM);
        advancedCoin.setHighlightColor(Colors.DELUXE_QUALITY);
        advancedCoin.setNumSampler(advancedCoinNS);
        ultimateItemSampler.addModel(new SampleModel<>(advancedCoin, 2000));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModel(new SampleModel<>(3, 200));
        advancedBoxNS.addModel(new SampleModel<>(5, 500));
        advancedBoxNS.addModel(new SampleModel<>(8, 150));
        advancedBoxNS.addModel(new SampleModel<>(10, 100));
        Item advancedBox = new Item("全屏", ItemType.BOX, IconKey.ADVANCED_BOX, StorageKey.ADVANCED_BOX_NUM);
        advancedBox.setHighlightColor(Colors.ULTIMATE_QUALITY);
        advancedBox.setNumSampler(advancedBoxNS);
        advancedBox.setSubItemSampler(abSubItemSampler);
        ultimateItemSampler.addModel(new SampleModel<>(advancedBox, 2000));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModel(new SampleModel<>(1, 100));
        deluxeBoxNS.addModel(new SampleModel<>(2, 500));
        deluxeBoxNS.addModel(new SampleModel<>(3, 300));
        Item deluxeBox = new Item("辉煌", ItemType.BOX, IconKey.DELUXE_BOX, StorageKey.DELUXE_BOX_NUM);
        deluxeBox.setHighlightColor(Colors.ULTIMATE_QUALITY);
        deluxeBox.setNumSampler(deluxeBoxNS);
        deluxeBox.setSubItemSampler(dbSubItemSampler);
        ultimateItemSampler.addModel(new SampleModel<>(deluxeBox, 200));

        Sampler<Integer> advancedGiftNS = new Sampler<>();
        advancedGiftNS.addModel(new SampleModel<>(1, 999));
        advancedGiftNS.addModel(new SampleModel<>(2, 1));
        Item advancedGift = new Item("无暇天使", ItemType.GIFT, IconKey.ADVANCED_GIFT, StorageKey.ADVANCED_GIFT_NUM);
        advancedGift.setHighlightColor(Colors.ULTIMATE_QUALITY);
        advancedGift.setNumSampler(advancedGiftNS);
        ultimateItemSampler.addModel(new SampleModel<>(advancedGift, 1000));

        Sampler<Integer> advancedGift2NS = new Sampler<>();
        advancedGift2NS.addModel(new SampleModel<>(1, 500));
        advancedGift2NS.addModel(new SampleModel<>(2, 100));
        advancedGift2NS.addModel(new SampleModel<>(3, 10));
        Item advancedGift2 = new Item("白炽龙裔", ItemType.GIFT, IconKey.ADVANCED_GIFT_2, StorageKey.ADVANCED_GIFT_2_NUM);
        advancedGift2.setHighlightColor(Colors.ULTIMATE_QUALITY);
        advancedGift2.setNumSampler(advancedGift2NS);
        ultimateItemSampler.addModel(new SampleModel<>(advancedGift2, 2000));

        Item deluxeGift3 = new Item("玫瑰跑车-青花瓷", ItemType.GIFT, IconKey.DELUXE_GIFT_3, StorageKey.DELUXE_GIFT_3_NUM);
        deluxeGift3.setHighlightColor(Colors.ULTIMATE_QUALITY);
        ultimateItemSampler.addModel(new SampleModel<>(deluxeGift3, 500));

        Item ultimateGift = new Item("起源·应龙", ItemType.GIFT, IconKey.ULTIMATE_GIFT, StorageKey.ULTIMATE_GIFT_NUM);
        ultimateGift.setHighlightColor(Colors.ULTIMATE_QUALITY);
        ultimateItemSampler.addModel(new SampleModel<>(ultimateGift, 50));
    }

    // 蘑菇金库物品
    private static void initMRItemSampler() {
        mrItemSampler = new Sampler<>();

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModelsLinearWeights(ListUtil.ofRange(168, 398), 2000, 100);
        advancedCoinNS.addModel(new SampleModel<>(1888, 150));
        advancedCoinNS.addModel(new SampleModel<>(6666, 80));
        advancedCoinNS.addModel(new SampleModel<>(9999, 30));
        advancedCoinNS.addModel(new SampleModel<>(99999, 5));
        Item advancedCoin = new Item("金蘑菇", ItemType.CURRENCY, IconKey.ADVANCED_COIN, StorageKey.ADVANCED_COIN_NUM);
        advancedCoin.setHighlightColor(Colors.DELUXE_QUALITY);
        advancedCoin.setNumSampler(advancedCoinNS);
        mrItemSampler.addModel(new SampleModel<>(advancedCoin, 2000));
    }

    // 竞猜物品
    private static void initQuizItemSampler() {
        quizItemSampler = new Sampler<>();

        for (Item item : items) {
            if (item.isGuessable()) quizItemSampler.addModel(new SampleModel<>(item, 200));
        }
    }

    private static void initBBSubItemSampler() {
        bbSubItemSampler = new Sampler<>();

        Item bb1Gift = new Item("爱心飞艇", ItemType.GIFT, IconKey.RB1_GIFT, null);
        bb1Gift.setValue(10000);
        bb1Gift.setGiftPoints(1600);
        bbSubItemSampler.addModel(new SampleModel<>(bb1Gift, 50));

        Item bb2Gift = new Item("爱心电话亭", ItemType.GIFT, IconKey.RB2_GIFT, null);
        bb2Gift.setValue(10000);
        bb2Gift.setGiftPoints(1600);
        bbSubItemSampler.addModel(new SampleModel<>(bb2Gift, 50));

        Item bb3Gift = new Item("爱心魔法棒", ItemType.GIFT, IconKey.RB3_GIFT, null);
        bb3Gift.setValue(10000);
        bb3Gift.setGiftPoints(1600);
        bbSubItemSampler.addModel(new SampleModel<>(bb3Gift, 50));

        Item bb4Gift = new Item("胡萝卜软糖", ItemType.GIFT, IconKey.BB4_GIFT, null);
        bb4Gift.setValue(400);
        bb4Gift.setGiftPoints(64);
        bb4Gift.setBoxRegular(true);
        bbSubItemSampler.addModel(new SampleModel<>(bb4Gift, 3000));

        Item bb5Gift = new Item("爱心信号枪", ItemType.GIFT, IconKey.BB5_GIFT, null);
        bb5Gift.setValue(400);
        bb5Gift.setGiftPoints(64);
        bb5Gift.setBoxRegular(true);
        bbSubItemSampler.addModel(new SampleModel<>(bb5Gift, 3000));

        Item bb6Gift = new Item("甜蜜小熊", ItemType.GIFT, IconKey.BB6_GIFT, null);
        bb6Gift.setValue(1000);
        bb6Gift.setGiftPoints(160);
        bb6Gift.setBoxRegular(true);
        bbSubItemSampler.addModel(new SampleModel<>(bb6Gift, 3000));

        Item bb7Gift = new Item("星愿熊熊", ItemType.GIFT, IconKey.BB7_GIFT, null);
        bb7Gift.setValue(1000);
        bb7Gift.setGiftPoints(160);
        bb7Gift.setBoxRegular(true);
        bbSubItemSampler.addModel(new SampleModel<>(bb7Gift, 3000));

        Item bb8Gift = new Item("玫瑰小熊", ItemType.GIFT, IconKey.BB8_GIFT, null);
        bb8Gift.setValue(2000);
        bb8Gift.setGiftPoints(320);
        bbSubItemSampler.addModel(new SampleModel<>(bb8Gift, 300));

        Item bb9Gift = new Item("樱花伞", ItemType.GIFT, IconKey.BB9_GIFT, null);
        bb9Gift.setValue(4000);
        bb9Gift.setGiftPoints(640);
        bbSubItemSampler.addModel(new SampleModel<>(bb9Gift, 150));

        Item bb10Gift = new Item("理想国", ItemType.GIFT, IconKey.RB8_GIFT, null);
        bb10Gift.setValue(100000);
        bb10Gift.setGiftPoints(16000);
        bbSubItemSampler.addModel(new SampleModel<>(bb10Gift, 1));
    }

    private static void initRBSubItemSampler() {
        rbSubItemSampler = new Sampler<>();

        Item rb1Gift = new Item("爱心飞艇", ItemType.GIFT, IconKey.RB1_GIFT, null);
        rb1Gift.setValue(10000);
        rb1Gift.setGiftPoints(1600);
        rb1Gift.setBoxRegular(true);
        rbSubItemSampler.addModel(new SampleModel<>(rb1Gift, 3000));

        Item rb2Gift = new Item("爱心电话亭", ItemType.GIFT, IconKey.RB2_GIFT, null);
        rb2Gift.setValue(10000);
        rb2Gift.setGiftPoints(1600);
        rb2Gift.setBoxRegular(true);
        rbSubItemSampler.addModel(new SampleModel<>(rb2Gift, 3000));

        Item rb3Gift = new Item("爱心魔法棒", ItemType.GIFT, IconKey.RB3_GIFT, null);
        rb3Gift.setValue(10000);
        rb3Gift.setGiftPoints(1600);
        rb3Gift.setBoxRegular(true);
        rbSubItemSampler.addModel(new SampleModel<>(rb3Gift, 3000));

        Item rb4Gift = new Item("金丝雀爱巢", ItemType.GIFT, IconKey.RB4_GIFT, null);
        rb4Gift.setValue(10000);
        rb4Gift.setGiftPoints(1600);
        rbSubItemSampler.addModel(new SampleModel<>(rb4Gift, 500));

        Item rb5Gift = new Item("游艇", ItemType.GIFT, IconKey.RB5_GIFT, null);
        rb5Gift.setValue(20000);
        rb5Gift.setGiftPoints(3200);
        rbSubItemSampler.addModel(new SampleModel<>(rb5Gift, 300));

        Item rb6Gift = new Item("钻石手表", ItemType.GIFT, IconKey.RB6_GIFT, null);
        rb6Gift.setValue(30000);
        rb6Gift.setGiftPoints(3200);
        rbSubItemSampler.addModel(new SampleModel<>(rb6Gift, 300));

        Item rb7Gift = new Item("水晶竖琴", ItemType.GIFT, IconKey.RB7_GIFT, null);
        rb7Gift.setValue(30000);
        rb7Gift.setGiftPoints(4800);
        rbSubItemSampler.addModel(new SampleModel<>(rb7Gift, 200));

        Item rb8Gift = new Item("理想国", ItemType.GIFT, IconKey.RB8_GIFT, null);
        rb8Gift.setValue(100000);
        rb8Gift.setGiftPoints(16000);
        rbSubItemSampler.addModel(new SampleModel<>(rb8Gift, 180));
    }

    private static void initABSubItemSampler() {
        abSubItemSampler = new Sampler<>();

        Item ab1Gift = new Item("陪你去看流星雨", ItemType.GIFT, IconKey.AB1_GIFT, null);
        ab1Gift.setValue(100000);
        ab1Gift.setGiftPoints(16000);
        ab1Gift.setBoxRegular(true);
        abSubItemSampler.addModel(new SampleModel<>(ab1Gift, 3000));

        Item ab2Gift = new Item("倾城绝恋", ItemType.GIFT, IconKey.AB2_GIFT, null);
        ab2Gift.setValue(100000);
        ab2Gift.setGiftPoints(30000);
        ab2Gift.setBoxRegular(true);
        abSubItemSampler.addModel(new SampleModel<>(ab2Gift, 2700));

        Item ab3Gift = new Item("倾世一诺", ItemType.GIFT, IconKey.AB3_GIFT, null);
        ab3Gift.setValue(100000);
        ab3Gift.setGiftPoints(16000);
        ab3Gift.setBoxRegular(true);
        abSubItemSampler.addModel(new SampleModel<>(ab3Gift, 3000));

        Item ab4Gift = new Item("理想国", ItemType.GIFT, IconKey.RB8_GIFT, null);
        ab4Gift.setValue(100000);
        ab4Gift.setGiftPoints(16000);
        abSubItemSampler.addModel(new SampleModel<>(ab4Gift, 500));

        Item ab5Gift = new Item("战争女王", ItemType.GIFT, IconKey.AB5_GIFT, null);
        ab5Gift.setValue(300000);
        ab5Gift.setGiftPoints(48000);
        abSubItemSampler.addModel(new SampleModel<>(ab5Gift, 50));

        Item ab6Gift = new Item("招福舞狮", ItemType.GIFT, IconKey.AB6_GIFT, null);
        ab6Gift.setValue(50000);
        ab6Gift.setGiftPoints(8000);
        abSubItemSampler.addModel(new SampleModel<>(ab6Gift, 500));
    }

    private static void initDBSubItemSampler() {
        dbSubItemSampler = new Sampler<>();

        Item db1Gift = new Item("命乾无极", ItemType.GIFT, IconKey.DB1_GIFT, null);
        db1Gift.setValue(500000);
        db1Gift.setGiftPoints(80000);
        dbSubItemSampler.addModel(new SampleModel<>(db1Gift, 200));

        Item db2Gift = new Item("嘉年星港", ItemType.GIFT, IconKey.DB2_GIFT, null);
        db2Gift.setValue(300000);
        db2Gift.setGiftPoints(48000);
        db2Gift.setBoxRegular(true);
        dbSubItemSampler.addModel(new SampleModel<>(db2Gift, 3000));

        Item db3Gift = new Item("战争女王", ItemType.GIFT, IconKey.AB5_GIFT, null);
        db3Gift.setValue(300000);
        db3Gift.setGiftPoints(48000);
        dbSubItemSampler.addModel(new SampleModel<>(db3Gift, 1000));

        Item db4Gift = new Item("锦绣山河", ItemType.GIFT, IconKey.DB4_GIFT, null);
        db4Gift.setValue(300000);
        db4Gift.setGiftPoints(48000);
        db4Gift.setBoxRegular(true);
        dbSubItemSampler.addModel(new SampleModel<>(db4Gift, 3000));

        Item db5Gift = new Item("魔灵古堡", ItemType.GIFT, IconKey.DB5_GIFT, null);
        db5Gift.setValue(188888);
        db5Gift.setGiftPoints(30000);
        dbSubItemSampler.addModel(new SampleModel<>(db5Gift, 1000));
    }
}

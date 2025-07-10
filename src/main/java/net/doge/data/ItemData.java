package net.doge.data;

import net.doge.constant.IconKey;
import net.doge.constant.ItemType;
import net.doge.constant.StorageKey;
import net.doge.model.Item;
import net.doge.model.SampleModel;
import net.doge.model.Sampler;
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
    public static Sampler<Item> advancedTower2ItemSampler = new Sampler<>();
    // 金塔物品生成器
    public static Sampler<Item> deluxeTowerItemSampler = new Sampler<>();
    // 中级密藏物品生成器
    public static Sampler<Item> regularTreasureItemSampler = new Sampler<>();
    public static Sampler<Item> regularTreasure2ItemSampler = new Sampler<>();
    // 高级密藏物品生成器
    public static Sampler<Item> advancedTreasureItemSampler = new Sampler<>();
    public static Sampler<Item> advancedTreasure2ItemSampler = new Sampler<>();
    // 超级密藏物品生成器
    public static Sampler<Item> deluxeTreasureItemSampler = new Sampler<>();
    public static Sampler<Item> deluxeTreasure2ItemSampler = new Sampler<>();
    // 究级密藏物品生成器
    public static Sampler<Item> ultimateTreasureItemSampler = new Sampler<>();
    public static Sampler<Item> ultimateTreasure2ItemSampler = new Sampler<>();
    // 蘑菇金库物品生成器
    public static Sampler<Item> mrTreasureItemSampler = new Sampler<>();

    // 小盒子子物品生成器
    private static Sampler<Item> bbSubItemSampler = new Sampler<>();
    private static Sampler<Item> bb2SubItemSampler = new Sampler<>();
    // 大盒子子物品生成器
    private static Sampler<Item> rbSubItemSampler = new Sampler<>();
    private static Sampler<Item> rb2SubItemSampler = new Sampler<>();
    // 全屏子物品生成器
    private static Sampler<Item> abSubItemSampler = new Sampler<>();
    private static Sampler<Item> ab2SubItemSampler = new Sampler<>();
    // 辉煌子物品生成器
    private static Sampler<Item> dbSubItemSampler = new Sampler<>();
    private static Sampler<Item> db2SubItemSampler = new Sampler<>();

    // 物品列表
    public static List<Item> items = new LinkedList<>();

    // 碎片
    public static Item BASIC_SHARD;
    public static Item COMMON_SHARD;
    public static Item REGULAR_SHARD;
    public static Item ADVANCED_SHARD;
    // 币
    public static Item COIN;
    // 30 礼物
    public static Item BASIC_GIFT;
    public static Item BASIC_GIFT_2;
    // 300 礼物
    public static Item REGULAR_GIFT;
    public static Item REGULAR_GIFT_21;
    // 10k 小件
    public static Item REGULAR_GIFT_2;
    // 赠送金蘑菇
    public static Item REGULAR_COIN;
    // 雕像
    public static Item STATUE;
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
    public static Item BASIC_BOX_2;
    // 大盒子
    public static Item REGULAR_BOX;
    public static Item REGULAR_BOX_2;
    // 全屏
    public static Item ADVANCED_BOX;
    public static Item ADVANCED_BOX_2;
    // 辉煌
    public static Item DELUXE_BOX;
    public static Item DELUXE_BOX_2;
    // 大件
    public static Item ADVANCED_GIFT;
    public static Item ADVANCED_GIFT_21;
    public static Item ADVANCED_GIFT_2;
    public static Item ADVANCED_GIFT_22;
    // 情定爱琴海
    public static Item DELUXE_GIFT;
    // 爱之天使号
    public static Item DELUXE_GIFT_2;
    // 青花瓷跑车
    public static Item DELUXE_GIFT_3;
    // 玫瑰跑车
    public static Item DELUXE_GIFT_4;
    // 玫瑰跑车-神龙
    public static Item DELUXE_GIFT_5;
    // 玫瑰跑车-银河
    public static Item DELUXE_GIFT_6;
    // 起源·应龙
    public static Item ULTIMATE_GIFT;
    // 起源·黑洞
    public static Item ULTIMATE_GIFT_2;
    // 兑换券
    public static Item TICKET;
    // 皮肤
    public static Item SKIN1;
    public static Item SKIN2;
    public static Item SKIN3;
    public static Item SKIN4;

    // 小盒子子物品
    public static Item BB4_GIFT;
    public static Item BB5_GIFT;
    public static Item BB6_GIFT;
    public static Item BB7_GIFT;
    public static Item BB8_GIFT;
    public static Item BB9_GIFT;
    // 大盒子子物品
    public static Item RB1_GIFT;
    public static Item RB2_GIFT;
    public static Item RB3_GIFT;
    public static Item RB4_GIFT;
    public static Item RB5_GIFT;
    public static Item RB6_GIFT;
    public static Item RB7_GIFT;
    public static Item RB8_GIFT;
    public static Item RB21_GIFT;
    public static Item RB22_GIFT;
    public static Item RB23_GIFT;
    public static Item RB24_GIFT;
    public static Item RB25_GIFT;
    public static Item RB26_GIFT;
    public static Item RB27_GIFT;
    public static Item RB28_GIFT;
    public static Item RB29_GIFT;
    public static Item RB210_GIFT;
    // 全屏子物品
    public static Item AB1_GIFT;
    public static Item AB2_GIFT;
    public static Item AB3_GIFT;
    public static Item AB5_GIFT;
    public static Item AB6_GIFT;
    public static Item AB25_GIFT;
    public static Item AB26_GIFT;
    public static Item AB27_GIFT;
    public static Item AB28_GIFT;
    // 辉煌子物品
    public static Item DB1_GIFT;
    public static Item DB2_GIFT;
    public static Item DB4_GIFT;
    public static Item DB5_GIFT;
    public static Item DB22_GIFT;

    static {
        initData();
    }

    private static void initData() {
        initItem();
        initBoxSubItem();

        initAdvancedTowerItemSampler();
        initDeluxeTowerItemSampler();
        initRegularTowerItemSampler();
        initBasicTowerItemSampler();

        initRegularTreasureItemSampler();
        initAdvancedTreasureItemSampler();
        initDeluxeTreasureItemSampler();
        initUltimateTreasureItemSampler();
        initMRTreasureItemSampler();

        initBBSubItemSampler();
        initBB2SubItemSampler();
        initRBSubItemSampler();
        initRB2SubItemSampler();
        initABSubItemSampler();
        initAB2SubItemSampler();
        initDBSubItemSampler();
        initDB2SubItemSampler();
    }

    // 所有物品
    private static void initItem() {
        BASIC_SHARD = new Item("引航碎片", ItemType.CURRENCY, IconKey.BASIC_SHARD, StorageKey.BASIC_SHARD_NUM);
        BASIC_SHARD.setHighlightColor(GColor.BASIC_QUALITY);
        items.add(BASIC_SHARD);

        COMMON_SHARD = new Item("神圣星核", ItemType.CURRENCY, IconKey.COMMON_SHARD, StorageKey.COMMON_SHARD_NUM);
        COMMON_SHARD.setHighlightColor(GColor.BASIC_QUALITY);
        items.add(COMMON_SHARD);

        REGULAR_SHARD = new Item("星门碎片", ItemType.CURRENCY, IconKey.REGULAR_SHARD, StorageKey.REGULAR_SHARD_NUM);
        REGULAR_SHARD.setHighlightColor(GColor.BASIC_QUALITY);
        items.add(REGULAR_SHARD);

        ADVANCED_SHARD = new Item("圣殿碎片", ItemType.CURRENCY, IconKey.ADVANCED_SHARD, StorageKey.ADVANCED_SHARD_NUM);
        ADVANCED_SHARD.setHighlightColor(GColor.BASIC_QUALITY);
        items.add(ADVANCED_SHARD);

        BASIC_STEP = new Item("一塔牌子", ItemType.CURRENCY, IconKey.BASIC_STEP, StorageKey.BASIC_STEP_NUM);
        BASIC_STEP.setIconThumbKey(IconKey.BASIC_STEP_THUMB);
        BASIC_STEP.setHighlightColor(GColor.BASIC_QUALITY);
        BASIC_STEP.setPreferential(true);
        items.add(BASIC_STEP);

        COIN = new Item("金币", ItemType.CURRENCY, IconKey.COIN, StorageKey.COIN_NUM);
        COIN.setIconThumbKey(IconKey.COIN_THUMB);
        COIN.setHighlightColor(GColor.REGULAR_QUALITY);
        COIN.setValue(66);
        COIN.setGuessable(true);
        items.add(COIN);

        BASIC_GIFT = new Item("小情书", ItemType.GIFT, IconKey.BASIC_GIFT, StorageKey.BASIC_GIFT_NUM);
        BASIC_GIFT.setHighlightColor(GColor.BASIC_QUALITY);
        BASIC_GIFT.setValue(30);
        BASIC_GIFT.setExchangeable(true);
        BASIC_GIFT.setExchangeCost(1);
        BASIC_GIFT.setGuessable(true);
        items.add(BASIC_GIFT);

        BASIC_GIFT_2 = new Item("虹猫玩偶", ItemType.GIFT, IconKey.BASIC_GIFT_2, StorageKey.BASIC_GIFT_2_NUM);
        BASIC_GIFT_2.setHighlightColor(GColor.BASIC_QUALITY);
        BASIC_GIFT_2.setValue(30);
        BASIC_GIFT_2.setExchangeable(true);
        BASIC_GIFT_2.setExchangeCost(1);
        BASIC_GIFT_2.setGuessable(true);
        items.add(BASIC_GIFT_2);

        REGULAR_GIFT = new Item("送花小狗", ItemType.GIFT, IconKey.REGULAR_GIFT, StorageKey.REGULAR_GIFT_NUM);
        REGULAR_GIFT.setHighlightColor(GColor.BASIC_QUALITY);
        REGULAR_GIFT.setValue(300);
        REGULAR_GIFT.setGiftPoints(48);
        REGULAR_GIFT.setExchangeable(true);
        REGULAR_GIFT.setExchangeCost(5);
        REGULAR_GIFT.setGuessable(true);
        items.add(REGULAR_GIFT);

        REGULAR_GIFT_21 = new Item("麒麟", ItemType.GIFT, IconKey.REGULAR_GIFT_21, StorageKey.REGULAR_GIFT_21_NUM);
        REGULAR_GIFT_21.setHighlightColor(GColor.BASIC_QUALITY);
        REGULAR_GIFT_21.setValue(300);
        REGULAR_GIFT_21.setGiftPoints(48);
        REGULAR_GIFT_21.setExchangeable(true);
        REGULAR_GIFT_21.setExchangeCost(5);
        REGULAR_GIFT_21.setGuessable(true);
        items.add(REGULAR_GIFT_21);

        REGULAR_COIN = new Item("赠送金蘑菇", ItemType.CURRENCY, IconKey.REGULAR_COIN, StorageKey.REGULAR_COIN_NUM);
        REGULAR_COIN.setIconThumbKey(IconKey.REGULAR_COIN_THUMB);
        REGULAR_COIN.setHighlightColor(GColor.BASIC_QUALITY);
        REGULAR_COIN.setGuessable(true);
        items.add(REGULAR_COIN);

        STATUE = new Item("初代塔坦王雕像", ItemType.CURRENCY, IconKey.STATUE, StorageKey.STATUE_NUM);
        STATUE.setHighlightColor(GColor.ADVANCED_QUALITY);
        STATUE.setGuessable(true);
        items.add(STATUE);

        REGULAR_GIFT_2 = new Item("居士汪", ItemType.GIFT, IconKey.REGULAR_GIFT_2, StorageKey.REGULAR_GIFT_2_NUM);
        REGULAR_GIFT_2.setHighlightColor(GColor.DELUXE_QUALITY);
        REGULAR_GIFT_2.setValue(10000);
        REGULAR_GIFT_2.setGiftPoints(1600);
        REGULAR_GIFT_2.setExchangeable(true);
        REGULAR_GIFT_2.setExchangeCost(100);
        items.add(REGULAR_GIFT_2);

        REGULAR_STEP = new Item("二塔牌子", ItemType.CURRENCY, IconKey.REGULAR_STEP, StorageKey.REGULAR_STEP_NUM);
        REGULAR_STEP.setIconThumbKey(IconKey.REGULAR_STEP_THUMB);
        REGULAR_STEP.setHighlightColor(GColor.REGULAR_QUALITY);
        REGULAR_STEP.setGuessable(true);
        items.add(REGULAR_STEP);

        ADVANCED_STEP = new Item("三塔牌子", ItemType.CURRENCY, IconKey.ADVANCED_STEP, StorageKey.ADVANCED_STEP_NUM);
        ADVANCED_STEP.setIconThumbKey(IconKey.ADVANCED_STEP_THUMB);
        ADVANCED_STEP.setHighlightColor(GColor.ADVANCED_QUALITY);
        ADVANCED_STEP.setGuessable(true);
        ADVANCED_STEP.setPreferential(true);
        items.add(ADVANCED_STEP);

        DELUXE_STEP = new Item("金塔牌子", ItemType.CURRENCY, IconKey.DELUXE_STEP, StorageKey.DELUXE_STEP_NUM);
        DELUXE_STEP.setIconThumbKey(IconKey.DELUXE_STEP_THUMB);
        DELUXE_STEP.setHighlightColor(GColor.DELUXE_QUALITY);
        DELUXE_STEP.setPreferential(true);
        items.add(DELUXE_STEP);

        ADVANCED_COIN = new Item("金蘑菇", ItemType.CURRENCY, IconKey.ADVANCED_COIN, StorageKey.ADVANCED_COIN_NUM);
        ADVANCED_COIN.setIconThumbKey(IconKey.ADVANCED_COIN_THUMB);
        ADVANCED_COIN.setHighlightColor(GColor.DELUXE_QUALITY);
        ADVANCED_COIN.setPreferential(true);
        items.add(ADVANCED_COIN);

        BASIC_BOX = new Item("木兰小盒子", ItemType.BOX, IconKey.BASIC_BOX, StorageKey.BASIC_BOX_NUM);
        BASIC_BOX.setHighlightColor(GColor.REGULAR_QUALITY);
        BASIC_BOX.setValue(1000);
        BASIC_BOX.setExchangeable(true);
        BASIC_BOX.setExchangeCost(15);
        BASIC_BOX.setGuessable(true);
        BASIC_BOX.setGiftExp(20);
        BASIC_BOX.setSubItemSampler(bbSubItemSampler);
        items.add(BASIC_BOX);

        BASIC_BOX_2 = new Item("宏梦小盒子", ItemType.BOX, IconKey.BASIC_BOX_2, StorageKey.BASIC_BOX_2_NUM);
        BASIC_BOX_2.setHighlightColor(GColor.REGULAR_QUALITY);
        BASIC_BOX_2.setValue(1000);
        BASIC_BOX_2.setExchangeable(true);
        BASIC_BOX_2.setExchangeCost(15);
        BASIC_BOX_2.setGuessable(true);
        BASIC_BOX_2.setGiftExp(20);
        BASIC_BOX_2.setSubItemSampler(bb2SubItemSampler);
        items.add(BASIC_BOX_2);

        REGULAR_BOX = new Item("木兰大盒子", ItemType.BOX, IconKey.REGULAR_BOX, StorageKey.REGULAR_BOX_NUM);
        REGULAR_BOX.setHighlightColor(GColor.DELUXE_QUALITY);
        REGULAR_BOX.setValue(10000);
        REGULAR_BOX.setExchangeable(true);
        REGULAR_BOX.setExchangeCost(120);
        REGULAR_BOX.setGuessable(true);
        REGULAR_BOX.setGiftExp(150);
        REGULAR_BOX.setPreferential(true);
        REGULAR_BOX.setSubItemSampler(rbSubItemSampler);
        items.add(REGULAR_BOX);

        REGULAR_BOX_2 = new Item("宏梦大盒子", ItemType.BOX, IconKey.REGULAR_BOX_2, StorageKey.REGULAR_BOX_2_NUM);
        REGULAR_BOX_2.setHighlightColor(GColor.DELUXE_QUALITY);
        REGULAR_BOX_2.setValue(10000);
        REGULAR_BOX_2.setExchangeable(true);
        REGULAR_BOX_2.setExchangeCost(120);
        REGULAR_BOX_2.setGuessable(true);
        REGULAR_BOX_2.setGiftExp(150);
        REGULAR_BOX_2.setPreferential(true);
        REGULAR_BOX_2.setSubItemSampler(rb2SubItemSampler);
        items.add(REGULAR_BOX_2);

        ADVANCED_BOX = new Item("木兰全屏", ItemType.BOX, IconKey.ADVANCED_BOX, StorageKey.ADVANCED_BOX_NUM);
        ADVANCED_BOX.setHighlightColor(GColor.ULTIMATE_QUALITY);
        ADVANCED_BOX.setValue(100000);
        ADVANCED_BOX.setExchangeable(true);
        ADVANCED_BOX.setExchangeCost(1500);
        ADVANCED_BOX.setGuessable(true);
        ADVANCED_BOX.setGiftExp(1500);
        ADVANCED_BOX.setPreferential(true);
        ADVANCED_BOX.setSubItemSampler(abSubItemSampler);
        items.add(ADVANCED_BOX);

        ADVANCED_BOX_2 = new Item("宏梦全屏", ItemType.BOX, IconKey.ADVANCED_BOX_2, StorageKey.ADVANCED_BOX_2_NUM);
        ADVANCED_BOX_2.setHighlightColor(GColor.ULTIMATE_QUALITY);
        ADVANCED_BOX_2.setValue(100000);
        ADVANCED_BOX_2.setExchangeable(true);
        ADVANCED_BOX_2.setExchangeCost(1500);
        ADVANCED_BOX_2.setGuessable(true);
        ADVANCED_BOX_2.setGiftExp(1500);
        ADVANCED_BOX_2.setPreferential(true);
        ADVANCED_BOX_2.setSubItemSampler(ab2SubItemSampler);
        items.add(ADVANCED_BOX_2);

        DELUXE_BOX = new Item("木兰辉煌", ItemType.BOX, IconKey.DELUXE_BOX, StorageKey.DELUXE_BOX_NUM);
        DELUXE_BOX.setHighlightColor(GColor.ULTIMATE_QUALITY);
        DELUXE_BOX.setValue(300000);
        DELUXE_BOX.setPreferential(true);
        DELUXE_BOX.setSubItemSampler(dbSubItemSampler);
        items.add(DELUXE_BOX);

        DELUXE_BOX_2 = new Item("宏梦辉煌", ItemType.BOX, IconKey.DELUXE_BOX_2, StorageKey.DELUXE_BOX_2_NUM);
        DELUXE_BOX_2.setHighlightColor(GColor.ULTIMATE_QUALITY);
        DELUXE_BOX_2.setValue(300000);
        DELUXE_BOX_2.setPreferential(true);
        DELUXE_BOX_2.setSubItemSampler(db2SubItemSampler);
        items.add(DELUXE_BOX_2);

        ADVANCED_GIFT = new Item("无暇天使", ItemType.GIFT, IconKey.ADVANCED_GIFT, StorageKey.ADVANCED_GIFT_NUM);
        ADVANCED_GIFT.setValue(1000000);
        ADVANCED_GIFT.setGiftPoints(160000);
        ADVANCED_GIFT.setHighlightColor(GColor.ULTIMATE_QUALITY);
        ADVANCED_GIFT.setPreferential(true);
        items.add(ADVANCED_GIFT);

        ADVANCED_GIFT_21 = new Item("天地为笼", ItemType.GIFT, IconKey.ADVANCED_GIFT_21, StorageKey.ADVANCED_GIFT_21_NUM);
        ADVANCED_GIFT_21.setValue(1000000);
        ADVANCED_GIFT_21.setGiftPoints(160000);
        ADVANCED_GIFT_21.setHighlightColor(GColor.ULTIMATE_QUALITY);
        ADVANCED_GIFT_21.setPreferential(true);
        items.add(ADVANCED_GIFT_21);

        ADVANCED_GIFT_2 = new Item("白炽龙裔", ItemType.GIFT, IconKey.ADVANCED_GIFT_2, StorageKey.ADVANCED_GIFT_2_NUM);
        ADVANCED_GIFT_2.setHighlightColor(GColor.ULTIMATE_QUALITY);
        ADVANCED_GIFT_2.setValue(500000);
        ADVANCED_GIFT_2.setGiftPoints(80000);
        ADVANCED_GIFT_2.setPreferential(true);
        items.add(ADVANCED_GIFT_2);

        ADVANCED_GIFT_22 = new Item("伞下遨游", ItemType.GIFT, IconKey.ADVANCED_GIFT_22, StorageKey.ADVANCED_GIFT_22_NUM);
        ADVANCED_GIFT_22.setHighlightColor(GColor.ULTIMATE_QUALITY);
        ADVANCED_GIFT_22.setValue(500000);
        ADVANCED_GIFT_22.setGiftPoints(80000);
        ADVANCED_GIFT_22.setPreferential(true);
        items.add(ADVANCED_GIFT_22);

        DELUXE_GIFT = new Item("情定爱琴海", ItemType.GIFT, IconKey.DELUXE_GIFT, StorageKey.DELUXE_GIFT_NUM);
        DELUXE_GIFT.setHighlightColor(GColor.ULTIMATE_QUALITY);
        DELUXE_GIFT.setValue(1888888);
        DELUXE_GIFT.setGiftPoints(666666);
        DELUXE_GIFT.setPreferential(true);
        items.add(DELUXE_GIFT);

        DELUXE_GIFT_2 = new Item("爱之天使号", ItemType.GIFT, IconKey.DELUXE_GIFT_2, StorageKey.DELUXE_GIFT_2_NUM);
        DELUXE_GIFT_2.setHighlightColor(GColor.ULTIMATE_QUALITY);
        DELUXE_GIFT_2.setValue(1888888);
        DELUXE_GIFT_2.setGiftPoints(566666);
        DELUXE_GIFT_2.setPreferential(true);
        items.add(DELUXE_GIFT_2);

        DELUXE_GIFT_3 = new Item("玫瑰跑车-青花瓷", ItemType.GIFT, IconKey.DELUXE_GIFT_3, StorageKey.DELUXE_GIFT_3_NUM);
        DELUXE_GIFT_3.setHighlightColor(GColor.ULTIMATE_QUALITY);
        DELUXE_GIFT_3.setValue(1888888);
        DELUXE_GIFT_3.setGiftPoints(666666);
        DELUXE_GIFT_3.setPreferential(true);
        items.add(DELUXE_GIFT_3);

        DELUXE_GIFT_4 = new Item("玫瑰跑车", ItemType.GIFT, IconKey.DELUXE_GIFT_4, StorageKey.DELUXE_GIFT_4_NUM);
        DELUXE_GIFT_4.setHighlightColor(GColor.ULTIMATE_QUALITY);
        DELUXE_GIFT_4.setValue(1888888);
        DELUXE_GIFT_4.setGiftPoints(299999);
        DELUXE_GIFT_4.setPreferential(true);
        items.add(DELUXE_GIFT_4);

        DELUXE_GIFT_5 = new Item("玫瑰跑车-神龙", ItemType.GIFT, IconKey.DELUXE_GIFT_5, StorageKey.DELUXE_GIFT_5_NUM);
        DELUXE_GIFT_5.setValue(1888888);
        DELUXE_GIFT_5.setGiftPoints(666666);
        DELUXE_GIFT_5.setPreferential(true);
        items.add(DELUXE_GIFT_5);

        DELUXE_GIFT_6 = new Item("玫瑰跑车-银河", ItemType.GIFT, IconKey.DELUXE_GIFT_6, StorageKey.DELUXE_GIFT_6_NUM);
        DELUXE_GIFT_6.setValue(5200000);
        DELUXE_GIFT_6.setGiftPoints(1688888);
        DELUXE_GIFT_6.setHighlightColor(GColor.ULTIMATE_QUALITY);
        DELUXE_GIFT_6.setPreferential(true);
        items.add(DELUXE_GIFT_6);

        ULTIMATE_GIFT = new Item("起源·应龙", ItemType.GIFT, IconKey.ULTIMATE_GIFT, StorageKey.ULTIMATE_GIFT_NUM);
        ULTIMATE_GIFT.setHighlightColor(GColor.ULTIMATE_QUALITY);
        ULTIMATE_GIFT.setValue(2888888);
        ULTIMATE_GIFT.setGiftPoints(888888);
        ULTIMATE_GIFT.setPreferential(true);
        items.add(ULTIMATE_GIFT);

        ULTIMATE_GIFT_2 = new Item("起源·黑洞", ItemType.GIFT, IconKey.ULTIMATE_GIFT_2, StorageKey.ULTIMATE_GIFT_2_NUM);
        ULTIMATE_GIFT_2.setHighlightColor(GColor.ULTIMATE_QUALITY);
        ULTIMATE_GIFT_2.setValue(2888888);
        ULTIMATE_GIFT_2.setGiftPoints(888888);
        ULTIMATE_GIFT_2.setPreferential(true);
        items.add(ULTIMATE_GIFT_2);

        TICKET = new Item("嘉年华孢子兑换券", ItemType.SKIN, IconKey.TICKET, StorageKey.TICKET);
        TICKET.setHighlightColor(GColor.ULTIMATE_QUALITY);
        TICKET.setShowExp(16888);
        TICKET.setPreferential(true);
        items.add(TICKET);

        SKIN1 = new Item("好吃的骨头", ItemType.SKIN, IconKey.SKIN1, StorageKey.SKIN1_NUM);
        SKIN1.setHighlightColor(GColor.ULTIMATE_QUALITY);
        SKIN1.setShowExp(6666);
        SKIN1.setPreferential(true);
        items.add(SKIN1);

        SKIN2 = new Item("丘比特", ItemType.SKIN, IconKey.SKIN2, StorageKey.SKIN2_NUM);
        SKIN2.setHighlightColor(GColor.ULTIMATE_QUALITY);
        SKIN2.setShowExp(8888);
        SKIN2.setPreferential(true);
        items.add(SKIN2);

        SKIN3 = new Item("王子", ItemType.SKIN, IconKey.SKIN3, StorageKey.SKIN3_NUM);
        SKIN3.setHighlightColor(GColor.ULTIMATE_QUALITY);
        SKIN3.setShowExp(3333);
        SKIN3.setPreferential(true);
        items.add(SKIN3);

        SKIN4 = new Item("公主", ItemType.SKIN, IconKey.SKIN4, StorageKey.SKIN4_NUM);
        SKIN4.setHighlightColor(GColor.ULTIMATE_QUALITY);
        SKIN4.setShowExp(3333);
        SKIN4.setPreferential(true);
        items.add(SKIN4);
    }

    // 盲盒物品
    private static void initBoxSubItem() {
        // 小盒子
        BB4_GIFT = new Item("胡萝卜软糖", ItemType.GIFT, IconKey.BB4_GIFT, StorageKey.BB4_GIFT_NUM);
        BB4_GIFT.setValue(400);
        BB4_GIFT.setGiftPoints(64);
        items.add(BB4_GIFT);

        BB5_GIFT = new Item("爱心信号枪", ItemType.GIFT, IconKey.BB5_GIFT, StorageKey.BB5_GIFT_NUM);
        BB5_GIFT.setValue(400);
        BB5_GIFT.setGiftPoints(64);
        items.add(BB5_GIFT);

        BB6_GIFT = new Item("甜蜜小熊", ItemType.GIFT, IconKey.BB6_GIFT, StorageKey.BB6_GIFT_NUM);
        BB6_GIFT.setValue(1000);
        BB6_GIFT.setGiftPoints(160);
        items.add(BB6_GIFT);

        BB7_GIFT = new Item("星愿熊熊", ItemType.GIFT, IconKey.BB7_GIFT, StorageKey.BB7_GIFT_NUM);
        BB7_GIFT.setValue(1000);
        BB7_GIFT.setGiftPoints(160);
        items.add(BB7_GIFT);

        BB8_GIFT = new Item("玫瑰小熊", ItemType.GIFT, IconKey.BB8_GIFT, StorageKey.BB8_GIFT_NUM);
        BB8_GIFT.setValue(2000);
        BB8_GIFT.setGiftPoints(320);
        items.add(BB8_GIFT);

        BB9_GIFT = new Item("樱花伞", ItemType.GIFT, IconKey.BB9_GIFT, StorageKey.BB9_GIFT_NUM);
        BB9_GIFT.setValue(4000);
        BB9_GIFT.setGiftPoints(640);
        items.add(BB9_GIFT);

        // 大盒子
        RB1_GIFT = new Item("爱心飞艇", ItemType.GIFT, IconKey.RB1_GIFT, StorageKey.RB1_GIFT_NUM);
        RB1_GIFT.setValue(10000);
        RB1_GIFT.setGiftPoints(1600);
        items.add(RB1_GIFT);

        RB2_GIFT = new Item("爱心电话亭", ItemType.GIFT, IconKey.RB2_GIFT, StorageKey.RB2_GIFT_NUM);
        RB2_GIFT.setValue(10000);
        RB2_GIFT.setGiftPoints(1600);
        items.add(RB2_GIFT);

        RB3_GIFT = new Item("爱心魔法棒", ItemType.GIFT, IconKey.RB3_GIFT, StorageKey.RB3_GIFT_NUM);
        RB3_GIFT.setValue(10000);
        RB3_GIFT.setGiftPoints(1600);
        items.add(RB3_GIFT);

        RB4_GIFT = new Item("金丝雀爱巢", ItemType.GIFT, IconKey.RB4_GIFT, StorageKey.RB4_GIFT_NUM);
        RB4_GIFT.setValue(10000);
        RB4_GIFT.setGiftPoints(1600);
        items.add(RB4_GIFT);

        RB5_GIFT = new Item("游艇", ItemType.GIFT, IconKey.RB5_GIFT, StorageKey.RB5_GIFT_NUM);
        RB5_GIFT.setValue(20000);
        RB5_GIFT.setGiftPoints(3200);
        items.add(RB5_GIFT);

        RB6_GIFT = new Item("钻石手表", ItemType.GIFT, IconKey.RB6_GIFT, StorageKey.RB6_GIFT_NUM);
        RB6_GIFT.setValue(20000);
        RB6_GIFT.setGiftPoints(3200);
        items.add(RB6_GIFT);

        RB7_GIFT = new Item("水晶竖琴", ItemType.GIFT, IconKey.RB7_GIFT, StorageKey.RB7_GIFT_NUM);
        RB7_GIFT.setValue(30000);
        RB7_GIFT.setGiftPoints(4800);
        items.add(RB7_GIFT);

        RB8_GIFT = new Item("理想国", ItemType.GIFT, IconKey.RB8_GIFT, StorageKey.RB8_GIFT_NUM);
        RB8_GIFT.setValue(100000);
        RB8_GIFT.setGiftPoints(16000);
        items.add(RB8_GIFT);

        RB21_GIFT = new Item("虹猫", ItemType.GIFT, IconKey.RB21_GIFT, StorageKey.RB21_GIFT_NUM);
        RB21_GIFT.setValue(10000);
        RB21_GIFT.setGiftPoints(1600);
        items.add(RB21_GIFT);

        RB22_GIFT = new Item("蓝兔", ItemType.GIFT, IconKey.RB22_GIFT, StorageKey.RB22_GIFT_NUM);
        RB22_GIFT.setValue(10000);
        RB22_GIFT.setGiftPoints(1600);
        items.add(RB22_GIFT);

        RB23_GIFT = new Item("大奔", ItemType.GIFT, IconKey.RB23_GIFT, StorageKey.RB23_GIFT_NUM);
        RB23_GIFT.setValue(10000);
        RB23_GIFT.setGiftPoints(1600);
        items.add(RB23_GIFT);

        RB24_GIFT = new Item("黑小虎", ItemType.GIFT, IconKey.RB24_GIFT, StorageKey.RB24_GIFT_NUM);
        RB24_GIFT.setValue(10000);
        RB24_GIFT.setGiftPoints(1600);
        items.add(RB24_GIFT);

        RB25_GIFT = new Item("莎丽", ItemType.GIFT, IconKey.RB25_GIFT, StorageKey.RB25_GIFT_NUM);
        RB25_GIFT.setValue(20000);
        RB25_GIFT.setGiftPoints(3200);
        items.add(RB25_GIFT);

        RB26_GIFT = new Item("逗逗", ItemType.GIFT, IconKey.RB26_GIFT, StorageKey.RB26_GIFT_NUM);
        RB26_GIFT.setValue(20000);
        RB26_GIFT.setGiftPoints(3200);
        items.add(RB26_GIFT);

        RB27_GIFT = new Item("跳跳", ItemType.GIFT, IconKey.RB27_GIFT, StorageKey.RB27_GIFT_NUM);
        RB27_GIFT.setValue(30000);
        RB27_GIFT.setGiftPoints(4800);
        items.add(RB27_GIFT);

        RB28_GIFT = new Item("达达", ItemType.GIFT, IconKey.RB28_GIFT, StorageKey.RB28_GIFT_NUM);
        RB28_GIFT.setValue(30000);
        RB28_GIFT.setGiftPoints(4800);
        items.add(RB28_GIFT);

        RB29_GIFT = new Item("紫兔", ItemType.GIFT, IconKey.RB29_GIFT, StorageKey.RB29_GIFT_NUM);
        RB29_GIFT.setValue(50000);
        RB29_GIFT.setGiftPoints(8000);
        items.add(RB29_GIFT);

        RB210_GIFT = new Item("七剑合璧", ItemType.GIFT, IconKey.RB210_GIFT, StorageKey.RB210_GIFT_NUM);
        RB210_GIFT.setValue(100000);
        RB210_GIFT.setGiftPoints(16000);
        items.add(RB210_GIFT);

        // 全屏
        AB1_GIFT = new Item("陪你去看流星雨", ItemType.GIFT, IconKey.AB1_GIFT, StorageKey.AB1_GIFT_NUM);
        AB1_GIFT.setValue(100000);
        AB1_GIFT.setGiftPoints(16000);
        items.add(AB1_GIFT);

        AB2_GIFT = new Item("倾城绝恋", ItemType.GIFT, IconKey.AB2_GIFT, StorageKey.AB2_GIFT_NUM);
        AB2_GIFT.setValue(100000);
        AB2_GIFT.setGiftPoints(30000);
        items.add(AB2_GIFT);

        AB3_GIFT = new Item("倾世一诺", ItemType.GIFT, IconKey.AB3_GIFT, StorageKey.AB3_GIFT_NUM);
        AB3_GIFT.setValue(100000);
        AB3_GIFT.setGiftPoints(16000);
        items.add(AB3_GIFT);

        AB5_GIFT = new Item("战争女王", ItemType.GIFT, IconKey.AB5_GIFT, StorageKey.AB5_GIFT_NUM);
        AB5_GIFT.setValue(300000);
        AB5_GIFT.setGiftPoints(48000);
        items.add(AB5_GIFT);

        AB6_GIFT = new Item("招福舞狮", ItemType.GIFT, IconKey.AB6_GIFT, StorageKey.AB6_GIFT_NUM);
        AB6_GIFT.setValue(50000);
        AB6_GIFT.setGiftPoints(8000);
        items.add(AB6_GIFT);

        AB25_GIFT = new Item("威风祥麟", ItemType.GIFT, IconKey.AB25_GIFT, StorageKey.AB25_GIFT_NUM);
        AB25_GIFT.setValue(188888);
        AB25_GIFT.setGiftPoints(30000);
        items.add(AB25_GIFT);

        AB26_GIFT = new Item("父爱如山", ItemType.GIFT, IconKey.AB26_GIFT, StorageKey.AB26_GIFT_NUM);
        AB26_GIFT.setValue(188888);
        AB26_GIFT.setGiftPoints(30000);
        items.add(AB26_GIFT);

        AB27_GIFT = new Item("七侠团聚", ItemType.GIFT, IconKey.AB27_GIFT, StorageKey.AB27_GIFT_NUM);
        AB27_GIFT.setValue(300000);
        AB27_GIFT.setGiftPoints(48000);
        items.add(AB27_GIFT);

        AB28_GIFT = new Item("虹运当头", ItemType.GIFT, IconKey.AB28_GIFT, StorageKey.AB28_GIFT_NUM);
        AB28_GIFT.setValue(300000);
        AB28_GIFT.setGiftPoints(48000);
        items.add(AB28_GIFT);

        // 辉煌
        DB1_GIFT = new Item("命乾无极", ItemType.GIFT, IconKey.DB1_GIFT, StorageKey.DB1_GIFT_NUM);
        DB1_GIFT.setValue(500000);
        DB1_GIFT.setGiftPoints(80000);
        items.add(DB1_GIFT);

        DB2_GIFT = new Item("嘉年星港", ItemType.GIFT, IconKey.DB2_GIFT, StorageKey.DB2_GIFT_NUM);
        DB2_GIFT.setValue(300000);
        DB2_GIFT.setGiftPoints(48000);
        items.add(DB2_GIFT);

        DB4_GIFT = new Item("锦绣山河", ItemType.GIFT, IconKey.DB4_GIFT, StorageKey.DB4_GIFT_NUM);
        DB4_GIFT.setValue(300000);
        DB4_GIFT.setGiftPoints(48000);
        items.add(DB4_GIFT);

        DB5_GIFT = new Item("魔灵古堡", ItemType.GIFT, IconKey.DB5_GIFT, StorageKey.DB5_GIFT_NUM);
        DB5_GIFT.setValue(188888);
        DB5_GIFT.setGiftPoints(30000);
        items.add(DB5_GIFT);

        DB22_GIFT = new Item("天魔乱舞", ItemType.GIFT, IconKey.DB22_GIFT, StorageKey.DB22_GIFT_NUM);
        DB22_GIFT.setValue(500000);
        DB22_GIFT.setGiftPoints(80000);
        items.add(DB22_GIFT);
    }

    // 一塔物品
    private static void initBasicTowerItemSampler() {
        Sampler<Integer> basicGiftNS = new Sampler<>();
        basicGiftNS.addModel(new SampleModel<>(1, 2000));
        basicGiftNS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 50, 10);
        Item basicGift = BASIC_GIFT.clone();
        basicGift.setNumSampler(basicGiftNS);
        basicTowerItemSampler.addModel(new SampleModel<>(basicGift, 1000));

        Sampler<Integer> regularGiftNS = new Sampler<>();
        basicGiftNS.addModel(new SampleModel<>(1, 2000));
        regularGiftNS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 50, 10);
        Item regularGift = REGULAR_GIFT.clone();
        regularGift.setNumSampler(regularGiftNS);
        basicTowerItemSampler.addModel(new SampleModel<>(regularGift, 50));

        Sampler<Integer> regularCoinNS = new Sampler<>();
        regularCoinNS.addModelsLinearWeights(ListUtil.ofRange(10, 40), 200, 10);
        Item regularCoin = REGULAR_COIN.clone();
        regularCoin.setNumSampler(regularCoinNS);
        basicTowerItemSampler.addModel(new SampleModel<>(regularCoin, 2000));

        Sampler<Integer> basicShardNS = new Sampler<>();
        basicShardNS.addModelsLinearWeights(ListUtil.ofRange(1, 2), 2000, 1000);
        basicShardNS.addModelsLinearWeights(ListUtil.ofRange(3, 5), 50, 10);
        Item basicShard = BASIC_SHARD.clone();
        basicShard.setNumSampler(basicShardNS);
        basicTowerItemSampler.addModel(new SampleModel<>(basicShard, 1500));

        Sampler<Integer> commonShardNS = new Sampler<>();
        commonShardNS.addModel(new SampleModel<>(1, 2000));
        commonShardNS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 50, 10);
        Item commonShard = COMMON_SHARD.clone();
        commonShard.setNumSampler(commonShardNS);
        basicTowerItemSampler.addModel(new SampleModel<>(commonShard, 1000));

        basicTowerItemSampler.addModel(new SampleModel<>(BASIC_STEP, 100));

        basicTowerItemSampler.addModel(new SampleModel<>(REGULAR_STEP, 10));
    }

    // 二塔物品
    private static void initRegularTowerItemSampler() {
        Sampler<Integer> coinNS = new Sampler<>();
        coinNS.addModelsLinearWeights(ListUtil.ofRange(1, 3), 2000, 1000);
        coinNS.addModelsLinearWeights(ListUtil.ofRange(4, 10), 50, 10);
        Item coin = COIN.clone();
        coin.setNumSampler(coinNS);
        regularTowerItemSampler.addModel(new SampleModel<>(coin, 1500));

        Sampler<Integer> basicGiftNS = new Sampler<>();
        basicGiftNS.addModelsLinearWeights(ListUtil.ofRange(1, 3), 2000, 1000);
        basicGiftNS.addModelsLinearWeights(ListUtil.ofRange(4, 10), 50, 10);
        Item basicGift = BASIC_GIFT.clone();
        basicGift.setNumSampler(basicGiftNS);
        regularTowerItemSampler.addModel(new SampleModel<>(basicGift, 2000));

        Sampler<Integer> regularGiftNS = new Sampler<>();
        regularGiftNS.addModel(new SampleModel<>(1, 2000));
        regularGiftNS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 50, 100);
        Item regularGift = REGULAR_GIFT.clone();
        regularGift.setNumSampler(regularGiftNS);
        regularTowerItemSampler.addModel(new SampleModel<>(regularGift, 500));

        Sampler<Integer> regularCoinNS = new Sampler<>();
        regularCoinNS.addModelsLinearWeights(ListUtil.ofRange(30, 60), 200, 10);
        Item regularCoin = REGULAR_COIN.clone();
        regularCoin.setNumSampler(regularCoinNS);
        regularTowerItemSampler.addModel(new SampleModel<>(regularCoin, 2000));

        Sampler<Integer> regularShardNS = new Sampler<>();
        regularShardNS.addModelsLinearWeights(ListUtil.ofRange(1, 4), 2000, 1000);
        regularShardNS.addModelsLinearWeights(ListUtil.ofRange(5, 10), 50, 10);
        Item regularShard = REGULAR_SHARD.clone();
        regularShard.setNumSampler(regularShardNS);
        regularTowerItemSampler.addModel(new SampleModel<>(regularShard, 1500));

        Sampler<Integer> commonShardNS = new Sampler<>();
        commonShardNS.addModelsLinearWeights(ListUtil.ofRange(1, 3), 2000, 1000);
        commonShardNS.addModelsLinearWeights(ListUtil.ofRange(4, 10), 50, 10);
        Item commonShard = COMMON_SHARD.clone();
        commonShard.setNumSampler(commonShardNS);
        regularTowerItemSampler.addModel(new SampleModel<>(commonShard, 1500));

        regularTowerItemSampler.addModel(new SampleModel<>(REGULAR_GIFT_2, 100));

        regularTowerItemSampler.addModel(new SampleModel<>(DELUXE_STEP, 10));

        regularTowerItemSampler.addModel(new SampleModel<>(ADVANCED_BOX, 2));
    }

    // 三塔物品
    private static void initAdvancedTowerItemSampler() {
        Sampler<Integer> coinNS = new Sampler<>();
        coinNS.addModelsLinearWeights(ListUtil.ofRange(10, 30), 200, 100);
        coinNS.addModelsLinearWeights(ListUtil.ofRange(31, 40), 50, 10);
        coinNS.addModel(new SampleModel<>(66, 60));
        coinNS.addModel(new SampleModel<>(99, 40));
        coinNS.addModel(new SampleModel<>(199, 20));
        Item coin = COIN.clone();
        coin.setNumSampler(coinNS);
        advancedTowerItemSampler.addModel(new SampleModel<>(coin, 2000));
        advancedTower2ItemSampler.addModel(new SampleModel<>(coin, 2000));

        Sampler<Integer> basicGiftNS = new Sampler<>();
        basicGiftNS.addModelsLinearWeights(ListUtil.ofRange(3, 6), 2000, 1000);
        basicGiftNS.addModelsLinearWeights(ListUtil.ofRange(7, 10), 50, 10);
        Item basicGift = BASIC_GIFT.clone();
        basicGift.setNumSampler(basicGiftNS);
        advancedTowerItemSampler.addModel(new SampleModel<>(basicGift, 1500));

        Sampler<Integer> basicGift2NS = new Sampler<>();
        basicGift2NS.addModelsLinearWeights(ListUtil.ofRange(3, 6), 2000, 1000);
        basicGift2NS.addModelsLinearWeights(ListUtil.ofRange(7, 10), 50, 10);
        Item basicGift2 = BASIC_GIFT_2.clone();
        basicGift2.setNumSampler(basicGift2NS);
        advancedTower2ItemSampler.addModel(new SampleModel<>(basicGift2, 1500));

        Sampler<Integer> regularGiftNS = new Sampler<>();
        regularGiftNS.addModelsLinearWeights(ListUtil.ofRange(1, 3), 2000, 1000);
        regularGiftNS.addModelsLinearWeights(ListUtil.ofRange(4, 10), 50, 10);
        Item regularGift = REGULAR_GIFT.clone();
        regularGift.setNumSampler(regularGiftNS);
        advancedTowerItemSampler.addModel(new SampleModel<>(regularGift, 2000));

        Sampler<Integer> regularGift21NS = new Sampler<>();
        regularGift21NS.addModelsLinearWeights(ListUtil.ofRange(1, 3), 2000, 1000);
        regularGift21NS.addModelsLinearWeights(ListUtil.ofRange(4, 10), 50, 10);
        Item regularGift21 = REGULAR_GIFT_21.clone();
        regularGift21.setNumSampler(regularGift21NS);
        advancedTower2ItemSampler.addModel(new SampleModel<>(regularGift21, 2000));

        Sampler<Integer> regularCoinNS = new Sampler<>();
        regularCoinNS.addModel(new SampleModel<>(333, 60));
        regularCoinNS.addModel(new SampleModel<>(666, 40));
        Item regularCoin = REGULAR_COIN.clone();
        regularCoin.setNumSampler(regularCoinNS);
        advancedTowerItemSampler.addModel(new SampleModel<>(regularCoin, 1500));
        advancedTower2ItemSampler.addModel(new SampleModel<>(regularCoin, 1500));

        Sampler<Integer> statueNS = new Sampler<>();
        statueNS.addModelsLinearWeights(ListUtil.ofRange(2, 5), 2000, 1000);
        statueNS.addModelsLinearWeights(ListUtil.ofRange(6, 8), 50, 10);
        Item statue = STATUE.clone();
        statue.setNumSampler(statueNS);
        advancedTowerItemSampler.addModel(new SampleModel<>(statue, 1000));
        advancedTower2ItemSampler.addModel(new SampleModel<>(statue, 1000));

        advancedTowerItemSampler.addModel(new SampleModel<>(REGULAR_STEP, 450));
        advancedTower2ItemSampler.addModel(new SampleModel<>(REGULAR_STEP, 450));

        advancedTowerItemSampler.addModel(new SampleModel<>(ADVANCED_STEP, 250));
        advancedTower2ItemSampler.addModel(new SampleModel<>(ADVANCED_STEP, 250));

        advancedTowerItemSampler.addModel(new SampleModel<>(DELUXE_STEP, 30));
        advancedTower2ItemSampler.addModel(new SampleModel<>(DELUXE_STEP, 30));

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModel(new SampleModel<>(9999, 990));
        advancedCoinNS.addModel(new SampleModel<>(99999, 10));
        Item advancedCoin = ADVANCED_COIN.clone();
        advancedCoin.setNumSampler(advancedCoinNS);
        advancedTowerItemSampler.addModel(new SampleModel<>(advancedCoin, 3));
        advancedTower2ItemSampler.addModel(new SampleModel<>(advancedCoin, 3));

        Sampler<Integer> basicBoxNS = new Sampler<>();
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 3), 2000, 1000);
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(4, 10), 50, 10);
        Item basicBox = BASIC_BOX.clone();
        basicBox.setNumSampler(basicBoxNS);
        advancedTowerItemSampler.addModel(new SampleModel<>(basicBox, 800));

        Sampler<Integer> basicBox2NS = new Sampler<>();
        basicBox2NS.addModelsLinearWeights(ListUtil.ofRange(1, 3), 2000, 1000);
        basicBox2NS.addModelsLinearWeights(ListUtil.ofRange(4, 10), 50, 10);
        Item basicBox2 = BASIC_BOX_2.clone();
        basicBox2.setNumSampler(basicBox2NS);
        advancedTower2ItemSampler.addModel(new SampleModel<>(basicBox2, 800));

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModel(new SampleModel<>(1, 2000));
        regularBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 50, 1);
        Item regularBox = REGULAR_BOX.clone();
        regularBox.setNumSampler(regularBoxNS);
        advancedTowerItemSampler.addModel(new SampleModel<>(regularBox, 200));

        Sampler<Integer> regularBox2NS = new Sampler<>();
        regularBox2NS.addModel(new SampleModel<>(1, 2000));
        regularBox2NS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 50, 1);
        Item regularBox2 = REGULAR_BOX_2.clone();
        regularBox2.setNumSampler(regularBox2NS);
        advancedTower2ItemSampler.addModel(new SampleModel<>(regularBox2, 200));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModel(new SampleModel<>(1, 2000));
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 30, 1);
        Item advancedBox = ADVANCED_BOX.clone();
        advancedBox.setNumSampler(advancedBoxNS);
        advancedTowerItemSampler.addModel(new SampleModel<>(advancedBox, 40));

        Sampler<Integer> advancedBox2NS = new Sampler<>();
        advancedBox2NS.addModel(new SampleModel<>(1, 2000));
        advancedBox2NS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 30, 1);
        Item advancedBox2 = ADVANCED_BOX_2.clone();
        advancedBox2.setNumSampler(advancedBox2NS);
        advancedTower2ItemSampler.addModel(new SampleModel<>(advancedBox2, 40));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModel(new SampleModel<>(1, 2000));
        deluxeBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 15, 1);
        Item deluxeBox = DELUXE_BOX.clone();
        deluxeBox.setNumSampler(deluxeBoxNS);
        advancedTowerItemSampler.addModel(new SampleModel<>(deluxeBox, 20));

        Sampler<Integer> deluxeBox2NS = new Sampler<>();
        deluxeBox2NS.addModel(new SampleModel<>(1, 2000));
        deluxeBox2NS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 15, 1);
        Item deluxeBox2 = DELUXE_BOX_2.clone();
        deluxeBox2.setNumSampler(deluxeBox2NS);
        advancedTower2ItemSampler.addModel(new SampleModel<>(deluxeBox2, 20));

        Sampler<Integer> advancedGiftNS = new Sampler<>();
        advancedGiftNS.addModel(new SampleModel<>(1, 2000));
        advancedGiftNS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 5, 1);
        Item advancedGift = ADVANCED_GIFT.clone();
        advancedGift.setNumSampler(advancedGiftNS);
        advancedTowerItemSampler.addModel(new SampleModel<>(advancedGift, 5));

        Sampler<Integer> advancedGift21NS = new Sampler<>();
        advancedGift21NS.addModel(new SampleModel<>(1, 2000));
        advancedGift21NS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 5, 1);
        Item advancedGift21 = ADVANCED_GIFT_21.clone();
        advancedGift21.setNumSampler(advancedGift21NS);
        advancedTower2ItemSampler.addModel(new SampleModel<>(advancedGift21, 5));

        Sampler<Integer> advancedGift2NS = new Sampler<>();
        advancedGift2NS.addModel(new SampleModel<>(1, 2000));
        advancedGift2NS.addModelsLinearWeights(ListUtil.ofRange(2, 5), 10, 1);
        Item advancedGift2 = ADVANCED_GIFT_2.clone();
        advancedGift2.setNumSampler(advancedGift2NS);
        advancedTowerItemSampler.addModel(new SampleModel<>(advancedGift2, 8));

        Sampler<Integer> advancedGift22NS = new Sampler<>();
        advancedGift22NS.addModel(new SampleModel<>(1, 2000));
        advancedGift22NS.addModelsLinearWeights(ListUtil.ofRange(2, 5), 10, 1);
        Item advancedGift22 = ADVANCED_GIFT_22.clone();
        advancedGift22.setNumSampler(advancedGift22NS);
        advancedTower2ItemSampler.addModel(new SampleModel<>(advancedGift22, 8));

        advancedTowerItemSampler.addModel(new SampleModel<>(DELUXE_GIFT, 2));
        advancedTower2ItemSampler.addModel(new SampleModel<>(DELUXE_GIFT, 2));

        advancedTowerItemSampler.addModel(new SampleModel<>(DELUXE_GIFT_2, 2));
        advancedTower2ItemSampler.addModel(new SampleModel<>(DELUXE_GIFT_2, 2));

        advancedTowerItemSampler.addModel(new SampleModel<>(DELUXE_GIFT_4, 2));
        advancedTower2ItemSampler.addModel(new SampleModel<>(DELUXE_GIFT_4, 2));

        advancedTowerItemSampler.addModel(new SampleModel<>(ULTIMATE_GIFT, 2));
        advancedTower2ItemSampler.addModel(new SampleModel<>(ULTIMATE_GIFT, 2));

        advancedTowerItemSampler.addModel(new SampleModel<>(ULTIMATE_GIFT_2, 2));
        advancedTower2ItemSampler.addModel(new SampleModel<>(ULTIMATE_GIFT_2, 2));

        advancedTowerItemSampler.addModel(new SampleModel<>(TICKET, 1));
        advancedTower2ItemSampler.addModel(new SampleModel<>(TICKET, 1));

        advancedTowerItemSampler.addModel(new SampleModel<>(SKIN1, 1));
        advancedTower2ItemSampler.addModel(new SampleModel<>(SKIN1, 1));

        advancedTowerItemSampler.addModel(new SampleModel<>(SKIN2, 1));
        advancedTower2ItemSampler.addModel(new SampleModel<>(SKIN2, 1));

        advancedTowerItemSampler.addModel(new SampleModel<>(SKIN3, 1));
        advancedTower2ItemSampler.addModel(new SampleModel<>(SKIN3, 1));

        advancedTowerItemSampler.addModel(new SampleModel<>(SKIN4, 1));
        advancedTower2ItemSampler.addModel(new SampleModel<>(SKIN4, 1));
    }

    // 金塔物品
    private static void initDeluxeTowerItemSampler() {
        Sampler<Integer> coinNS = new Sampler<>();
        coinNS.addModel(new SampleModel<>(99, 400));
        coinNS.addModel(new SampleModel<>(199, 500));
        coinNS.addModel(new SampleModel<>(899, 300));
        coinNS.addModel(new SampleModel<>(999, 200));
        Item coin = COIN.clone();
        coin.setHighlightColor(GColor.DELUXE_QUALITY);
        coin.setNumSampler(coinNS);
        deluxeTowerItemSampler.addModel(new SampleModel<>(coin, 2000));

        Sampler<Integer> statueNS = new Sampler<>();
        statueNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 2000, 1000);
        statueNS.addModelsLinearWeights(ListUtil.ofRange(11, 16), 50, 10);
        Item statue = STATUE.clone();
        statue.setNumSampler(statueNS);
        deluxeTowerItemSampler.addModel(new SampleModel<>(statue, 1000));

        Sampler<Integer> advancedShardNS = new Sampler<>();
        advancedShardNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 2000, 1000);
        advancedShardNS.addModelsLinearWeights(ListUtil.ofRange(11, 16), 50, 10);
        Item advancedShard = ADVANCED_SHARD.clone();
        advancedShard.setNumSampler(advancedShardNS);
        deluxeTowerItemSampler.addModel(new SampleModel<>(advancedShard, 800));

        Sampler<Integer> commonShardNS = new Sampler<>();
        commonShardNS.addModelsLinearWeights(ListUtil.ofRange(30, 100), 2000, 1000);
        commonShardNS.addModelsLinearWeights(ListUtil.ofRange(101, 200), 50, 10);
        Item commonShard = COMMON_SHARD.clone();
        commonShard.setNumSampler(commonShardNS);
        deluxeTowerItemSampler.addModel(new SampleModel<>(commonShard, 800));

        Sampler<Integer> basicBoxNS = new Sampler<>();
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 3), 2000, 1000);
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(4, 10), 50, 10);
        Item basicBox = BASIC_BOX.clone();
        basicBox.setNumSampler(basicBoxNS);
        deluxeTowerItemSampler.addModel(new SampleModel<>(basicBox, 1000));

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModel(new SampleModel<>(1, 2000));
        regularBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 50, 1);
        Item regularBox = REGULAR_BOX.clone();
        regularBox.setNumSampler(regularBoxNS);
        deluxeTowerItemSampler.addModel(new SampleModel<>(regularBox, 200));

        Sampler<Integer> regularGift2NS = new Sampler<>();
        regularGift2NS.addModel(new SampleModel<>(1, 2000));
        regularGift2NS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 50, 1);
        Item regularGift2 = REGULAR_GIFT_2.clone();
        regularGift2.setNumSampler(regularGift2NS);
        deluxeTowerItemSampler.addModel(new SampleModel<>(regularGift2, 500));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModel(new SampleModel<>(1, 2000));
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 30, 1);
        Item advancedBox = ADVANCED_BOX.clone();
        advancedBox.setNumSampler(advancedBoxNS);
        deluxeTowerItemSampler.addModel(new SampleModel<>(advancedBox, 20));

        deluxeTowerItemSampler.addModel(new SampleModel<>(DELUXE_GIFT_3, 2));

        deluxeTowerItemSampler.addModel(new SampleModel<>(DELUXE_GIFT_6, 1));

        deluxeTowerItemSampler.addModel(new SampleModel<>(ULTIMATE_GIFT, 2));

        deluxeTowerItemSampler.addModel(new SampleModel<>(ULTIMATE_GIFT_2, 2));
    }

    // 中级密藏物品
    private static void initRegularTreasureItemSampler() {
        Sampler<Integer> coinNS = new Sampler<>();
        coinNS.addModel(new SampleModel<>(199, 200));
        coinNS.addModel(new SampleModel<>(399, 20));
        coinNS.addModel(new SampleModel<>(699, 2));
        Item coin = COIN.clone();
        coin.setHighlightColor(GColor.DELUXE_QUALITY);
        coin.setNumSampler(coinNS);
        regularTreasureItemSampler.addModel(new SampleModel<>(coin, 2000));
        regularTreasure2ItemSampler.addModel(new SampleModel<>(coin, 2000));

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModel(new SampleModel<>(1, 100));
        regularBoxNS.addModel(new SampleModel<>(2, 80));
        regularBoxNS.addModel(new SampleModel<>(4, 10));
        Item regularBox = REGULAR_BOX.clone();
        regularBox.setNumSampler(regularBoxNS);
        regularTreasureItemSampler.addModel(new SampleModel<>(regularBox, 2000));

        Sampler<Integer> regularBox2NS = new Sampler<>();
        regularBox2NS.addModel(new SampleModel<>(1, 100));
        regularBox2NS.addModel(new SampleModel<>(2, 80));
        regularBox2NS.addModel(new SampleModel<>(4, 10));
        Item regularBox2 = REGULAR_BOX_2.clone();
        regularBox2.setNumSampler(regularBox2NS);
        regularTreasure2ItemSampler.addModel(new SampleModel<>(regularBox2, 2000));

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModel(new SampleModel<>(1888, 980));
        advancedCoinNS.addModel(new SampleModel<>(6666, 20));
        Item advancedCoin = ADVANCED_COIN.clone();
        advancedCoin.setNumSampler(advancedCoinNS);
        regularTreasureItemSampler.addModel(new SampleModel<>(advancedCoin, 40));
        regularTreasure2ItemSampler.addModel(new SampleModel<>(advancedCoin, 40));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModel(new SampleModel<>(1, 2000));
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 30, 1);
        Item advancedBox = ADVANCED_BOX.clone();
        advancedBox.setNumSampler(advancedBoxNS);
        regularTreasureItemSampler.addModel(new SampleModel<>(advancedBox, 60));

        Sampler<Integer> advancedBox2NS = new Sampler<>();
        advancedBox2NS.addModel(new SampleModel<>(1, 2000));
        advancedBox2NS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 30, 1);
        Item advancedBox2 = REGULAR_BOX_2.clone();
        advancedBox2.setNumSampler(advancedBox2NS);
        regularTreasure2ItemSampler.addModel(new SampleModel<>(advancedBox2, 60));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModel(new SampleModel<>(1, 2000));
        deluxeBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 15, 1);
        Item deluxeBox = DELUXE_BOX.clone();
        deluxeBox.setNumSampler(deluxeBoxNS);
        regularTreasureItemSampler.addModel(new SampleModel<>(deluxeBox, 20));

        Sampler<Integer> deluxeBox2NS = new Sampler<>();
        deluxeBox2NS.addModel(new SampleModel<>(1, 2000));
        deluxeBox2NS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 15, 1);
        Item deluxeBox2 = DELUXE_BOX_2.clone();
        deluxeBox2.setNumSampler(deluxeBox2NS);
        regularTreasure2ItemSampler.addModel(new SampleModel<>(deluxeBox2, 20));

        Sampler<Integer> advancedGiftNS = new Sampler<>();
        advancedGiftNS.addModel(new SampleModel<>(1, 2000));
        advancedGiftNS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 5, 1);
        Item advancedGift = ADVANCED_GIFT.clone();
        advancedGift.setNumSampler(advancedGiftNS);
        regularTreasureItemSampler.addModel(new SampleModel<>(advancedGift, 5));

        Sampler<Integer> advancedGift21NS = new Sampler<>();
        advancedGift21NS.addModel(new SampleModel<>(1, 2000));
        advancedGift21NS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 5, 1);
        Item advancedGift21 = ADVANCED_GIFT_21.clone();
        advancedGift21.setNumSampler(advancedGift21NS);
        regularTreasure2ItemSampler.addModel(new SampleModel<>(advancedGift21, 5));

        Sampler<Integer> advancedGift2NS = new Sampler<>();
        advancedGift2NS.addModel(new SampleModel<>(1, 2000));
        advancedGift2NS.addModelsLinearWeights(ListUtil.ofRange(2, 5), 10, 1);
        Item advancedGift2 = ADVANCED_GIFT_2.clone();
        advancedGift2.setNumSampler(advancedGift2NS);
        regularTreasureItemSampler.addModel(new SampleModel<>(advancedGift2, 10));

        Sampler<Integer> advancedGift22NS = new Sampler<>();
        advancedGift22NS.addModel(new SampleModel<>(1, 2000));
        advancedGift22NS.addModelsLinearWeights(ListUtil.ofRange(2, 5), 10, 1);
        Item advancedGift22 = ADVANCED_GIFT_22.clone();
        advancedGift22.setNumSampler(advancedGift22NS);
        regularTreasure2ItemSampler.addModel(new SampleModel<>(advancedGift22, 10));

        regularTreasureItemSampler.addModel(new SampleModel<>(DELUXE_GIFT_3, 1));
        regularTreasure2ItemSampler.addModel(new SampleModel<>(DELUXE_GIFT_3, 1));
    }

    // 高级密藏物品
    private static void initAdvancedTreasureItemSampler() {
        Sampler<Integer> coinNS = new Sampler<>();
        coinNS.addModel(new SampleModel<>(199, 20));
        coinNS.addModel(new SampleModel<>(399, 200));
        coinNS.addModel(new SampleModel<>(699, 50));
        Item coin = COIN.clone();
        coin.setHighlightColor(GColor.DELUXE_QUALITY);
        coin.setNumSampler(coinNS);
        advancedTreasureItemSampler.addModel(new SampleModel<>(coin, 2000));
        advancedTreasure2ItemSampler.addModel(new SampleModel<>(coin, 2000));

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModel(new SampleModel<>(2, 200));
        regularBoxNS.addModel(new SampleModel<>(4, 150));
        regularBoxNS.addModel(new SampleModel<>(8, 20));
        Item regularBox = REGULAR_BOX.clone();
        regularBox.setNumSampler(regularBoxNS);
        advancedTreasureItemSampler.addModel(new SampleModel<>(regularBox, 2000));

        Sampler<Integer> regularBox2NS = new Sampler<>();
        regularBox2NS.addModel(new SampleModel<>(2, 200));
        regularBox2NS.addModel(new SampleModel<>(4, 150));
        regularBox2NS.addModel(new SampleModel<>(8, 20));
        Item regularBox2 = REGULAR_BOX_2.clone();
        regularBox2.setNumSampler(regularBox2NS);
        advancedTreasure2ItemSampler.addModel(new SampleModel<>(regularBox2, 2000));

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModel(new SampleModel<>(1888, 920));
        advancedCoinNS.addModel(new SampleModel<>(6666, 60));
        advancedCoinNS.addModel(new SampleModel<>(9999, 20));
        Item advancedCoin = ADVANCED_COIN.clone();
        advancedCoin.setNumSampler(advancedCoinNS);
        advancedTreasureItemSampler.addModel(new SampleModel<>(advancedCoin, 50));
        advancedTreasure2ItemSampler.addModel(new SampleModel<>(advancedCoin, 50));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModel(new SampleModel<>(1, 2000));
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 35, 1);
        Item advancedBox = ADVANCED_BOX.clone();
        advancedBox.setNumSampler(advancedBoxNS);
        advancedTreasureItemSampler.addModel(new SampleModel<>(advancedBox, 70));

        Sampler<Integer> advancedBox2NS = new Sampler<>();
        advancedBox2NS.addModel(new SampleModel<>(1, 2000));
        advancedBox2NS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 35, 1);
        Item advancedBox2 = ADVANCED_BOX_2.clone();
        advancedBox2.setNumSampler(advancedBox2NS);
        advancedTreasure2ItemSampler.addModel(new SampleModel<>(advancedBox2, 70));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModel(new SampleModel<>(1, 2000));
        deluxeBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 20, 1);
        Item deluxeBox = DELUXE_BOX.clone();
        deluxeBox.setNumSampler(deluxeBoxNS);
        advancedTreasureItemSampler.addModel(new SampleModel<>(deluxeBox, 25));

        Sampler<Integer> deluxeBox2NS = new Sampler<>();
        deluxeBox2NS.addModel(new SampleModel<>(1, 2000));
        deluxeBox2NS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 20, 1);
        Item deluxeBox2 = DELUXE_BOX_2.clone();
        deluxeBox2.setNumSampler(deluxeBox2NS);
        advancedTreasure2ItemSampler.addModel(new SampleModel<>(deluxeBox2, 25));

        Sampler<Integer> advancedGiftNS = new Sampler<>();
        advancedGiftNS.addModel(new SampleModel<>(1, 2000));
        advancedGiftNS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 10, 1);
        Item advancedGift = ADVANCED_GIFT.clone();
        advancedGift.setNumSampler(advancedGiftNS);
        advancedTreasureItemSampler.addModel(new SampleModel<>(advancedGift, 8));

        Sampler<Integer> advancedGift21NS = new Sampler<>();
        advancedGift21NS.addModel(new SampleModel<>(1, 2000));
        advancedGift21NS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 10, 1);
        Item advancedGift21 = ADVANCED_GIFT_21.clone();
        advancedGift21.setNumSampler(advancedGift21NS);
        advancedTreasure2ItemSampler.addModel(new SampleModel<>(advancedGift21, 8));

        Sampler<Integer> advancedGift2NS = new Sampler<>();
        advancedGift2NS.addModel(new SampleModel<>(1, 2000));
        advancedGift2NS.addModelsLinearWeights(ListUtil.ofRange(2, 5), 15, 1);
        Item advancedGift2 = ADVANCED_GIFT_2.clone();
        advancedGift2.setNumSampler(advancedGift2NS);
        advancedTreasureItemSampler.addModel(new SampleModel<>(advancedGift2, 16));

        Sampler<Integer> advancedGift22NS = new Sampler<>();
        advancedGift22NS.addModel(new SampleModel<>(1, 2000));
        advancedGift22NS.addModelsLinearWeights(ListUtil.ofRange(2, 5), 15, 1);
        Item advancedGift22 = ADVANCED_GIFT_22.clone();
        advancedGift22.setNumSampler(advancedGift22NS);
        advancedTreasure2ItemSampler.addModel(new SampleModel<>(advancedGift22, 16));

        advancedTreasureItemSampler.addModel(new SampleModel<>(DELUXE_GIFT_3, 2));
        advancedTreasure2ItemSampler.addModel(new SampleModel<>(DELUXE_GIFT_3, 2));
    }

    // 超级密藏物品
    private static void initDeluxeTreasureItemSampler() {
        Sampler<Integer> coinNS = new Sampler<>();
        coinNS.addModel(new SampleModel<>(199, 20));
        coinNS.addModel(new SampleModel<>(399, 200));
        coinNS.addModel(new SampleModel<>(699, 100));
        Item coin = COIN.clone();
        coin.setHighlightColor(GColor.DELUXE_QUALITY);
        coin.setNumSampler(coinNS);
        deluxeTreasureItemSampler.addModel(new SampleModel<>(coin, 2000));
        deluxeTreasure2ItemSampler.addModel(new SampleModel<>(coin, 2000));

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModel(new SampleModel<>(4, 200));
        regularBoxNS.addModel(new SampleModel<>(8, 40));
        Item regularBox = REGULAR_BOX.clone();
        regularBox.setNumSampler(regularBoxNS);
        deluxeTreasureItemSampler.addModel(new SampleModel<>(regularBox, 2000));

        Sampler<Integer> regularBox2NS = new Sampler<>();
        regularBox2NS.addModel(new SampleModel<>(4, 200));
        regularBox2NS.addModel(new SampleModel<>(8, 40));
        Item regularBox2 = REGULAR_BOX_2.clone();
        regularBox2.setNumSampler(regularBox2NS);
        deluxeTreasure2ItemSampler.addModel(new SampleModel<>(regularBox2, 2000));

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModel(new SampleModel<>(1888, 900));
        advancedCoinNS.addModel(new SampleModel<>(6666, 80));
        advancedCoinNS.addModel(new SampleModel<>(9999, 20));
        Item advancedCoin = ADVANCED_COIN.clone();
        advancedCoin.setNumSampler(advancedCoinNS);
        deluxeTreasureItemSampler.addModel(new SampleModel<>(advancedCoin, 60));
        deluxeTreasure2ItemSampler.addModel(new SampleModel<>(advancedCoin, 60));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModel(new SampleModel<>(1, 2000));
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 40, 1);
        Item advancedBox = ADVANCED_BOX.clone();
        advancedBox.setNumSampler(advancedBoxNS);
        deluxeTreasureItemSampler.addModel(new SampleModel<>(advancedBox, 80));

        Sampler<Integer> advancedBox2NS = new Sampler<>();
        advancedBox2NS.addModel(new SampleModel<>(1, 2000));
        advancedBox2NS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 40, 1);
        Item advancedBox2 = ADVANCED_BOX_2.clone();
        advancedBox2.setNumSampler(advancedBox2NS);
        deluxeTreasure2ItemSampler.addModel(new SampleModel<>(advancedBox2, 80));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModel(new SampleModel<>(1, 2000));
        deluxeBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 25, 1);
        Item deluxeBox = DELUXE_BOX.clone();
        deluxeBox.setNumSampler(deluxeBoxNS);
        deluxeTreasureItemSampler.addModel(new SampleModel<>(deluxeBox, 30));

        Sampler<Integer> deluxeBox2NS = new Sampler<>();
        deluxeBox2NS.addModel(new SampleModel<>(1, 2000));
        deluxeBox2NS.addModelsLinearWeights(ListUtil.ofRange(2, 10), 25, 1);
        Item deluxeBox2 = DELUXE_BOX_2.clone();
        deluxeBox2.setNumSampler(deluxeBox2NS);
        deluxeTreasure2ItemSampler.addModel(new SampleModel<>(deluxeBox2, 30));

        Sampler<Integer> advancedGiftNS = new Sampler<>();
        advancedGiftNS.addModel(new SampleModel<>(1, 2000));
        advancedGiftNS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 15, 1);
        Item advancedGift = ADVANCED_GIFT.clone();
        advancedGift.setNumSampler(advancedGiftNS);
        deluxeTreasureItemSampler.addModel(new SampleModel<>(advancedGift, 10));

        Sampler<Integer> advancedGift21NS = new Sampler<>();
        advancedGift21NS.addModel(new SampleModel<>(1, 2000));
        advancedGift21NS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 15, 1);
        Item advancedGift21 = ADVANCED_GIFT_21.clone();
        advancedGift21.setNumSampler(advancedGift21NS);
        deluxeTreasure2ItemSampler.addModel(new SampleModel<>(advancedGift21, 10));

        Sampler<Integer> advancedGift2NS = new Sampler<>();
        advancedGift2NS.addModel(new SampleModel<>(1, 2000));
        advancedGift2NS.addModelsLinearWeights(ListUtil.ofRange(2, 5), 20, 1);
        Item advancedGift2 = ADVANCED_GIFT_2.clone();
        advancedGift2.setNumSampler(advancedGift2NS);
        deluxeTreasureItemSampler.addModel(new SampleModel<>(advancedGift2, 20));

        Sampler<Integer> advancedGift22NS = new Sampler<>();
        advancedGift22NS.addModel(new SampleModel<>(1, 2000));
        advancedGift22NS.addModelsLinearWeights(ListUtil.ofRange(2, 5), 20, 1);
        Item advancedGift22 = ADVANCED_GIFT_22.clone();
        advancedGift22.setNumSampler(advancedGift22NS);
        deluxeTreasure2ItemSampler.addModel(new SampleModel<>(advancedGift22, 20));

        deluxeTreasureItemSampler.addModel(new SampleModel<>(DELUXE_GIFT_3, 3));
        deluxeTreasure2ItemSampler.addModel(new SampleModel<>(DELUXE_GIFT_3, 3));
    }

    // 究级密藏物品
    private static void initUltimateTreasureItemSampler() {
        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModel(new SampleModel<>(30, 60));
        regularBoxNS.addModel(new SampleModel<>(50, 100));
        regularBoxNS.addModel(new SampleModel<>(80, 40));
        Item regularBox = REGULAR_BOX.clone();
        regularBox.setNumSampler(regularBoxNS);
        ultimateTreasureItemSampler.addModel(new SampleModel<>(regularBox, 2000));

        Sampler<Integer> regularBox2NS = new Sampler<>();
        regularBox2NS.addModel(new SampleModel<>(30, 60));
        regularBox2NS.addModel(new SampleModel<>(50, 100));
        regularBox2NS.addModel(new SampleModel<>(80, 40));
        Item regularBox2 = REGULAR_BOX_2.clone();
        regularBox2.setNumSampler(regularBox2NS);
        ultimateTreasure2ItemSampler.addModel(new SampleModel<>(regularBox2, 2000));

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModel(new SampleModel<>(9999, 900));
        advancedCoinNS.addModel(new SampleModel<>(99999, 100));
        Item advancedCoin = ADVANCED_COIN.clone();
        advancedCoin.setNumSampler(advancedCoinNS);
        ultimateTreasureItemSampler.addModel(new SampleModel<>(advancedCoin, 2000));
        ultimateTreasure2ItemSampler.addModel(new SampleModel<>(advancedCoin, 2000));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModel(new SampleModel<>(3, 200));
        advancedBoxNS.addModel(new SampleModel<>(5, 500));
        advancedBoxNS.addModel(new SampleModel<>(8, 150));
        advancedBoxNS.addModel(new SampleModel<>(10, 100));
        Item advancedBox = ADVANCED_BOX.clone();
        advancedBox.setNumSampler(advancedBoxNS);
        ultimateTreasureItemSampler.addModel(new SampleModel<>(advancedBox, 2000));

        Sampler<Integer> advancedBox2NS = new Sampler<>();
        advancedBox2NS.addModel(new SampleModel<>(3, 200));
        advancedBox2NS.addModel(new SampleModel<>(5, 500));
        advancedBox2NS.addModel(new SampleModel<>(8, 150));
        advancedBox2NS.addModel(new SampleModel<>(10, 100));
        Item advancedBox2 = ADVANCED_BOX_2.clone();
        advancedBox2.setNumSampler(advancedBox2NS);
        ultimateTreasure2ItemSampler.addModel(new SampleModel<>(advancedBox2, 2000));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModel(new SampleModel<>(1, 100));
        deluxeBoxNS.addModel(new SampleModel<>(2, 500));
        deluxeBoxNS.addModel(new SampleModel<>(3, 300));
        Item deluxeBox = DELUXE_BOX.clone();
        deluxeBox.setNumSampler(deluxeBoxNS);
        ultimateTreasureItemSampler.addModel(new SampleModel<>(deluxeBox, 2000));

        Sampler<Integer> deluxeBox2NS = new Sampler<>();
        deluxeBox2NS.addModel(new SampleModel<>(1, 100));
        deluxeBox2NS.addModel(new SampleModel<>(2, 500));
        deluxeBox2NS.addModel(new SampleModel<>(3, 300));
        Item deluxeBox2 = DELUXE_BOX_2.clone();
        deluxeBox2.setNumSampler(deluxeBox2NS);
        ultimateTreasure2ItemSampler.addModel(new SampleModel<>(deluxeBox2, 2000));

        Sampler<Integer> advancedGiftNS = new Sampler<>();
        advancedGiftNS.addModel(new SampleModel<>(1, 900));
        advancedGiftNS.addModel(new SampleModel<>(2, 100));
        Item advancedGift = ADVANCED_GIFT.clone();
        advancedGift.setNumSampler(advancedGiftNS);
        ultimateTreasureItemSampler.addModel(new SampleModel<>(advancedGift, 600));

        Sampler<Integer> advancedGift21NS = new Sampler<>();
        advancedGift21NS.addModel(new SampleModel<>(1, 900));
        advancedGift21NS.addModel(new SampleModel<>(2, 100));
        Item advancedGift21 = ADVANCED_GIFT_21.clone();
        advancedGift21.setNumSampler(advancedGift21NS);
        ultimateTreasure2ItemSampler.addModel(new SampleModel<>(advancedGift21, 600));

        Sampler<Integer> advancedGift2NS = new Sampler<>();
        advancedGift2NS.addModel(new SampleModel<>(1, 500));
        advancedGift2NS.addModel(new SampleModel<>(2, 200));
        advancedGift2NS.addModel(new SampleModel<>(3, 20));
        Item advancedGift2 = ADVANCED_GIFT_2.clone();
        advancedGift2.setNumSampler(advancedGift2NS);
        ultimateTreasureItemSampler.addModel(new SampleModel<>(advancedGift2, 1200));

        Sampler<Integer> advancedGift22NS = new Sampler<>();
        advancedGift22NS.addModel(new SampleModel<>(1, 500));
        advancedGift22NS.addModel(new SampleModel<>(2, 200));
        advancedGift22NS.addModel(new SampleModel<>(3, 20));
        Item advancedGift22 = ADVANCED_GIFT_22.clone();
        advancedGift22.setNumSampler(advancedGift22NS);
        ultimateTreasure2ItemSampler.addModel(new SampleModel<>(advancedGift22, 1200));

        ultimateTreasureItemSampler.addModel(new SampleModel<>(DELUXE_GIFT, 200));
        ultimateTreasure2ItemSampler.addModel(new SampleModel<>(DELUXE_GIFT, 200));

        ultimateTreasureItemSampler.addModel(new SampleModel<>(DELUXE_GIFT_2, 300));
        ultimateTreasure2ItemSampler.addModel(new SampleModel<>(DELUXE_GIFT_2, 300));

        ultimateTreasureItemSampler.addModel(new SampleModel<>(DELUXE_GIFT_3, 200));
        ultimateTreasure2ItemSampler.addModel(new SampleModel<>(DELUXE_GIFT_3, 200));

        ultimateTreasureItemSampler.addModel(new SampleModel<>(ULTIMATE_GIFT, 100));
        ultimateTreasure2ItemSampler.addModel(new SampleModel<>(ULTIMATE_GIFT, 100));

        ultimateTreasureItemSampler.addModel(new SampleModel<>(ULTIMATE_GIFT_2, 100));
        ultimateTreasure2ItemSampler.addModel(new SampleModel<>(ULTIMATE_GIFT_2, 100));

        ultimateTreasureItemSampler.addModel(new SampleModel<>(DELUXE_GIFT_6, 30));
        ultimateTreasure2ItemSampler.addModel(new SampleModel<>(DELUXE_GIFT_6, 30));
    }

    // 蘑菇金库物品
    private static void initMRTreasureItemSampler() {
        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModelsLinearWeights(ListUtil.ofRange(98, 398), 200, 100);
        advancedCoinNS.addModel(new SampleModel<>(1888, 180));
        advancedCoinNS.addModel(new SampleModel<>(6666, 120));
        advancedCoinNS.addModel(new SampleModel<>(9999, 60));
        advancedCoinNS.addModel(new SampleModel<>(99999, 5));
        Item advancedCoin = ADVANCED_COIN.clone();
        advancedCoin.setNumSampler(advancedCoinNS);
        mrTreasureItemSampler.addModel(new SampleModel<>(advancedCoin, 2000));
    }

    private static void initBBSubItemSampler() {
        bbSubItemSampler.addModel(new SampleModel<>(RB1_GIFT, 80));
        bbSubItemSampler.addModel(new SampleModel<>(RB2_GIFT, 80));
        bbSubItemSampler.addModel(new SampleModel<>(RB3_GIFT, 80));

        Item bb4Gift = BB4_GIFT.clone();
        bb4Gift.setBoxRegular(true);
        bbSubItemSampler.addModel(new SampleModel<>(bb4Gift, 3000));

        Item bb5Gift = BB5_GIFT.clone();
        bb5Gift.setBoxRegular(true);
        bbSubItemSampler.addModel(new SampleModel<>(bb5Gift, 3000));

        Item bb6Gift = BB6_GIFT.clone();
        bb6Gift.setBoxRegular(true);
        bbSubItemSampler.addModel(new SampleModel<>(bb6Gift, 3000));

        Item bb7Gift = BB7_GIFT.clone();
        bb7Gift.setBoxRegular(true);
        bbSubItemSampler.addModel(new SampleModel<>(bb7Gift, 3000));

        bbSubItemSampler.addModel(new SampleModel<>(BB8_GIFT, 300));
        bbSubItemSampler.addModel(new SampleModel<>(BB9_GIFT, 150));
        bbSubItemSampler.addModel(new SampleModel<>(RB8_GIFT, 1));
    }

    private static void initBB2SubItemSampler() {
        bb2SubItemSampler.addModel(new SampleModel<>(RB21_GIFT, 100));
        bb2SubItemSampler.addModel(new SampleModel<>(RB22_GIFT, 100));
        bb2SubItemSampler.addModel(new SampleModel<>(RB23_GIFT, 100));
        bb2SubItemSampler.addModel(new SampleModel<>(RB24_GIFT, 17));

        Item bb25Gift = BB4_GIFT.clone();
        bb25Gift.setBoxRegular(true);
        bb2SubItemSampler.addModel(new SampleModel<>(bb25Gift, 3000));

        Item bb26Gift = BB5_GIFT.clone();
        bb26Gift.setBoxRegular(true);
        bb2SubItemSampler.addModel(new SampleModel<>(bb26Gift, 3000));

        Item bb27Gift = BB6_GIFT.clone();
        bb27Gift.setBoxRegular(true);
        bb2SubItemSampler.addModel(new SampleModel<>(bb27Gift, 3000));

        Item bb28Gift = BB7_GIFT.clone();
        bb28Gift.setBoxRegular(true);
        bb2SubItemSampler.addModel(new SampleModel<>(bb28Gift, 3000));

        bb2SubItemSampler.addModel(new SampleModel<>(BB8_GIFT, 300));
        bb2SubItemSampler.addModel(new SampleModel<>(BB9_GIFT, 150));
        bb2SubItemSampler.addModel(new SampleModel<>(RB29_GIFT, 4));
        bb2SubItemSampler.addModel(new SampleModel<>(RB210_GIFT, 2));
    }

    private static void initRBSubItemSampler() {
        Item rb1Gift = RB1_GIFT.clone();
        rb1Gift.setBoxRegular(true);
        rbSubItemSampler.addModel(new SampleModel<>(rb1Gift, 3000));

        Item rb2Gift = RB2_GIFT.clone();
        rb2Gift.setBoxRegular(true);
        rbSubItemSampler.addModel(new SampleModel<>(rb2Gift, 3000));

        Item rb3Gift = RB3_GIFT.clone();
        rb3Gift.setBoxRegular(true);
        rbSubItemSampler.addModel(new SampleModel<>(rb3Gift, 3000));

        rbSubItemSampler.addModel(new SampleModel<>(RB4_GIFT, 500));
        rbSubItemSampler.addModel(new SampleModel<>(RB5_GIFT, 300));
        rbSubItemSampler.addModel(new SampleModel<>(RB6_GIFT, 300));
        rbSubItemSampler.addModel(new SampleModel<>(RB7_GIFT, 200));
        rbSubItemSampler.addModel(new SampleModel<>(RB8_GIFT, 180));
    }

    private static void initRB2SubItemSampler() {
        Item rb21Gift = RB21_GIFT.clone();
        rb21Gift.setBoxRegular(true);
        rb2SubItemSampler.addModel(new SampleModel<>(rb21Gift, 3000));

        Item rb22Gift = RB22_GIFT.clone();
        rb22Gift.setBoxRegular(true);
        rb2SubItemSampler.addModel(new SampleModel<>(rb22Gift, 3000));

        Item rb23Gift = RB23_GIFT.clone();
        rb23Gift.setBoxRegular(true);
        rb2SubItemSampler.addModel(new SampleModel<>(rb23Gift, 3000));

        rb2SubItemSampler.addModel(new SampleModel<>(RB24_GIFT, 500));
        rb2SubItemSampler.addModel(new SampleModel<>(RB25_GIFT, 300));
        rb2SubItemSampler.addModel(new SampleModel<>(RB26_GIFT, 300));
        rb2SubItemSampler.addModel(new SampleModel<>(RB27_GIFT, 250));
        rb2SubItemSampler.addModel(new SampleModel<>(RB28_GIFT, 250));
        rb2SubItemSampler.addModel(new SampleModel<>(RB29_GIFT, 200));
        rb2SubItemSampler.addModel(new SampleModel<>(RB210_GIFT, 200));
    }

    private static void initABSubItemSampler() {
        Item ab1Gift = AB1_GIFT.clone();
        ab1Gift.setBoxRegular(true);
        abSubItemSampler.addModel(new SampleModel<>(ab1Gift, 3000));

        Item ab2Gift = AB2_GIFT.clone();
        ab2Gift.setBoxRegular(true);
        abSubItemSampler.addModel(new SampleModel<>(ab2Gift, 3000));

        Item ab3Gift = AB3_GIFT.clone();
        ab3Gift.setBoxRegular(true);
        abSubItemSampler.addModel(new SampleModel<>(ab3Gift, 3000));

        abSubItemSampler.addModel(new SampleModel<>(RB8_GIFT, 500));
        abSubItemSampler.addModel(new SampleModel<>(AB5_GIFT, 100));
        abSubItemSampler.addModel(new SampleModel<>(AB6_GIFT, 500));
    }

    private static void initAB2SubItemSampler() {
        Item ab21Gift = AB1_GIFT.clone();
        ab21Gift.setBoxRegular(true);
        ab2SubItemSampler.addModel(new SampleModel<>(ab21Gift, 3000));

        Item ab22Gift = AB2_GIFT.clone();
        ab22Gift.setBoxRegular(true);
        ab2SubItemSampler.addModel(new SampleModel<>(ab22Gift, 3000));

        Item ab23Gift = AB3_GIFT.clone();
        ab23Gift.setBoxRegular(true);
        ab2SubItemSampler.addModel(new SampleModel<>(ab23Gift, 3000));

        ab2SubItemSampler.addModel(new SampleModel<>(RB210_GIFT, 500));

        ab2SubItemSampler.addModel(new SampleModel<>(AB25_GIFT, 220));
        ab2SubItemSampler.addModel(new SampleModel<>(AB26_GIFT, 220));
        ab2SubItemSampler.addModel(new SampleModel<>(AB27_GIFT, 100));
        ab2SubItemSampler.addModel(new SampleModel<>(AB28_GIFT, 100));
    }

    private static void initDBSubItemSampler() {
        dbSubItemSampler.addModel(new SampleModel<>(DB1_GIFT, 200));

        Item db2Gift = DB2_GIFT.clone();
        db2Gift.setBoxRegular(true);
        dbSubItemSampler.addModel(new SampleModel<>(db2Gift, 3000));

        dbSubItemSampler.addModel(new SampleModel<>(AB5_GIFT, 600));

        Item db4Gift = DB4_GIFT.clone();
        db4Gift.setBoxRegular(true);
        dbSubItemSampler.addModel(new SampleModel<>(db4Gift, 3000));

        dbSubItemSampler.addModel(new SampleModel<>(DB5_GIFT, 600));
    }

    private static void initDB2SubItemSampler() {
        db2SubItemSampler.addModel(new SampleModel<>(DB1_GIFT, 200));
        db2SubItemSampler.addModel(new SampleModel<>(DB22_GIFT, 220));

        Item db23Gift = DB2_GIFT.clone();
        db23Gift.setBoxRegular(true);
        db2SubItemSampler.addModel(new SampleModel<>(db23Gift, 3000));

        db2SubItemSampler.addModel(new SampleModel<>(AB27_GIFT, 650));

        Item db25Gift = DB4_GIFT.clone();
        db25Gift.setBoxRegular(true);
        db2SubItemSampler.addModel(new SampleModel<>(db25Gift, 3000));

        db2SubItemSampler.addModel(new SampleModel<>(AB28_GIFT, 650));
        db2SubItemSampler.addModel(new SampleModel<>(DB5_GIFT, 600));
    }
}

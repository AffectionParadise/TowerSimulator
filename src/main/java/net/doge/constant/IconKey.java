package net.doge.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IconKey {
    // 头像
    AVATAR("Avatar"),
    // 终点
    DESTINATION("Destination"),
    // 一塔
    BASIC_TOWER("BasicTower"),
    // 二塔
    REGULAR_TOWER("RegularTower"),
    // 三塔
    ADVANCED_TOWER("AdvancedTower"),
    // 金塔
    DELUXE_TOWER("DeluxeTower"),
    // 密藏
    TREASURE("Treasure"),
    // 蘑菇金库
    MR_TREASURE("MRTreasure"),
    // 翻倍
    BONUS1("Bonus1"),
    BONUS2("Bonus2"),
    BONUS3("Bonus3"),
    // 礼物积分
    GIFT_POINTS("GiftPoints"),
    // 购买一塔牌子
    BASIC_STEP_TRANSACTION("BasicStepTransaction"),
    // 购买二塔牌子
    REGULAR_STEP_TRANSACTION("RegularStepTransaction"),
    // 购买三塔牌子
    ADVANCED_STEP_TRANSACTION("AdvancedStepTransaction"),

    // 币总数
    COIN_NUM("CoinNum"),
    // 不可见区域
    INVISIBLE("Invisible"),
    // 币
    COIN("Coin"),
    // 币(缩略图)
    COIN_THUMB("CoinThumb"),
    // 30 礼物
    BASIC_GIFT("BasicGift"),
    // 300 礼物
    REGULAR_GIFT("RegularGift"),
    // 10k 礼物
    REGULAR_GIFT_2("RegularGift2"),
    // 一塔牌子
    BASIC_STEP("BasicStep"),
    // 一塔牌子(缩略图)
    BASIC_STEP_THUMB("BasicStepThumb"),
    // 二塔牌子
    REGULAR_STEP("RegularStep"),
    // 二塔牌子(缩略图)
    REGULAR_STEP_THUMB("RegularStepThumb"),
    // 三塔牌子
    ADVANCED_STEP("AdvancedStep"),
    // 三塔牌子(缩略图)
    ADVANCED_STEP_THUMB("AdvancedStepThumb"),
    // 积累步数(缩略图)
    GATHERED_STEP_THUMB("GatheredStepThumb"),
    // 金塔牌子
    DELUXE_STEP("DeluxeStep"),
    // 金塔牌子(缩略图)
    DELUXE_STEP_THUMB("DeluxeStepThumb"),
    // 赠送金蘑菇
    REGULAR_COIN("RegularCoin"),
    // 金蘑菇
    ADVANCED_COIN("AdvancedCoin"),
    // 金蘑菇(缩略图)
    ADVANCED_COIN_THUMB("AdvancedCoinThumb"),
    // 雕像
    STATUE("Statue"),
    // 小盒子
    BASIC_BOX("BasicBox"),
    // 大盒子
    REGULAR_BOX("RegularBox"),
    // 大礼物宝盒
    RANDOM_GIFT_GROUP("RandomGiftGroup"),
    // 全屏
    ADVANCED_BOX("AdvancedBox"),
    // 辉煌
    DELUXE_BOX("DeluxeBox"),
    // 1m
    ADVANCED_GIFT("AdvancedGift"),
    // 500k
    ADVANCED_GIFT_2("AdvancedGift2"),
    // 情定爱琴海
    DELUXE_GIFT("DeluxeGift"),
    // 爱之天使号
    DELUXE_GIFT_2("DeluxeGift2"),
    // 玫瑰跑车-青花瓷
    DELUXE_GIFT_3("DeluxeGift3"),
    // 玫瑰跑车
    DELUXE_GIFT_4("DeluxeGift4"),
    // 起源·应龙
    ULTIMATE_GIFT("UltimateGift"),
    // 嘉年华孢子兑换券
    TICKET("Ticket"),

    // 大盒子子物品
    BB4_GIFT("bb4Gift"),
    BB5_GIFT("bb5Gift"),
    BB6_GIFT("bb6Gift"),
    BB7_GIFT("bb7Gift"),
    BB8_GIFT("bb8Gift"),
    BB9_GIFT("bb9Gift"),

    // 大盒子子物品
    RB1_GIFT("rb1Gift"),
    RB2_GIFT("rb2Gift"),
    RB3_GIFT("rb3Gift"),
    RB4_GIFT("rb4Gift"),
    RB5_GIFT("rb5Gift"),
    RB6_GIFT("rb6Gift"),
    RB7_GIFT("rb7Gift"),
    RB8_GIFT("rb8Gift"),

    // 全屏子物品
    AB1_GIFT("ab1Gift"),
    AB2_GIFT("ab2Gift"),
    AB3_GIFT("ab3Gift"),
    AB5_GIFT("ab5Gift"),
    AB6_GIFT("ab6Gift"),

    // 辉煌子物品
    DB1_GIFT("db1Gift"),
    DB2_GIFT("db2Gift"),
    DB4_GIFT("db4Gift"),
    DB5_GIFT("db5Gift");

    private final String value;
}

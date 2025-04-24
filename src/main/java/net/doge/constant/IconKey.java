package net.doge.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IconKey {
    // 头像
    AVATAR("Avatar"),
    // show 经验
    SHOW_EXP("ShowExp"),
    SHOW_EXP_THUMB("ShowExpThumb"),
    // 贵族
    NOBLE1("Noble1"),
    NOBLE2("Noble2"),
    NOBLE3("Noble3"),
    NOBLE4("Noble4"),
    NOBLE5("Noble5"),
    NOBLE6("Noble6"),
    NOBLE7("Noble7"),
    // 青花瓷会员
    VIP1("Vip1"),
    // 神龙会员
    VIP2("Vip2"),
    // 银河会员
    VIP3("Vip3"),

    // 终点
    DESTINATION("Destination"),
    // 一塔
    BASIC_TOWER("BasicTower"),
    // 二塔
    REGULAR_TOWER("RegularTower"),
    // 三塔
    ADVANCED_TOWER("AdvancedTower"),
    ADVANCED_TOWER_2("AdvancedTower2"),
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
    // 币
    COIN("Coin"),
    // 币(缩略图)
    COIN_THUMB("CoinThumb"),
    // 30 礼物
    BASIC_GIFT("BasicGift"),
    BASIC_GIFT_2("BasicGift2"),
    // 300 礼物
    REGULAR_GIFT("RegularGift"),
    REGULAR_GIFT_21("RegularGift21"),
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
    // 赠送金蘑菇(缩略图)
    REGULAR_COIN_THUMB("RegularCoinThumb"),
    // 金蘑菇
    ADVANCED_COIN("AdvancedCoin"),
    // 金蘑菇(缩略图)
    ADVANCED_COIN_THUMB("AdvancedCoinThumb"),
    // 雕像
    STATUE("Statue"),
    // 小碎片
    BASIC_SHARD("BasicShard"),
    // 中碎片
    REGULAR_SHARD("RegularShard"),
    // 大碎片
    ADVANCED_SHARD("AdvancedShard"),
    // 通用碎片
    COMMON_SHARD("CommonShard"),
    // 小盒子
    BASIC_BOX("BasicBox"),
    BASIC_BOX_2("BasicBox2"),
    // 大盒子
    REGULAR_BOX("RegularBox"),
    REGULAR_BOX_2("RegularBox2"),
    // 大礼物宝盒
    RANDOM_GIFT_GROUP("RandomGiftGroup"),
    // 全屏
    ADVANCED_BOX("AdvancedBox"),
    ADVANCED_BOX_2("AdvancedBox2"),
    // 辉煌
    DELUXE_BOX("DeluxeBox"),
    DELUXE_BOX_2("DeluxeBox2"),
    // 1m
    ADVANCED_GIFT("AdvancedGift"),
    ADVANCED_GIFT_21("AdvancedGift21"),
    // 500k
    ADVANCED_GIFT_2("AdvancedGift2"),
    ADVANCED_GIFT_22("AdvancedGift22"),
    // 情定爱琴海
    DELUXE_GIFT("DeluxeGift"),
    // 爱之天使号
    DELUXE_GIFT_2("DeluxeGift2"),
    // 玫瑰跑车-青花瓷
    DELUXE_GIFT_3("DeluxeGift3"),
    // 玫瑰跑车
    DELUXE_GIFT_4("DeluxeGift4"),
    // 玫瑰跑车-神龙
    DELUXE_GIFT_5("DeluxeGift5"),
    // 玫瑰跑车-银河
    DELUXE_GIFT_6("DeluxeGift6"),
    // 起源·应龙
    ULTIMATE_GIFT("UltimateGift"),
    // 起源·黑洞
    ULTIMATE_GIFT_2("UltimateGift2"),
    // 嘉年华孢子兑换券
    TICKET("Ticket"),
    // 好吃的骨头
    SKIN1("Skin1"),
    // 丘比特
    SKIN2("Skin2"),
    // 王子
    SKIN3("Skin3"),
    // 公主
    SKIN4("Skin4"),

    // 大盒子子物品
    BB4_GIFT("bb4Gift"),
    BB5_GIFT("bb5Gift"),
    BB6_GIFT("bb6Gift"),
    BB7_GIFT("bb7Gift"),
    BB8_GIFT("bb8Gift"),
    BB9_GIFT("bb9Gift"),

    // 大盒子子物品
    RB1_GIFT("rb1Gift"),
    RB21_GIFT("rb21Gift"),
    RB2_GIFT("rb2Gift"),
    RB22_GIFT("rb22Gift"),
    RB3_GIFT("rb3Gift"),
    RB23_GIFT("rb23Gift"),
    RB4_GIFT("rb4Gift"),
    RB24_GIFT("rb24Gift"),
    RB5_GIFT("rb5Gift"),
    RB25_GIFT("rb25Gift"),
    RB6_GIFT("rb6Gift"),
    RB26_GIFT("rb26Gift"),
    RB7_GIFT("rb7Gift"),
    RB27_GIFT("rb27Gift"),
    RB8_GIFT("rb8Gift"),
    RB28_GIFT("rb28Gift"),
    RB29_GIFT("rb29Gift"),

    // 全屏子物品
    AB1_GIFT("ab1Gift"),
    AB2_GIFT("ab2Gift"),
    AB3_GIFT("ab3Gift"),
    AB5_GIFT("ab5Gift"),
    AB25_GIFT("ab25Gift"),
    AB6_GIFT("ab6Gift"),
    AB26_GIFT("ab26Gift"),
    AB27_GIFT("ab27Gift"),

    // 辉煌子物品
    DB1_GIFT("db1Gift"),
    DB2_GIFT("db2Gift"),
    DB4_GIFT("db4Gift"),
    DB5_GIFT("db5Gift");

    private final String value;

    @Override
    public String toString() {
        return value;
    }
}

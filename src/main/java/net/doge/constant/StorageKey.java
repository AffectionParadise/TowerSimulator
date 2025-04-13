package net.doge.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StorageKey {
    // SHOW 经验
    SHOW_EXP("ShowExp"),
    // 金蘑菇消耗数量
    ADVANCED_COIN_CONSUMED("AdvancedCoinConsumed"),
    // 礼物经验
    GIFT_EXP("GiftExp"),
    // 三塔牌子经验
    ADVANCED_STEP_EXP("AdvancedStepExp"),
    // 三塔通关次数
    ADVANCED_TOWER_CLEARED("AdvancedTowerCleared"),
    // 金塔通关次数
    DELUXE_TOWER_CLEARED("DeluxeTowerCleared"),
    // 总价值
    TOTAL_VALUE("TotalValue"),
    // 礼物积分
    GIFT_POINTS("GiftPoints"),
    // 一塔牌子数量
    BASIC_STEP_NUM("BasicStepNum"),
    // 二塔牌子数量
    REGULAR_STEP_NUM("RegularStepNum"),
    // 三塔牌子数量
    ADVANCED_STEP_NUM("AdvancedStepNum"),
    // 积累步数
    GATHERED_STEP_NUM("GatheredStepNum"),
    // 金塔牌子数量
    DELUXE_STEP_NUM("DeluxeStepNum"),
    // 币数量
    COIN_NUM("CoinNum"),
    // 30 礼物数量
    BASIC_GIFT_NUM("BasicGiftNum"),
    // 300 礼物数量
    REGULAR_GIFT_NUM("RegularGiftNum"),
    // 10k 礼物数量
    REGULAR_GIFT_2_NUM("RegularGift2Num"),
    // 赠送金蘑菇数量
    REGULAR_COIN_NUM("RegularCoinNum"),
    // 金蘑菇数量
    ADVANCED_COIN_NUM("AdvancedCoinNum"),
    // 雕像数量
    STATUE_NUM("StatueNum"),
    // 小碎片数量
    BASIC_SHARD_NUM("BasicShardNum"),
    // 中碎片数量
    REGULAR_SHARD_NUM("RegularShardNum"),
    // 大碎片数量
    ADVANCED_SHARD_NUM("AdvancedShardNum"),
    // 通用碎片数量
    COMMON_SHARD_NUM("CommonShardNum"),
    // 小盒子数量
    BASIC_BOX_NUM("basicBoxNum"),
    // 大盒子数量
    REGULAR_BOX_NUM("RegularBoxNum"),
    // 全屏数量
    ADVANCED_BOX_NUM("AdvancedBoxNum"),
    // 辉煌数量
    DELUXE_BOX_NUM("DeluxeBoxNum"),
    // 1m 数量
    ADVANCED_GIFT_NUM("AdvancedGiftNum"),
    // 500k 数量
    ADVANCED_GIFT_2_NUM("AdvancedGift2Num"),
    // 情定爱琴海数量
    DELUXE_GIFT_NUM("DeluxeGiftNum"),
    // 爱之天使号数量
    DELUXE_GIFT_2_NUM("DeluxeGift2Num"),
    // 玫瑰跑车-青花瓷数量
    DELUXE_GIFT_3_NUM("DeluxeGift3Num"),
    // 玫瑰跑车数量
    DELUXE_GIFT_4_NUM("DeluxeGift4Num"),
    // 玫瑰跑车-神龙数量
    DELUXE_GIFT_5_NUM("DeluxeGift5Num"),
    // 玫瑰跑车-银河数量
    DELUXE_GIFT_6_NUM("DeluxeGift6Num"),
    // 起源·应龙数量
    ULTIMATE_GIFT_NUM("UltimateGiftNum"),
    // 起源·黑洞数量
    ULTIMATE_GIFT_2_NUM("UltimateGift2Num"),
    // 嘉年华孢子兑换券数量
    TICKET("Ticket"),
    // 好吃的骨头数量
    SKIN1_NUM("Skin1Num"),
    // 丘比特数量
    SKIN2_NUM("Skin2Num"),
    // 王子数量
    SKIN3_NUM("Skin3Num"),
    // 公主数量
    SKIN4_NUM("Skin4Num"),

    // 小盒子子物品数量
    BB4_GIFT_NUM("BB4GiftNum"),
    BB5_GIFT_NUM("BB5GiftNum"),
    BB6_GIFT_NUM("BB6GiftNum"),
    BB7_GIFT_NUM("BB7GiftNum"),
    BB8_GIFT_NUM("BB8GiftNum"),
    BB9_GIFT_NUM("BB9GiftNum"),

    // 大盒子子物品数量
    RB1_GIFT_NUM("RB1GiftNum"),
    RB2_GIFT_NUM("RB2GiftNum"),
    RB3_GIFT_NUM("RB3GiftNum"),
    RB4_GIFT_NUM("RB4GiftNum"),
    RB5_GIFT_NUM("RB5GiftNum"),
    RB6_GIFT_NUM("RB6GiftNum"),
    RB7_GIFT_NUM("RB7GiftNum"),
    RB8_GIFT_NUM("RB8GiftNum"),

    // 全屏子物品数量
    AB1_GIFT_NUM("AB1GiftNum"),
    AB2_GIFT_NUM("AB2GiftNum"),
    AB3_GIFT_NUM("AB3GiftNum"),
    AB5_GIFT_NUM("AB5GiftNum"),
    AB6_GIFT_NUM("AB6GiftNum"),

    // 辉煌子物品数量
    DB1_GIFT_NUM("DB1GiftNum"),
    DB2_GIFT_NUM("DB2GiftNum"),
    DB4_GIFT_NUM("DB4GiftNum"),
    DB5_GIFT_NUM("DB5GiftNum");

    private final String value;

    public static StorageKey find(String value) {
        for (StorageKey key : StorageKey.values()) {
            if (key.value.equals(value)) return key;
        }
        return null;
    }

    @Override
    public String toString() {
        return value;
    }
}

package net.doge.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StorageKey {
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
    // 起源·应龙数量
    ULTIMATE_GIFT_NUM("UltimateGiftNum"),
    // 嘉年华孢子兑换券数量
    TICKET("Ticket");

    private final String value;

    public static StorageKey find(String value) {
        for (StorageKey key : StorageKey.values()) {
            if (key.value.equals(value)) return key;
        }
        return null;
    }
}

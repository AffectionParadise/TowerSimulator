package net.doge.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 玩法类型
 */
@Getter
@AllArgsConstructor
public enum TrickType {
    // 双胞胎
    SAME2("双胞胎"),
    // 123
    DISORDER_123(" 123 无序"),
    // 1234
    DISORDER_1234(" 1234 无序"),
    // 3 胞胎
    SAME3(" 3 胞胎"),
    // 5 胞胎及以上
    SAME5(" 5 胞胎及以上"),
    // 6 胞胎及以上
    SAME6(" 6 胞胎及以上"),
    // 7 胞胎及以上
    SAME7(" 7 胞胎及以上"),
    // 单双
    OOE("全单或全双"),
    // 全十
    ALL10K("全十"),
    // 爆 10K
    EXTREME_10K("爆 10K"),
    // 爆大
    EXTREME_100K("爆大"),
    // 3 不同
    DIFF3(" 3 不同"),
    // 3 不同 10K
    DIFF3_10K(" 3 不同 10K"),
    // 3 不同 100K
    DIFF3_100K(" 3 不同 100K"),
    // 3 不同价值
    DIFF3_VALUE(" 3 不同价值"),
    // 4 不同
    DIFF4(" 4 不同"),
    // 6/3
    SPECIAL_63(" 6/3"),
    // 5/2
    SPECIAL_52(" 5/2"),
    // 二选一
    CHOICE_21("二选一"),
    // 三选一
    CHOICE_31("三选一"),
    // 四选一
    CHOICE_41("四选一");

    private final String name;

    @Override
    public String toString() {
        return name;
    }
}

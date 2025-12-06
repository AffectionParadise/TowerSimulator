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
    // 222/33/15
    DISORDER_222_33_15(" 222/33/15 无序"),
    // 222/33/15 含碎片
    DISORDER_222_33_15_WF(" 222/33/15 无序含碎片"),
    // 3 胞胎
    SAME3(" 3 胞胎"),
    // 4 胞胎
    SAME4(" 4 胞胎"),
    // 无 1
    NONE_1("无 1"),
    // 含 111 无序
    SUB_111("含 111 无序"),
    // 3 胞胎及以下
    SAME3_BELOW(" 3 胞胎及以下"),
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
    // 爆 300K
    EXTREME_300K("爆 300K"),
    // 爆 500K
    EXTREME_500K("爆 500K"),
    // 3 不同
    DIFF3(" 3 不同"),
    // 3 不同 10K
    DIFF3_10K(" 3 不同 10K"),
    // 3 不同 10K 不含隐藏
    DIFF3_10K_WOM(" 3 不同 10K 不含隐藏"),
    // 3 不同 10K 含隐藏
    DIFF3_10K_WM(" 3 不同 10K 含隐藏"),
    // 3 不同 100K
    DIFF3_100K(" 3 不同 100K"),
    // 3 不同价值
    DIFF3_VALUE(" 3 不同价值"),
    // 4 不同价值
    DIFF4_VALUE(" 4 不同价值"),
    // 4 不同
    DIFF4(" 4 不同"),
    // 06/3
    NONE_63("无 6/3"),
    // 09/3
    NONE_93("无 9/3"),
    // 6/3
    SPECIAL_63(" 6/3"),
    // 9/3
    SPECIAL_93(" 9/3"),
    // 05/2
    NONE_52("无 5/2"),
    // 08/2
    NONE_82("无 8/2"),
    // 5/2
    SPECIAL_52(" 5/2"),
    // 8/2
    SPECIAL_82(" 8/2"),
    // 二选一
    CHOICE_21("二选一"),
    // 三选一
    CHOICE_31("三选一"),
    // 四选一
    CHOICE_41("四选一"),
    // 多爆
    PACKED("多爆"),
    // 无多爆
    NOT_PACKED("无多爆");

    private final String name;

    @Override
    public String toString() {
        return name;
    }
}

package net.doge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.doge.constant.TrickType;

import java.util.*;

@Data
@AllArgsConstructor
public class Trick {
    // 类型
    private TrickType type;
    // 期望物品
    private Item itemExpected;
    // 期望数量
    private int numExpected;
    // 奖励物品
    private Item itemRewarded;
    // 奖励数量
    private int numRewarded;
    // 是否通过
    private boolean accepted;
    // 选择的物品
    private Item itemChosen;

    public Trick(TrickType type, Item itemExpected, int numExpected, Item itemRewarded, int numRewarded) {
        this.type = type;
        this.itemExpected = itemExpected;
        this.numExpected = numExpected;
        this.itemRewarded = itemRewarded;
        this.numRewarded = numRewarded;
    }

    public String getTitle() {
        return String.format("送出 %s 个%s，出现%s", numExpected, itemExpected.getName(), type.getName());
    }

    public boolean accept(GiftRecord record) {
        if (accepted) return false;
        Item itemPresented = record.getItemPresented();
        int numPresented = record.getNumPresented();
        if (!itemPresented.equals(itemExpected) || numPresented != numExpected) return false;
        List<GiftResult> results = record.getResults();
        boolean accepted = false;
        switch (type) {
            case SAME2:
                accepted = isSameN(results, 2);
                break;
            case DISORDER_123:
                accepted = isDisorder(results, Arrays.asList(1, 2, 3));
                break;
            case DISORDER_1234:
                accepted = isDisorder(results, Arrays.asList(1, 2, 3, 4));
                break;
            case DISORDER_222_33_15:
                accepted = isDisorder(results, Arrays.asList(2, 2, 2)) || isDisorder(results, Arrays.asList(3, 3)) || isDisorder(results, Arrays.asList(1, 5));
                break;
            case DISORDER_222_33_15_WF:
                accepted = (isDisorder(results, Arrays.asList(2, 2, 2)) || isDisorder(results, Arrays.asList(3, 3)) || isDisorder(results, Arrays.asList(1, 5))) && isWithFragment(results);
                break;
            case SAME3:
                accepted = isSameN(results, 3);
                break;
            case SAME4:
                accepted = isSameN(results, 4);
                break;
            case SAME3_BELOW:
                accepted = isSameNBelow(results, 3);
                break;
            case NONE_1:
                accepted = isNone(results, 1);
                break;
            case SUB_111:
                accepted = isSub(results, Arrays.asList(1, 1, 1));
                break;
            case SAME5:
                accepted = isSameN(results, 5);
                break;
            case SAME6:
                accepted = isSameN(results, 6);
                break;
            case SAME7:
                accepted = isSameN(results, 7);
                break;
            case SAME7_BELOW:
                accepted = isSameNBelow(results, 7);
                break;
            case SAME8:
                accepted = isSameN(results, 8);
                break;
            case SAME9:
                accepted = isSameN(results, 9);
                break;
            case SAME10:
                accepted = isSameN(results, 10);
                break;
            case OOE:
                accepted = isOOE(results, 1) || isOOE(results, 0);
                break;
            case ALL10K:
                accepted = isAllValue(results, 10000);
                break;
            case EXTREME_10K:
                accepted = isExtreme(results, 10000);
                break;
            case EXTREME_100K:
                accepted = isExtreme(results, 100000);
                break;
            case EXTREME_300K:
                accepted = isExtreme(results, 300000);
                break;
            case EXTREME_500K:
                accepted = isExtreme(results, 500000);
                break;
            case DIFF2_1K:
                accepted = results.size() == 2 && isAllValue(results, 1000);
                break;
            case DIFF3:
                accepted = results.size() == 3;
                break;
            case DIFF3_10K:
                accepted = results.size() == 3 && isAllValue(results, 10000);
                break;
            case DIFF3_10K_WOM:
                accepted = results.size() == 3 && isAllValue(results, 10000) && !isWithMystery(results);
                break;
            case DIFF3_10K_WM:
                accepted = results.size() == 3 && isAllValue(results, 10000) && isWithMystery(results);
                break;
            case DIFF3_100K:
                accepted = results.size() == 3 && isAllValue(results, 100000);
                break;
            case DIFF2_VALUE:
                accepted = results.size() == 2 && isDiffValue(results);
                break;
            case DIFF3_VALUE:
                accepted = results.size() == 3 && isDiffValue(results);
                break;
            case DIFF4_VALUE:
                accepted = results.size() == 4 && isDiffValue(results);
                break;
            case DIFF4:
                accepted = results.size() == 4;
                break;
            case NONE_63:
            case NONE_93:
            case NONE_52:
            case NONE_82:
                accepted = isAllBoxRegular(results);
                break;
            case SPECIAL_63:
            case SPECIAL_93:
            case SPECIAL_52:
            case SPECIAL_82:
                accepted = isAllNotBoxRegular(results);
                break;
            case SAME2_63:
            case SAME2_93:
            case SAME2_52:
            case SAME2_82:
                accepted = isSameN(results, 2) && isAllNotBoxRegular(results);
                break;
            case CHOICE_21:
            case CHOICE_31:
            case CHOICE_41:
                accepted = results.get(0).getItem().equals(itemChosen);
                break;
            case PACKED:
                accepted = isPacked(results, numPresented);
                break;
            case NOT_PACKED:
                accepted = !isPacked(results, numPresented);
                break;
        }
        this.accepted = accepted;
        return accepted;
    }

    // 重置
    public void reset() {
        accepted = false;
        itemChosen = null;
    }

    // 是否为选择类型的玩法
    public boolean isChoice() {
        return type == TrickType.CHOICE_21 || type == TrickType.CHOICE_31 || type == TrickType.CHOICE_41;
    }

    // 是否已选择
    public boolean isItemChosen() {
        return itemChosen != null;
    }

    // 判断是否为 n 胞胎及以上
    private boolean isSameN(List<GiftResult> results, int n) {
        for (GiftResult result : results) {
            if (result.getNum() >= n) return true;
        }
        return false;
    }

    // 判断是否全为 n 胞胎及以下
    private boolean isSameNBelow(List<GiftResult> results, int n) {
        for (GiftResult result : results) {
            if (result.getNum() > n) return false;
        }
        return true;
    }

    // 判断是否含碎片
    private boolean isWithFragment(List<GiftResult> results) {
        for (GiftResult result : results) {
            if (result.getItem().isFragment()) return true;
        }
        return false;
    }

    // 判断是否为某个数字序列(无序)
    private boolean isDisorder(List<GiftResult> results, List<Integer> numsExpected) {
        List<Integer> nums = new LinkedList<>();
        for (GiftResult result : results) nums.add(result.getNum());
        Collections.sort(nums);
        Collections.sort(numsExpected);
        return nums.equals(numsExpected);
    }

    // 判断是否不含某个数字
    private boolean isNone(List<GiftResult> results, int n) {
        for (GiftResult result : results) {
            if (result.getNum() == n) return false;
        }
        return true;
    }

    // 判断是否含某个数字序列(无序)
    private boolean isSub(List<GiftResult> results, List<Integer> numsExpected) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        // 统计每个数字出现次数
        for (GiftResult result : results) {
            int num = result.getNum();
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        // 消耗子序列中数字次数
        for (Integer num : numsExpected) {
            Integer count = freqMap.getOrDefault(num, 0);
            if (count == 0) return false;
            freqMap.put(num, count - 1);
        }
        return true;
    }

    // 判断是否为单/双
    private boolean isOOE(List<GiftResult> results, int mod) {
        for (GiftResult result : results) {
            if (result.getNum() % 2 != mod) return false;
        }
        return true;
    }

    // 判断是否含隐藏
    private boolean isWithMystery(List<GiftResult> results) {
        for (GiftResult result : results) {
            if (result.getItem().isMysterious()) return true;
        }
        return false;
    }

    // 判断是否为全为某个相同价值
    private boolean isAllValue(List<GiftResult> results, int value) {
        for (GiftResult result : results) {
            if (result.getItem().getValue() != value) return false;
        }
        return true;
    }

    // 判断 06/3 05/2 08/2
    private boolean isAllBoxRegular(List<GiftResult> results) {
        for (GiftResult result : results) {
            if (!result.getItem().isBoxRegular()) return false;
        }
        return true;
    }

    // 判断是否全部 6/3 5/2 8/2
    private boolean isAllNotBoxRegular(List<GiftResult> results) {
        for (GiftResult result : results) {
            if (result.getItem().isBoxRegular()) return false;
        }
        return true;
    }

    // 判断是否爆指定价值礼物
    private boolean isExtreme(List<GiftResult> results, int value) {
        for (GiftResult result : results) {
            if (result.getItem().getValue() == value) return true;
        }
        return false;
    }

    // 判断是否不同价值
    private boolean isDiffValue(List<GiftResult> results) {
        List<Integer> values = new LinkedList<>();
        for (GiftResult result : results) values.add(result.getItem().getValue());
        return values.size() == new HashSet<>(values).size();
    }

    // 判断是否多爆
    private boolean isPacked(List<GiftResult> results, int numPresented) {
        int num = 0;
        for (GiftResult result : results) num += result.getNum();
        return num > numPresented;
    }
}

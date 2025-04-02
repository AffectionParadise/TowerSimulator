package net.doge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.doge.constant.TrickType;
import net.doge.data.TrickData;

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

    public void accept(GiftRecord record) {
        if (accepted) return;
        Item itemPresented = record.getItemPresented();
        int numPresented = record.getNumPresented();
        List<GiftResult> results = record.getResults();
        if (!itemPresented.equals(itemExpected) || numPresented != numExpected) return;
        boolean accepted = false;
        switch (type) {
            case SAME2:
                accepted = isSameN(results, 2);
                break;
            case DISORDER_1234:
                accepted = isDisorder(results, Arrays.asList(1, 2, 3, 4));
                break;
            case SAME3:
                accepted = isSameN(results, 3);
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
            case OOE:
                accepted = isOOE(results, 1) || isOOE(results, 0);
                break;
            case ALL10K:
                accepted = isAllValue(results, 10000);
                break;
            case EXTREME:
                accepted = isExtreme(results);
                break;
            case DIFF3:
                accepted = results.size() == 3;
                break;
            case DIFF3_10K:
                accepted = results.size() == 3 && isAllValue(results, 10000);
                break;
            case DIFF3_100K:
                accepted = results.size() == 3 && isAllValue(results, 100000);
                break;
            case DIFF3_VALUE:
                accepted = results.size() == 3 && isDiffValue(results);
                break;
            case DIFF4:
                accepted = results.size() == 4;
                break;
            case SPECIAL_63:
            case SPECIAL_52:
                accepted = !results.get(0).getItem().isBoxRegular();
                break;
            case CHOICE_21:
            case CHOICE_31:
            case CHOICE_41:
                accepted = results.get(0).getItem().equals(itemChosen);
                break;
        }
        this.accepted = accepted;
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

    // 判断是否为 n 胞胎
    private boolean isSameN(List<GiftResult> results, int n) {
        for (GiftResult result : results) {
            if (result.getNum() >= n) return true;
        }
        return false;
    }

    // 判断是否为某个数字序列
    private boolean isDisorder(List<GiftResult> results, List<Integer> numsExpected) {
        List<Integer> nums = new LinkedList<>();
        for (GiftResult result : results) nums.add(result.getNum());
        Collections.sort(nums);
        Collections.sort(numsExpected);
        return nums.equals(numsExpected);
    }

    // 判断是否为单/双
    private boolean isOOE(List<GiftResult> results, int mod) {
        for (GiftResult result : results) {
            if (result.getNum() % 2 != mod) return false;
        }
        return true;
    }

    // 判断是否为全十
    private boolean isAllValue(List<GiftResult> results, int value) {
        for (GiftResult result : results) {
            if (result.getItem().getValue() != value) return false;
        }
        return true;
    }

    // 判断是否爆大
    private boolean isExtreme(List<GiftResult> results) {
        for (GiftResult result : results) {
            if (result.getItem().getValue() == 100000) return true;
        }
        return false;
    }

    // 判断是否不同价值
    private boolean isDiffValue(List<GiftResult> results) {
        List<Integer> values = new LinkedList<>();
        for (GiftResult result : results) values.add(result.getItem().getValue());
        return values.size() == new HashSet<>(values).size();
    }
}

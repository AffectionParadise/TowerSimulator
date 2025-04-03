package net.doge.model;

import lombok.Data;
import net.doge.constant.IconKey;

@Data
public class Bonus {
    // 图标 key
    private IconKey iconKey;
    // 最小倍率
    private int minRate;
    // 最大倍率
    private int maxRate;
    // 倍数生成器
    private Sampler<Integer> rateSampler;
    // 步数物品
    private Item stepItem;
    // 步数消耗
    private int stepCost;
    // 持续步数
    private int duration;
    // 剩余步数
    private int stepLeft;

    public Bonus(IconKey iconKey, int minRate, int maxRate, Sampler<Integer> rateSampler, Item stepItem, int stepCost, int duration) {
        this.iconKey = iconKey;
        this.minRate = minRate;
        this.maxRate = maxRate;
        this.rateSampler = rateSampler;
        this.stepItem = stepItem;
        this.stepCost = stepCost;
        this.duration = duration;
    }

    // 重置剩余步数
    public void reset() {
        stepLeft = duration;
    }

    // 消耗
    public void consume() {
        stepLeft--;
    }
}

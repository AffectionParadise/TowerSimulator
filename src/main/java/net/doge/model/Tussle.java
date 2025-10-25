package net.doge.model;

import lombok.Data;
import net.doge.constant.TussleStatus;

@Data
public class Tussle {
    // 总时间(s)
    private int duration;
    // 开始时的时间戳
    private long startTs;
    // 状态
    private TussleStatus status;
    // 目标礼物价值
    private int targetValue;
    // 当前礼物价值
    private int currValue;
    // 奖励物品
    private Item itemReceived;
    // 奖励数量
    private int numReceived;

    public Tussle(int duration, int targetValue, Item itemReceived, int numReceived) {
        this.duration = duration;
        this.targetValue = targetValue;
        this.itemReceived = itemReceived;
        this.numReceived = numReceived;
    }

    public void setStatus(TussleStatus status) {
        this.status = status;
        if (status == TussleStatus.PROGRESSING) startTs = System.currentTimeMillis();
    }

    public boolean isProgressing() {
        return status == TussleStatus.PROGRESSING;
    }

    // 是否达标
    public boolean isSuccess() {
        return currValue >= targetValue;
    }

    public void addCurrValue(int amount) {
        currValue += amount;
    }

    // 重置
    public void reset() {
        status = TussleStatus.SPARE;
        currValue = 0;
    }
}

package net.doge.model;

import lombok.Data;
import net.doge.constant.QuizStatus;
import net.doge.data.ItemData;

@Data
public class Quiz {
    // 标题
    private String title;
    // 标题物品
    private Item titleItem;
    // 筹码物品
    private Item chipItem;
    // 状态
    private QuizStatus status;
    // 预期结果
    private int expectedNum;
    // 实际数量
    private int actualNum;
    // 投入数量
    private int stakeNum;

    public Quiz(String title, Item chipItem) {
        this.title = title;
        this.chipItem = chipItem;
        setStatus(QuizStatus.SPARE);
    }

    public void setStatus(QuizStatus status) {
        this.status = status;
        if (status == QuizStatus.SPARE) titleItem = ItemData.quizItemSampler.lottery().getItem();
    }

    public boolean isStatus(QuizStatus status) {
        return this.status == status;
    }

    public String getPrefixText() {
        String text;
        if (status == QuizStatus.SPARE || status == QuizStatus.WAITING) text = "下一关";
        else if (status == QuizStatus.PROGRESSING) text = "本关";
        else text = "指定关卡";
        return text;
    }

    public static String getQuizText(int num) {
        return num == 1 ? "奇数" : "偶数";
    }

    public void raise(int stepNum) {
        this.stakeNum += stepNum;
    }

    public int getSuccessStakeNum() {
        return stakeNum * 2;
    }

    public boolean isSuccess() {
        return actualNum % 2 == expectedNum;
    }
}

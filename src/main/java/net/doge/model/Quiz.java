package net.doge.model;

import lombok.Data;
import net.doge.constant.QuizStatus;
import net.doge.data.ItemData;

@Data
public class Quiz {
    // 竞猜物品生成器
    private Sampler<Item> quizItemSampler = new Sampler<>();

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
    // 下注上限
    private int maxStakeNum;

    public Quiz(String title, Item chipItem, int maxStakeNum) {
        this.title = title;
        this.chipItem = chipItem;
        this.maxStakeNum = maxStakeNum;
        // 竞猜物品
        for (Item item : ItemData.items) {
            if (item.isGuessable()) quizItemSampler.addModel(new SampleModel<>(item, 200));
        }
        refresh();
    }

    public void refresh() {
        status = QuizStatus.SPARE;
        titleItem = quizItemSampler.lottery().getItem();
        actualNum = 0;
        stakeNum = 0;
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

    public void addActualNum(int amount) {
        this.actualNum += amount;
    }

    public boolean isSuccess() {
        return actualNum % 2 == expectedNum;
    }

    // 判断是否在指定塔中进行竞猜
    public boolean isCompatible(Tower tower) {
        for (SampleModel<Item> model : tower.getItemSampler().getModels()) {
            if (model.getItem().equals(titleItem)) return true;
        }
        return false;
    }
}

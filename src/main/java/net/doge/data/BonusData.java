package net.doge.data;

import net.doge.constant.IconKey;
import net.doge.model.Bonus;
import net.doge.model.SampleModel;
import net.doge.model.Sampler;
import net.doge.util.ListUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * 翻倍数据
 */
public class BonusData {
    // 翻倍
    public static List<Bonus> bonuses = new LinkedList<>();

    public static Bonus BONUS2;

    static {
        initData();
    }

    private static void initData() {
        Sampler<Integer> sampler = new Sampler<>();
        sampler.addModelsLinearWeights(ListUtil.ofRange(3, 10), 5000, 10);
        bonuses.add(new Bonus(IconKey.BONUS1, 3, 10, sampler, ItemData.ADVANCED_STEP, 5, 30));

        sampler = new Sampler<>();
        sampler.addModelsLinearWeights(ListUtil.ofRange(5, 16), 10000, 10);
        sampler.addModel(new SampleModel<>(100, 1));
        bonuses.add(BONUS2 = new Bonus(IconKey.BONUS2, 5, 100, sampler, ItemData.ADVANCED_STEP, 10, 30));

        sampler = new Sampler<>();
        sampler.addModelsLinearWeights(ListUtil.ofRange(1, 5), 2000, 10);
        bonuses.add(new Bonus(IconKey.BONUS3, 1, 5, sampler, ItemData.ADVANCED_STEP, 2, 30));
    }
}

package net.doge.data;

import net.doge.constant.IconKey;
import net.doge.model.Bonus;
import net.doge.model.Event;
import net.doge.model.SampleModel;
import net.doge.model.Sampler;

import java.util.LinkedList;
import java.util.List;

/**
 * 翻倍数据
 */
public class BonusData {
    // 翻倍
    public static List<Bonus> bonuses = new LinkedList<>();

    static {
        initData();
    }

    private static void initData() {
        Sampler<Integer> sampler = new Sampler<>();
        sampler.addModel(new SampleModel<>(3, 2000));
        sampler.addModel(new SampleModel<>(4, 1800));
        sampler.addModel(new SampleModel<>(5, 1400));
        sampler.addModel(new SampleModel<>(6, 600));
        sampler.addModel(new SampleModel<>(7, 300));
        sampler.addModel(new SampleModel<>(8, 150));
        sampler.addModel(new SampleModel<>(9, 75));
        sampler.addModel(new SampleModel<>(10, 10));
        bonuses.add(new Bonus(IconKey.BONUS1, 3, 10, sampler, ItemData.ADVANCED_STEP, 5, 30));

        sampler = new Sampler<>();
        sampler.addModel(new SampleModel<>(5, 2000));
        sampler.addModel(new SampleModel<>(6, 1900));
        sampler.addModel(new SampleModel<>(7, 1500));
        sampler.addModel(new SampleModel<>(8, 1000));
        sampler.addModel(new SampleModel<>(9, 400));
        sampler.addModel(new SampleModel<>(10, 120));
        sampler.addModel(new SampleModel<>(11, 60));
        sampler.addModel(new SampleModel<>(12, 50));
        sampler.addModel(new SampleModel<>(13, 40));
        sampler.addModel(new SampleModel<>(14, 30));
        sampler.addModel(new SampleModel<>(15, 20));
        sampler.addModel(new SampleModel<>(100, 1));
        bonuses.add(new Bonus(IconKey.BONUS2, 5, 100, sampler, ItemData.ADVANCED_STEP, 10, 30));

        sampler = new Sampler<>();
        sampler.addModel(new SampleModel<>(1, 1000));
        sampler.addModel(new SampleModel<>(2, 800));
        sampler.addModel(new SampleModel<>(3, 400));
        sampler.addModel(new SampleModel<>(4, 80));
        sampler.addModel(new SampleModel<>(5, 20));
        bonuses.add(new Bonus(IconKey.BONUS3, 1, 5, sampler, ItemData.ADVANCED_STEP, 2, 30));
    }
}

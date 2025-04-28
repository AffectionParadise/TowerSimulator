package net.doge.data;

import net.doge.model.SampleModel;
import net.doge.model.Sampler;
import net.doge.model.Tussle;

/**
 * 角逐数据
 */
public class TussleData {
    // 角逐
    public static Sampler<Tussle> tussleSampler = new Sampler<>();
    public static Tussle currTussle;

    static {
        initData();
    }

    private static void initData() {
        // 5 分钟
        tussleSampler.addModel(new SampleModel<>(new Tussle(300, 500000, ItemData.ADVANCED_STEP, 10), 200));
        tussleSampler.addModel(new SampleModel<>(new Tussle(300, 1000000, ItemData.ADVANCED_STEP, 18), 200));
        tussleSampler.addModel(new SampleModel<>(new Tussle(300, 2000000, ItemData.ADVANCED_STEP, 32), 200));
        tussleSampler.addModel(new SampleModel<>(new Tussle(300, 5000000, ItemData.ADVANCED_STEP, 68), 200));
        // 10 分钟
        tussleSampler.addModel(new SampleModel<>(new Tussle(600, 1000000, ItemData.ADVANCED_STEP, 18), 200));
        tussleSampler.addModel(new SampleModel<>(new Tussle(600, 2000000, ItemData.ADVANCED_STEP, 32), 200));
        tussleSampler.addModel(new SampleModel<>(new Tussle(600, 5000000, ItemData.ADVANCED_STEP, 68), 200));
        tussleSampler.addModel(new SampleModel<>(new Tussle(600, 10000000, ItemData.ADVANCED_STEP, 128), 200));
        // 20 分钟
        tussleSampler.addModel(new SampleModel<>(new Tussle(1200, 2000000, ItemData.ADVANCED_STEP, 26), 200));
        tussleSampler.addModel(new SampleModel<>(new Tussle(1200, 5000000, ItemData.ADVANCED_STEP, 58), 200));
        tussleSampler.addModel(new SampleModel<>(new Tussle(1200, 10000000, ItemData.ADVANCED_STEP, 96), 200));
        tussleSampler.addModel(new SampleModel<>(new Tussle(1200, 20000000, ItemData.ADVANCED_STEP, 188), 200));
        tussleSampler.addModel(new SampleModel<>(new Tussle(1200, 50000000, ItemData.ADVANCED_STEP, 368), 200));
        // 30 分钟
        tussleSampler.addModel(new SampleModel<>(new Tussle(1800, 5000000, ItemData.ADVANCED_STEP, 38), 200));
        tussleSampler.addModel(new SampleModel<>(new Tussle(1800, 10000000, ItemData.ADVANCED_STEP, 68), 200));
        tussleSampler.addModel(new SampleModel<>(new Tussle(1800, 20000000, ItemData.ADVANCED_STEP, 128), 200));
        tussleSampler.addModel(new SampleModel<>(new Tussle(1800, 50000000, ItemData.ADVANCED_STEP, 288), 200));
        tussleSampler.addModel(new SampleModel<>(new Tussle(1800, 88000000, ItemData.ADVANCED_STEP, 666), 150));
        tussleSampler.addModel(new SampleModel<>(new Tussle(1800, 100000000, ItemData.ADVANCED_STEP, 888), 100));

        refresh();
    }

    public static void refresh() {
        currTussle = tussleSampler.lottery().getItem();
        currTussle.reset();
    }
}

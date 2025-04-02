package net.doge.data;

import net.doge.constant.TrickType;
import net.doge.model.SampleModel;
import net.doge.model.Sampler;
import net.doge.model.Trick;

public class TrickData {
    public static Sampler<Trick> trickSampler;

    public static Trick currTrick;

    // 小盒子
    public static final Trick BASIC_BOX_SAME2 = new Trick(TrickType.SAME2, ItemData.BASIC_BOX, 2, ItemData.ADVANCED_STEP, 1);
    public static final Trick BASIC_BOX_DIFF3_VALUE = new Trick(TrickType.DIFF3_VALUE, ItemData.BASIC_BOX, 3, ItemData.ADVANCED_STEP, 3);
    public static final Trick BASIC_BOX_DISORDER_1234 = new Trick(TrickType.DISORDER_1234, ItemData.BASIC_BOX, 10, ItemData.ADVANCED_STEP, 8);
    public static final Trick BASIC_BOX_SAME5 = new Trick(TrickType.SAME5, ItemData.BASIC_BOX, 10, ItemData.ADVANCED_STEP, 8);
    public static final Trick BASIC_BOX_OOE = new Trick(TrickType.OOE, ItemData.BASIC_BOX, 10, ItemData.ADVANCED_STEP, 12);
    public static final Trick BASIC_BOX_CHOICE_41 = new Trick(TrickType.CHOICE_41, ItemData.BASIC_BOX, 1, ItemData.ADVANCED_STEP, 1);
    // 大盒子
    public static final Trick REGULAR_BOX_SAME2 = new Trick(TrickType.SAME2, ItemData.REGULAR_BOX, 2, ItemData.ADVANCED_STEP, 8);
    public static final Trick REGULAR_BOX_SAME3 = new Trick(TrickType.SAME3, ItemData.REGULAR_BOX, 3, ItemData.ADVANCED_STEP, 12);
    public static final Trick REGULAR_BOX_DISORDER_1234 = new Trick(TrickType.DISORDER_1234, ItemData.REGULAR_BOX, 10, ItemData.ADVANCED_STEP, 16);
    public static final Trick REGULAR_BOX_SAME5 = new Trick(TrickType.SAME5, ItemData.REGULAR_BOX, 10, ItemData.ADVANCED_STEP, 16);
    public static final Trick REGULAR_BOX_SAME6 = new Trick(TrickType.SAME6, ItemData.REGULAR_BOX, 10, ItemData.ADVANCED_STEP, 28);
    public static final Trick REGULAR_BOX_SAME7 = new Trick(TrickType.SAME7, ItemData.REGULAR_BOX, 10, ItemData.ADVANCED_STEP, 48);
    public static final Trick REGULAR_BOX_OOE = new Trick(TrickType.OOE, ItemData.REGULAR_BOX, 10, ItemData.ADVANCED_STEP, 20);
    public static final Trick REGULAR_BOX_ALL10K = new Trick(TrickType.ALL10K, ItemData.REGULAR_BOX, 10, ItemData.ADVANCED_STEP, 12);
    public static final Trick REGULAR_BOX_EXTREME = new Trick(TrickType.EXTREME, ItemData.REGULAR_BOX, 10, ItemData.ADVANCED_STEP, 16);
    public static final Trick REGULAR_BOX_DIFF3 = new Trick(TrickType.DIFF3, ItemData.REGULAR_BOX, 3, ItemData.ADVANCED_STEP, 6);
    public static final Trick REGULAR_BOX_DIFF3_10K = new Trick(TrickType.DIFF3_10K, ItemData.REGULAR_BOX, 3, ItemData.ADVANCED_STEP, 8);
    public static final Trick REGULAR_BOX_DIFF3_VALUE = new Trick(TrickType.DIFF3_VALUE, ItemData.REGULAR_BOX, 3, ItemData.ADVANCED_STEP, 48);
    public static final Trick REGULAR_BOX_DIFF4 = new Trick(TrickType.DIFF4, ItemData.REGULAR_BOX, 4, ItemData.ADVANCED_STEP, 16);
    public static final Trick REGULAR_BOX_CHOICE_31 = new Trick(TrickType.CHOICE_31, ItemData.REGULAR_BOX, 1, ItemData.ADVANCED_STEP, 3);
    // 全屏
    public static final Trick ADVANCED_BOX_SAME2 = new Trick(TrickType.SAME2, ItemData.ADVANCED_BOX, 2, ItemData.ADVANCED_STEP, 16);
    public static final Trick ADVANCED_BOX_SAME3 = new Trick(TrickType.SAME3, ItemData.ADVANCED_BOX, 3, ItemData.ADVANCED_STEP, 26);
    public static final Trick ADVANCED_BOX_DISORDER_1234 = new Trick(TrickType.DISORDER_1234, ItemData.ADVANCED_BOX, 10, ItemData.ADVANCED_STEP, 28);
    public static final Trick ADVANCED_BOX_SAME5 = new Trick(TrickType.SAME5, ItemData.ADVANCED_BOX, 10, ItemData.ADVANCED_STEP, 28);
    public static final Trick ADVANCED_BOX_DIFF3 = new Trick(TrickType.DIFF3, ItemData.ADVANCED_BOX, 3, ItemData.ADVANCED_STEP, 16);
    public static final Trick ADVANCED_BOX_DIFF3_100K = new Trick(TrickType.DIFF3_100K, ItemData.ADVANCED_BOX, 3, ItemData.ADVANCED_STEP, 20);
    public static final Trick ADVANCED_BOX_SPECIAL_63 = new Trick(TrickType.SPECIAL_63, ItemData.ADVANCED_BOX, 1, ItemData.ADVANCED_STEP, 12);
    public static final Trick ADVANCED_BOX_CHOICE_31 = new Trick(TrickType.CHOICE_31, ItemData.ADVANCED_BOX, 1, ItemData.ADVANCED_STEP, 8);
    // 辉煌
    public static final Trick DELUXE_BOX_SAME2 = new Trick(TrickType.SAME2, ItemData.DELUXE_BOX, 2, ItemData.ADVANCED_STEP, 20);
    public static final Trick DELUXE_BOX_SPECIAL_52 = new Trick(TrickType.SPECIAL_52, ItemData.DELUXE_BOX, 1, ItemData.ADVANCED_STEP, 16);
    public static final Trick DELUXE_BOX_CHOICE_21 = new Trick(TrickType.CHOICE_21, ItemData.DELUXE_BOX, 1, ItemData.ADVANCED_STEP, 8);

    static {
        initData();
    }

    private static void initData() {
        trickSampler = new Sampler<>();

        trickSampler.addModel(new SampleModel<>(BASIC_BOX_SAME2, 200));
        trickSampler.addModel(new SampleModel<>(BASIC_BOX_DIFF3_VALUE, 200));
        trickSampler.addModel(new SampleModel<>(BASIC_BOX_DISORDER_1234, 200));
        trickSampler.addModel(new SampleModel<>(BASIC_BOX_SAME5, 200));
        trickSampler.addModel(new SampleModel<>(BASIC_BOX_OOE, 200));
        trickSampler.addModel(new SampleModel<>(BASIC_BOX_CHOICE_41, 200));
        trickSampler.addModel(new SampleModel<>(REGULAR_BOX_SAME2, 200));
        trickSampler.addModel(new SampleModel<>(REGULAR_BOX_SAME3, 200));
        trickSampler.addModel(new SampleModel<>(REGULAR_BOX_DISORDER_1234, 200));
        trickSampler.addModel(new SampleModel<>(REGULAR_BOX_SAME5, 200));
        trickSampler.addModel(new SampleModel<>(REGULAR_BOX_SAME6, 180));
        trickSampler.addModel(new SampleModel<>(REGULAR_BOX_SAME7, 150));
        trickSampler.addModel(new SampleModel<>(REGULAR_BOX_OOE, 200));
        trickSampler.addModel(new SampleModel<>(REGULAR_BOX_ALL10K, 200));
        trickSampler.addModel(new SampleModel<>(REGULAR_BOX_EXTREME, 200));
        trickSampler.addModel(new SampleModel<>(REGULAR_BOX_DIFF3, 200));
        trickSampler.addModel(new SampleModel<>(REGULAR_BOX_DIFF3_10K, 200));
        trickSampler.addModel(new SampleModel<>(REGULAR_BOX_DIFF3_VALUE, 100));
        trickSampler.addModel(new SampleModel<>(REGULAR_BOX_DIFF4, 200));
        trickSampler.addModel(new SampleModel<>(REGULAR_BOX_CHOICE_31, 200));
        trickSampler.addModel(new SampleModel<>(ADVANCED_BOX_SAME2, 200));
        trickSampler.addModel(new SampleModel<>(ADVANCED_BOX_SAME3, 200));
        trickSampler.addModel(new SampleModel<>(ADVANCED_BOX_DISORDER_1234, 200));
        trickSampler.addModel(new SampleModel<>(ADVANCED_BOX_SAME5, 200));
        trickSampler.addModel(new SampleModel<>(ADVANCED_BOX_DIFF3, 200));
        trickSampler.addModel(new SampleModel<>(ADVANCED_BOX_DIFF3_100K, 200));
        trickSampler.addModel(new SampleModel<>(ADVANCED_BOX_SPECIAL_63, 200));
        trickSampler.addModel(new SampleModel<>(ADVANCED_BOX_CHOICE_31, 200));
        trickSampler.addModel(new SampleModel<>(DELUXE_BOX_SAME2, 200));
        trickSampler.addModel(new SampleModel<>(DELUXE_BOX_SPECIAL_52, 200));
        trickSampler.addModel(new SampleModel<>(DELUXE_BOX_CHOICE_21, 200));

        refresh();
    }

    public static void refresh() {
        if (currTrick != null) currTrick.reset();
        currTrick = TrickData.trickSampler.lottery().getItem();
    }
}

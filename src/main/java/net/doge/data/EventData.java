package net.doge.data;

import net.doge.model.Event;
import net.doge.model.SampleModel;
import net.doge.model.Sampler;

/**
 * 事件数据
 */
public class EventData {
    // 事件生成器
    public static Sampler<Event> eventSampler = new Sampler<>();

    // 无
    public static final Event NOTHING = new Event();
    // 礼物翻倍
    public static final Event BONUS_TRIGGER = new Event();
    // 中级密藏
    public static final Event REGULAR_TREASURE = new Event(TowerData.REGULAR_TREASURE);
    // 高级密藏
    public static final Event ADVANCED_TREASURE = new Event(TowerData.ADVANCED_TREASURE);
    // 超级密藏
    public static final Event DELUXE_TREASURE = new Event(TowerData.DELUXE_TREASURE);
    // 究极密藏
    public static final Event ULTIMATE_TREASURE = new Event(TowerData.ULTIMATE_TREASURE);
    // 蘑菇塔
    public static final Event MR_TREASURE = new Event(TowerData.MR_TREASURE);

    static {
        initData();
    }

    private static void initData() {
        eventSampler.addModel(new SampleModel<>(NOTHING, 30000));
        eventSampler.addModel(new SampleModel<>(BONUS_TRIGGER, 25));
        eventSampler.addModel(new SampleModel<>(REGULAR_TREASURE, 15));
        eventSampler.addModel(new SampleModel<>(ADVANCED_TREASURE, 10));
        eventSampler.addModel(new SampleModel<>(DELUXE_TREASURE, 5));
        eventSampler.addModel(new SampleModel<>(ULTIMATE_TREASURE, 1));
        eventSampler.addModel(new SampleModel<>(MR_TREASURE, 30));
    }

    // 判断是否无事件
    public static boolean isNothing(Event event) {
        return event == NOTHING;
    }

    // 判断是否是礼物翻倍
    public static boolean isBonusTrigger(Event event) {
        return event == BONUS_TRIGGER;
    }

    // 判断某个事件是否为密藏
    public static boolean isTreasure(Event event) {
        return event == REGULAR_TREASURE
                || event == ADVANCED_TREASURE
                || event == DELUXE_TREASURE
                || event == ULTIMATE_TREASURE
                || event == MR_TREASURE;
    }
}

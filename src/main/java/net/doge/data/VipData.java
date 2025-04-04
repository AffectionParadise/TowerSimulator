package net.doge.data;

import net.doge.constant.Colors;
import net.doge.constant.IconKey;
import net.doge.model.Bonus;
import net.doge.model.SampleModel;
import net.doge.model.Sampler;
import net.doge.model.Vip;
import net.doge.ui.widget.color.GColor;

import java.util.LinkedList;
import java.util.List;

/**
 * 会员数据
 */
public class VipData {
    // 会员
    public static List<Vip> vips = new LinkedList<>();

    static {
        initData();
    }

    private static void initData() {
        vips.add(new Vip("青花瓷会员", IconKey.VIP1, GColor.LIGHT_BLUE, "青花瓷至臻福利", ItemData.DELUXE_GIFT_4, ItemData.DELUXE_GIFT_3, ItemData.ADVANCED_COIN, 58888, 500));
        vips.add(new Vip("神龙会员", IconKey.VIP2, GColor.DARK_ORANGE, "来自神龙的召唤", ItemData.DELUXE_GIFT_4, ItemData.DELUXE_GIFT_5, ItemData.ADVANCED_COIN, 108888, 1000));
        vips.add(new Vip("银河会员", IconKey.VIP3, GColor.DARK_PURPLE, "来自银河的眷顾", ItemData.DELUXE_GIFT_4, ItemData.DELUXE_GIFT_6, ItemData.ADVANCED_COIN, 368888, 1000));
    }
}

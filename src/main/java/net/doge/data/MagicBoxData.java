package net.doge.data;

import net.doge.model.Compound;
import net.doge.model.Item;
import net.doge.model.SampleModel;
import net.doge.model.Sampler;
import net.doge.util.ListUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * 魔盒数据
 */
public class MagicBoxData {
    // 魔盒
    public static List<Compound> compounds = new LinkedList<>();

    static {
        initRegularKeyCompound();
        initAdvancedKeyCompound();
        initDeluxeKeyCompound();
    }

    // 传说钥匙
    private static void initRegularKeyCompound() {
        Sampler<Item> regularKeySampler = new Sampler<>();

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 2), 500, 100);
        regularBoxNS.addModelsLinearWeights(ListUtil.ofRange(3, 10), 50, 1);
        Item regularBox = ItemData.REGULAR_BOX.clone();
        regularBox.setNumSampler(regularBoxNS);
        regularKeySampler.addModel(new SampleModel<>(regularBox, 800));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 3), 500, 50);
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(4, 10), 10, 1);
        Item advancedBox = ItemData.ADVANCED_BOX.clone();
        advancedBox.setNumSampler(advancedBoxNS);
        regularKeySampler.addModel(new SampleModel<>(advancedBox, 150));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 2), 500, 50);
        deluxeBoxNS.addModelsLinearWeights(ListUtil.ofRange(3, 10), 10, 1);
        Item deluxeBox = ItemData.DELUXE_BOX.clone();
        deluxeBox.setNumSampler(deluxeBoxNS);
        regularKeySampler.addModel(new SampleModel<>(deluxeBox, 30));

        Sampler<Integer> advancedGiftNS = new Sampler<>();
        advancedGiftNS.addModel(new SampleModel<>(1, 200));
        advancedGiftNS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 10, 1);
        Item advancedGift = ItemData.ADVANCED_GIFT.clone();
        advancedGift.setNumSampler(advancedGiftNS);
        regularKeySampler.addModel(new SampleModel<>(advancedGift, 5));

        Sampler<Integer> advancedGift2NS = new Sampler<>();
        advancedGift2NS.addModel(new SampleModel<>(1, 200));
        advancedGift2NS.addModelsLinearWeights(ListUtil.ofRange(2, 5), 10, 1);
        Item advancedGift2 = ItemData.ADVANCED_GIFT_2.clone();
        advancedGift2.setNumSampler(advancedGift2NS);
        regularKeySampler.addModel(new SampleModel<>(advancedGift2, 10));

        regularKeySampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_3, 3));

        regularKeySampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT, 3));

        regularKeySampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_2, 5));

        regularKeySampler.addModel(new SampleModel<>(ItemData.ULTIMATE_GIFT_3, 2));

        regularKeySampler.addModel(new SampleModel<>(ItemData.ULTIMATE_GIFT, 2));

        regularKeySampler.addModel(new SampleModel<>(ItemData.ULTIMATE_GIFT_2, 2));

        regularKeySampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_6, 1));

        compounds.add(new Compound(ItemData.REGULAR_KEY, 1, regularKeySampler));
    }

    // 至臻钥匙
    private static void initAdvancedKeyCompound() {
        Sampler<Item> advancedKeySampler = new Sampler<>();

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 2), 500, 200);
        regularBoxNS.addModelsLinearWeights(ListUtil.ofRange(3, 10), 80, 1);
        Item regularBox = ItemData.REGULAR_BOX.clone();
        regularBox.setNumSampler(regularBoxNS);
        advancedKeySampler.addModel(new SampleModel<>(regularBox, 200));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 3), 500, 100);
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(4, 10), 50, 1);
        Item advancedBox = ItemData.ADVANCED_BOX.clone();
        advancedBox.setNumSampler(advancedBoxNS);
        advancedKeySampler.addModel(new SampleModel<>(advancedBox, 500));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 2), 500, 80);
        deluxeBoxNS.addModelsLinearWeights(ListUtil.ofRange(3, 10), 20, 1);
        Item deluxeBox = ItemData.DELUXE_BOX.clone();
        deluxeBox.setNumSampler(deluxeBoxNS);
        advancedKeySampler.addModel(new SampleModel<>(deluxeBox, 140));

        Sampler<Integer> advancedGiftNS = new Sampler<>();
        advancedGiftNS.addModel(new SampleModel<>(1, 200));
        advancedGiftNS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 20, 1);
        Item advancedGift = ItemData.ADVANCED_GIFT.clone();
        advancedGift.setNumSampler(advancedGiftNS);
        advancedKeySampler.addModel(new SampleModel<>(advancedGift, 40));

        Sampler<Integer> advancedGift2NS = new Sampler<>();
        advancedGift2NS.addModel(new SampleModel<>(1, 200));
        advancedGift2NS.addModelsLinearWeights(ListUtil.ofRange(2, 5), 20, 1);
        Item advancedGift2 = ItemData.ADVANCED_GIFT_2.clone();
        advancedGift2.setNumSampler(advancedGift2NS);
        advancedKeySampler.addModel(new SampleModel<>(advancedGift2, 80));

        advancedKeySampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_3, 4));

        advancedKeySampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT, 4));

        advancedKeySampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_2, 6));

        advancedKeySampler.addModel(new SampleModel<>(ItemData.ULTIMATE_GIFT_3, 3));

        advancedKeySampler.addModel(new SampleModel<>(ItemData.ULTIMATE_GIFT, 3));

        advancedKeySampler.addModel(new SampleModel<>(ItemData.ULTIMATE_GIFT_2, 3));

        advancedKeySampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_6, 2));

        compounds.add(new Compound(ItemData.ADVANCED_KEY, 1, advancedKeySampler));
    }

    // 辉煌钥匙
    private static void initDeluxeKeyCompound() {
        Sampler<Item> deluxeKeySampler = new Sampler<>();

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 3), 500, 150);
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(4, 10), 80, 1);
        Item advancedBox = ItemData.ADVANCED_BOX.clone();
        advancedBox.setNumSampler(advancedBoxNS);
        deluxeKeySampler.addModel(new SampleModel<>(advancedBox, 200));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 2), 500, 150);
        deluxeBoxNS.addModelsLinearWeights(ListUtil.ofRange(3, 10), 80, 1);
        Item deluxeBox = ItemData.DELUXE_BOX.clone();
        deluxeBox.setNumSampler(deluxeBoxNS);
        deluxeKeySampler.addModel(new SampleModel<>(deluxeBox, 400));

        Sampler<Integer> advancedGiftNS = new Sampler<>();
        advancedGiftNS.addModel(new SampleModel<>(1, 200));
        advancedGiftNS.addModelsLinearWeights(ListUtil.ofRange(2, 3), 40, 1);
        Item advancedGift = ItemData.ADVANCED_GIFT.clone();
        advancedGift.setNumSampler(advancedGiftNS);
        deluxeKeySampler.addModel(new SampleModel<>(advancedGift, 100));

        Sampler<Integer> advancedGift2NS = new Sampler<>();
        advancedGift2NS.addModel(new SampleModel<>(1, 200));
        advancedGift2NS.addModelsLinearWeights(ListUtil.ofRange(2, 5), 40, 1);
        Item advancedGift2 = ItemData.ADVANCED_GIFT_2.clone();
        advancedGift2.setNumSampler(advancedGift2NS);
        deluxeKeySampler.addModel(new SampleModel<>(advancedGift2, 200));

        deluxeKeySampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_3, 5));

        deluxeKeySampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT, 5));

        deluxeKeySampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_2, 7));

        deluxeKeySampler.addModel(new SampleModel<>(ItemData.ULTIMATE_GIFT_3, 4));

        deluxeKeySampler.addModel(new SampleModel<>(ItemData.ULTIMATE_GIFT, 4));

        deluxeKeySampler.addModel(new SampleModel<>(ItemData.ULTIMATE_GIFT_2, 4));

        deluxeKeySampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_6, 3));

        compounds.add(new Compound(ItemData.DELUXE_KEY, 1, deluxeKeySampler));
    }
}

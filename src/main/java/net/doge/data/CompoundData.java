package net.doge.data;

import net.doge.model.Compound;
import net.doge.model.Item;
import net.doge.model.SampleModel;
import net.doge.model.Sampler;
import net.doge.util.ListUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * 礼物合成数据
 */
public class CompoundData {
    // 合成
    public static List<Compound> compounds = new LinkedList<>();

    static {
        initBasicBoxCompound();
        initRegularBoxCompound();
        initAdvancedBoxCompound();
    }

    private static void initBasicBoxCompound() {
        Sampler<Item> basicBoxSampler = new Sampler<>();
        Sampler<Item> basicBox2Sampler = new Sampler<>();

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModelsLinearWeights(ListUtil.ofRange(298, 198), 200, 50);
        advancedCoinNS.addModelsLinearWeights(ListUtil.ofRange(299, 598), 150, 10);
        Item advancedCoin = ItemData.ADVANCED_COIN.clone();
        advancedCoin.setNumSampler(advancedCoinNS);
        basicBoxSampler.addModel(new SampleModel<>(advancedCoin, 800));
        basicBox2Sampler.addModel(new SampleModel<>(advancedCoin, 800));

        Sampler<Integer> advancedStepNS = new Sampler<>();
        advancedStepNS.addModelsLinearWeights(ListUtil.ofRange(1, 3), 500, 100);
        Item advancedStep = ItemData.ADVANCED_STEP.clone();
        advancedStep.setNumSampler(advancedStepNS);
        basicBoxSampler.addModel(new SampleModel<>(advancedStep, 800));
        basicBox2Sampler.addModel(new SampleModel<>(advancedStep, 800));

        Sampler<Integer> basicBoxNS = new Sampler<>();
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(9, 5), 200, 50);
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(11, 16), 150, 10);
        Item basicBox = ItemData.BASIC_BOX.clone();
        Item basicBox2 = ItemData.BASIC_BOX_2.clone();
        basicBox.setNumSampler(basicBoxNS);
        basicBox2.setNumSampler(basicBoxNS);
        basicBoxSampler.addModel(new SampleModel<>(basicBox, 2000));
        basicBox2Sampler.addModel(new SampleModel<>(basicBox2, 2000));

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 2), 500, 100);
        regularBoxNS.addModelsLinearWeights(ListUtil.ofRange(3, 10), 50, 1);
        Item regularBox = ItemData.REGULAR_BOX.clone();
        Item regularBox2 = ItemData.REGULAR_BOX_2.clone();
        regularBox.setNumSampler(regularBoxNS);
        regularBox2.setNumSampler(regularBoxNS);
        basicBoxSampler.addModel(new SampleModel<>(regularBox, 100));
        basicBox2Sampler.addModel(new SampleModel<>(regularBox2, 100));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 2), 200, 10);
        Item advancedBox = ItemData.ADVANCED_BOX.clone();
        Item advancedBox2 = ItemData.ADVANCED_BOX_2.clone();
        advancedBox.setNumSampler(advancedBoxNS);
        advancedBox2.setNumSampler(advancedBoxNS);
        basicBoxSampler.addModel(new SampleModel<>(advancedBox, 10));
        basicBox2Sampler.addModel(new SampleModel<>(advancedBox2, 10));

        basicBoxSampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_4, 1));
        basicBox2Sampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_4, 1));

        compounds.add(new Compound(ItemData.BASIC_BOX, 10, basicBoxSampler));
        compounds.add(new Compound(ItemData.BASIC_BOX_2, 10, basicBox2Sampler));
    }

    private static void initRegularBoxCompound() {
        Sampler<Item> regularBoxSampler = new Sampler<>();
        Sampler<Item> regularBox2Sampler = new Sampler<>();

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModelsLinearWeights(ListUtil.ofRange(1490, 894), 200, 50);
        advancedCoinNS.addModelsLinearWeights(ListUtil.ofRange(1491, 2086), 150, 10);
        Item advancedCoin = ItemData.ADVANCED_COIN.clone();
        advancedCoin.setNumSampler(advancedCoinNS);
        regularBoxSampler.addModel(new SampleModel<>(advancedCoin, 800));
        regularBox2Sampler.addModel(new SampleModel<>(advancedCoin, 800));

        Sampler<Integer> advancedStepNS = new Sampler<>();
        advancedStepNS.addModelsLinearWeights(ListUtil.ofRange(5, 3), 400, 150);
        advancedStepNS.addModelsLinearWeights(ListUtil.ofRange(6, 10), 200, 10);
        Item advancedStep = ItemData.ADVANCED_STEP.clone();
        advancedStep.setNumSampler(advancedStepNS);
        regularBoxSampler.addModel(new SampleModel<>(advancedStep, 800));
        regularBox2Sampler.addModel(new SampleModel<>(advancedStep, 800));

        Sampler<Integer> basicBoxNS = new Sampler<>();
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(50, 30), 200, 50);
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(51, 70), 150, 10);
        Item basicBox = ItemData.BASIC_BOX.clone();
        Item basicBox2 = ItemData.BASIC_BOX_2.clone();
        basicBox.setNumSampler(basicBoxNS);
        basicBox2.setNumSampler(basicBoxNS);
        regularBoxSampler.addModel(new SampleModel<>(basicBox, 600));
        regularBox2Sampler.addModel(new SampleModel<>(basicBox2, 600));

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModelsLinearWeights(ListUtil.ofRange(4, 3), 400, 150);
        regularBoxNS.addModelsLinearWeights(ListUtil.ofRange(6, 10), 200, 1);
        Item regularBox = ItemData.REGULAR_BOX.clone();
        Item regularBox2 = ItemData.REGULAR_BOX_2.clone();
        regularBox.setNumSampler(regularBoxNS);
        regularBox2.setNumSampler(regularBoxNS);
        regularBoxSampler.addModel(new SampleModel<>(regularBox, 2000));
        regularBox2Sampler.addModel(new SampleModel<>(regularBox2, 2000));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 2), 400, 150);
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(3, 5), 100, 10);
        Item advancedBox = ItemData.ADVANCED_BOX.clone();
        Item advancedBox2 = ItemData.ADVANCED_BOX_2.clone();
        advancedBox.setNumSampler(advancedBoxNS);
        advancedBox2.setNumSampler(advancedBoxNS);
        regularBoxSampler.addModel(new SampleModel<>(advancedBox, 100));
        regularBox2Sampler.addModel(new SampleModel<>(advancedBox2, 100));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModel(new SampleModel<>(1, 990));
        deluxeBoxNS.addModel(new SampleModel<>(2, 10));
        Item deluxeBox = ItemData.DELUXE_BOX.clone();
        Item deluxeBox2 = ItemData.DELUXE_BOX_2.clone();
        deluxeBox.setNumSampler(deluxeBoxNS);
        deluxeBox2.setNumSampler(deluxeBoxNS);
        regularBoxSampler.addModel(new SampleModel<>(deluxeBox, 20));
        regularBox2Sampler.addModel(new SampleModel<>(deluxeBox2, 20));

        regularBoxSampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_4, 5));
        regularBox2Sampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_4, 5));

        compounds.add(new Compound(ItemData.REGULAR_BOX, 5, regularBoxSampler));
        compounds.add(new Compound(ItemData.REGULAR_BOX_2, 5, regularBox2Sampler));
    }

    private static void initAdvancedBoxCompound() {
        Sampler<Item> advancedBoxSampler = new Sampler<>();
        Sampler<Item> advancedBox2Sampler = new Sampler<>();

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModelsLinearWeights(ListUtil.ofRange(2980, 1490), 200, 50);
        advancedCoinNS.addModelsLinearWeights(ListUtil.ofRange(2981, 4470), 150, 10);
        Item advancedCoin = ItemData.ADVANCED_COIN.clone();
        advancedCoin.setNumSampler(advancedCoinNS);
        advancedBoxSampler.addModel(new SampleModel<>(advancedCoin, 800));
        advancedBox2Sampler.addModel(new SampleModel<>(advancedCoin, 800));

        Sampler<Integer> advancedStepNS = new Sampler<>();
        advancedStepNS.addModelsLinearWeights(ListUtil.ofRange(10, 5), 400, 150);
        advancedStepNS.addModelsLinearWeights(ListUtil.ofRange(11, 20), 200, 10);
        Item advancedStep = ItemData.ADVANCED_STEP.clone();
        advancedStep.setNumSampler(advancedStepNS);
        advancedBoxSampler.addModel(new SampleModel<>(advancedStep, 800));
        advancedBox2Sampler.addModel(new SampleModel<>(advancedStep, 800));

        Sampler<Integer> basicBoxNS = new Sampler<>();
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(100, 60), 200, 50);
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(101, 150), 150, 10);
        Item basicBox = ItemData.BASIC_BOX.clone();
        Item basicBox2 = ItemData.BASIC_BOX_2.clone();
        basicBox.setNumSampler(basicBoxNS);
        basicBox2.setNumSampler(basicBoxNS);
        advancedBoxSampler.addModel(new SampleModel<>(basicBox, 600));
        advancedBox2Sampler.addModel(new SampleModel<>(basicBox2, 600));

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModelsLinearWeights(ListUtil.ofRange(10, 5), 400, 150);
        regularBoxNS.addModelsLinearWeights(ListUtil.ofRange(11, 16), 200, 1);
        Item regularBox = ItemData.REGULAR_BOX.clone();
        Item regularBox2 = ItemData.REGULAR_BOX_2.clone();
        regularBox.setNumSampler(regularBoxNS);
        regularBox2.setNumSampler(regularBoxNS);
        advancedBoxSampler.addModel(new SampleModel<>(regularBox, 2000));
        advancedBox2Sampler.addModel(new SampleModel<>(regularBox2, 2000));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 5), 600, 100);
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(6, 10), 50, 10);
        Item advancedBox = ItemData.ADVANCED_BOX.clone();
        Item advancedBox2 = ItemData.ADVANCED_BOX_2.clone();
        advancedBox.setNumSampler(advancedBoxNS);
        advancedBox2.setNumSampler(advancedBoxNS);
        advancedBoxSampler.addModel(new SampleModel<>(advancedBox, 100));
        advancedBox2Sampler.addModel(new SampleModel<>(advancedBox2, 100));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 2), 600, 100);
        deluxeBoxNS.addModelsLinearWeights(ListUtil.ofRange(3, 5), 50, 10);
        Item deluxeBox = ItemData.DELUXE_BOX.clone();
        Item deluxeBox2 = ItemData.DELUXE_BOX_2.clone();
        deluxeBox.setNumSampler(deluxeBoxNS);
        deluxeBox2.setNumSampler(deluxeBoxNS);
        advancedBoxSampler.addModel(new SampleModel<>(deluxeBox, 20));
        advancedBox2Sampler.addModel(new SampleModel<>(deluxeBox2, 20));

        Sampler<Integer> advancedGiftNS = new Sampler<>();
        advancedGiftNS.addModel(new SampleModel<>(1, 990));
        advancedGiftNS.addModel(new SampleModel<>(2, 10));
        Item advancedGift = ItemData.ADVANCED_GIFT.clone();
        Item advancedGift21 = ItemData.ADVANCED_GIFT_21.clone();
        advancedGift.setNumSampler(advancedGiftNS);
        advancedGift21.setNumSampler(advancedGiftNS);
        advancedBoxSampler.addModel(new SampleModel<>(advancedGift, 10));
        advancedBox2Sampler.addModel(new SampleModel<>(advancedGift21, 10));

        advancedBoxSampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_4, 6));
        advancedBox2Sampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_4, 6));

        compounds.add(new Compound(ItemData.ADVANCED_BOX, 1, advancedBoxSampler));
        compounds.add(new Compound(ItemData.ADVANCED_BOX_2, 1, advancedBox2Sampler));
    }
}

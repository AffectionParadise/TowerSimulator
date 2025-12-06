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
        Sampler<Item> basicBoxCSampler = new Sampler<>();
        Sampler<Item> basicBoxMSampler = new Sampler<>();
        Sampler<Item> basicBoxSSampler = new Sampler<>();

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModelsLinearWeights(ListUtil.ofRange(298, 198), 300, 100);
        advancedCoinNS.addModelsLinearWeights(ListUtil.ofRange(299, 598), 100, 10);
        Item advancedCoin = ItemData.ADVANCED_COIN.clone();
        advancedCoin.setNumSampler(advancedCoinNS);
        basicBoxSampler.addModel(new SampleModel<>(advancedCoin, 800));
        basicBox2Sampler.addModel(new SampleModel<>(advancedCoin, 800));
        basicBoxCSampler.addModel(new SampleModel<>(advancedCoin, 800));
        basicBoxMSampler.addModel(new SampleModel<>(advancedCoin, 800));
        basicBoxSSampler.addModel(new SampleModel<>(advancedCoin, 800));

        Sampler<Integer> advancedStepNS = new Sampler<>();
        advancedStepNS.addModelsLinearWeights(ListUtil.ofRange(1, 3), 500, 100);
        Item advancedStep = ItemData.ADVANCED_STEP.clone();
        advancedStep.setNumSampler(advancedStepNS);
        basicBoxSampler.addModel(new SampleModel<>(advancedStep, 800));
        basicBox2Sampler.addModel(new SampleModel<>(advancedStep, 800));
        basicBoxCSampler.addModel(new SampleModel<>(advancedStep, 800));
        basicBoxMSampler.addModel(new SampleModel<>(advancedStep, 800));
        basicBoxSSampler.addModel(new SampleModel<>(advancedStep, 800));

        Sampler<Integer> basicBoxNS = new Sampler<>();
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(9, 5), 200, 50);
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(11, 15), 50, 10);
        Item basicBox = ItemData.BASIC_BOX.clone();
        Item basicBox2 = ItemData.BASIC_BOX_2.clone();
        Item basicBoxC = ItemData.BASIC_BOX_C.clone();
        Item basicBoxM = ItemData.BASIC_BOX_M.clone();
        Item basicBoxS = ItemData.BASIC_BOX_S.clone();
        basicBox.setNumSampler(basicBoxNS);
        basicBox2.setNumSampler(basicBoxNS);
        basicBoxC.setNumSampler(basicBoxNS);
        basicBoxM.setNumSampler(basicBoxNS);
        basicBoxS.setNumSampler(basicBoxNS);
        basicBoxSampler.addModel(new SampleModel<>(basicBox, 2000));
        basicBox2Sampler.addModel(new SampleModel<>(basicBox2, 2000));
        basicBoxCSampler.addModel(new SampleModel<>(basicBoxC, 2000));
        basicBoxMSampler.addModel(new SampleModel<>(basicBoxM, 2000));
        basicBoxSSampler.addModel(new SampleModel<>(basicBoxS, 2000));

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 2), 300, 100);
        regularBoxNS.addModelsLinearWeights(ListUtil.ofRange(3, 10), 100, 1);
        Item regularBox = ItemData.REGULAR_BOX.clone();
        Item regularBox2 = ItemData.REGULAR_BOX_2.clone();
        Item regularBoxC = ItemData.REGULAR_BOX_C.clone();
        Item regularBoxM = ItemData.REGULAR_BOX_M.clone();
        Item regularBoxS = ItemData.REGULAR_BOX_S.clone();
        regularBox.setNumSampler(regularBoxNS);
        regularBox2.setNumSampler(regularBoxNS);
        regularBoxC.setNumSampler(regularBoxNS);
        regularBoxM.setNumSampler(regularBoxNS);
        regularBoxS.setNumSampler(regularBoxNS);
        basicBoxSampler.addModel(new SampleModel<>(regularBox, 100));
        basicBox2Sampler.addModel(new SampleModel<>(regularBox2, 100));
        basicBoxCSampler.addModel(new SampleModel<>(regularBoxC, 100));
        basicBoxMSampler.addModel(new SampleModel<>(regularBoxM, 100));
        basicBoxSSampler.addModel(new SampleModel<>(regularBoxS, 100));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 2), 200, 10);
        Item advancedBox = ItemData.ADVANCED_BOX.clone();
        Item advancedBox2 = ItemData.ADVANCED_BOX_2.clone();
        Item advancedBoxC = ItemData.ADVANCED_BOX_C.clone();
        Item advancedBoxM = ItemData.ADVANCED_BOX_M.clone();
        Item advancedBoxS = ItemData.ADVANCED_BOX_S.clone();
        advancedBox.setNumSampler(advancedBoxNS);
        advancedBox2.setNumSampler(advancedBoxNS);
        advancedBoxC.setNumSampler(advancedBoxNS);
        advancedBoxM.setNumSampler(advancedBoxNS);
        advancedBoxS.setNumSampler(advancedBoxNS);
        basicBoxSampler.addModel(new SampleModel<>(advancedBox, 10));
        basicBox2Sampler.addModel(new SampleModel<>(advancedBox2, 10));
        basicBoxCSampler.addModel(new SampleModel<>(advancedBoxC, 10));
        basicBoxMSampler.addModel(new SampleModel<>(advancedBoxM, 10));
        basicBoxSSampler.addModel(new SampleModel<>(advancedBoxS, 10));

        basicBoxSampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_4, 1));
        basicBox2Sampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_4, 1));
        basicBoxCSampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_4, 1));
        basicBoxMSampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_4, 1));
        basicBoxSSampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_4, 1));

        compounds.add(new Compound(ItemData.BASIC_BOX, 10, basicBoxSampler));
        compounds.add(new Compound(ItemData.BASIC_BOX_2, 10, basicBox2Sampler));
        compounds.add(new Compound(ItemData.BASIC_BOX_C, 10, basicBoxCSampler));
        compounds.add(new Compound(ItemData.BASIC_BOX_M, 10, basicBoxMSampler));
        compounds.add(new Compound(ItemData.BASIC_BOX_S, 10, basicBoxSSampler));
    }

    private static void initRegularBoxCompound() {
        Sampler<Item> regularBoxSampler = new Sampler<>();
        Sampler<Item> regularBox2Sampler = new Sampler<>();
        Sampler<Item> regularBoxCSampler = new Sampler<>();
        Sampler<Item> regularBoxMSampler = new Sampler<>();
        Sampler<Item> regularBoxSSampler = new Sampler<>();

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModelsLinearWeights(ListUtil.ofRange(1490, 894), 200, 50);
        advancedCoinNS.addModelsLinearWeights(ListUtil.ofRange(1491, 2086), 50, 10);
        Item advancedCoin = ItemData.ADVANCED_COIN.clone();
        advancedCoin.setNumSampler(advancedCoinNS);
        regularBoxSampler.addModel(new SampleModel<>(advancedCoin, 800));
        regularBox2Sampler.addModel(new SampleModel<>(advancedCoin, 800));
        regularBoxCSampler.addModel(new SampleModel<>(advancedCoin, 800));
        regularBoxMSampler.addModel(new SampleModel<>(advancedCoin, 800));
        regularBoxSSampler.addModel(new SampleModel<>(advancedCoin, 800));

        Sampler<Integer> advancedStepNS = new Sampler<>();
        advancedStepNS.addModelsLinearWeights(ListUtil.ofRange(5, 3), 400, 150);
        advancedStepNS.addModelsLinearWeights(ListUtil.ofRange(6, 10), 150, 10);
        Item advancedStep = ItemData.ADVANCED_STEP.clone();
        advancedStep.setNumSampler(advancedStepNS);
        regularBoxSampler.addModel(new SampleModel<>(advancedStep, 800));
        regularBox2Sampler.addModel(new SampleModel<>(advancedStep, 800));
        regularBoxCSampler.addModel(new SampleModel<>(advancedStep, 800));
        regularBoxMSampler.addModel(new SampleModel<>(advancedStep, 800));
        regularBoxSSampler.addModel(new SampleModel<>(advancedStep, 800));

        Sampler<Integer> basicBoxNS = new Sampler<>();
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(50, 30), 200, 50);
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(51, 70), 50, 10);
        Item basicBox = ItemData.BASIC_BOX.clone();
        Item basicBox2 = ItemData.BASIC_BOX_2.clone();
        Item basicBoxC = ItemData.BASIC_BOX_C.clone();
        Item basicBoxM = ItemData.BASIC_BOX_M.clone();
        Item basicBoxS = ItemData.BASIC_BOX_S.clone();
        basicBox.setNumSampler(basicBoxNS);
        basicBox2.setNumSampler(basicBoxNS);
        basicBoxC.setNumSampler(basicBoxNS);
        basicBoxM.setNumSampler(basicBoxNS);
        basicBoxS.setNumSampler(basicBoxNS);
        regularBoxSampler.addModel(new SampleModel<>(basicBox, 600));
        regularBox2Sampler.addModel(new SampleModel<>(basicBox2, 600));
        regularBoxCSampler.addModel(new SampleModel<>(basicBoxC, 600));
        regularBoxMSampler.addModel(new SampleModel<>(basicBoxM, 600));
        regularBoxSSampler.addModel(new SampleModel<>(basicBoxS, 600));

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModelsLinearWeights(ListUtil.ofRange(4, 3), 400, 150);
        regularBoxNS.addModelsLinearWeights(ListUtil.ofRange(6, 10), 150, 10);
        Item regularBox = ItemData.REGULAR_BOX.clone();
        Item regularBox2 = ItemData.REGULAR_BOX_2.clone();
        Item regularBoxC = ItemData.REGULAR_BOX_C.clone();
        Item regularBoxM = ItemData.REGULAR_BOX_M.clone();
        Item regularBoxS = ItemData.REGULAR_BOX_S.clone();
        regularBox.setNumSampler(regularBoxNS);
        regularBox2.setNumSampler(regularBoxNS);
        regularBoxC.setNumSampler(regularBoxNS);
        regularBoxM.setNumSampler(regularBoxNS);
        regularBoxS.setNumSampler(regularBoxNS);
        regularBoxSampler.addModel(new SampleModel<>(regularBox, 2000));
        regularBox2Sampler.addModel(new SampleModel<>(regularBox2, 2000));
        regularBoxCSampler.addModel(new SampleModel<>(regularBoxC, 2000));
        regularBoxMSampler.addModel(new SampleModel<>(regularBoxM, 2000));
        regularBoxSSampler.addModel(new SampleModel<>(regularBoxS, 2000));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 2), 300, 100);
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(3, 5), 50, 1);
        Item advancedBox = ItemData.ADVANCED_BOX.clone();
        Item advancedBox2 = ItemData.ADVANCED_BOX_2.clone();
        Item advancedBoxC = ItemData.ADVANCED_BOX_C.clone();
        Item advancedBoxM = ItemData.ADVANCED_BOX_M.clone();
        Item advancedBoxS = ItemData.ADVANCED_BOX_S.clone();
        advancedBox.setNumSampler(advancedBoxNS);
        advancedBox2.setNumSampler(advancedBoxNS);
        advancedBoxC.setNumSampler(advancedBoxNS);
        advancedBoxM.setNumSampler(advancedBoxNS);
        advancedBoxS.setNumSampler(advancedBoxNS);
        regularBoxSampler.addModel(new SampleModel<>(advancedBox, 100));
        regularBox2Sampler.addModel(new SampleModel<>(advancedBox2, 100));
        regularBoxCSampler.addModel(new SampleModel<>(advancedBoxC, 100));
        regularBoxMSampler.addModel(new SampleModel<>(advancedBoxM, 100));
        regularBoxSSampler.addModel(new SampleModel<>(advancedBoxS, 100));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModel(new SampleModel<>(1, 990));
        deluxeBoxNS.addModel(new SampleModel<>(2, 10));
        Item deluxeBox = ItemData.DELUXE_BOX.clone();
        Item deluxeBox2 = ItemData.DELUXE_BOX_2.clone();
        Item deluxeBoxS = ItemData.DELUXE_BOX_S.clone();
        deluxeBox.setNumSampler(deluxeBoxNS);
        deluxeBox2.setNumSampler(deluxeBoxNS);
        deluxeBoxS.setNumSampler(deluxeBoxNS);
        regularBoxSampler.addModel(new SampleModel<>(deluxeBox, 20));
        regularBox2Sampler.addModel(new SampleModel<>(deluxeBox2, 20));
        regularBoxSSampler.addModel(new SampleModel<>(deluxeBoxS, 20));

        regularBoxSampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_4, 3));
        regularBox2Sampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_4, 3));
        regularBoxCSampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_4, 3));
        regularBoxMSampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_4, 3));
        regularBoxSSampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_4, 3));

        compounds.add(new Compound(ItemData.REGULAR_BOX, 5, regularBoxSampler));
        compounds.add(new Compound(ItemData.REGULAR_BOX_2, 5, regularBox2Sampler));
        compounds.add(new Compound(ItemData.REGULAR_BOX_C, 5, regularBoxCSampler));
        compounds.add(new Compound(ItemData.REGULAR_BOX_M, 5, regularBoxMSampler));
        compounds.add(new Compound(ItemData.REGULAR_BOX_S, 5, regularBoxSSampler));
    }

    private static void initAdvancedBoxCompound() {
        Sampler<Item> advancedBoxSampler = new Sampler<>();
        Sampler<Item> advancedBox2Sampler = new Sampler<>();
        Sampler<Item> advancedBoxCSampler = new Sampler<>();
        Sampler<Item> advancedBoxMSampler = new Sampler<>();
        Sampler<Item> advancedBoxSSampler = new Sampler<>();

        Sampler<Integer> advancedCoinNS = new Sampler<>();
        advancedCoinNS.addModelsLinearWeights(ListUtil.ofRange(2980, 1490), 200, 50);
        advancedCoinNS.addModelsLinearWeights(ListUtil.ofRange(2981, 4470), 50, 10);
        Item advancedCoin = ItemData.ADVANCED_COIN.clone();
        advancedCoin.setNumSampler(advancedCoinNS);
        advancedBoxSampler.addModel(new SampleModel<>(advancedCoin, 800));
        advancedBox2Sampler.addModel(new SampleModel<>(advancedCoin, 800));
        advancedBoxCSampler.addModel(new SampleModel<>(advancedCoin, 800));
        advancedBoxMSampler.addModel(new SampleModel<>(advancedCoin, 800));
        advancedBoxSSampler.addModel(new SampleModel<>(advancedCoin, 800));

        Sampler<Integer> advancedStepNS = new Sampler<>();
        advancedStepNS.addModelsLinearWeights(ListUtil.ofRange(10, 5), 400, 150);
        advancedStepNS.addModelsLinearWeights(ListUtil.ofRange(11, 20), 150, 10);
        Item advancedStep = ItemData.ADVANCED_STEP.clone();
        advancedStep.setNumSampler(advancedStepNS);
        advancedBoxSampler.addModel(new SampleModel<>(advancedStep, 800));
        advancedBox2Sampler.addModel(new SampleModel<>(advancedStep, 800));
        advancedBoxCSampler.addModel(new SampleModel<>(advancedStep, 800));
        advancedBoxMSampler.addModel(new SampleModel<>(advancedStep, 800));
        advancedBoxSSampler.addModel(new SampleModel<>(advancedStep, 800));

        Sampler<Integer> basicBoxNS = new Sampler<>();
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(100, 60), 200, 50);
        basicBoxNS.addModelsLinearWeights(ListUtil.ofRange(101, 150), 50, 10);
        Item basicBox = ItemData.BASIC_BOX.clone();
        Item basicBox2 = ItemData.BASIC_BOX_2.clone();
        Item basicBoxC = ItemData.BASIC_BOX_C.clone();
        Item basicBoxM = ItemData.BASIC_BOX_M.clone();
        Item basicBoxS = ItemData.BASIC_BOX_S.clone();
        basicBox.setNumSampler(basicBoxNS);
        basicBox2.setNumSampler(basicBoxNS);
        basicBoxC.setNumSampler(basicBoxNS);
        basicBoxM.setNumSampler(basicBoxNS);
        basicBoxS.setNumSampler(basicBoxNS);
        advancedBoxSampler.addModel(new SampleModel<>(basicBox, 600));
        advancedBox2Sampler.addModel(new SampleModel<>(basicBox2, 600));
        advancedBoxCSampler.addModel(new SampleModel<>(basicBoxC, 600));
        advancedBoxMSampler.addModel(new SampleModel<>(basicBoxM, 600));
        advancedBoxSSampler.addModel(new SampleModel<>(basicBoxS, 600));

        Sampler<Integer> regularBoxNS = new Sampler<>();
        regularBoxNS.addModelsLinearWeights(ListUtil.ofRange(10, 5), 400, 150);
        regularBoxNS.addModelsLinearWeights(ListUtil.ofRange(11, 16), 150, 1);
        Item regularBox = ItemData.REGULAR_BOX.clone();
        Item regularBox2 = ItemData.REGULAR_BOX_2.clone();
        Item regularBoxC = ItemData.REGULAR_BOX_C.clone();
        Item regularBoxM = ItemData.REGULAR_BOX_M.clone();
        Item regularBoxS = ItemData.REGULAR_BOX_S.clone();
        regularBox.setNumSampler(regularBoxNS);
        regularBox2.setNumSampler(regularBoxNS);
        regularBoxC.setNumSampler(regularBoxNS);
        regularBoxM.setNumSampler(regularBoxNS);
        regularBoxS.setNumSampler(regularBoxNS);
        advancedBoxSampler.addModel(new SampleModel<>(regularBox, 2000));
        advancedBox2Sampler.addModel(new SampleModel<>(regularBox2, 2000));
        advancedBoxCSampler.addModel(new SampleModel<>(regularBoxC, 2000));
        advancedBoxMSampler.addModel(new SampleModel<>(regularBoxM, 2000));
        advancedBoxSSampler.addModel(new SampleModel<>(regularBoxS, 2000));

        Sampler<Integer> advancedBoxNS = new Sampler<>();
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(2, 5), 800, 100);
        advancedBoxNS.addModelsLinearWeights(ListUtil.ofRange(6, 10), 50, 10);
        Item advancedBox = ItemData.ADVANCED_BOX.clone();
        Item advancedBox2 = ItemData.ADVANCED_BOX_2.clone();
        Item advancedBoxC = ItemData.ADVANCED_BOX_C.clone();
        Item advancedBoxM = ItemData.ADVANCED_BOX_M.clone();
        Item advancedBoxS = ItemData.ADVANCED_BOX_S.clone();
        advancedBox.setNumSampler(advancedBoxNS);
        advancedBox2.setNumSampler(advancedBoxNS);
        advancedBoxC.setNumSampler(advancedBoxNS);
        advancedBoxM.setNumSampler(advancedBoxNS);
        advancedBoxS.setNumSampler(advancedBoxNS);
        advancedBoxSampler.addModel(new SampleModel<>(advancedBox, 100));
        advancedBox2Sampler.addModel(new SampleModel<>(advancedBox2, 100));
        advancedBoxCSampler.addModel(new SampleModel<>(advancedBoxC, 100));
        advancedBoxMSampler.addModel(new SampleModel<>(advancedBoxM, 100));
        advancedBoxSSampler.addModel(new SampleModel<>(advancedBoxS, 100));

        Sampler<Integer> deluxeBoxNS = new Sampler<>();
        deluxeBoxNS.addModelsLinearWeights(ListUtil.ofRange(1, 2), 800, 100);
        deluxeBoxNS.addModelsLinearWeights(ListUtil.ofRange(3, 5), 50, 10);
        Item deluxeBox = ItemData.DELUXE_BOX.clone();
        Item deluxeBox2 = ItemData.DELUXE_BOX_2.clone();
        Item deluxeBoxS = ItemData.DELUXE_BOX_S.clone();
        deluxeBox.setNumSampler(deluxeBoxNS);
        deluxeBox2.setNumSampler(deluxeBoxNS);
        deluxeBoxS.setNumSampler(deluxeBoxNS);
        advancedBoxSampler.addModel(new SampleModel<>(deluxeBox, 20));
        advancedBox2Sampler.addModel(new SampleModel<>(deluxeBox2, 20));
        advancedBoxSSampler.addModel(new SampleModel<>(deluxeBoxS, 20));

        Sampler<Integer> advancedGiftNS = new Sampler<>();
        advancedGiftNS.addModel(new SampleModel<>(1, 990));
        advancedGiftNS.addModel(new SampleModel<>(2, 10));
        Item advancedGift = ItemData.ADVANCED_GIFT.clone();
        Item advancedGift21 = ItemData.ADVANCED_GIFT_21.clone();
        Item advancedGiftC = ItemData.ADVANCED_GIFT_C.clone();
        Item advancedGiftM = ItemData.ADVANCED_GIFT_M.clone();
        Item advancedGiftS = ItemData.ADVANCED_GIFT_S.clone();
        advancedGift.setNumSampler(advancedGiftNS);
        advancedGift21.setNumSampler(advancedGiftNS);
        advancedGiftC.setNumSampler(advancedGiftNS);
        advancedGiftM.setNumSampler(advancedGiftNS);
        advancedGiftS.setNumSampler(advancedGiftNS);
        advancedBoxSampler.addModel(new SampleModel<>(advancedGift, 10));
        advancedBox2Sampler.addModel(new SampleModel<>(advancedGift21, 10));
        advancedBoxCSampler.addModel(new SampleModel<>(advancedGiftC, 10));
        advancedBoxMSampler.addModel(new SampleModel<>(advancedGiftM, 10));
        advancedBoxSSampler.addModel(new SampleModel<>(advancedGiftS, 10));

        advancedBoxSampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_4, 6));
        advancedBox2Sampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_4, 6));
        advancedBoxCSampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_4, 6));
        advancedBoxMSampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_4, 6));
        advancedBoxSSampler.addModel(new SampleModel<>(ItemData.DELUXE_GIFT_4, 6));

        compounds.add(new Compound(ItemData.ADVANCED_BOX, 1, advancedBoxSampler));
        compounds.add(new Compound(ItemData.ADVANCED_BOX_2, 1, advancedBox2Sampler));
        compounds.add(new Compound(ItemData.ADVANCED_BOX_C, 1, advancedBoxCSampler));
        compounds.add(new Compound(ItemData.ADVANCED_BOX_M, 1, advancedBoxMSampler));
        compounds.add(new Compound(ItemData.ADVANCED_BOX_S, 1, advancedBoxSSampler));
    }
}

package net.doge.model;

import lombok.Getter;
import net.doge.util.RandomUtil;

import java.util.*;

public class Sampler<I> {
    @Getter
    private List<SampleModel<I>> models = new LinkedList<>();
    private List<Double> weightPrefixSum = new ArrayList<>();
    @Getter
    private double weightSum;

    public void addModel(SampleModel<I> model) {
        models.add(model);
        updateWeightSum();
    }

    public void updateWeightSum() {
        weightPrefixSum.clear();
        weightSum = 0;
        for (SampleModel<I> model : models) weightPrefixSum.add(weightSum += model.getWeight());
    }

    public void addModelsLinearWeights(List<I> items, double maxWeight, double minWeight) {
        int n = items.size();
        double step = (maxWeight - minWeight) / (n - 1), weight = maxWeight;
        // 计算权重(线性函数)
        for (int i = 0; i < n; i++) {
            addModel(new SampleModel<>(items.get(i), weight));
            weight -= step;
        }
    }

    // 抽取一次，返回奖品
    public SampleModel<I> lottery() {
        double n = RandomUtil.nextDouble() * weightSum;
        SampleModel<I> res = models.isEmpty() ? null : models.get(0);
        for (int i = 0, s = weightPrefixSum.size(); i < s; i++) {
            if (n >= weightPrefixSum.get(i)) res = models.get(i + 1);
            else break;
        }
        return res;
    }

    // 抽取 n 次，返回奖品列表
    public List<SampleModel<I>> lottery(int times) {
        List<SampleModel<I>> res = new LinkedList<>();
        for (int i = 0; i < times; i++) res.add(lottery());
        return res;
    }

    // 抽取 n 次，返回奖品哈希表
    public Map<SampleModel<I>, Integer> lotteryMap(int times) {
        List<SampleModel<I>> res = lottery(times);
        // 使用 LinkedHashMap 保持插入顺序
        Map<SampleModel<I>, Integer> resMap = new LinkedHashMap<>();
        res.forEach(m -> resMap.put(m, resMap.getOrDefault(m, 0) + 1));
        return resMap;
    }

    // 叠加物品权重
    public void addWeight(I item, double amount) {
        for (SampleModel<I> model : models) {
            if (model.getItem().equals(item)) model.addWeight(amount);
        }
        updateWeightSum();
    }
}

package net.doge.model;

import lombok.Getter;

import java.security.SecureRandom;
import java.util.*;

public class Sampler<I> {
    @Getter
    private List<SampleModel<I>> models = new LinkedList<>();
    private List<Double> weightPrefixSum = new ArrayList<>();
    @Getter
    private double weightSum;

    private static final Random random = new Random();

    public void addModel(SampleModel<I> model) {
        models.add(model);
        weightPrefixSum.add(weightSum += model.getWeight());
    }

    public void addModelsLinearWeights(List<I> items, double maxWeight, double minWeight) {
        int n = items.size();
        double step = (maxWeight - minWeight) / n, weight = maxWeight;
        // 计算权重(线性函数)
        for (int i = 0; i < n; i++) {
            addModel(new SampleModel<>(items.get(i), weight));
            weight -= step;
        }
    }

    // 抽取一次，返回奖品
    public SampleModel<I> lottery() {
        double n = random.nextDouble() * weightSum;
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
        Map<SampleModel<I>, Integer> resMap = new HashMap<>();
        res.forEach(m -> resMap.put(m, resMap.getOrDefault(m, 0) + 1));
        return resMap;
    }
}

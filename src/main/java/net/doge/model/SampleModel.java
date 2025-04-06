package net.doge.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SampleModel<I> {
    // 物品
    private I item;
    // 权重
    private double weight;

    public void addWeight(double amount) {
        weight += amount;
    }
}

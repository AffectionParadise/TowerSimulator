package net.doge.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemProbabilityModel<I> {
    // 物品
    private I item;
    // 概率
    private double probability;
}

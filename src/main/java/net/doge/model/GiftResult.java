package net.doge.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GiftResult {
    // 物品
    private Item item;
    // 数量
    private int num;
}

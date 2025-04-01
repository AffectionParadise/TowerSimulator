package net.doge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.doge.constant.IconKey;

@Data
@AllArgsConstructor
public class Transaction {
    // 图标 key
    private IconKey iconKey;
    // 得到的物品
    private Item itemReceived;
    // 获得数量
    private int numReceived;
    // 消耗的物品
    private Item itemConsumed;
    // 消耗数量
    private int cost;
}

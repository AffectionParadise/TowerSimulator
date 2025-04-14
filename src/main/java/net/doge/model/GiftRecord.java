package net.doge.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GiftRecord {
    // 赠送的物品
    private Item itemPresented;
    // 赠送的数量
    private int numPresented;
    // 子物品
    private List<GiftResult> results;
    // 总价值
    private long totalValue;

    // 是否为单种礼物
    public boolean isOneKind() {
        return results == null || results.size() == 1;
    }
}

package net.doge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.doge.constant.IconKey;
import net.doge.ui.widget.color.GColor;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Vip {
    // 名称
    private String name;
    // 图标 key
    private IconKey iconKey;
    // 强调颜色
    private GColor highlightColor;
    // 浅颜色
    private GColor brightColor;
    // 描述
    private String desc;
    // 源物品
    private Item sourceItem;
    // 目标物品
    private Item targetItem;
    // 叠加的权重
    private double weightIncrement;
    // 概率描述
    private String weightDesc;
    // 消耗物品
    private Item itemConsumed;
    // 消耗数量
    private int cost;
    // 持续步数
    private int duration;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vip vip = (Vip) o;
        return hashCode() == vip.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, iconKey);
    }
}

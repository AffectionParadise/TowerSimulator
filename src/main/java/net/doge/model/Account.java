package net.doge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.doge.constant.IconKey;
import net.doge.ui.widget.color.GColor;

@Data
@AllArgsConstructor
public class Account {
    // 名称
    private String name;
    // 头像
    private IconKey avatar;
    // 会员剩余步数
    private int vipStepLeft;
    // 会员
    private Vip vip;

    public Account(String name, IconKey avatar) {
        this.name = name;
        this.avatar = avatar;
    }

    public void addVipStepLeft(int amount) {
        vipStepLeft += amount;
    }

    public GColor getTextColor() {
        return vip == null ? GColor.DEFAULT : vip.getHighlightColor();
    }

    public GColor getBrightColor() {
        return vip == null ? null : vip.getBrightColor();
    }

    public GColor getHighlightColor() {
        return vip == null ? null : vip.getHighlightColor();
    }

    public void consumeVip() {
        if (vip == null) return;
        vipStepLeft--;
    }

    public boolean isVip() {
        return vip != null;
    }
}

package net.doge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.doge.constant.IconKey;
import net.doge.constant.StorageKey;
import net.doge.data.DataStorage;
import net.doge.data.NobleData;
import net.doge.data.ShowData;
import net.doge.ui.widget.color.GColor;

@Data
@AllArgsConstructor
public class Account {
    // 名称
    private String name;
    // 头像
    private IconKey avatar;
    // show 等级
    private int showLevel;
    // 下一 show 等级所需经验值
    private int showExpRequired;
    // 下一 show 等级已获取经验值
    private int showExpGained;
    // 贵族
    private Noble noble;
    // 会员剩余步数
    private int vipStepLeft;
    // 会员
    private Vip vip;

    public Account(String name, IconKey avatar) {
        this.name = name;
        this.avatar = avatar;
    }

    public boolean isMaxShowLevel() {
        return showLevel >= ShowData.MAX_LEVEL;
    }

    public void updateShowLevel() {
        int totalShowExp = DataStorage.get(StorageKey.SHOW_EXP);
        int d = ShowData.EXP_INCREMENT, max = ShowData.MAX_LEVEL;
        for (int i = 1; i < max; i++) {
            if (totalShowExp >= i * (i - 1) * d / 2) showLevel = i;
            else break;
        }
        showExpRequired = showLevel * d;
        showExpGained = totalShowExp - showLevel * (showLevel - 1) * d / 2;
    }

    public void updateNoble() {
        int numConsumed = DataStorage.get(StorageKey.ADVANCED_COIN_CONSUMED);
        Noble noble = null;
        for (Noble nob : NobleData.nobles) {
            if (numConsumed < nob.getNumRequired()) break;
            else noble = nob;
        }
        this.noble = noble;
    }

    public boolean isNoble() {
        return noble != null;
    }

    public void addVipStepLeft(int amount) {
        vipStepLeft += amount;
    }

    public GColor getTextColor() {
        return isVip() ? vip.getHighlightColor() : GColor.DEFAULT;
    }

    public GColor getBrightColor() {
        return isVip() ? vip.getBrightColor() : null;
    }

    public GColor getHighlightColor() {
        return isVip() ? vip.getHighlightColor() : null;
    }

    public void consumeVip() {
        if (!isVip()) return;
        vipStepLeft--;
    }

    public boolean isVip() {
        return vip != null;
    }
}

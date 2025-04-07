package net.doge.model;

import lombok.Data;
import net.doge.constant.IconKey;
import net.doge.constant.TowerBlockStatus;
import net.doge.data.AccountData;
import net.doge.ui.widget.label.GPLabel;
import net.doge.util.IconUtil;

@Data
public class TowerBlock {
    // 物品
    private Item item;
    // 数量
    private int num;
    // 状态
    private TowerBlockStatus status;
    // 是否为终点
    private boolean end;
    // 对应的标签组件
    private GPLabel label;

    public void setStatus(TowerBlockStatus status) {
        this.status = status;
        switch (status) {
            case ME:
                item = null;
                label.setC1(null);
                label.setForeground(AccountData.account.getTextColor().getAWTColor());
                label.setText(AccountData.account.getName());
                label.setIcon(IconUtil.getIcon(AccountData.account.getAvatar()));
                break;
            case ACTIVATED:
                if (end) return;
                boolean empty = isEmpty();
                label.setC1(empty ? AccountData.account.getBrightColor() : item.getHighlightColor());
                label.setUseGradientPaint(false);
                label.setForeground(null);
                label.setText(empty || num <= 1 ? " " : String.valueOf(num));
                label.setIcon(empty ? null : IconUtil.getIcon(item.getIconKey()));
                break;
            case INVISIBLE:
                if (end) return;
                label.setC1(AccountData.account.getBrightColor());
                label.setC2(AccountData.account.getHighlightColor());
                label.setUseGradientPaint(true);
                label.setForeground(null);
                label.setText(" ");
                label.setIcon(null);
                break;
            case DISABLED:
                label.setC1(null);
                label.setForeground(null);
                label.setText(" ");
                label.setIcon(null);
                break;
        }
    }

    public void setEnd(boolean end) {
        this.end = end;
        if (!end) return;
        label.setC1(null);
        label.setText("终点");
        label.setIcon(IconUtil.getIcon(IconKey.DESTINATION));
    }

    public void setItem(Item item) {
        this.item = item;
        num = item.hasNumSampler() ? item.getNumSampler().lottery().getItem() : 1;
    }

    // 是否为激活状态
    public boolean isActive() {
        return status == TowerBlockStatus.ACTIVATED;
    }

    // 是否不可见
    public boolean isInvisible() {
        return status == TowerBlockStatus.INVISIBLE;
    }

    // 是否禁用
    public boolean isDisabled() {
        return status == TowerBlockStatus.DISABLED;
    }

    public boolean isEmpty() {
        return item == null;
    }
}

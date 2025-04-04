package net.doge.model;

import lombok.Data;
import net.doge.constant.IconKey;
import net.doge.constant.TowerBlockStatus;
import net.doge.data.AccountData;
import net.doge.ui.widget.label.GLabel;
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
    private GLabel label;

    public void setStatus(TowerBlockStatus status) {
        this.status = status;
        switch (status) {
            case ME:
                item = null;
                label.setForeground(AccountData.account.getHighlightColor().getAWTColor());
                label.setBackground(null);
                label.setText(AccountData.account.getName());
                label.setIcon(IconUtil.getIcon(AccountData.account.getAvatar()));
                break;
            case ACTIVATED:
                if (end) return;
                boolean empty = isEmpty();
                label.setForeground(null);
                label.setBackground(empty ? null : item.getHighlightColor());
                label.setText(empty || num <= 1 ? " " : String.valueOf(num));
                label.setIcon(empty ? null : IconUtil.getIcon(item.getIconKey()));
                break;
            case INVISIBLE:
                label.setForeground(null);
                label.setBackground(null);
                label.setText(" ");
                label.setIcon(IconUtil.getIcon(IconKey.INVISIBLE));
                break;
        }
    }

    public void setEnd(boolean end) {
        this.end = end;
        if (!end) return;
        label.setBackground(null);
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

    // 是否可见
    public boolean isVisible() {
        return status != TowerBlockStatus.INVISIBLE;
    }

    public boolean isEmpty() {
        return item == null;
    }
}

package net.doge.ui.widget.panel;

import net.doge.data.ActivityData;
import net.doge.ui.TowerUI;

public class GiftExpRewardPanel extends RewardPanel {

    public GiftExpRewardPanel(TowerUI ui) {
        super(ui, ActivityData.giftExpRewards, "赠送盲盒礼物，获得超多通行证奖励！");
    }
}

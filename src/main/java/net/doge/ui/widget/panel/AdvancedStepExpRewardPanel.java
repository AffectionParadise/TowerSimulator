package net.doge.ui.widget.panel;

import net.doge.data.ActivityData;
import net.doge.ui.TowerUI;

public class AdvancedStepExpRewardPanel extends RewardPanel {

    public AdvancedStepExpRewardPanel(TowerUI ui) {
        super(ui, ActivityData.advancedStepExpRewards, String.format("消耗三塔牌子走塔获得经验(每个 %s 经验)，领取超多通行证奖励！", ActivityData.ADVANCED_STEP_EXP));
    }
}

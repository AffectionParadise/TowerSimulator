package net.doge.ui.widget.panel;

import net.doge.data.ActivityData;
import net.doge.ui.TowerUI;

public class StepConsumptionRewardPanel extends RewardPanel {

    public StepConsumptionRewardPanel(TowerUI ui) {
        super(ui, ActivityData.stepConsumptionRewards, String.format("消耗%s走塔，获得大量返利！", ActivityData.stepConsumptionRewards.get(0).getItemReceived().getName()));
    }
}

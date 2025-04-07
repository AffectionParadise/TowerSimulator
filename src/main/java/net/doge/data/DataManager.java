package net.doge.data;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import net.doge.constant.StorageKey;
import net.doge.model.Account;
import net.doge.model.GiftRecord;
import net.doge.model.Reward;
import net.doge.ui.TowerUI;
import net.doge.util.JsonUtil;

import java.util.List;
import java.util.Map;

public class DataManager {
    // 载入数据
    public static void loadData(TowerUI ui) {
        JSONObject data = JsonUtil.read("data.json");
        // 账号
        JSONObject accountJson = data.getJSONObject("Account");
        if (JsonUtil.notEmpty(accountJson)) AccountData.account = accountJson.to(Account.class);
        // 礼物库存
        JSONObject dataStorageJson = data.getJSONObject("DataStorage");
        if (JsonUtil.notEmpty(dataStorageJson)) {
            for (Map.Entry<String, Object> entry : dataStorageJson.entrySet()) {
                StorageKey k = StorageKey.find(entry.getKey());
                int v = (int) entry.getValue();
                DataStorage.add(k, v);
            }
        }
        // 礼物统计
        JSONObject giftCensusJson = data.getJSONObject("GiftCensus");
        if (JsonUtil.notEmpty(giftCensusJson)) {
            for (Map.Entry<String, Object> entry : giftCensusJson.entrySet()) {
                StorageKey k = StorageKey.find(entry.getKey());
                int v = (int) entry.getValue();
                GiftCensusStorage.add(k, v);
            }
        }
        // 送礼记录
        JSONArray giftRecordsJsonArray = data.getJSONArray("GiftRecords");
        if (JsonUtil.notEmpty(giftRecordsJsonArray)) {
            List<GiftRecord> records = giftRecordsJsonArray.toList(GiftRecord.class);
            GiftRecordStorage.getStorage().addAll(records);
        }
        // 奖励
        JSONArray stepConsumptionRewardsJsonArray = data.getJSONArray("StepConsumptionRewards");
        if (JsonUtil.notEmpty(stepConsumptionRewardsJsonArray)) {
            List<Reward> rewards = stepConsumptionRewardsJsonArray.toList(Reward.class);
            for (int i = 0, s = rewards.size(); i < s; i++)
                ActivityData.stepConsumptionRewards.get(i).setReceived(rewards.get(i).isReceived());
        }
        JSONArray giftExpRewardsJsonArray = data.getJSONArray("GiftExpRewards");
        if (JsonUtil.notEmpty(giftExpRewardsJsonArray)) {
            List<Reward> rewards = giftExpRewardsJsonArray.toList(Reward.class);
            for (int i = 0, s = rewards.size(); i < s; i++)
                ActivityData.giftExpRewards.get(i).setReceived(rewards.get(i).isReceived());
        }
        JSONArray advancedStepExpRewardsJsonArray = data.getJSONArray("AdvancedStepExpRewards");
        if (JsonUtil.notEmpty(advancedStepExpRewardsJsonArray)) {
            List<Reward> rewards = advancedStepExpRewardsJsonArray.toList(Reward.class);
            for (int i = 0, s = rewards.size(); i < s; i++)
                ActivityData.advancedStepExpRewards.get(i).setReceived(rewards.get(i).isReceived());
        }
        JSONArray advancedTowerClearRewardsJsonArray = data.getJSONArray("AdvancedTowerClearRewards");
        if (JsonUtil.notEmpty(advancedTowerClearRewardsJsonArray)) {
            List<Reward> rewards = advancedTowerClearRewardsJsonArray.toList(Reward.class);
            for (int i = 0, s = rewards.size(); i < s; i++)
                ActivityData.advancedTowerClearRewards.get(i).setReceived(rewards.get(i).isReceived());
        }
        JSONArray deluxeTowerClearRewardsJsonArray = data.getJSONArray("DeluxeTowerClearRewards");
        if (JsonUtil.notEmpty(deluxeTowerClearRewardsJsonArray)) {
            List<Reward> rewards = deluxeTowerClearRewardsJsonArray.toList(Reward.class);
            for (int i = 0, s = rewards.size(); i < s; i++)
                ActivityData.deluxeTowerClearRewards.get(i).setReceived(rewards.get(i).isReceived());
        }

        // 刷新数据显示
        ui.updateGatheredStepAmount(0);
        ui.updateItemAmountAndView(ItemData.ADVANCED_STEP, JsonUtil.isEmpty(data) ? 10000 : 0);
    }

    // 保存数据
    public static void saveData() {
        JSONObject data = new JSONObject();
        // 账号
        JSONObject accountJson = JSONObject.from(AccountData.account, JSONWriter.Feature.FieldBased);
        data.put("Account", accountJson);
        // 礼物库存
        JSONObject dataStorageJson = JSONObject.from(DataStorage.getStorage(), JSONWriter.Feature.WriteEnumUsingToString);
        data.put("DataStorage", dataStorageJson);
        // 礼物统计
        JSONObject giftCensusJson = JSONObject.from(GiftCensusStorage.getStorage(), JSONWriter.Feature.WriteEnumUsingToString);
        data.put("GiftCensus", giftCensusJson);
        // 送礼记录
        JSONArray giftRecordsJsonArray = JSONArray.from(GiftRecordStorage.getStorage());
        data.put("GiftRecords", giftRecordsJsonArray);
        // 奖励
        JSONArray stepConsumptionRewardsJsonArray = JSONArray.from(ActivityData.stepConsumptionRewards);
        data.put("StepConsumptionRewards", stepConsumptionRewardsJsonArray);
        JSONArray giftExpRewardsJsonArray = JSONArray.from(ActivityData.giftExpRewards);
        data.put("GiftExpRewards", giftExpRewardsJsonArray);
        JSONArray advancedStepExpRewardsJsonArray = JSONArray.from(ActivityData.advancedStepExpRewards);
        data.put("AdvancedStepExpRewards", advancedStepExpRewardsJsonArray);
        JSONArray advancedTowerClearRewardsJsonArray = JSONArray.from(ActivityData.advancedTowerClearRewards);
        data.put("AdvancedTowerClearRewards", advancedTowerClearRewardsJsonArray);
        JSONArray deluxeTowerClearRewardsJsonArray = JSONArray.from(ActivityData.deluxeTowerClearRewards);
        data.put("DeluxeTowerClearRewards", deluxeTowerClearRewardsJsonArray);
        JsonUtil.toFile(data, "data.json");
    }
}

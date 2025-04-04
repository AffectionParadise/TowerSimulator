package net.doge.ui;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import net.doge.data.*;
import net.doge.model.*;
import net.doge.constant.*;
import net.doge.model.Event;
import net.doge.ui.widget.button.GButton;
import net.doge.ui.widget.color.GColor;
import net.doge.ui.widget.dialog.*;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.panel.GPanel;
import net.doge.util.IconUtil;
import net.doge.util.JsonUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TowerUI extends JFrame {
    public Tower currTower = TowerData.ADVANCED_TOWER;
    public Event currEvent = EventData.NOTHING;
    private Bonus currBonus;
    private Quiz quiz = ActivityData.quiz;

    private GPanel mainPanel = new GPanel();
    private GButton towerBtn = new GButton("塔群", GColor.DARK_ORANGE);
    private GLabel gatheredLabel = new GLabel();
    private GLabel stepLabel = new GLabel();
    private GButton stepPlusBtn = new GButton("+", GColor.DEEP_GREEN);
    private GButton backpackBtn = new GButton("探险背包", GColor.LIGHT_BLUE);
    private GLabel bonusLabel = new GLabel();
    private GButton activityBtn = new GButton("活动", GColor.DARK_RED);
    private GButton storeBtn = new GButton("宝藏商店", GColor.LIGHT_BLUE);
    private GButton giftBtn = new GButton("礼物", GColor.DEEP_GREEN);

    public void init() {
        loadData();

        generateBlocks(TowerData.ADVANCED_TOWER, true);

        // 关闭时保存游戏数据
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveData();
            }
        });

        // 作弊
        TowerUI THIS = this;
        towerBtn.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() != KeyEvent.VK_ENTER) return;
                new CheatDialog(THIS);
            }
        });

        Box topBox = new Box(BoxLayout.X_AXIS);
        towerBtn.addActionListener(e -> {
            TowerDialog towerDialog = new TowerDialog(this);
            if (!towerDialog.isConfirmed()) return;
            currTower = towerDialog.getSelectedTower();
            Item stepItem = currTower.getStepItem();
            stepLabel.setIcon(IconUtil.getIcon(stepItem.getIconThumbKey()));
            updateItemAmountAndView(stepItem, 0);
            generateBlocks(currTower, false);
        });

        gatheredLabel.setIcon(IconUtil.getIcon(IconKey.GATHERED_STEP_THUMB));
        stepLabel.setIcon(IconUtil.getIcon(currTower.getStepItem().getIconThumbKey()));
        stepPlusBtn.addActionListener(e -> new TransactionDialog(this));
        backpackBtn.addActionListener(e -> new BackpackDialog(this));
        bonusLabel.setForeground(GColor.DARK_RED.getAWTColor());
        activityBtn.addActionListener(e -> new ActivityDialog(this));
        storeBtn.addActionListener(e -> new CoinExchangeDialog(this, ItemData.COIN));
        giftBtn.addActionListener(e -> new GiftDialog(this));

        setTitle("走塔模拟器");
        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int sw = 20;
        topBox.add(Box.createHorizontalStrut(sw));
        topBox.add(towerBtn);
        topBox.add(Box.createHorizontalStrut(sw));
        topBox.add(gatheredLabel);
        topBox.add(Box.createHorizontalStrut(sw));
        topBox.add(stepLabel);
        topBox.add(Box.createHorizontalStrut(sw));
        topBox.add(stepPlusBtn);
        topBox.add(Box.createHorizontalStrut(sw));
        topBox.add(backpackBtn);
        topBox.add(Box.createHorizontalStrut(sw));
        topBox.add(bonusLabel);
        topBox.add(Box.createHorizontalGlue());
        topBox.add(activityBtn);
        topBox.add(Box.createHorizontalStrut(sw));
        topBox.add(storeBtn);
        topBox.add(Box.createHorizontalStrut(sw));
        topBox.add(giftBtn);
        topBox.add(Box.createHorizontalStrut(sw));
        add(topBox, BorderLayout.NORTH);

        mainPanel.setLayout(new GridLayout(currTower.r, currTower.c));
        add(mainPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void generateBlocks(Tower tower, boolean isNew) {
        currTower = tower;
        stepPlusBtn.setVisible(currTower.isPurchasable());
        // 保持翻倍事件
        if (EventData.isBonusTrigger(currEvent) && TowerData.isAdvancedTower(currTower)) {
            updateBonusStepLeft();
        } else bonusLabel.setText(tower.getTitle());
        mainPanel.removeAll();
        // 新生成地图
        if (isNew || tower.isEmpty()) {
            currTower.x = currTower.y = 0;
            currTower.getBackpackStorage().clear();
            Sampler<Item> itemSampler = ItemData.getItemSampler(tower);
            for (int i = 0; i < currTower.r; i++) {
                for (int j = 0; j < currTower.c; j++) {
                    TowerBlock block = new TowerBlock();

                    Item item = itemSampler.lottery().getItem();
                    block.setItem(item);

                    GLabel label = new GLabel();
                    label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    label.setHorizontalTextPosition(SwingConstants.CENTER);
                    label.setVerticalTextPosition(SwingConstants.BOTTOM);
                    label.setOpaque(true);
                    block.setLabel(label);

                    block.setStatus(TowerBlockStatus.INVISIBLE);

                    int dx = i;
                    int dy = j;
                    label.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            move(currTower.x, currTower.y, dx, dy);
                        }
                    });
                    mainPanel.add(label);

                    currTower.blocks[i][j] = block;
                }
            }
            currTower.blocks[0][0].setStatus(TowerBlockStatus.ME);
            currTower.blocks[currTower.r - 1][currTower.c - 1].setEnd(true);

            if (TowerData.isAdvancedTower(currTower) && quiz.isStatus(QuizStatus.PROGRESSING))
                quiz.setActualNum(getTargetNum());
        }
        // 延用旧地图(从密藏出来)
        else {
            for (int i = 0; i < currTower.r; i++)
                for (int j = 0; j < currTower.c; j++)
                    mainPanel.add(currTower.blocks[i][j].getLabel());
        }
        mainPanel.repaint();
        move(currTower.x, currTower.y, currTower.x, currTower.y);
    }

    // 更新物品数量并回显
    public void updateItemAmountAndView(Item stepItem, int amount) {
        StorageKey sk = stepItem.getStorageKey();
        DataStorage.add(sk, amount);
        if (currTower.getStepItem().equals(stepItem)) stepLabel.setText(String.valueOf(DataStorage.get(sk)));
    }

    // 更新积累步数
    private void updateGatheredStepAmount(int amount) {
        DataStorage.add(StorageKey.GATHERED_STEP_NUM, amount);
        gatheredLabel.setText(String.valueOf(DataStorage.get(StorageKey.GATHERED_STEP_NUM)));
    }

    // 更新礼物翻倍剩余步数
    public void updateBonusStepLeft() {
        bonusLabel.setText(String.format("%s~%s倍 剩余步数：%s", currBonus.getMinRate(), currBonus.getMaxRate(), currBonus.getStepLeft()));
    }

    public void updateBonusStepLeft(TowerBlock block, int rate) {
        Item item = block.getItem();
        bonusLabel.setText(String.format("%s~%s倍 剩余步数：%s (获得 %s 个%s * %s 倍)", currBonus.getMinRate(), currBonus.getMaxRate(), currBonus.getStepLeft(),
                block.getNum(), item.getName(), rate));
    }

    // 密藏结束
    public void finishTreasure(Tower tower) {
        currEvent = EventData.NOTHING;
        tower.setVisible(false);
        if (currTower != tower) return;
        generateBlocks(TowerData.ADVANCED_TOWER, false);
    }

    // 移动函数
    private void move(int x1, int y1, int x2, int y2) {
        if (!isReachable(x1, y1, x2, y2)) return;
        // 是否无效移动
        boolean invalidMovement = currTower.blocks[x2][y2].isEmpty();
        // 检查牌子数量是否充足
        if (!invalidMovement && currTower.getStepCost() > DataStorage.get(currTower.getStepItem().getStorageKey())) {
            new TipDialog(this, String.format("%s不足", currTower.getStepItem().getName()));
            return;
        }
        // 还原起点
        activateBlock(x1, y1);
        // 占据目标点
        occupyBlock(x2, y2);
        // 更新终点的视野
        updateVision(x2, y2);
        if (invalidMovement) return;
        if (currTower.blocks[x2][y2].isEnd()) {
            // 显示本关获得物品
            backpackBtn.doClick();
            // 判断竞猜
            if (TowerData.isAdvancedTower(currTower)) {
                if (quiz.isStatus(QuizStatus.WAITING)) quiz.setStatus(QuizStatus.PROGRESSING);
                else if (quiz.isStatus(QuizStatus.PROGRESSING)) quiz.setStatus(QuizStatus.OVER);
            }
            // 密藏结束
            if (TowerData.isTreasure(currTower)) finishTreasure(currTower);
            else generateBlocks(currTower, true);
        }
        // 判断事件
        else if (TowerData.isAdvancedTower(currTower) && EventData.isNothing(currEvent)) {
            Sampler<Event> eventSampler = EventData.eventSampler;
            Event event = eventSampler.lottery().getItem();
            // 无
            if (EventData.isNothing(event)) return;
            // 触发密藏
            if (EventData.isTreasure(event)) {
                currEvent = event;
                TreasureDialog treasureDialog = new TreasureDialog(this);
                Tower tower = event.getTower();
                tower.setVisible(true);
                if (!treasureDialog.isConfirmed()) return;
                generateBlocks(tower, true);
            }
            // 触发礼物翻倍
            else if (EventData.isBonusTrigger(event)) {
                BonusDialog bonusDialog = new BonusDialog(this);
                if (!bonusDialog.isConfirmed()) return;
                currBonus = bonusDialog.getSelectedBonus();
                currBonus.reset();
                updateBonusStepLeft();
                currTower.setStepCost(currBonus.getStepCost());
                currEvent = EventData.BONUS_TRIGGER;
            }
        }
    }

    // 更新某点周围视野
    private void updateVision(int x, int y) {
        // 四个视野搜索方向：上下左右
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) activateBlock(x + dir[0], y + dir[1]);
    }

    // 占据某点
    private void occupyBlock(int x, int y) {
        TowerBlock block = currTower.blocks[currTower.x = x][currTower.y = y];
        if (!block.isEmpty()) {
            // 牌子减少
            Item stepItem = currTower.getStepItem();
            int stepCost = currTower.getStepCost();
            updateItemAmountAndView(stepItem, -stepCost);
            // 积累步数
            if (stepItem.equals(ItemData.ADVANCED_STEP)) updateGatheredStepAmount(stepCost);
            // 计算倍率
            int rate = 1;
            if (TowerData.isAdvancedTower(currTower) && EventData.isBonusTrigger(currEvent)) {
                rate = currBonus.getRateSampler().lottery().getItem();
                currBonus.consume();
                updateBonusStepLeft(block, rate);
                if (currBonus.getStepLeft() <= 0) {
                    currTower.setStepCost(1);
                    currEvent = EventData.NOTHING;
                    currBonus = null;
                    bonusLabel.setText(null);
                }
            }
            // 获得目标数量的礼物
            int num = rate * block.getNum();
            Item blockItem = block.getItem();
            // 会员转化礼物
            Account account = AccountData.account;
            if (account.isVip()) {
                Vip vip = account.getVip();
                Item sourceItem = vip.getSourceItem();
                if (blockItem.equals(sourceItem)) {
                    blockItem = vip.getTargetItem();
                    new ConversionDialog(this);
                }
            }
            StorageKey key = blockItem.getStorageKey();
            DataStorage.add(key, num);
            currTower.getBackpackStorage().add(key, num);
            if (blockItem.equals(stepItem)) updateItemAmountAndView(stepItem, 0);
            // 会员消耗
            account.consumeVip();
            if (account.getVipStepLeft() <= 0) {
                account.setVip(null);
            }
        }
        block.setStatus(TowerBlockStatus.ME);
    }

    // 激活某点
    private void activateBlock(int x, int y) {
        if (x < 0 || x >= currTower.r || y < 0 || y >= currTower.c) return;
        currTower.blocks[x][y].setStatus(TowerBlockStatus.ACTIVATED);
    }

    // 判断两点是否可达
    private boolean isReachable(int x1, int y1, int x2, int y2) {
        // 越界
        if (x1 < 0 || x1 >= currTower.r || y1 < 0 || y1 >= currTower.c) return false;
        if (x2 < 0 || x2 >= currTower.r || y2 < 0 || y2 >= currTower.c) return false;

        // 起点和终点相同
        if (x1 == x2 && y1 == y2) return true;

        boolean[][] visited = new boolean[currTower.r][currTower.c];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x1, y1});
        visited[x1][y1] = true;

        // 四个移动方向：上下左右
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] dir : directions) {
                int nx = current[0] + dir[0];
                int ny = current[1] + dir[1];
                // 检查新坐标是否合法且未被访问
                if (nx >= 0 && nx < currTower.r && ny >= 0 && ny < currTower.c && !visited[nx][ny] && currTower.blocks[nx][ny].isVisible()) {
                    // 检查是否到达终点
                    if (nx == x2 && ny == y2) return true;
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return false;
    }

    // 获取竞猜目标数量
    private int getTargetNum() {
        int res = 0;
        for (int i = 0; i < currTower.r; i++) {
            for (int j = 0; j < currTower.c; j++) {
                if (quiz.getTitleItem() != currTower.blocks[i][j].getItem()) continue;
                res += currTower.blocks[i][j].getNum();
            }
        }
        return res;
    }

    // 载入数据
    private void loadData() {
        JSONObject data = JsonUtil.read("data.json");
        JSONObject accountJson = data.getJSONObject("Account");
        if (JsonUtil.notEmpty(accountJson)) AccountData.account = accountJson.to(Account.class);
        JSONObject dataStorageJson = data.getJSONObject("DataStorage");
        if (JsonUtil.notEmpty(dataStorageJson)) {
            for (Map.Entry<String, Object> entry : dataStorageJson.entrySet()) {
                StorageKey k = StorageKey.find(entry.getKey());
                int v = (int) entry.getValue();
                DataStorage.add(k, v);
            }
        }
        JSONObject giftCensusJson = data.getJSONObject("GiftCensus");
        if (JsonUtil.notEmpty(giftCensusJson)) {
            for (Map.Entry<String, Object> entry : giftCensusJson.entrySet()) {
                StorageKey k = StorageKey.find(entry.getKey());
                int v = (int) entry.getValue();
                GiftCensusStorage.add(k, v);
            }
        }
        JSONArray giftRecordsJsonArray = data.getJSONArray("GiftRecords");
        if (JsonUtil.notEmpty(giftRecordsJsonArray)) {
            List<GiftRecord> records = giftRecordsJsonArray.toList(GiftRecord.class);
            GiftRecordStorage.getStorage().addAll(records);
        }

        // 刷新数据显示
        updateGatheredStepAmount(0);
        updateItemAmountAndView(ItemData.ADVANCED_STEP, JsonUtil.isEmpty(data) ? 10000 : 0);
    }

    // 保存数据
    private void saveData() {
        JSONObject data = new JSONObject();
        JSONObject accountJson = JSONObject.from(AccountData.account, JSONWriter.Feature.FieldBased);
        data.put("Account", accountJson);
        JSONObject dataStorageJson = JSONObject.from(DataStorage.getStorage(), JSONWriter.Feature.WriteEnumUsingToString);
        data.put("DataStorage", dataStorageJson);
        JSONObject giftCensusJson = JSONObject.from(GiftCensusStorage.getStorage(), JSONWriter.Feature.WriteEnumUsingToString);
        data.put("GiftCensus", giftCensusJson);
        JSONArray giftRecordsJsonArray = JSONArray.from(GiftRecordStorage.getStorage());
        data.put("GiftRecords", giftRecordsJsonArray);
        JsonUtil.toFile(data, "data.json");
    }

    // 全局字体抗锯齿，必须在初始化 UIManager 之前调用！
    private static void enableAntiAliasing() {
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
    }

    public static void main(String[] args) {
        enableAntiAliasing();
        new TowerUI().init();
    }
}

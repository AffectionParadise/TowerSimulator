package net.doge.ui;

import net.doge.constant.IconKey;
import net.doge.constant.QuizStatus;
import net.doge.constant.StorageKey;
import net.doge.constant.TowerBlockStatus;
import net.doge.data.*;
import net.doge.data.manager.DataManager;
import net.doge.data.storage.DataStorage;
import net.doge.model.*;
import net.doge.model.Event;
import net.doge.ui.widget.button.GButton;
import net.doge.ui.widget.color.GColor;
import net.doge.ui.widget.dialog.*;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.label.GPLabel;
import net.doge.ui.widget.panel.GPanel;
import net.doge.util.IconUtil;
import net.doge.util.RandomUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TowerUI extends JFrame {
    public boolean silent;
    public Event currEvent = EventData.NOTHING;
    private Bonus currBonus;
    private Tower eventTriggeredTower;
    private Quiz quiz = ActivityData.quiz;

    public Timer autoMoveTimer;

    private GPanel mainPanel = new GPanel();
    private GButton accountBtn = new GButton("账号", GColor.DARK_PURPLE);
    private GButton towerBtn = new GButton("塔群", GColor.DARK_ORANGE);
    private GLabel gatheredLabel = new GLabel();
    private GLabel stepLabel = new GLabel();
    private GButton stepPlusBtn = new GButton("+", GColor.DEEP_GREEN);
    private GButton backpackBtn = new GButton("探险背包", GColor.LIGHT_BLUE);
    private GButton autoBtn = new GButton("自动探索", GColor.DARK_RED);
    private GLabel bonusLabel = new GLabel();
    private GButton activityBtn = new GButton("活动", GColor.DARK_RED);
    private GButton magicBtn = new GButton("魔法屋", GColor.DEEP_GREEN);
    private GButton storeBtn = new GButton("宝藏商店", GColor.LIGHT_BLUE);
    private GButton giftBtn = new GButton("礼物", GColor.DEEP_GREEN);

    public void init() {
        DataManager.loadData(this);

        generateBlocks(TowerData.ADVANCED_TOWER, true);

        // 关闭时保存游戏数据
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                DataManager.saveData();
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                if (autoMoveTimer.isRunning()) autoBtn.doClick();
            }
        });

        // 自动探索
        autoMoveTimer = new Timer(300, e -> {
            for (int i = 0, r = TowerData.currTower.r; i < r; i++) {
                for (int j = 0, c = TowerData.currTower.c; j < c; j++) {
                    TowerBlock block = TowerData.currTower.blocks[i][j];
                    if (!block.isActive() || block.isEmpty()) continue;
                    move(TowerData.currTower.x, TowerData.currTower.y, i, j);
                    return;
                }
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
        accountBtn.addActionListener(e -> new AccountDetailDialog(this));
        towerBtn.addActionListener(e -> {
            TowerDialog towerDialog = new TowerDialog(this);
            if (!towerDialog.isConfirmed()) return;
            Tower tower = towerDialog.getSelectedTower();
            Item stepItem = tower.getStepItem();
            stepLabel.setIcon(IconUtil.getIcon(stepItem.getIconThumbKey()));
            generateBlocks(tower, false);
            updateItemAmountAndView(stepItem, 0);
        });
        gatheredLabel.setIcon(IconUtil.getIcon(IconKey.GATHERED_STEP_THUMB));
        stepLabel.setIcon(IconUtil.getIcon(TowerData.currTower.getStepItem().getIconThumbKey()));
        stepPlusBtn.addActionListener(e -> new TransactionDialog(this));
        backpackBtn.addActionListener(e -> new BackpackDialog(this));
        autoBtn.addActionListener(e -> {
            if (autoMoveTimer.isRunning()) {
                autoMoveTimer.stop();
                autoBtn.setText("自动探索");
            } else {
                autoMoveTimer.start();
                autoBtn.setText("取消");
            }
        });
        bonusLabel.setForeground(GColor.DARK_RED.getAwtColor());
        activityBtn.addActionListener(e -> new ActivityDialog(this));
        magicBtn.addActionListener(e -> new ShowExchangeDialog(this));
        storeBtn.addActionListener(e -> new CoinExchangeDialog(this, ItemData.COIN));
        giftBtn.addActionListener(e -> new GiftDialog(this));

        setTitle("走塔模拟器");
        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int sw = 20;
        topBox.add(Box.createHorizontalStrut(sw));
        topBox.add(accountBtn);
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
        topBox.add(autoBtn);
        topBox.add(Box.createHorizontalStrut(sw));
        topBox.add(bonusLabel);
        topBox.add(Box.createHorizontalGlue());
        topBox.add(activityBtn);
        topBox.add(Box.createHorizontalStrut(sw));
        topBox.add(magicBtn);
        topBox.add(Box.createHorizontalStrut(sw));
        topBox.add(storeBtn);
        topBox.add(Box.createHorizontalStrut(sw));
        topBox.add(giftBtn);
        topBox.add(Box.createHorizontalStrut(sw));
        add(topBox, BorderLayout.NORTH);

        mainPanel.setLayout(new GridLayout(TowerData.currTower.r, TowerData.currTower.c));
        add(mainPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void generateBlocks(Tower tower, boolean isNew) {
        TowerData.currTower = tower;
        stepPlusBtn.setVisible(tower.isPurchasable());
        // 保持翻倍事件
        if (EventData.isBonusTrigger(currEvent) && eventTriggeredTower == tower) {
            updateBonusStepLeft();
        } else bonusLabel.setText(tower.getTitle());
        mainPanel.removeAll();
        // 新生成地图
        if (isNew || tower.isEmpty()) {
            tower.x = tower.y = 0;
            tower.getBackpackStorage().clear();
            for (int i = 0, r = tower.r; i < r; i++) {
                for (int j = 0, c = tower.c; j < c; j++) {
                    TowerBlock block = new TowerBlock();

                    GPLabel label = new GPLabel();
                    label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    label.setHorizontalTextPosition(SwingConstants.CENTER);
                    label.setVerticalTextPosition(SwingConstants.BOTTOM);
                    block.setLabel(label);

                    block.setStatus(TowerBlockStatus.INVISIBLE);

                    int dx = i;
                    int dy = j;
                    label.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            // 自动探索时不可同时操作
                            if (autoMoveTimer.isRunning()) return;
                            move(tower.x, tower.y, dx, dy);
                        }
                    });
                    mainPanel.add(label);

                    tower.blocks[i][j] = block;
                }
            }
            // 生成障碍物
            generateObstacles(0, 0, tower.r - 1, tower.c - 1);
            tower.blocks[0][0].setStatus(TowerBlockStatus.ME);
            tower.blocks[tower.r - 1][tower.c - 1].setEnd(true);
        }
        // 延用旧地图(从密藏出来)
        else {
            for (int i = 0, r = tower.r; i < r; i++) {
                for (int j = 0, c = tower.c; j < c; j++) {
                    TowerBlock block = tower.blocks[i][j];
                    block.setStatus(block.getStatus());
                    mainPanel.add(block.getLabel());
                }
            }
        }
        mainPanel.repaint();
        move(tower.x, tower.y, tower.x, tower.y);
    }

    // 更新物品数量并回显
    public void updateItemAmountAndView(Item stepItem, int amount) {
        StorageKey sk = stepItem.getStorageKey();
        DataStorage.add(sk, amount);
        if (TowerData.currTower.getStepItem().equals(stepItem)) stepLabel.setText(String.valueOf(DataStorage.get(sk)));
    }

    // 更新积累步数
    public void updateGatheredStepAmount(int amount) {
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
        if (TowerData.currTower != tower) return;
        generateBlocks(eventTriggeredTower, false);
    }

    // 移动函数
    private void move(int x1, int y1, int x2, int y2) {
        if (!isReachable(x1, y1, x2, y2)) return;
        Tower tower = TowerData.currTower;
        // 是否无效移动
        boolean invalidMovement = tower.blocks[x2][y2].isEmpty();
        // 检查牌子数量是否充足
        if (!invalidMovement && tower.getStepCost() > DataStorage.get(tower.getStepItem().getStorageKey())) {
            if (autoMoveTimer.isRunning()) autoBtn.doClick();
            new TipDialog(this, String.format("%s不足", tower.getStepItem().getName()));
            return;
        }
        // 还原起点
        activateBlock(x1, y1);
        // 占据目标点
        occupyBlock(x2, y2);
        // 更新终点的视野
        updateVision(x2, y2);
        if (invalidMovement) return;
        if (tower.blocks[x2][y2].isEnd()) {
            // 显示本关获得物品
            if (!silent) backpackBtn.doClick();
            if (TowerData.isAdvancedTower(tower)) {
                // 通关次数增加
                DataStorage.add(StorageKey.ADVANCED_TOWER_CLEARED, 1);
                // 判断竞猜
                if (quiz.isCompatible(tower)) {
                    if (quiz.isStatus(QuizStatus.WAITING)) quiz.setStatus(QuizStatus.PROGRESSING);
                    else if (quiz.isStatus(QuizStatus.PROGRESSING)) quiz.setStatus(QuizStatus.OVER);
                }
            } else if (TowerData.isDeluxeTower(tower)) {
                DataStorage.add(StorageKey.DELUXE_TOWER_CLEARED, 1);
            }
            // 密藏结束
            if (TowerData.isTreasure(tower)) finishTreasure(tower);
            else generateBlocks(tower, true);
        }
        // 判断事件
        else if (tower.isTriggerable() && EventData.isNothing(currEvent)) {
            Sampler<Event> eventSampler = tower.getEventSampler();
            Event event = eventSampler.lottery().getItem();
            // 无
            if (EventData.isNothing(event)) return;
            // 触发密藏
            if (EventData.isTreasure(event)) {
                eventTriggeredTower = tower;
                currEvent = event;
                Tower t = event.getTower();
                t.setVisible(true);
                if (!silent) {
                    TreasureDialog treasureDialog = new TreasureDialog(this);
                    if (!treasureDialog.isConfirmed()) return;
                }
                generateBlocks(t, true);
            }
            // 触发礼物翻倍
            else if (EventData.isBonusTrigger(event)) {
                if (silent) return;
                BonusDialog bonusDialog = new BonusDialog(this);
                if (!bonusDialog.isConfirmed()) return;
                eventTriggeredTower = tower;
                currBonus = bonusDialog.getSelectedBonus();
                currBonus.reset();
                updateBonusStepLeft();
                tower.setStepCost(currBonus.getStepCost());
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
        Tower tower = TowerData.currTower;
        TowerBlock block = tower.blocks[tower.x = x][tower.y = y];
        if (!block.isEmpty()) {
            // 牌子减少
            Item stepItem = tower.getStepItem();
            int stepCost = tower.getStepCost();
            updateItemAmountAndView(stepItem, -stepCost);
            if (stepItem.equals(ItemData.ADVANCED_STEP)) {
                // 积累步数
                updateGatheredStepAmount(stepCost);
                // 三塔牌子经验
                DataStorage.add(StorageKey.ADVANCED_STEP_EXP, stepCost * ActivityData.ADVANCED_STEP_EXP);
            }
            // 计算倍率
            int rate = 1;
            if (EventData.isBonusTrigger(currEvent) && eventTriggeredTower == tower) {
                rate = currBonus.getRateSampler().lottery().getItem();
                currBonus.consume();
                updateBonusStepLeft(block, rate);
                if (currBonus.getStepLeft() <= 0) {
                    tower.setStepCost(1);
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
                    if (!silent) new ConversionDialog(this);
                }
            }
            // 礼物库存增加
            StorageKey key = blockItem.getStorageKey();
            DataStorage.add(key, num);
            // 皮肤 show 增加
            if (blockItem.isSkin()) DataStorage.add(StorageKey.SHOW_EXP, num * blockItem.getShowExp());
            tower.getBackpackStorage().add(key, num);
            if (blockItem.equals(stepItem)) updateItemAmountAndView(stepItem, 0);
            // 会员消耗
            if (TowerData.isAdvancedTower(tower) && account.isVip()) {
                account.consumeVip();
                if (account.getVipStepLeft() <= 0) {
                    Vip vip = account.getVip();
                    // 恢复物品概率
                    tower.getItemSampler().addWeight(vip.getSourceItem(), -vip.getWeightIncrement());
                    account.setVip(null);
                    account.setVipStepLeft(0);
                    updateBlockStyle();
                }
            }
        }
        block.setStatus(TowerBlockStatus.ME);
    }

    // 激活某点
    private void activateBlock(int x, int y) {
        Tower tower = TowerData.currTower;
        if (x < 0 || x >= tower.r || y < 0 || y >= tower.c || tower.blocks[x][y].isDisabled())
            return;
        Sampler<Item> itemSampler = tower.getItemSampler();
        TowerBlock block = tower.blocks[x][y];
        // 从不可见变为激活时生成物品
        if (block.isInvisible()) {
            Item item = itemSampler.lottery().getItem();
            block.setItem(item);
            if (quiz.isStatus(QuizStatus.PROGRESSING) && quiz.getTitleItem().equals(item)) {
                quiz.addActualNum(block.getNum());
            }
        }
        block.setStatus(TowerBlockStatus.ACTIVATED);
    }

    // 判断两点是否可达
    private boolean isReachable(int x1, int y1, int x2, int y2) {
        Tower tower = TowerData.currTower;
        // 越界
        if (x1 < 0 || x1 >= tower.r || y1 < 0 || y1 >= tower.c) return false;
        if (x2 < 0 || x2 >= tower.r || y2 < 0 || y2 >= tower.c) return false;

        // 起点和终点相同
        if (x1 == x2 && y1 == y2) return true;

        boolean[][] visited = new boolean[tower.r][tower.c];
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
                if (nx >= 0 && nx < tower.r && ny >= 0 && ny < tower.c && !visited[nx][ny]
                        && !tower.blocks[nx][ny].isInvisible() && !tower.blocks[nx][ny].isDisabled()) {
                    // 检查是否到达终点
                    if (nx == x2 && ny == y2) return true;
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return false;
    }

    // 生成障碍物
    public void generateObstacles(int sx, int sy, int dx, int dy) {
        List<int[]> available = new LinkedList<>();
        Tower tower = TowerData.currTower;
        for (int i = 0, r = tower.r; i < r; i++) {
            for (int j = 0, c = tower.c; j < c; j++) {
                if (i == sx && j == sy || i == dx && j == dy) continue;
                available.add(new int[]{i, j});
            }
        }
        int obstaclesPlaced = 0, numObstacles = RandomUtil.nextInt(tower.minObstacles, tower.maxObstacles + 1);
        while (obstaclesPlaced < numObstacles && !available.isEmpty()) {
            int randomIndex = RandomUtil.nextInt(0, available.size());
            int[] pos = available.get(randomIndex);
            int x = pos[0], y = pos[1];

            // 交换到末尾以便 O(1) 删除
            int[] lastPos = available.get(available.size() - 1);
            available.set(randomIndex, lastPos);
            available.remove(available.size() - 1);

            TowerBlock block = tower.blocks[x][y];
            TowerBlockStatus os = block.getStatus();
            block.setStatus(TowerBlockStatus.DISABLED); // 暂时设置为障碍物
            int expected = tower.r * tower.c - (obstaclesPlaced + 1);
            int actual = bfs(sx, sy, dx, dy);

            if (actual == expected) obstaclesPlaced++;
            else {
                tower.blocks[x][y].setStatus(os); // 恢复
                available.add(pos); // 重新加入候选列表
            }
        }

        if (obstaclesPlaced < numObstacles) {
            throw new RuntimeException("Could not place the required number of obstacles without breaking connectivity.");
        }
    }

    private int bfs(int sx, int sy, int dx, int dy) {
        Tower tower = TowerData.currTower;
        boolean[][] visited = new boolean[tower.r][tower.c];
        Queue<int[]> queue = new LinkedList<>();
        if (tower.blocks[sx][sy].isInvisible()) {
            queue.add(new int[]{sx, sy});
            visited[sx][sy] = true;
        }
        int count = 0;
        // 四个移动方向：上下左右
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            count++;
            // 排除掉终点后续连接点，因为终点不可通过
            if (current[0] == dx && current[1] == dy) continue;
            for (int[] dir : directions) {
                int nx = current[0] + dir[0];
                int ny = current[1] + dir[1];
                if (nx >= 0 && nx < tower.r && ny >= 0 && ny < tower.c && !visited[nx][ny] && TowerData.currTower.blocks[nx][ny].isInvisible()) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return count;
    }

    // 更新地图样式
    public void updateBlockStyle() {
        Tower tower = TowerData.currTower;
        for (int i = 0, r = tower.r; i < r; i++) {
            for (int j = 0, c = tower.c; j < c; j++) {
                TowerBlock block = tower.blocks[i][j];
                block.setStatus(block.getStatus());
            }
        }
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

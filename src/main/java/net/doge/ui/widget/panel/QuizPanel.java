package net.doge.ui.widget.panel;

import net.doge.constant.Colors;
import net.doge.constant.QuizStatus;
import net.doge.data.ActivityData;
import net.doge.data.DataStorage;
import net.doge.data.FontData;
import net.doge.data.ItemData;
import net.doge.model.Item;
import net.doge.model.Quiz;
import net.doge.ui.TowerUI;
import net.doge.ui.widget.button.GButton;
import net.doge.ui.widget.color.GColor;
import net.doge.ui.widget.dialog.ActivityDialog;
import net.doge.ui.widget.dialog.TipDialog;
import net.doge.ui.widget.label.GLabel;
import net.doge.ui.widget.textfield.NumTextField;
import net.doge.util.IconUtil;

import javax.swing.*;
import java.awt.*;

public class QuizPanel extends GPanel {
    private ActivityDialog d;
    private TowerUI ui;
    private Quiz quiz = ActivityData.quiz;

    // 标题
    private Box topBox = new Box(BoxLayout.X_AXIS);
    private GLabel currencyLabel = new GLabel();
    private GPanel titlePanel = new GPanel();
    private GLabel titleLabel = new GLabel();
    // 提示
    private GPanel tipPanel = new GPanel();
    private GLabel tipLabel = new GLabel();
    // 开始
    private GPanel ctrlPanel = new GPanel();
    private GButton minus100Btn = new GButton("-100", GColor.DEEP_GREEN);
    private GButton minus10Btn = new GButton("-10", GColor.DEEP_GREEN);
    private GButton minusBtn = new GButton("-", GColor.DEEP_GREEN);
    private NumTextField numTextField = new NumTextField("0");
    private GButton plusBtn = new GButton("+", GColor.DEEP_GREEN);
    private GButton plus10Btn = new GButton("+10", GColor.DEEP_GREEN);
    private GButton plus100Btn = new GButton("+100", GColor.DEEP_GREEN);
    private GButton oddBtn = new GButton("猜单数", GColor.DARK_RED);
    private GButton evenBtn = new GButton("猜双数", GColor.LIGHT_BLUE);
    private GButton raiseBtn = new GButton("加注", GColor.LIGHT_BLUE);
    private GButton receiveBtn = new GButton("领取", GColor.DARK_ORANGE);
    private GButton nextTurnBtn = new GButton("下一轮", GColor.DARK_RED);

    public QuizPanel(TowerUI ui, ActivityDialog d) {
        this.ui = ui;
        this.d = d;
        init();
    }

    private void updateQuizView() {
        switch (quiz.getStatus()) {
            case SPARE:
                titleLabel.setText(String.format(quiz.getTitle(), quiz.getPrefixText(), quiz.getTitleItem().getName(), "?"));
                tipLabel.setText(String.format("投入%s，竞猜成功即可获得双倍奖励", quiz.getChipItem().getName()));
                tipLabel.setIcon(null);
                break;
            case WAITING:
            case PROGRESSING:
                titleLabel.setText(String.format(quiz.getTitle(), quiz.getPrefixText(), quiz.getTitleItem().getName(), "?"));
                tipLabel.setText(String.format("我的投入：%s，我的竞猜：%s，成功预期可得 %s", quiz.getStakeNum(), Quiz.getQuizText(quiz.getExpectedNum()), quiz.getSuccessStakeNum()));
                tipLabel.setIcon(IconUtil.getIcon(quiz.getChipItem().getIconThumbKey()));
                break;
            case OVER:
                titleLabel.setText(String.format(quiz.getTitle(), quiz.getPrefixText(), quiz.getTitleItem().getName(), quiz.getActualNum()));
                if (quiz.isSuccess()) {
                    tipLabel.setText(String.format("竞猜成功，请领取奖励 %s", quiz.getSuccessStakeNum()));
                    tipLabel.setIcon(IconUtil.getIcon(quiz.getChipItem().getIconThumbKey()));
                } else tipLabel.setText("竞猜失败，请再接再厉");
                break;
        }
        minus100Btn.setVisible(!quiz.isStatus(QuizStatus.OVER));
        minus10Btn.setVisible(!quiz.isStatus(QuizStatus.OVER));
        minusBtn.setVisible(!quiz.isStatus(QuizStatus.OVER));
        numTextField.setVisible(!quiz.isStatus(QuizStatus.OVER));
        plusBtn.setVisible(!quiz.isStatus(QuizStatus.OVER));
        plus10Btn.setVisible(!quiz.isStatus(QuizStatus.OVER));
        plus100Btn.setVisible(!quiz.isStatus(QuizStatus.OVER));
        oddBtn.setVisible(quiz.isStatus(QuizStatus.SPARE));
        evenBtn.setVisible(quiz.isStatus(QuizStatus.SPARE));
        raiseBtn.setVisible(quiz.isStatus(QuizStatus.WAITING) || quiz.isStatus(QuizStatus.PROGRESSING));
        receiveBtn.setVisible(quiz.isStatus(QuizStatus.OVER) && quiz.isSuccess());
        nextTurnBtn.setVisible(quiz.isStatus(QuizStatus.OVER) && !quiz.isSuccess());
    }

    private void init() {
        Item chipItem = quiz.getChipItem();
        currencyLabel.setText(String.valueOf(DataStorage.get(chipItem.getStorageKey())));
        currencyLabel.setIcon(IconUtil.getIcon(chipItem.getIconThumbKey()));
        topBox.add(Box.createHorizontalGlue());
        topBox.add(currencyLabel);
        topBox.add(Box.createHorizontalStrut(20));

        titleLabel.setFont(FontData.TIP_FONT);
        titleLabel.setForeground(GColor.DEEP_GREEN.getAWTColor());
        titlePanel.add(titleLabel);

        tipLabel.setFont(FontData.TIP_FONT);
        tipLabel.setForeground(GColor.DARK_RED.getAWTColor());
        tipLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        tipPanel.add(tipLabel);

        minus100Btn.addActionListener(e_ -> updateAmount(-100));
        minus10Btn.addActionListener(e_ -> updateAmount(-10));
        minusBtn.addActionListener(e_ -> updateAmount(-1));
        plusBtn.addActionListener(e_ -> updateAmount(1));
        plus10Btn.addActionListener(e_ -> updateAmount(10));
        plus100Btn.addActionListener(e_ -> updateAmount(100));
        oddBtn.addActionListener(e -> bet(1));
        evenBtn.addActionListener(e -> bet(0));
        raiseBtn.addActionListener(e -> raise());
        receiveBtn.addActionListener(e -> {
            ui.updateItemAmountAndView(chipItem, quiz.getSuccessStakeNum());
            currencyLabel.setText(String.valueOf(DataStorage.get(chipItem.getStorageKey())));
            quiz.setStatus(QuizStatus.SPARE);
            updateQuizView();
        });
        nextTurnBtn.addActionListener(e -> {
            quiz.setStatus(QuizStatus.SPARE);
            updateQuizView();
        });

        ctrlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        ctrlPanel.add(minus100Btn);
        ctrlPanel.add(minus10Btn);
        ctrlPanel.add(minusBtn);
        ctrlPanel.add(numTextField);
        ctrlPanel.add(plusBtn);
        ctrlPanel.add(plus10Btn);
        ctrlPanel.add(plus100Btn);
        ctrlPanel.add(oddBtn);
        ctrlPanel.add(evenBtn);
        ctrlPanel.add(raiseBtn);
        ctrlPanel.add(receiveBtn);
        ctrlPanel.add(nextTurnBtn);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(topBox);
        add(Box.createVerticalGlue());
        add(titlePanel);
        add(Box.createVerticalGlue());
        add(tipPanel);
        add(Box.createVerticalGlue());
        add(ctrlPanel);
        add(Box.createVerticalGlue());

        updateQuizView();
    }

    private void updateAmount(int amount) {
        String text = numTextField.getText();
        if (text.isEmpty()) return;
        int nn = Integer.parseInt(text) + amount;
        if (nn < 1 || nn > DataStorage.get(quiz.getChipItem().getStorageKey())) return;
        numTextField.setText(String.valueOf(nn));
    }

    // 下注
    private void bet(int expectedNum) {
        String text = numTextField.getText();
        int stepNum = Integer.parseInt(text);
        Item chipItem = quiz.getChipItem();
        if (stepNum < 1) {
            new TipDialog(d, "不满足最低下注数量要求");
            return;
        } else if (stepNum > DataStorage.get(chipItem.getStorageKey())) {
            new TipDialog(d, String.format("%s不足", chipItem.getName()));
            return;
        }
        ui.updateItemAmountAndView(chipItem, -stepNum);
        currencyLabel.setText(String.valueOf(DataStorage.get(chipItem.getStorageKey())));
        quiz.setExpectedNum(expectedNum);
        quiz.setStakeNum(stepNum);
        quiz.setStatus(QuizStatus.WAITING);
        updateQuizView();
    }

    // 加注
    private void raise() {
        String text = numTextField.getText();
        int stepNum = Integer.parseInt(text);
        Item chipItem = quiz.getChipItem();
        if (stepNum < 1) {
            new TipDialog(d, "不满足最低加注数量要求");
            return;
        } else if (stepNum > DataStorage.get(chipItem.getStorageKey())) {
            new TipDialog(d, String.format("%s不足", chipItem.getName()));
            return;
        }
        ui.updateItemAmountAndView(chipItem, -stepNum);
        currencyLabel.setText(String.valueOf(DataStorage.get(chipItem.getStorageKey())));
        quiz.raise(stepNum);
        updateQuizView();
    }
}

package net.doge.data;

import net.doge.constant.IconKey;
import net.doge.model.Transaction;

import java.util.LinkedList;
import java.util.List;

public class TransactionData {
    public static List<Transaction> transactions = new LinkedList<>();

    static {
        initData();
    }

    public static void initData() {
        // 一塔
        transactions.add(new Transaction(IconKey.BASIC_STEP, ItemData.BASIC_STEP, 1, ItemData.ADVANCED_COIN, 10));
        transactions.add(new Transaction(IconKey.BASIC_STEP_TRANSACTION, ItemData.BASIC_STEP, 10000, ItemData.ADVANCED_COIN, 63998));
        transactions.add(new Transaction(IconKey.BASIC_STEP_TRANSACTION, ItemData.BASIC_STEP, 5000, ItemData.ADVANCED_COIN, 32998));
        transactions.add(new Transaction(IconKey.BASIC_STEP_TRANSACTION, ItemData.BASIC_STEP, 1000, ItemData.ADVANCED_COIN, 6800));
        transactions.add(new Transaction(IconKey.BASIC_STEP_TRANSACTION, ItemData.BASIC_STEP, 500, ItemData.ADVANCED_COIN, 3498));
        transactions.add(new Transaction(IconKey.BASIC_STEP_TRANSACTION, ItemData.BASIC_STEP, 100, ItemData.ADVANCED_COIN, 698));
        transactions.add(new Transaction(IconKey.BASIC_STEP_TRANSACTION, ItemData.BASIC_STEP, 50, ItemData.ADVANCED_COIN, 368));
        transactions.add(new Transaction(IconKey.BASIC_STEP_TRANSACTION, ItemData.BASIC_STEP, 20, ItemData.ADVANCED_COIN, 160));
        transactions.add(new Transaction(IconKey.BASIC_STEP_TRANSACTION, ItemData.BASIC_STEP, 10, ItemData.ADVANCED_COIN, 90));

        // 二塔
        transactions.add(new Transaction(IconKey.REGULAR_STEP, ItemData.REGULAR_STEP, 1, ItemData.ADVANCED_COIN, 128));
        transactions.add(new Transaction(IconKey.REGULAR_STEP_TRANSACTION, ItemData.REGULAR_STEP, 10000, ItemData.ADVANCED_COIN, 998400));
        transactions.add(new Transaction(IconKey.REGULAR_STEP_TRANSACTION, ItemData.REGULAR_STEP, 5000, ItemData.ADVANCED_COIN, 512000));
        transactions.add(new Transaction(IconKey.REGULAR_STEP_TRANSACTION, ItemData.REGULAR_STEP, 1000, ItemData.ADVANCED_COIN, 104960));
        transactions.add(new Transaction(IconKey.REGULAR_STEP_TRANSACTION, ItemData.REGULAR_STEP, 500, ItemData.ADVANCED_COIN, 53758));
        transactions.add(new Transaction(IconKey.REGULAR_STEP_TRANSACTION, ItemData.REGULAR_STEP, 100, ItemData.ADVANCED_COIN, 11008));
        transactions.add(new Transaction(IconKey.REGULAR_STEP_TRANSACTION, ItemData.REGULAR_STEP, 30, ItemData.ADVANCED_COIN, 3388));
        transactions.add(new Transaction(IconKey.REGULAR_STEP_TRANSACTION, ItemData.REGULAR_STEP, 10, ItemData.ADVANCED_COIN, 1188));

        // 三塔
        transactions.add(new Transaction(IconKey.ADVANCED_STEP, ItemData.ADVANCED_STEP, 1, ItemData.ADVANCED_COIN, 298));
        transactions.add(new Transaction(IconKey.ADVANCED_STEP_TRANSACTION, ItemData.ADVANCED_STEP, 10000, ItemData.ADVANCED_COIN, 2384000));
        transactions.add(new Transaction(IconKey.ADVANCED_STEP_TRANSACTION, ItemData.ADVANCED_STEP, 5000, ItemData.ADVANCED_COIN, 1221800));
        transactions.add(new Transaction(IconKey.ADVANCED_STEP_TRANSACTION, ItemData.ADVANCED_STEP, 1000, ItemData.ADVANCED_COIN, 250320));
        transactions.add(new Transaction(IconKey.ADVANCED_STEP_TRANSACTION, ItemData.ADVANCED_STEP, 500, ItemData.ADVANCED_COIN, 128140));
        transactions.add(new Transaction(IconKey.ADVANCED_STEP_TRANSACTION, ItemData.ADVANCED_STEP, 100, ItemData.ADVANCED_COIN, 26220));
        transactions.add(new Transaction(IconKey.ADVANCED_STEP_TRANSACTION, ItemData.ADVANCED_STEP, 30, ItemData.ADVANCED_COIN, 8040));
        transactions.add(new Transaction(IconKey.ADVANCED_STEP_TRANSACTION, ItemData.ADVANCED_STEP, 10, ItemData.ADVANCED_COIN, 2680));
    }
}

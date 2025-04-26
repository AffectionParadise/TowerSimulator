package net.doge.data.storage;

import lombok.Getter;
import net.doge.model.GiftRecord;

import java.util.LinkedList;

public class GiftRecordStorage {
    private static final int MAX_SIZE = 100;
    @Getter
    private static LinkedList<GiftRecord> storage = new LinkedList<>();

    public static void add(GiftRecord record) {
        storage.add(0, record);
        if (storage.size() > MAX_SIZE) storage.removeLast();
    }
}

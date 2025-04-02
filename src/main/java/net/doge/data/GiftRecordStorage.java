package net.doge.data;

import lombok.Getter;
import net.doge.constant.StorageKey;
import net.doge.model.GiftRecord;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GiftRecordStorage {
    private static final int MAX_SIZE = 50;
    @Getter
    private static LinkedList<GiftRecord> storage = new LinkedList<>();

    public static void add(GiftRecord record) {
        storage.add(0, record);
        if (storage.size() > MAX_SIZE) storage.removeLast();
    }
}

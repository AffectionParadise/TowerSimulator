package net.doge.data.storage;

import lombok.Getter;
import net.doge.constant.StorageKey;

import java.util.HashMap;
import java.util.Map;

public class GiftCensusStorage {
    @Getter
    protected static Map<StorageKey, Integer> storage = new HashMap<>();

    public static int get(StorageKey key) {
        return storage.getOrDefault(key, 0);
    }

    public static void add(StorageKey key, int value) {
        storage.put(key, get(key) + value);
    }
}

package net.doge.data;

import lombok.Getter;
import net.doge.constant.StorageKey;

import java.util.HashMap;
import java.util.Map;

public class GiftCensusStorage {
    @Getter
    private static Map<StorageKey, Integer> storage = new HashMap<>();

    public static int get(StorageKey key) {
        return storage.getOrDefault(key, 0);
    }

    public static void add(StorageKey key, int value) {
        // 溢出后重置为 0
        storage.put(key, Math.max(0, storage.getOrDefault(key, 0) + value));
    }
}

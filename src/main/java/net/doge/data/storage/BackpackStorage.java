package net.doge.data.storage;

import lombok.Getter;
import net.doge.constant.StorageKey;

import java.util.HashMap;
import java.util.Map;

@Getter
public class BackpackStorage {
    private Map<StorageKey, Integer> storage = new HashMap<>();

    public int get(StorageKey key) {
        return storage.getOrDefault(key, 0);
    }

    public void add(StorageKey key, int value) {
        storage.put(key, storage.getOrDefault(key, 0) + value);
    }

    public void clear() {
        storage.clear();
    }
}

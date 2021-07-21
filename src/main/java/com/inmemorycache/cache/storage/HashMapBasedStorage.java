package com.inmemorycache.cache.storage;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {

    Map<Key, Value> storage;
    private final Integer capacity;

    public HashMapBasedStorage(Integer capacity) {
        this.capacity = capacity;
        storage = new HashMap<>();
    }

    @Override
    public void add(Key key, Value value) throws RuntimeException {
        if (isStorageFull()) throw new RuntimeException("Capacity Full.....");
        storage.put(key, value);
    }

    @Override
    public void remove(Key key) throws RuntimeException {
        if (!storage.containsKey(key)) throw new RuntimeException(key + "doesn't exist in cache.");
        storage.remove(key);
    }

    @Override
    public Value get(Key key) throws RuntimeException {
        if (!storage.containsKey(key)) throw new RuntimeException(key + "doesn't exist in cache.");
        return storage.get(key);
    }

    private boolean isStorageFull() {
        return storage.size() == capacity;
    }
}


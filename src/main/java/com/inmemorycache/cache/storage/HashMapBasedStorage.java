package com.inmemorycache.cache.storage;

import com.inmemorycache.cache.exception.StorageFullException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {

    Map<Key, Value> storage;
    private final Integer capacity;

    public HashMapBasedStorage(Integer capacity) {
        this.capacity = capacity;
        storage = new HashMap<>();
    }

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        if (isStorageFull()) throw new StorageFullException("Storage Full");
        storage.put(key, value);
    }

    @Override
    public void remove(Key key) throws NoSuchElementException {
        if (!storage.containsKey(key)) throw new NoSuchElementException(key + "doesn't exist in cache.");
        storage.remove(key);
    }

    @Override
    public Value get(Key key) throws NoSuchElementException {
        if (!storage.containsKey(key)) throw new NoSuchElementException(key + "doesn't exist in cache.");
        return storage.get(key);
    }

    private boolean isStorageFull() {
        return storage.size() == capacity;
    }
}


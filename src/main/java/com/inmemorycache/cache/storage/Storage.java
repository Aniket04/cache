package com.inmemorycache.cache.storage;

public interface Storage<Key, Value> {
    public void add(Key key, Value value) throws RuntimeException;

    void remove(Key key) throws RuntimeException;

    Value get(Key key) throws RuntimeException;
}

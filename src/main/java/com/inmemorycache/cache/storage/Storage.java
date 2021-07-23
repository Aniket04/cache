package com.inmemorycache.cache.storage;

import com.inmemorycache.cache.exception.StorageFullException;

import java.util.NoSuchElementException;

public interface Storage<Key, Value> {
    public void add(Key key, Value value) throws StorageFullException;

    void remove(Key key) throws NoSuchElementException;

    Value get(Key key) throws NoSuchElementException;
}

package com.inmemorycache.cache.cache_type;

import com.inmemorycache.cache.eviction_policy.EvictionPolicy;
import com.inmemorycache.cache.exception.StorageFullException;
import com.inmemorycache.cache.exception.UnexpectedStateException;
import com.inmemorycache.cache.storage.Storage;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

public class Cache<Key, Value> {
    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;
    private static Logger logger = Logger.getLogger(Cache.class.getName());

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value) {
        try {
            this.storage.add(key, value);
            this.evictionPolicy.keyPut(key);
        } catch (Exception exception) {
            if(exception.getClass() == StorageFullException.class) {
                logger.info("Got storage full. Will try to evict.");
                Optional<Key> keyToRemove = evictionPolicy.evictKey();
                Key keyNeedToRemove = keyToRemove.orElseThrow(() -> new UnexpectedStateException("Unexpected State. Storage full and no key to evict."));
                this.storage.remove(keyNeedToRemove);
                logger.info("Creating space by evicting item..." + keyToRemove);
                put(key, value);
            }
            else {
                throw new RuntimeException("Some Unexpected behaviour in put method");
            }
        }
    }

    public Value get(Key key) {
        try {
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        } catch (NoSuchElementException notFoundException) {
            logger.info("Tried to access non-existing key.");
            return null;
        }
    }
}
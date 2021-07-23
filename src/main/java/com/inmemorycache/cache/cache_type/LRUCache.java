package com.inmemorycache.cache.cache_type;

import com.inmemorycache.cache.eviction_policy.LRUEvictionPolicy;
import com.inmemorycache.cache.storage.HashMapBasedStorage;

public class LRUCache<Key,Value> extends Cache<Key, Value> {
    public LRUCache(final int capacity) {
        super(new LRUEvictionPolicy<Key>(), new HashMapBasedStorage<Key, Value>(capacity));
    }
}


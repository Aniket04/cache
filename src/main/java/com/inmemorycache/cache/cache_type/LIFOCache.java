package com.inmemorycache.cache.cache_type;

import com.inmemorycache.cache.eviction_policy.LIFOEvictionPolicy;
import com.inmemorycache.cache.storage.HashMapBasedStorage;

public class LIFOCache<Key, Value> extends Cache<Key, Value> {
    public LIFOCache(final int capacity) {
        super(new LIFOEvictionPolicy<Key>(), new HashMapBasedStorage<Key, Value>(capacity));
    }
}

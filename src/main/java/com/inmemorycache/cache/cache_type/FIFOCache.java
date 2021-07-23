package com.inmemorycache.cache.cache_type;

import com.inmemorycache.cache.eviction_policy.FIFOEvictionPolicy;
import com.inmemorycache.cache.storage.HashMapBasedStorage;

public class FIFOCache<Key, Value> extends Cache<Key, Value> {
    public FIFOCache(final int capacity) {
        super(new FIFOEvictionPolicy<Key>(), new HashMapBasedStorage<Key, Value>(capacity));
    }
}

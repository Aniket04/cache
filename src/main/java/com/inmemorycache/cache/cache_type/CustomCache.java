package com.inmemorycache.cache.cache_type;

import com.inmemorycache.cache.eviction_policy.EvictionPolicy;
import com.inmemorycache.cache.storage.HashMapBasedStorage;

public class CustomCache<Key,Value> extends Cache<Key, Value>{
    public CustomCache(final int capacity, EvictionPolicy<Key> customEvictionPolicy) {
        super(customEvictionPolicy, new HashMapBasedStorage<Key, Value>(capacity));
    }
}

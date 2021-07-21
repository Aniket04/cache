package com.inmemorycache.cache.eviction_policy;

public interface EvictionPolicy<Key>{
    void keyPut(Key key);
    void keyAccessed(Key key);
    Key evictKey();
}

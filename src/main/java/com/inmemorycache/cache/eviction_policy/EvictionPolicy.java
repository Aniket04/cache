package com.inmemorycache.cache.eviction_policy;

import java.util.Optional;

public interface EvictionPolicy<Key>{
    void keyPut(Key key);

    void keyAccessed(Key key);

    Optional<Key> evictKey();
}

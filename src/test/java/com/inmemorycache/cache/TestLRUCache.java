package com.inmemorycache.cache;

import com.inmemorycache.cache.cache_type.LRUCache;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import static org.junit.Assert.*;

public class TestLRUCache {

    @Test
    void testCaching() {
        LRUCache<Integer, String> myCache = new LRUCache<Integer,String>(10);
        myCache.put(1, "test1");
        myCache.put(2, "test2");
        assertEquals(myCache.get(1), "test1");
        assertEquals(myCache.get(2), "test2");
    }

    @Test
    void testEvictionPolicy() {
        LRUCache<Integer, String> myCache = new LRUCache<Integer,String>(3);
        myCache.put(1, "string1");
        myCache.put(2, "string2");
        myCache.put(3, "string3");
        assertEquals(myCache.get(1), "string1");
        myCache.put(4, "string4");
        assertNull(myCache.get(2));
        assertEquals(myCache.get(1), "string1");
        assertEquals(myCache.get(3), "string3");
        assertEquals(myCache.get(4), "string4");
    }


}

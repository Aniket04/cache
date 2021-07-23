package com.inmemorycache.cache;

import com.inmemorycache.cache.cache_type.FIFOCache;
import com.inmemorycache.cache.cache_type.LIFOCache;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestLIFOCache {
    @Test
    void testCaching() {
        LIFOCache<Integer, String> myCache = new LIFOCache<Integer,String>(10);
        myCache.put(1, "test1");
        myCache.put(2, "test2");
        assertEquals(myCache.get(1), "test1");
        assertEquals(myCache.get(2), "test2");
    }

    @Test
    void testEvictionPolicy() {
        LIFOCache<Integer, String> myCache = new LIFOCache<Integer,String>(3);
        myCache.put(1, "string1");
        myCache.put(2, "string2");
        myCache.put(3, "string3");
        assertEquals(myCache.get(1), "string1");
        myCache.put(4, "string4");
        assertNull(myCache.get(3));
        assertEquals(myCache.get(1), "string1");
        assertEquals(myCache.get(2), "string2");
        assertEquals(myCache.get(4), "string4");
    }

}

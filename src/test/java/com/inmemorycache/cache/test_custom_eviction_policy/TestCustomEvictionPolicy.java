package com.inmemorycache.cache.test_custom_eviction_policy;

import com.inmemorycache.cache.cache_type.Cache;
import com.inmemorycache.cache.cache_type.CustomCache;
import com.inmemorycache.cache.cache_type.FIFOCache;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestCustomEvictionPolicy {
    @Test
    void testCaching() {
        Cache<String, String> myCache = new CustomCache<String,String>(10, new CustomEvictionPolicyForTest<String>());
        myCache.put("1", "test1");
        myCache.put("2", "test2");
        assertEquals(myCache.get("1"), "test1");
        assertEquals(myCache.get("2"), "test2");
    }

    @Test
    void testEvictionPolicy() {
        Cache<String, String> myCache = new CustomCache<String,String>(3, new CustomEvictionPolicyForTest<String>());
        myCache.put("1", "string1");
        myCache.put("2", "string2");
        myCache.put("3", "string3");
        assertEquals(myCache.get("1"), "string1");
        myCache.put("4", "string4");
        assertNull(myCache.get("1"));
        assertEquals(myCache.get("2"), "string2");
        assertEquals(myCache.get("3"), "string3");
        assertEquals(myCache.get("4"), "string4");
    }
}

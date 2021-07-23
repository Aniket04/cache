package com.inmemorycache.cache.test_custom_eviction_policy;

import com.inmemorycache.cache.eviction_policy.EvictionPolicy;
import com.inmemorycache.cache.helper.DoublyLinkedList;
import com.inmemorycache.cache.helper.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CustomEvictionPolicyForTest<Key> implements EvictionPolicy<Key> {
    private DoublyLinkedList<Key> dll;
    private Map<Key, DoublyLinkedListNode<Key>> mapper;

    public CustomEvictionPolicyForTest() {
        this.dll = new DoublyLinkedList<>();
        this.mapper = new HashMap<>();
    }

    @Override
    public void  keyPut(Key key) {
        DoublyLinkedListNode<Key> newNode = dll.addElementAtLast(key);
        mapper.put(key, newNode);
    }

    @Override
    public void  keyAccessed(Key key) {
        dll.detachNode(mapper.get(key));
        dll.addNodeAtLast(mapper.get(key));
    }


    @Override
    public Optional<Key> evictKey() {
        DoublyLinkedListNode<Key> last = dll.getLastNode();
        if(last == null) {
            return null;
        }
        dll.detachNode(last);
        return Optional.of(last.getElement());
    }
}


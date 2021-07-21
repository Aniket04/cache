package com.inmemorycache.cache.eviction_policy;

import com.inmemorycache.cache.eviction_policy_storage.DoublyLinkedList;
import com.inmemorycache.cache.eviction_policy_storage.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class FIFOEvictionPolicy<Key> implements EvictionPolicy<Key>{
    private DoublyLinkedList<Key> dll;
    private Map<Key, DoublyLinkedListNode<Key>> mapper;

    public FIFOEvictionPolicy() {
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
    }


    @Override
    public Key evictKey() {
        DoublyLinkedListNode<Key> first = dll.getFirstNode();
        if(first == null) {
            return null;
        }
        dll.detachNode(first);
        return first.getElement();
    }
}

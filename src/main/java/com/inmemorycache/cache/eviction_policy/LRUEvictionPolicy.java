package com.inmemorycache.cache.eviction_policy;

import com.inmemorycache.cache.eviction_policy_storage.DoublyLinkedList;
import com.inmemorycache.cache.eviction_policy_storage.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    private DoublyLinkedList<Key> dll;
    private Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy() {
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
    public Key evictKey() {
        DoublyLinkedListNode<Key> first = dll.getFirstNode();
        if(first == null) {
            return null;
        }
        dll.detachNode(first);
        return first.getElement();
    }
}

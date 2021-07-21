package com.inmemorycache.cache.eviction_policy;

import com.inmemorycache.cache.eviction_policy_storage.DoublyLinkedList;
import com.inmemorycache.cache.eviction_policy_storage.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LIFOEvictionPolicy<Key> implements EvictionPolicy<Key>{
    private DoublyLinkedList<Key> dll;
    private Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LIFOEvictionPolicy() {
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
        DoublyLinkedListNode<Key> last = dll.getLastNode();
        if(last == null) {
            return null;
        }
        dll.detachNode(last);
        return last.getElement();
    }
}

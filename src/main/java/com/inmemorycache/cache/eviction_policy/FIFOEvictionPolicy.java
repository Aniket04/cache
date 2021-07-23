package com.inmemorycache.cache.eviction_policy;

import com.inmemorycache.cache.helper.DoublyLinkedList;
import com.inmemorycache.cache.helper.DoublyLinkedListNode;
import java.util.Map;
import java.util.Optional;

public class FIFOEvictionPolicy<Key> implements EvictionPolicy<Key>{
    private DoublyLinkedList<Key> dll;
    private Map<Key, DoublyLinkedListNode<Key>> mapper;

    public FIFOEvictionPolicy() {
        this.dll = new DoublyLinkedList<>();
    }

    @Override
    public void  keyPut(Key key) {
        DoublyLinkedListNode<Key> newNode = dll.addElementAtLast(key);
    }

    @Override
    public void  keyAccessed(Key key) {
    }

    @Override
    public Optional<Key> evictKey() {
        DoublyLinkedListNode<Key> first = dll.getFirstNode();
        if(first == null) {
            return null;
        }
        dll.detachNode(first);
        return Optional.of(first.getElement());
    }
}

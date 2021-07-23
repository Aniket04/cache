package com.inmemorycache.cache.eviction_policy;

import com.inmemorycache.cache.eviction_policy_helper.DoublyLinkedList;
import com.inmemorycache.cache.eviction_policy_helper.DoublyLinkedListNode;

import java.util.Optional;

public class LIFOEvictionPolicy<Key> implements EvictionPolicy<Key>{
    private DoublyLinkedList<Key> dll;

    public LIFOEvictionPolicy() {
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
        DoublyLinkedListNode<Key> last = dll.getLastNode();
        if(last == null) {
            return null;
        }
        dll.detachNode(last);
        return Optional.of(last.getElement());
    }
}

package com.inmemorycache.cache.eviction_policy_storage;


public class DoublyLinkedListNode<E> {
    DoublyLinkedListNode<E> next;
    DoublyLinkedListNode<E> prev;
    E element;

    public DoublyLinkedListNode(E element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }

    public DoublyLinkedListNode<E> getNext() {
        return next;
    }

    public DoublyLinkedListNode<E> getPrev() {
        return prev;
    }

    public E getElement() {
        return element;
    }
}

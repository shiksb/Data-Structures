package com.DoublyLinkedList;

import java.util.Iterator;
/**
 * Created by shikhar on 3/4/17.
 */
public interface LinkedListInterface<T> {

    public void add(T item, int index);
    public void addFirst(T item);
    public void addLast(T item);
    public void remove(int index);
    public T get(int index);
    public void set(T item, int index);
    public Iterator<T> iterator();
    public int size();
}

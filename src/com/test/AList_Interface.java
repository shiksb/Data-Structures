package com.test;

import java.util.Iterator;

/**
 * Created by shikhar on 3/3/17.
 */
public interface AList_Interface<T> {
    public void addFirst(T item);
    public void addLast(T item);
    public void add(T item, int index);
    public void removeLast();
    public void removeFirst();
    public void remove(int index);
    public T getFirst();
    public T getLast();
    public T get(int index);
    public void set(T item, int index);
    public Iterator<T> iterator();
    public int size();
}

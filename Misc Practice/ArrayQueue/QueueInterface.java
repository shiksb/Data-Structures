// package com.ArrayQueue;

/**
 * Created by shikhar on 3/5/17.
 */
public interface QueueInterface<T> {
    public void enqueue(T item);
    public T dequeue();
    public int size();
}

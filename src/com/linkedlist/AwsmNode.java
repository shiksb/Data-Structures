package com.linkedlist;

/**
 * Created by shikhar on 3/3/17.
 */
public class AwsmNode<T> {
    public T data;
    public AwsmNode<T> next;

    public AwsmNode(T data, AwsmNode<T> next) {
        this.data = data;
        this.next = next;
    }
}

package com.linkedlist;

import com.company.*;
import com.company.AwsmList;

import java.util.Iterator;

/**
 * Created by shikhar on 3/3/17.
 */
public class AwsmLinkedList<T> implements Iterable<T>, com.company.AwsmList<T> {

    private AwsmNode<T> head;
    private int size;

    public AwsmLinkedList() {
        this.head = new AwsmNode<>(null, null);
        this.size = 0;
    }

    @Override
    public void addFirst(T item) {
        add(item, 0);
    }

    @Override
    public void addLast(T item) {
        add(item, size);
    }

    @Override
    public void add(T item, int index) {
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            AwsmNode<T> current = head;
            for(int i = 0; i < index; i++) {
                current = current.next;
            }
            AwsmNode<T> newNode = new AwsmNode<>(item, current.next);
            current.next = newNode;
            size++;
        }
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void remove(int index) {
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            AwsmNode<T> current = head;
            for(int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    @Override
    public T get(int index) {
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            AwsmNode<T> current = head;
            for(int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }
    }

    @Override
    public void setFirst(T item) {
        set(item, 0);
    }

    @Override
    public void setLast(T item) {
        set(item, size - 1);
    }

    @Override
    public void set(T item, int index) {
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            AwsmNode<T> current = head;
            for(int i = 0; i < index; i++) {
                current = current.next;
            }
            current.data = item;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new AwsmLinkedListIterator<>();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        AwsmNode<T> current = head.next;
        while (current != null) {
            stringBuilder.append(current.data);
            stringBuilder.append(" ");
            current = current.next;
        }
        return stringBuilder.toString().trim();
    }

    public class AwsmLinkedListIterator<AnotherT> implements Iterator<T> {

        public AwsmNode<T> current;

        public AwsmLinkedListIterator() {
            this.current = head;
        }

        public boolean hasNext(){
            return current.next != null;
        }

        public T next() {
            current = current.next;
            return current.data;
        }
    }

    public class AwsmNode<YetAnotherT> {
        public YetAnotherT data;
        public AwsmNode<YetAnotherT> next;

        public AwsmNode(YetAnotherT data, AwsmNode<YetAnotherT> next) {
            this.data = data;
            this.next = next;
        }
    }

}

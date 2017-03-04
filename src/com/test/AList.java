package com.test;

import java.util.Iterator;

/**
 * Created by shikhar on 3/3/17.
 */
public class AList<T> implements AList_Interface<T>, Iterable<T> {

    public T[] data;
    public int size;

    public AList(int len) {
        data = (T[]) new Object[len];
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        add(item, 0);
    }

    @Override
    public void addLast(T item) {
        add(item, size - 1);
    }

    @Override
    public void add(T item, int index) {
        if(index < 0 || index >= data.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            if(data.length == size) {
                expand();
            }

            if(index > size) {
                index = size;
            }

            for(int i = size; i > index; i--) {
                data[i] = data[i - 1];
            }
            data[index] = item;
            size++;
        }
    }

    private void expand() {
        T[] big_data = (T[]) new Object[data.length * 2];
        for(int i = 0; i < data.length; i ++ ) {
            big_data[i] = data[i];
        }
        data = big_data;
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void remove(int index) {
        if(index < 0 || index >= data.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            if(index > size) {
                index = size;
            }
            for(int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            data[size - 1] = null;
            size--;
        }
    }

    @Override
    public T getFirst() {
        return data[0];
    }

    @Override
    public T getLast() {
        return data[size - 1];
    }

    @Override
    public T get(int index) {
        return data[index];
    }

    @Override
    public void set(T item, int index) {
        data[index] = item;
    }

//    @Override
//    public Iterator<T> iterate() {
//        return new AIter<>(this);
//    }

    @Override
    public Iterator<T> iterator() {
        return new AIter<>(this);
    }

    public class AIter<T> implements Iterator<T> {

        public AList<T> li;
        public int index;

        public AIter(AList<T> li) {
            this.li = li;
            index = 0;
        }

        public boolean hasNext() {
            return index < li.size();
        }

        public T next() {
            T item = li.get(index);
            index ++;
            return item;
        }
    }

    @Override
    public int size() {
        return this.size;
    }
}

package com.company;

import java.util.Iterator;

/**
 * Created by shikhar on 3/3/17.
 */
public class AwsmArrayListIterator<T> implements Iterator<T> {

    private AwsmArrayList<T> list;
    private int index;

    public AwsmArrayListIterator(AwsmArrayList<T> list) {
        this.list = list;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T next() throws IndexOutOfBoundsException {
        if (this.hasNext()) {
            T v = list.get(index);
            index ++;
            return v;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}

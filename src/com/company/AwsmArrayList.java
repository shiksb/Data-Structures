package com.company;
import java.util.Iterator;

/**
 * Created by shikhar on 3/2/17.
 */
public class AwsmArrayList<T> implements AwsmList<T>, Iterable<T> {

    private T[] data;
    private int size;

    public AwsmArrayList(int length) {
        this.data = (T[]) new Object[length];
        this.size = 0;
    }

    public AwsmArrayList() {
        this.data = (T[]) new Object[8];
        this.size = 0;
    }

    private void expand(){
        T[] big_data = (T[]) new Object[data.length * 2];
        for(int i = 0; i < data.length; i++) {
            big_data[i] = data[i];
        }
        data = big_data;
        System.out.println("Expanded to " + data.length);
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
    public void add(T item, int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException();
        } else {
            if(index > size) { index = size;}
            if(size == data.length) { expand(); }
            for(int i = size; i > index; i--){
                data[i] = data[i - 1];
            }
            data[index] = item;
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
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            for(int i = index; i < size - 1; i++){
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
    public T get(int index) throws ArrayIndexOutOfBoundsException {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return data[index];
        }
    }

    @Override
    public void setFirst(T item) {
        data[0] = item;
    }

    @Override
    public void setLast(T item) {
        data[size - 1] = item;
    }

    @Override
    public void set(T item, int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            data[index] = item;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new AwsmArrayListIterator<>(this);
    }

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

    @Override
    public int size() {
        return size;
    }
}

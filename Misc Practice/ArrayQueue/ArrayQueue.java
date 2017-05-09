// package com.ArrayQueue;

/**
 * Created by shikhar on 3/5/17.
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    private T[] queue;
    private int length;
    private int front;
    private int back;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int length){
        this.queue = (T[]) new Object[length];
        this.length = length;
        this.front = 0;
        this.back = 0;
    }

    @Override
    public void enqueue(T item) {
        if(size == length) { throw new ArrayIndexOutOfBoundsException(); }
        queue[back] = item;
        back = (back + 1) % length;
        size++;
    }

    @Override
    public T dequeue() {
        if(size == 0) { throw new ArrayIndexOutOfBoundsException(); }
        T frontitem = queue[front];
        // queue[front] = null;
        front = (front + 1) % length;
        size--;
        return frontitem;
    }

    @Override
    public int size() {
        return size++;
    }

    public void printQ(){
        System.out.println("The queue is: ");
        for(int i = 0; i < length; i++){
            System.out.println("\t" + i + ": " + queue[i]);
        }
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        queue.enqueue(1);
        queue.dequeue();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(4);
        queue.enqueue(5);
            queue.printQ();
        queue.enqueue(6);
        queue.enqueue(7);
            queue.printQ();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(11);
        queue.enqueue(12);
        queue.enqueue(13);
        queue.printQ();

    }
}

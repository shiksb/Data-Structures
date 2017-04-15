package com.ArrayStack;

/**
 * Created by shikhar on 3/4/17.
 */
public class ArrayStack<T> implements StackInterface<T> {

    private T[] myStack;
    private int size;

    public ArrayStack(int length) {
        this.myStack = (T[]) new Object[length];
        this.size = 0;
    }

    public void push(T item) {
        if(size == myStack.length) {
            throw new StackOverflowError();
        } else {
            myStack[size] = item;
            size++;
        }
    }

    public T pop() {
        if(size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            size--;
            T item = myStack[size];
            myStack[size] = null;
            return item;
        }
    }

    public int size() {
        return size;
    }


    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}


//package com.company;
/*
* Name: Shikhar Bakhda
* UNI: ssb2189
* TwoStackQueue.java
* This program defines the queue methods such as enqueue dequeue and more.
*
* */
public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {


    public MyStack<AnyType> S1 = new MyStack<>();
    public MyStack<AnyType> S2 = new MyStack<>();


    @Override
    public void enqueue(AnyType x) {
        S1.push(x);
    }

    @Override
    public AnyType dequeue() {
        if (S2.isEmpty()) {
            moveAllToRight();
        }
        return S2.pop();
    }

    @Override
    public boolean isEmpty() {
        if (S1.isEmpty() && S2.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return S1.size() + S2.size();
    }

    // method moves data from S1 to S2
    public void moveAllToRight() {
        while (!S1.isEmpty()) {
            S2.push(S1.pop());
        }
    }
}

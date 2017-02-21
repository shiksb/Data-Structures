//package com.company;
/*
* Name: Shikhar Bakhda
* UNI: ssb2189
* MyStack.java
* This program defines the stack methods needed
*
* */

public class MyStack<AnyType>{

    LinkedList<AnyType> li = new LinkedList<>();
    public int size;

    // constructor to initialise the size
    public MyStack(){
        size = 0;
    }

    // push method
    public void push(AnyType data) {
        li.insertFirst(data);
        size++;
    }

    // pop method
    public AnyType pop() {
        if(li.isEmpty()){
            return null;
        } else{
            AnyType popped = this.top();
            li.deleteFirst();
            size--;
            return popped;
        }
    }

    // top/peek method
    public AnyType top(){
        if(li.isEmpty()){return null;}
        else{
            return li.showFirst();
        }
    }

    // returns true if empty
    public Boolean isEmpty(){
        return li.isEmpty();
    }

    //returns size
    public int size() {
        return this.size;
    }

    // displays the stack
    public void displayStack() {
        System.out.println("  ");
        li.displayList();
    }
}
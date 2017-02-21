//package com.company;

/*
* Name: Shikhar Bakhda
* UNI: ssb2189
* Node.java
* This program defines a single Node that will be used for the linked list
*
* */

public class Node<AnyType> {

    public AnyType data;
    public Node<AnyType> next;

    public Node(AnyType data) {
        this.data = data;
    }

    public void displayNode() {
        System.out.println(data);
    }

}


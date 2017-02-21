//package com.company;
/*
* Name: Shikhar Bakhda
* UNI: ssb2189
* LinkedList.java
* This program defines the LinkedList that is needed for the questions
*
* */

public class LinkedList<AnyType> {

    public Node<AnyType> first;
    public int size;

    public LinkedList(){
        size = 0;
    }

    public void insertFirst(AnyType data) {
        Node n = new Node(data);
        n.next = first;
        first = n;
        size++;
    }

    public void deleteFirst() {
        first = first.next;
        size--;
    }

    public AnyType showFirst(){
        return first.data;
    }

    public void displayList() {
        Node current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return (first == null);
    }


}

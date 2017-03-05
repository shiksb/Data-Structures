package com.DoublyLinkedList;

import java.util.Iterator;

/**
 * Created by shikhar on 3/4/17.
 */
public class DoublyLinkedList<T> implements LinkedListInterface<T>,
        Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.next = tail;
        size = 0;
    }

    public Node<T> getNode(int index) {
        Node<T> current;
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        } else if(index <= size/2) {
            current = head;
            for(int i = 0; i < index; i ++) {
                current = current.next;
            }
        } else {
            current = tail;
            for(int i = size - 1; i >= index; i --) {
                current = current.prev;
            }
            current = tail.prev;
        }
        return current;
    }

    public void add(T item, int index) {
        Node<T> current = getNode(index);
        Node<T> newNode = new Node<>(item, current, current.next);
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    public void addFirst(T item) {
        add(item, 0);
    }

    public void addLast(T item){
        add(item, size);
    }

    public void remove(int index){
        Node<T> current = getNode(index).next;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
    }

    public T get(int index) {
        return getNode(index).next.data;
    }

    public void set(T item, int index) {
        getNode(index).next.data = item;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator<>();
    }

    public int size(){
        return this.size;
    }

    public class Node<AnotherT> {

        public Node<AnotherT> next;
        public Node<AnotherT> prev;
        public AnotherT data;

        public Node(AnotherT data, Node<AnotherT> prev, Node<AnotherT> next){
            this.next = next;
            this.prev = prev;
            this.data = data;
        }
    }

    public class LinkedListIterator<YetAnotherT> implements Iterator<T>{

        private Node<T> current;

        public LinkedListIterator(){
            this.current = head;
        }

        public T next() {
            current = current.next;
            return current.data;
        }

        public boolean hasNext() {
            return current.next.next != null;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(1);
        list.add(2, 0);
        list.addLast(3);
        Iterator<Integer> iter = list.iterator();

        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("\n" + list.get(1));
    }

}

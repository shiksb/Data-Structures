package com.LinkedStack;

/**
 * Created by shikhar on 3/4/17.
 */
public class LinkedStack<T> implements StackInterface<T> {

    private Node<T> head;
    private int size;

    public LinkedStack(){
        this.head = new Node<>(null, null);
        this.size = 0;
    }

    @Override
    public void push(T item) {
        addNode(item);
    }

    @Override
    public T pop() {
        return removeNode();
    }

    @Override
    public int size() {
        return size;
    }

    public void addNode(T item) {
        if(size < 0) { throw new ArrayIndexOutOfBoundsException(); }
        Node<T> current = head;
        for(int i = 0; i < size; i++) {
            current = current.next;
        }
        current.next = new Node<>(item, null);
        size++;
    }

    public T removeNode() {
        if(size == 0) { throw new ArrayIndexOutOfBoundsException(); }
        Node<T> current = head;
        for(int i = 0; i < size - 1; i++) {
            current = current.next;
        }
        T item = current.next.data;
        current.next = null;
        size--;
        return item;
    }


    public class Node<AnotherT> {
        public Node<AnotherT> next;
        public AnotherT data;

        public Node(AnotherT data, Node<AnotherT> next){
            this.next = next;
            this.data = data;
        }
    }

    public static void main(String[] args){
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }


}

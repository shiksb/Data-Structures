//package com.company;
/*
* Name: Shikhar Bakhda
* UNI: ssb2189
* Program2.java
* This program tests the TwoStackQueue class
*
* */

public class Program2 {



    /** If implemented correctly, this code should output: 
     0
     Hi
     3
     Hello
     How
     Are
     Are
     You
     FINE
     */


    public static final void main(String[] args) {


        TwoStackQueue<String> q = new TwoStackQueue<String>();
        System.out.println(q.size());

        q.enqueue("Hi");
        q.enqueue("Hello");
        q.enqueue("How");
        q.enqueue("Are");
        System.out.println(q.dequeue());
        System.out.println(q.size());
        q.enqueue("Are");
        q.enqueue("You");
        System.out.println(q.dequeue());
        q.enqueue("FINE");

        while(!q.isEmpty())
            System.out.println(q.dequeue());

    }





}
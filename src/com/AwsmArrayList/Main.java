package com.AwsmArrayList;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        AwsmArrayList<String> list = new AwsmArrayList<>();
        list.addFirst("pikachu");
        list.addLast("bulbasaur");
        list.addLast("mew");
        System.out.println("first is " + list.getFirst());   // pikachu
        System.out.println("second is " + list.get(1)); // bulbasaur
        list.remove(1);
        System.out.println("second is " + list.get(1)); //mew
        System.out.println("first is " + list.get(0)); //pika
        System.out.println(list.getLast()); // mew
        System.out.println(list.get(1)); // mew
         System.out.println(list.getLast()); // mew
        list.removeLast();
        System.out.println(list.getFirst()); //pika

        AwsmArrayList<Integer> li = new AwsmArrayList<>(3);
        for(int i = 0; i < 6; i ++){
            li.addFirst(i);
            System.out.println(li.getFirst());
        }
        System.out.println("printing");

        for(int i = 0; i < 6; i ++){
            System.out.println(li.get(i));
        }

        System.out.println("printing with iterator");

        AwsmArrayListIterator<Integer> l = new AwsmArrayListIterator<>(li);
        while(l.hasNext()){
            System.out.println(l.next());
        }
        System.out.println("printing with list.iterator");

        Iterator<Integer> it = li.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("enhanced for loop");

        for(Integer i : li) {
            System.out.println(i);
        }

    }
}

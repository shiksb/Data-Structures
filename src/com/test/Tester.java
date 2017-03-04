package com.test;
import java.util.Iterator;
/**
 * Created by shikhar on 3/3/17.
 */
public class Tester {
    public static void main(String[] args) {

        AList<Integer> list = new AList<>(8);
        list.add(5, 0);
        list.add(6, 0);
        list.add(7, 0);
        list.add(8, 0);
        list.remove(2);
        Iterator<Integer> iter = list.iterator();

        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        for(int i : list){
            System.out.println(i);
        }
    }
}

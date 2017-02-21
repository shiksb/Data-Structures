//package com.company;

/**
 * Problem3.java
 * This program prints the run time for the 3 subquestions
 * Created by Shikhar Bakhda on 2/3/17.
 * UNI: ssb2189
 */

public class Problem3 {

    // the recursive method of part c
    public static int foo(int n, int k) {
        if(n<=k)
            return 1;
        else
            return foo(n/k,k) + 1;
    }

    //the main method tests the code snippets of parts a through c
    public static void main(String[] args) {

        // initialising sum as 0
        int sum = 0;

        //Printing the time for problem A
        System.out.println("Problem A");

        for (int n = 0; n <= 100; n++) {
            long starTime = System.nanoTime(); //note the starting time
            for (int i = 0; i < 23; i++) {
                for (int j = 0; j < n; j++)
                    sum = sum + 1;
            }
            long endTime = System.nanoTime(); //note the ending time
            //print the difference
            System.out.println(n + "  " + (endTime - starTime));
        }

        System.out.println("Problem B");
        for (int n = 0; n <= 100; n++) {
            long starTime = System.nanoTime(); //note the starting time
            sum = 0;
            for (int i = 0; i < n; i++)
                for (int k = i; k < n; k++)
                    sum = sum + 1;
            long endTime = System.nanoTime(); //note the ending time
            //print the difference
            System.out.println(n + "  " + (endTime - starTime));
        }

        System.out.println("Problem C");
        for (int n = 0; n <= 100; n++) {
            int a;
            long starTime = System.nanoTime(); //note the starting time
            a = foo(n, 2);
            long endTime = System.nanoTime(); //note the ending time
            //print the difference
            System.out.println(n + "  " + (endTime - starTime));
        }
    }
}
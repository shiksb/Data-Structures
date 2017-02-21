//package com.company;

/*
* Name: Shikhar Bakhda
* UNI: ssb2189
* Main.java
* This program contains a printLots method that takes 2 integer Collections
 * and prints the elements of L of the indices given in P.
*
* */


// importing the necessary classes and interfaces
import java.util.*;


public class Main{

    // the printLots method takes 2 integer collections as parameters
    public static void printLots(Collection<Integer> L,
                                 Collection<Integer> P) {

        // Instantiating the iterator of P and L
        Iterator<Integer> itrP = P.iterator();
        Iterator<Integer> itrL = L.iterator();

        // Instantiating the first item of P
        Integer itemP = itrP.next();

        // iterating through every element in L
        for(int index = 0; itrL.hasNext(); index++){

            // Defining the next element in collection L
            Integer itemL = itrL.next();

            // comparing P's element to L's index, printing if matched
            if(index == itemP){
                System.out.println(itemL);

                // checking if P has a next element
                if(itrP.hasNext()){
                    itemP = itrP.next();
                }
                else {
                    break;
                }
            }
        }
    }


    // the main method tests the printLots method
    public static void main(String[] args) {

        // Instantiating the collection L
        ArrayList<Integer> L = new ArrayList<>();
        Collections.addAll(L,10,9,8,7,6);

        // Instantiating the collection P
        ArrayList<Integer> P = new ArrayList<>();
        Collections.addAll(P,1,2,4);

        // Testing the printLots method
        printLots(L,P);
    }
}

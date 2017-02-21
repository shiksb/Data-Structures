//package com.company;

// importing the Arrays class to use the Arrays.sort method
import java.util.Arrays;

/**
 * Problem2.java
 * Program searches for a certain perimeter in an array of rectangles
 * and returns the index of that rectangle in the array
 * Created by Shikhar Bakhda on 2/2/17.
 * UNI: ssb2189
 */

public class Problem2 {

    // The binarySearch method has the same signature as given,
    // and implements the Comparable class
    public static <AnyType extends Comparable<AnyType>>
        int binarySearch(AnyType[] a, AnyType x){

        // Initialising higher and lower boundaries to the first and last
        // index of the array
        int high = a.length - 1;
        int low = 0;

        // Using the helper method to return the index of the rectangle x
        return helper(low, high, a, x);
    }

    // The method helper recursively searches for the Rectangle x and
    //  returns its index
    private static <AnyType extends Comparable<AnyType>>
        int helper(int low, int high, AnyType[] a, AnyType x){

        // Initialising the mid index as the average of the lower
        //  and higher boundary
        int mid = (low + high) / 2;

        // Returning -1 if the Rectangle was not found.
        if(low > high){
            return -1;
        }

        // If the rectangle is smaller in perimeter, push the l
        //  ower boundary to mid + 1
        if(a[mid].compareTo(x) < 0){
            return helper(mid + 1, high, a, x);//recursive call
        }
        // If the rectangle is larger in perimeter, push the
        //  higher boundary to mid - 1
        else if(a[mid].compareTo(x) > 0){
            return helper(low, mid - 1, a, x); //recursive call
        }
        // If the rectangle is equal in perimeter, return mid
        else{
            return mid; //recursion will terminate
        }
    }

    // the main method, which tests the binarySearch method
    public static void main(String[] args){

        // Creating an arbitrary array of rectangles
        Rectangle[] rects = {
                new Rectangle(1.0, 2.0),
                new Rectangle(2.0, 3.0),
                new Rectangle(3.0, 4.0),
                new Rectangle(4.0, 5.0),
                new Rectangle(5.0, 6.0),
                new Rectangle(6.0, 7.0),
        };

        // Sorting the rects array
        Arrays.sort(rects);

        // Initialising the rectangle which is to be found
        Rectangle findMe = new Rectangle(2.0, 3.0);

        // Printing the index of the rectangle findMe
        System.out.println("The index of findMe is "
                + binarySearch(rects, findMe));
    }

}

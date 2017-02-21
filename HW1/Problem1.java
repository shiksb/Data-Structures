//package com.company;

/**
 * Problem1.java
 * This class tests the rectangle.
 * Created by Shikhar Bakhda on 2/2/17.
 * UNI: ssb2189
 */

public class Problem1 {

    // The findMax routine, identical to the one provided.
    public static<AnyType extends Comparable<AnyType>>
        AnyType findMax(AnyType[] arr) {
            int maxIndex = 0; // initialising maxIndex as 0
        for (int i = 1; i < arr.length; i++) //iterating through all the
                // rectangles
            if ( arr[i].compareTo(arr[maxIndex]) > 0 )
                //setting maxIndex as i if the rectangle has largest
                //  perimeter so far
                maxIndex = i;
        return arr[maxIndex]; //returning the rectangle with the
            // largest perimeter.
    }

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

        // Using the findMax method to find the rectangle with the largest
        //  perimeter.
        Rectangle biggest = Problem1.findMax(rects);

        // Printing the result.
        System.out.println("Rectangle with the largest perimeter has length "
                + biggest.getLength() + " and width "
                + biggest.getWidth());
    }
}

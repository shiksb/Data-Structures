//package com.company;

/**
 * Rectangle.java
 * This program defines a Rectangle and has a compareTo method to compare the
 * perimeter of the rectangle with another.
 * Created by shikhar on 2/2/17.
 * UNI: ssb2189
 */

// Implementing Comparable to use the method compareTo
public class Rectangle implements Comparable<Rectangle>{

    // Declaring the width and the length as private instance variables
    private double length;
    private double width;

    // The constructor initialises the instance variables
    public Rectangle(double l, double w){
        length = l;
        width = w;
    }

    // the getWidth function returns the width of the rectangle
    public double getWidth() {
        return width;
    }

    // the getLength function returns the width of the rectangle
    public double getLength() {
        return length;
    }

    // the perimeter function is a helper method that returns the
        // perimeter for a certain length and width
    private double perimeter(double len, double wid){
        return 2*(len + wid);
    }

    // The compareTo method takes a rectangle as a parameter
        // and returns certain values after comparing the perimeters
    public int compareTo(Rectangle rect){
        if(perimeter(length, width) >
                            perimeter(rect.getLength(), rect.getWidth())){
            //return 1 if this rectangle's perimeter > rect's perimeter
            return 1;
        }
        else if(perimeter(length, width) <
                            perimeter(rect.getLength(), rect.getWidth())){
            //return -1 if this rectangle's perimeter < rect's perimeter
            return -1;
        }
        else{
            //return 0 if this rectangle's perimeter = rect's perimeter
            return 0;
        }
    }
}


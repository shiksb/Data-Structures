package com.Comparable;

import org.w3c.dom.css.Rect;

/**
 * Created by shikhar on 3/5/17.
 */


public class Rectangle implements Comparable<Square> {

    private int length;
    private int breadth;

    public Rectangle(int l, int b){
        this.length = l;
        this.breadth = b;
    }

    public int perimeter() {
        return 2*(length+breadth);
    }

    public int compareTo(Square shape){
        if(shape.perimeter() < this.perimeter()){
            return 1;
        } else if(shape.perimeter() > this.perimeter()) {
            return -1;
        } else {
            return 0;
        }
    }


    public static void main(String[] args) {
        Rectangle r = new Rectangle(5, 7);
        Square s = new Square(6);

        System.out.println(r.compareTo(s));
    }

}

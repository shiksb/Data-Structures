package com.Comparable;

/**
 * Created by shikhar on 3/5/17.
 */
public class Square implements Comparable<Rectangle>{

    private int side;

    public Square(int s) {
        this.side = s;
    }

    public int perimeter() {
        return 4*side;
    }

    public int compareTo(Rectangle shape) {
        if(this.perimeter() > shape.perimeter()) {
            return 1;
        } else if(this.perimeter() < shape.perimeter()) {
            return -1;
        } else {
            return 0;
        }
    }
}

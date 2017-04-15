package com.JoesphusProblem;

/**
 * Created by shikhar on 3/5/17.
 */
public class josephus {

    public static int winner(int people){
        int power;
        for(power = 1; power < people; power *= 2);
        return (2*people - power) + 1;
    }

    public static void main(String[] args){
        System.out.print(winner(41));
    }

}

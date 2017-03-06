package com.TowerHanoi;

/**
 * Created by shikhar on 3/5/17.
 */
public class Tower {

    public static int count = 0;


    public static void move(int disks, char source, char dest, char aux) {
        if(disks > 0) {
            move(disks - 1, source, aux, dest);
            System.out.println("Move " + source + " to " + dest);
            count++;
            move(disks - 1, aux, dest, source);
        }
    }

    public static void main(String[] args){
        char source = 'A';
        char dest = 'C';
        char aux = 'B';
        int disks = 3;
        try{
            disks = Integer.parseInt(args[0]);
        } catch (Exception ex){}

        move(disks, source, dest, aux);
        System.out.println(count);
    }
}

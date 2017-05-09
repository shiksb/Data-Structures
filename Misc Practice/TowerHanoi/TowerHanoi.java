//package com.TowerHanoi;

/**
 * Created by shikhar on 3/5/17.
 */
public class TowerHanoi {

        public  static void tower(char from, char to, char spare, int disk) {
            if (disk > 0) {
                tower(from, spare, to, disk - 1);
                count++;
                System.out.println("move disk " + disk + " from " + from + " to " + to);
                tower(spare, to , from, disk - 1);
            }
        }


        private static int count=0;

        public static void main(String[] args) {
            int disk,i;
//            disk=Integer.parseInt(args[0]);
            disk = 5;
            System.out.println("Towers of Hanoi for " + disk + " disks:");
            tower('A','C','B',disk);
            System.out.println("Number of moves = " + count);
        }

}

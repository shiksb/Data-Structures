//package com.FileIO;
import java.io.*;

/**
 * Created by shikhar on 3/6/17.
 */
public class fileIO {
    public static void main(String[] args) throws Exception {

        String fileName = args[0];


        BufferedReader br = new BufferedReader(new FileReader(fileName + "" +
                ".txt"));

        String line = "";
        String text= "";

        while(line != null){
            line = br.readLine();
            text += line + "\n";
        }
        br.close();

        System.out.print(text);

    }
}

/*
Problem2.java
This file scans a file given as a command line argument
and indexes its words and line numbers. 
Author: Shikhar Bakhda
UNI: ssb2189
Date: 3/24/2017
*/


// importing the necessary classes
import java.util.Scanner;
import java.util.LinkedList;
import java.io.*;

public class Problem2 {
	public static void main(String[] args) throws IOException {
		AvlTree t = new AvlTree( );

		// word will contain the current word
        String word;

        // objects for reading file
        BufferedReader br = null;
        Scanner s = new Scanner("");

        int lineNo = 1; // initialising the line number to 1

        // the fileName given by the user
        String fileName;

        try{
            fileName = args[0]; // getting the fileName from command line

            // reading the file till the last line
        	br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while(line != null){
            	s = new Scanner(line);
            	while(s.hasNext()){ // scanning the line 
                    // formatting the word to handle punctuation and uppercase
            		word = s.next().toLowerCase().replaceAll("[\\p{Punct}]", "");
            		t.indexWord(word, lineNo); // indexing the word
            	}
                line = br.readLine(); // reading the next line
                lineNo++; // incrementing the line number
            }
        } catch (Exception ex){
            System.out.println(ex);
        } finally {
            br.close();
        }
        // printing the words and their line numbers
		t.printIndex();
	}
}
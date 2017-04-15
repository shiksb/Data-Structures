/*
SpellChecker.java
This file scans a file given as a command line argument
and compares it to a dictionary. It prints out 
misspelled words and shows similar words.
Author: Shikhar Bakhda
UNI: ssb2189
Date: 4/13/2017
*/


import java.util.*; // for Scanner
import java.io.*; // for fileIO functions


// This class checks spellings and prints out misspelled words
public class SpellChecker {

    // hashTable which will contain a list of words (key) and line numbers (value)
    private static Hashtable<String, Integer> table = new Hashtable<>();


    public static void main(String[] args) throws IOException {

        // objects for reading file
        BufferedReader br = null;

        int lineNo = 1; // initialising the line number to 1

        // the fileName given by the user
        String word, newword, spell="", fileName="", textName="";

        try {
            textName = args[1]; // getting the text file name from command line
            fileName = args[0]; // getting the fileName from command line

            // reading the file till the last line
            br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine(); // reading the line 
            while (line != null) {
                word = line.toLowerCase(); // formatting the word to handle
                // punctuation and uppercase
                table.put(word, lineNo); // indexing the word
                line = br.readLine(); // reading the next line
                lineNo++; // incrementing the line number
            }

            // reading the file till the last line
            br = new BufferedReader(new FileReader(textName));
            line = br.readLine();
            while (line != null) {
                Scanner s = new Scanner(line);
                while(s.hasNext()){
                    // saving the words into a string
                    spell += " " + s.next().toLowerCase(); 
                }
                line = br.readLine(); // reading the next line
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            br.close();
        }

        // scanning a string of all the words
        Scanner s = new Scanner(spell);
        while (s.hasNext()) {
            word = s.next().toLowerCase();
            // checking if word is misspelled 
            if (!table.containsKey(word)) {
                // printing misspelled word
                System.out.println(word + " is misspelled" +  
                    "\nSimilar words (if any):");

                // checking if adding a character corrects spelling
                for (Character c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
                    // adding every letter to a different index of the word
                    for (int i = 0; i <= word.length(); i++) {
                        newword = word.substring(0, i) + Character.toString(c)
                                 + word.substring(i, word.length());
                        // checking & printing if the new word is valid 
                        if (table.containsKey(newword)) {
                            System.out.println("\t" + newword);
                        }
                    }
                }

                // checking if removing the first letter makes word valid
                if (table.containsKey(word.substring(1, word.length()))) {
                    System.out.println("\t" + word.substring(1, word.length()));
                }

                // checking if removing every letter OR swapping letters
                        // makes spelling correct
                for (int i = 1; i < word.length(); i++) {
                    // creating a new word by swapping
                    newword = word.substring(0, i - 1) + word.charAt(i)
                            + word.charAt(i - 1) + word.substring(i + 1, word.length());
                    // creating another new word by removing character at index i
                    String newword2 = word.substring(0, i) + word.substring(i + 1, word.length());

                    // printing the 2 new words if they exist in the dictionary
                    if (table.containsKey(newword)) {
                        System.out.println("\t" + newword);
                    }
                    if (table.containsKey(newword2)) {
                        System.out.println("\t" + newword2);
                    }
                }
            }
        }

    }
}

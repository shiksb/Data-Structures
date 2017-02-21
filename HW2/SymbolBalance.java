//package com.company;

/*
* Name: Shikhar Bakhda
* UNI: ssb2189
* SymbolBalance.java
* This program contains a printLots method that takes 2 integer Collections
 * and prints the elements of L of the indices given in P.
*
* */

// importing the necessary classes and interfaces
import java.util.*;
import java.io.*;

public class SymbolBalance {

    // the current index of the text
    static int index = 0;

    // defining the string arrays of
    static String[] open = {"{", "[", "("};
    static String[] close = {"}", "]", ")"};

    // to not do anything if inside a string or comment
    static Boolean inComment = false;
    static Boolean inString = false;

    // this method returns the next symbol of the text excluding comments
    public static String nextSymbol(String text) {

    	// goes through all the characters in the text
        for (int x = index; x < text.length(); x++) {
            try{
                if(text.charAt(x) == '/' && text.charAt(x + 1) == '*'){
                    index += 2;
                    inComment = true;
                }
                if(text.charAt(x) == '*' && text.charAt(x + 1) == '/'){
                    index += 2;
                    inComment = false;
                }
            }
            catch(Exception ex) {}

            // checking for string
            if(text.charAt(x) == '"' && !inComment){
                index++;
                inString = !inString;
            }
            // only if not inside comment or string, we return the symbol
            if (!inComment && !inString){
                if (Arrays.asList(open).contains(Character.toString(
                        text.charAt(x))) == true ||
                        Arrays.asList(close).contains(Character.toString(
                                text.charAt(x))) == true) {
                    index = x + 1;
                    return Character.toString(text.charAt(x));
                }
            }
        }
        return null;
    }


    public static void main(String[] args) throws IOException {
    	// reading the file
        String text = "";
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(args[0]));
            String line = br.readLine();
            while(line != null){
                text += line + "\n";
                line = br.readLine();
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {
            br.close();
        }



        MyStack<String> st = new MyStack<>();
        String next = "", toClose = null;

        //  checking if all symbols are closed till no symbol is left
        while(next != null) {
            if(toClose == null){
                st.push(nextSymbol(text));
                next = nextSymbol(text);
            }
            toClose = st.top();
//            System.out.println( "toClose: " + toClose + " Next: " + next);

            if (Arrays.asList(open).contains(next)){
//                System.out.println("pushed " + next);
                st.push(next);
            }
            else{
                String opposite = "";
                for (int i = 0; i < 3; i++) {
                    if (toClose.compareTo(open[i]) == 0) {
                        opposite = close[i];
                    } else if (toClose.compareTo(close[i]) == 0) {
                        opposite = open[i];
                    }
                }
                if(next.compareTo(opposite) == 0){
//                    System.out.println("popped");
                    st.pop();
                }
                else {
//                    System.out.print(next + " unbalanced and ");
                    break;
                }
            }
            next = nextSymbol(text);
            toClose = st.top();
        }

        // printing the outcomes
        if(inString) {
            System.out.println("Unbalanced! Symbol  \" is mismatched.");
        }
        else if(inComment){
            System.out.println("Unbalanced! Symbol  /* is mismatched.");
        }
        else if(st.top() == null){
            System.out.println("Everything balanced. Woohoo!");
        }
        else {
            System.out.println("Unbalanced! Symbol " + st.top() + " is " +
                            "mismatched.");
        }
    }
}

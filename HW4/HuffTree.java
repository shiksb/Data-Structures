/*
HuffTree.java
This file scans a file, maps the characters and frequencies,
creates a Huffman tree and allows user to compress and 
decompress characters.
Author: Shikhar Bakhda
UNI: ssb2189
Date: 4/13/2017
*/

// for various data structures
import java.util.*;
// for file IO
import java.io.*;


public class HuffTree {

    // the root node of the Huffman tree
    private static HuffNode root;
    // a hashmap that contains the characters and their encoded binary form
    private static HashMap<String, Integer> codedMap = new HashMap<>();


    public static void main(String[] args) throws Exception {

        // reading the file fileName
        String text = "", fileName, line;
        BufferedReader br;
        try{
            fileName = args[0];
                    // reading the file till the last line
            br = new BufferedReader(new FileReader(fileName));
            line = br.readLine();
            while (line != null) {
                Scanner s = new Scanner(line);
                while(s.hasNext()){
                    // saving the words into a string
                    text += " " + s.next().toLowerCase(); 
                }
                line = br.readLine(); // reading the next line
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        // this hashmap contains characters and their frequencies
        HashMap<String, Integer> freq = new HashMap<>();

        // filling up the hashmap of character frequencies
        for (int i = 0; i < text.length(); i++) {
            String ch = Character.toString(text.charAt(i)).toLowerCase();
            if (freq.containsKey(ch)) {
                freq.put(ch, freq.get(ch) + 1);
            } else {
                freq.put(ch, 1); // creating if doesnt exist
            }
        }

        // creating a priority queue
        Comparator<HuffNode> comparator = new StringLengthComparator();
        PriorityQueue<HuffNode> queue = new PriorityQueue<>(freq.size() + 1,
                comparator);

        // adding single-node trees to the priority queue
        for (String key : freq.keySet()) {
            root = new HuffNode(key, freq.get(key), null, null);
            queue.add(root);
        }

        // creating the Huffman tree
        int treeID = 1;
        while (queue.size() > 1) {
            HuffNode smaller = queue.remove();
            HuffNode bigger = queue.remove();
            HuffNode root = new HuffNode("T" + treeID, smaller.freq + bigger.freq,
                    smaller, bigger);
            queue.add(root);
            treeID++;
        }

        // defining the root of the Huffman tree
        root = queue.remove();

        // printing the table headers
        System.out.println(String.format("%-2s   %-7s%-5s%13s", "Char",
                "Code", "Freq", "Total Bits"));
        
        traverse(root, ""); // this method will print the table

        // taking user input of 0s and 1s
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the code of 0s and 1s:");
        String code = s.next();
        String encoded = "";
        HuffNode node = root;

        // traversing the path entered and saving the 
            // corresponding keys in 'encoded'
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '0') {
                node = node.left;
            } else {
                node = node.right;
            }
            if (node.left == null && node.right == null) {
                encoded += node.key;
                node = root;
            }
        }

        // printing the decoded code if there's no error
        if(node != root && !freq.containsKey(node.key)) {
            System.out.println("error");
        } else {
            System.out.println(encoded);
        }

        // take user input of characters
        System.out.println("Enter the code of characters:");
        code = s.next();
        String compressed = "";

        // printing the encoded characters
        for(int i = 0; i < code.length(); i++){
            compressed += codedMap.get(Character.toString(code.charAt(i)));
        }
        System.out.println(compressed);
    }


    // this method uses post order traversal and prints the leaves
        // it also saves the keys and values to a hashmap
    private static void traverse(HuffNode node, String code){
        if(node != null){
            traverse(node.left, code + "0");
            traverse(node.right, code + "1");
            if(node.left == null && node.right == null){
                System.out.println(String.format("%-2s : %7s%5s%13s", node.key,
                        code, node.freq, code.length()*node.freq));
                // saving a mapping of characters (keys) to codes (values) 
                codedMap.put(node.key, Integer.parseInt(code));
            }
        }   
    }

    // this class compares 2 HuffNodes based on their frequency
    private static class StringLengthComparator implements
            Comparator<HuffNode> {
        @Override
        public int compare(HuffNode x, HuffNode y)
        {
            if (x.freq < y.freq)
            {
                return -1;
            }
            if (x.freq > y.freq)
            {
                return 1;
            }
            return 0;
        }
    }

}

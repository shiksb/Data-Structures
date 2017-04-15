/*
HuffNode.java
This file is a Huffman Tree node
Author: Shikhar Bakhda
UNI: ssb2189
Date: 4/13/2017
*/
public class HuffNode {

    public String key;
    public int freq;
    public HuffNode left;
    public HuffNode right;

    public HuffNode(String key, int freq, HuffNode left, HuffNode right){
        this.key = key;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}

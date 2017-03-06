package com.Trees;

/**
 * Created by shikhar on 3/6/17.
 */
public class Node {

    public Node left;
    public Node right;
    public int data;

    public Node(int data){
        this.data = data;
    }

    public void insert(int value) {
        if(value < data) {
            if(left != null) {
                left.insert(value);
            }
            else {
                left = new Node(value);
            }
        } else if(value > data) {
            if(right != null) {
                right.insert(value);
            } else {
                right = new Node(value);

            }
        }
    }

    public boolean contains(int value) {
        if(value < data) {
            if(left != null) {
                return left.contains(value);
            } else {
                return false;
            }
        } else if(value > data) {
            if(right != null) {
                return right.contains(value);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public void printInorder() {
        if(left != null){
            left.printInorder();
        }
        System.out.println(data);
        if(right != null) {
            right.printInorder();
        }
    }

    public void printPreorder(){
        System.out.println(data);
        if(left != null){
            left.printPreorder();
        }
        if(right != null) {
            right.printPreorder();
        }
    }
    public void printPostorder(){
        if(left != null){
            left.printPostorder();
        }
        if(right != null) {
            right.printPostorder();
        }
        System.out.println(data);
    }

    public int findMax(){
        if(right == null){
            return data;
        } else {
            return right.findMax();
        }
    }

    public int findMin(){
        Node node = this;
        while(node.left != null){
            node = node.left;
        }
        return node.data;
    }


    public void remove(int value){
        if(value < data){
            remove(left.data);
        } else if(value > data){
            remove(right.data);
        } else if(left != null && right != null) {
            data = right.findMin();
            right.remove(data);
        } else {
            if(left != null){
                data = left.data;
            } else if(right != null){
                data = right.data;
            }
            else {
                return;
            }
        }
    }


    public static void main(String[] args) {

        Node root = new Node(8);
        root.insert(3);
        root.insert(10);
        root.insert(1);
        root.insert(6);
        root.printInorder();
        root.remove(3);
        root.printInorder();


//        System.out.println(root.findMax());
//        System.out.println(root.findMin());
//        System.out.println(root.contains(6));
//        root.printPreorder();
//        System.out.println(root.contains(10));
//        root.printPostorder();


    }


}

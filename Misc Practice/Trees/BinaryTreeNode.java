package com.Trees;

/**
 * Created by shikhar on 3/5/17.
 */
public class BinaryTreeNode<T> implements Comparable<T> {

    public T element;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T element) {
        this(element, null, null);
    }

    public BinaryTreeNode(T element, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public int compareTo(T element){
//        if((int) this.element > (int) element) {
//            return 1;
//        } else if((int) this.element < (int) element) {
//            return -1;
//        } else {
//            return 0;
//        }
        return 1;
    }
}

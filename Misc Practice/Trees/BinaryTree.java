package com.Trees;

/**
 * Created by shikhar on 3/5/17.
 */
public class BinaryTree<T>  {

    private BinaryTreeNode<T> root;

    public BinaryTree(T element) {
        this.root = new BinaryTreeNode<>(element);
    }

    public BinaryTreeNode<T> insert(T element, BinaryTreeNode<T> node) {

        if(node == null){
            return new BinaryTreeNode<>(element, null, null);
        }

        if(node.compareTo(element) < 0){
           node.left = insert(element, node.left);
        } else if(node.compareTo(element) > 0) {
            node.right = insert(element, node.right);
        } else {
            ;
        }
        return node;
    }

    public boolean contains(T element, BinaryTreeNode<T> node) {
        if(node == null){
            return false;
        }

        if(node.compareTo(element) < 0){
            return contains(element, node.left);
        } else if(node.compareTo(element) > 0) {
            return contains(element, node.right);
        } else {
            return true;
        }
    }

    public BinaryTreeNode<T> findMin(BinaryTreeNode<T> node) {
        if(node == null) { return null; }

        if(node.left != null){
            return findMin(node.left);
        } else {
            return node;
        }
    }

    public BinaryTreeNode<T> findMax(BinaryTreeNode<T> node) {
        if (node == null) {
             return null;
        }

        while(node.right != null) {
            node = node.right;
        }
        return node;
    }

    public static void main(String[] args){
        System.out.print("");
    }

}

//package com.company;

/**
 * Created by shikhar on 2/20/17.
 */
public class StackNode {

    public static void main(String[] args) throws Exception {
        Array2Stack stack = new Array2Stack(5);
        try{
            System.out.println("Testing Pushes");
            stack.push(0, 1);
            stack.push(0, 2);
            stack.push(1, 3);
            stack.push(1, 4);
            stack.push(1, 5);
            stack.printStack(0);
            stack.printStack(1);
            System.out.println("Testing Pops");
            stack.pop(0);
            stack.printStack(0);
            stack.printStack(1);
            stack.pop(1);
            stack.pop(1);
            stack.printStack(0);
            stack.printStack(1);
            System.out.println("Testing Overflow");
            stack.push(0, 2);
            stack.push(1, 4);
            stack.push(1, 5);
            stack.push(1, 6);
            stack.push(1, 7);
        }
        catch (Exception ex){
            System.out.print(ex.getMessage());
        }

    }

}

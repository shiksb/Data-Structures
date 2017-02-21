//package com.company;

/**
 * Created by shikhar on 2/20/17.
 */
public class Array2Stack {

    // Saving the free indices
    public int[] freeIndex = new int[2];
    public int size; // size of array
    public int[] arr; // the actual array

    // instantiating the size, array, and the front and back free index
    public Array2Stack(int s) {
        size = s;
        arr = new int[size];
        freeIndex[0] = 0;
        freeIndex[1] = size - 1;
    }

    // push method for the stack whichStack
    public void push(int whichStack, int data) throws Exception{
        // checking if array is overflowing
        if(freeIndex[0] <= freeIndex[1]) {
            // pushing the data to the stack whichStack
            arr[freeIndex[whichStack]] = data;
            // incrementing index if it's the front stack
            if (whichStack == 0) {
                freeIndex[0]++;
            }
            // decrementing index if it's the back stack
            else if (whichStack == 1) {
                freeIndex[1]--;
            }
            // invalid stack
            else {
                System.out.println("Invalid Stack number");
            }
        }
        // error thrown if the front index is greater than the back index
        else{
            throw new Exception("ArrayOverflowError\n");
        }
    }

    // pop method
    public void pop(int whichStack) {
        // making sure the stack has at least one element
        if(freeIndex[0] != 0 && freeIndex[1] != size - 1){
            // decrementing index if it's the front stack
            if(whichStack == 0){
                freeIndex[0]--;
            }
            // incrementing index if it's the back stack
            else if(whichStack == 1){
                freeIndex[1]++;
            }
        }
    }

    // printing the stacks
    public void printStack(int whichStack) {
        // printing the front stack
        if(whichStack == 0){
            System.out.println("Stack 1:");
            for(int i = freeIndex[0] - 1; i >= 0; i--){
                System.out.println(arr[i]);
            }
        }
        // printing the back stack
        else if(whichStack == 1) {
            System.out.println("Stack 2:");
            for(int i = freeIndex[1] + 1; i < size; i++){
                System.out.println(arr[i]);
            }
        }
    }
}

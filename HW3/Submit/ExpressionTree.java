/*
ExpressionTree.java
This class defines an expression tree from a given
postfix expression using a expression stack.
Author: Shikhar Bakhda
UNI: ssb2189
Date: 3/24/201
*/

// importing Scanner to scan the postfix expression
import java.util.Scanner;
// importing LinkedList to use linked lists for the stack
import java.util.LinkedList;
	
// the Expression Tree class
public class ExpressionTree {

	// declaring the tree root instance variable
	public ExpressionNode root;

	// the constructor takes the postfix string as argument
	public ExpressionTree(String postfix) 
		throws RuntimeException  { 

		// Instantiating the scanner and stack
		Scanner s = new Scanner(postfix);
		Stack stack = new Stack();

		// scan all words till the last word
		while(s.hasNext()){

			String data = s.next(); // the next word

			// comparing the data of the node to symbols
			if(data.equals("*") || data.equals("/") ||
				data.equals("+") || data.equals("-")) {

				// instantiating the left and right nodes
				ExpressionNode right = stack.pop();
				ExpressionNode left = stack.pop();

				// pusing the node to the stack
				stack.push(new ExpressionNode(data, left, right));
			} else {
				// if not a symbol, the number is pushed as an orphan node
				stack.push(new ExpressionNode(data, null, null));
			}
		}

		// the last element of the stack is the root
		this.root = stack.pop();
		if(!stack.isEmpty()){
			throw new RuntimeException("Stack not empty");
		}
	}

	// this method evaluates the expression tree 
	public int eval() {
		return calculate(this.root);
	}

	// this method calculates the tree given the root
	private static int calculate(ExpressionNode root) {
		// if the node is full, it means it is a symbol
		// calculate the left and right sides
		if(root.left != null && root.right != null) {
			int resultLeft = calculate(root.left);
			int resultRight = calculate(root.right);
			int result = 0; // instantiating the result
			// performing the operations and storing the result
			switch(root.data){
				case "*": result = resultLeft * resultRight;
					break;
				case "/": result = resultLeft / resultRight;
					break;
				case "+": result = resultLeft + resultRight;
					break;
				case "-": result = resultLeft - resultRight;
					break;
			}	
			// returning the evaluation of the subtree
			return result;
		} else {
			// if the node is a leaf, it means node is a number
			// returning the number inside the node 
			return Integer.parseInt(root.data);
		}
	}

	// this method returns the postfix expression of the tree
	public String postfix() {
		return postOrder(this.root);
	}

	// postOrder traversal produces postfix expression
	private static String postOrder(ExpressionNode root) {
		if(root.left == null && root.right == null) {
			return root.data;
		}
		return postOrder(root.left) + " " + 
				postOrder(root.right) + " " + 
				 root.data;
	}

	// this method returns the prefix expression of the tree
	public String prefix() {
		return preOrder(this.root);
	}

	// preOrder traversal produces prefix expression
	private static String preOrder(ExpressionNode root) {
		if(root.left == null && root.right == null) {
			return root.data;
		}
		return root.data + " " + 
				preOrder(root.left) + " " + 
				 preOrder(root.right);
	}

	// this method returns the infix expression of the tree
	public String infix() {
		return inOrder(this.root);
	}

	// inOrder traversal produces infix expression
	private static String inOrder(ExpressionNode root) {
		if(root.left == null && root.right == null) {
			return root.data;
		}
		return "(" + inOrder(root.left) + " " + 
				root.data + " " + 
				 inOrder(root.right) + ")";
	}

	// the ExpressionNode static nested class
	public static class ExpressionNode {

		// the instance variables for the left and right nodes
			// and the data stored
		public ExpressionNode left;
		public ExpressionNode right;
		public String data;

		// this constructor instantiates the instance variables
		public ExpressionNode(String data, 
			ExpressionNode left, ExpressionNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	// the Stack static nested class
	public static class Stack {

		// the LinkedList instance variable
		private LinkedList<ExpressionNode> list;

		// instantiating the list as an empty list
		public Stack() {
		 	list = new LinkedList<>();
		}

		// the push method 
		public void push(ExpressionNode node) {
			list.addLast(node);
		}

		// the pop method
		public ExpressionNode pop() throws RuntimeException {
			if(!list.isEmpty()){
				return list.removeLast();
			} else {
				throw new RuntimeException("Can't pop from empty stack");
			}
		}

		// the isEmpty method
		public boolean isEmpty(){
			return list.isEmpty();
		}
	}
}
/*
Problem1.java
This class implements an expression tree using the ExpressionTree class
Author: Shikhar Bakhda
UNI: ssb2189
Date: 3/24/201
*/


public class Problem1 {

	// the main method tests the other methods
	public static void main(String[] args) {
		ExpressionTree tree = new ExpressionTree("34 2 - 5 *");
		System.out.println("\nValue");
		System.out.println(tree.eval());
		System.out.println("\nPostfix");
		System.out.println(tree.postfix());
		System.out.println("\nPrefix");
		System.out.println(tree.prefix());
		System.out.println("\nInfix");
		System.out.println(tree.infix());
	}
}
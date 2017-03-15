import java.util.Scanner;
import java.util.LinkedList;

public class ExpressionTree {

	public ExpressionNode root;
	private static String postfix, infix, prefix;

	public ExpressionTree(String postfix) { 
		Scanner s = new Scanner(postfix);
		Stack stack = new Stack();
		while(s.hasNext()){
			String data = s.next();
			if(data.equals("*") || data.equals("/") ||
				data.equals("+") || data.equals("-")) {
				ExpressionNode right = stack.pop();
				ExpressionNode left = stack.pop();
				stack.push(new ExpressionNode(data, left, right));
			} else {
				stack.push(new ExpressionNode(data, null, null));
			}
		}
		this.root = stack.pop();

		this.postfix = "";
		this.prefix = "";
		this.infix = "";
	}

	public int eval() {
		return calculate(this.root);
	}

	private static int calculate(ExpressionNode root) {
		if(root.left != null && root.right != null) {
			int resultLeft = calculate(root.left);
			int resultRight = calculate(root.right);
			int result = 0;
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
			return result;
		} else {
			return Integer.parseInt(root.data);
		}
	}

	public String postfix() {
		postOrder(this.root);
		return postfix;
	}

	public static void postOrder(ExpressionNode root) {
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			postfix += root.data + " ";
		}
	}

	public String prefix() {
		preOrder(this.root);
		return prefix;
	}

	public static void preOrder(ExpressionNode root) {
		if(root != null) {
			prefix += root.data + " ";
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public String infix() {
		inOrder(this.root);
		return infix;
	}

	public static void inOrder(ExpressionNode root) {
		if(root != null) {
			inOrder(root.left);
			infix += root.data + " ";
			inOrder(root.right);
		}
	}


	public static class ExpressionNode {

		public ExpressionNode left;
		public ExpressionNode right;
		public String data;

		public ExpressionNode(String data, 
			ExpressionNode left, ExpressionNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static class Stack {

		private LinkedList<ExpressionNode> list;

		public Stack() {
		 	list = new LinkedList<>();
		}

		public void push(ExpressionNode node) {
			list.addLast(node);
		}

		public ExpressionNode pop() {
			return list.removeLast();
		}
	}

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
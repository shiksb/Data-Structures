import java.util.Scanner;
import java.util.LinkedList;
public class Tester {
	public static class Stack {

		private LinkedList<Integer> list;

		public Stack() {
		 	list = new LinkedList<>();
		}

		public void push(int node) {
			list.addLast(node);
		}

		public int pop() {
			return list.removeLast();
		}
	}

	public static void main(String[] args) {
		String a = "32 * 2 - 10";
		Scanner s = new Scanner(a);
		while(s.hasNext()){
			System.out.println(s.next());
		}

		Stack st = new Stack();
		st.push(5);
		st.push(10);
		System.out.println(st.pop());
		System.out.println(st.pop());
		String str = "+";
		System.out.println(str == "+");
		System.out.println(Integer.parseInt("*"));
	}
}
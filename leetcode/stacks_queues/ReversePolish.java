/*
150. Evaluate Reverse Polish Notation
Medium
5.4K
847
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
Evaluate the expression. Return an integer that represents the value of the expression.
*/
import java.util.*;

public class ReversePolish {

	private static int reversePolish(String[] tokens) {
		Stack<Integer> st = new Stack<Integer>();

		int a, b;
		for(String s: tokens) {

			if (s.equals("+")) {
				st.add(st.pop() + st.pop());
			} else if (s.equals("-")) {
				b = st.pop();
				a = st.pop();
				st.add(a - b);
			} else if (s.equals("*")) {
				st.add(st.pop() * st.pop());
			} else if (s.equals("/")) {
				b = st.pop();
				a = st.pop();
				st.add(a / b);
			} else {
				st.add(Integer.parseInt(s));
			}

			/*
			if ((s.equals("+")) || (s.equals("-")) || (s.equals("*")) || (s.equals("/"))) {
				int operand2 = st.pop();
				int operand1 = st.pop();

				if (s.equals("+")) st.add(operand1 + operand2);
				if (s.equals("-")) st.add(operand1 - operand2);
				if (s.equals("*")) st.add(operand1 * operand2);
				if (s.equals("/")) st.add((int)(Math.floor(operand1 / operand2)));

			} else {
				st.push(Integer.parseInt(s));
			}
			*/
		}
		return st.pop();
	}

	public static void main(String[] args) {
		String[] tokens = {"2","1","+","3","*"};
		System.out.println(reversePolish(tokens));
	}
}
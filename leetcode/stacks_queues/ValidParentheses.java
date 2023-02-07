/*
20. Valid Parentheses
Easy
17.9K
1K
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.
*/

import java.util.*;

public class ValidParentheses {

	private static boolean validparentheses(String s) {
		Stack<Character> st = new Stack<Character>();

		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);

			if ( (ch=='(') || (ch=='[') || (ch=='{') ) {
				st.push(ch);
			} else {
				if (st.isEmpty()) return false;
				char bracket = st.pop();

				if ( (ch==')') && (bracket!='(') ) return false;
				if ( (ch==']') && (bracket!='[') ) return false;
				if ( (ch=='}') && (bracket!='{') ) return false;
			}
		}

		return st.isEmpty();
	}

	public static void main(String[] args) {
		String s = "(()((((()(";
		System.out.println(validparentheses(s));
	}
}
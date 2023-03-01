/*
22. Generate Parentheses
Medium
17.1K
684
Companies
Given n pairs of parentheses, write a function to generate all
combinations of well-formed parentheses.
*/
import java.util.*;

public class GenerateParentheses {

	// Backtrack
	/*
		Don’t have to generate all combinations, instead use this rule
		For n, there are 2n positions to be filled, at every stage
			( can be used if number of open paren < n
			) can be used only if number of close paren < number of open paren
		=> Use number of open parens, number of close parens as variables to track.
		Add the current subset to final result when len of current string = 2n (meaning all open
		and close parens have been used)
	*/
	private static List<String> generateParenthesesBacktrack(int n) {
		List<String> subsets = new ArrayList<String>();
		backtrack(subsets, "", 0, 0, n);
		return subsets;
	}

	private static void backtrack(List<String> subsets, String str, int openUsed, int closeUsed, int n){
		if (str.length() == 2*n) {
			subsets.add(str);
		} else {
			if (openUsed < n) backtrack(subsets, str+"(", openUsed+1, closeUsed, n);
			if (closeUsed < openUsed) backtrack(subsets, str+")", openUsed, closeUsed+1, n);
		}
		return;
	}

	/*
	private static List<String> generateParenthesesRecurse(int n) {
		List<String> subsets = new ArrayList<String>();
		List<String> newSubsets = new ArrayList<String>();
		Set<String> set = new HashSet<String>();

		if (n==0) {
			set.add("");
			newSubsets.add("");
		} else {
			// Get all subsets of len n-1
			subsets = generateParenthesesRecurse(n-1);
			//Set<String> subsets = generateParenthesesRecurse(n-1);

			// Generate new subsets by inserting "()" at every position
			// Keep track of duplicates by using a set
			for(String str: subsets) {
				for(int i=0; i<str.length(); i++) {
					if (str.charAt(i)=='(') {
						String s = insertStrAt(str, i);
						//set.add(s);
						if (set.add(s)) newSubsets.add(s);
					}
				}
				set.add("()" + str);
				newSubsets.add("()" + str);
			}
		}
		//return set;
		return newSubsets;
	}

	private static String insertStrAt(String s, int pos) {
		String left = s.substring(0, pos+1);
		String right = s.substring(pos+1, s.length());
		return left + "()" + right;
	}
	*/

	/*
	private static List<String> generateParenthesesRecurse(int n) {
		List<String> subsets = new ArrayList<String>();
		List<String> newSubsets = new ArrayList<String>();

		// Base case
		if (n==1) {
			subsets.add("()");
			return subsets;
		}
		// Get all parenthese for n-1
		subsets = generateParenthesesRecurse(n-1);

		for(int i=0; i<subsets.size(); i++) {
			String paren = subsets.get(i);
			String newparen = "";
			if(i==0) {
				newSubsets.add(paren + "()");
			} else {
				newSubsets.add(paren + "()");
				newSubsets.add("()" + paren);
			}
			newSubsets.add("(" + paren + ")");
		}
		return newSubsets;
	}
	*/

	public static void main(String[] args) {
		System.out.println(generateParenthesesRecurse(3));
	}
}
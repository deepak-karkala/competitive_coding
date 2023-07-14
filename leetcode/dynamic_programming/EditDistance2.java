/*
Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character

Input: A = “abad”, B = “abac”
Output: 1
Explanation: Operation 1: Replace d with c
*/

class EditDistance2 {

	private static int editdistance_recursive_top(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		return editdistance_recursive(s1, s2, m-1, n-1);
	}

	private static int editdistance_recursive(String s1, String s2, int m, int n){
		// Base cases
		if (m<0 && n<0) return 0;
		if (m<0) return n+1;
		if (n<0) return m+1;

		// Recursion
		// If the mth and nth element are same, D(m, n) distance same as D(m-1, n-1)
		if (s1.charAt(m) == s2.charAt(n)) {
			return editdistance_recursive(s1, s2, m-1, n-1);
		}
		// Else D(m, n) = min(D(m-1, n), D(m, n-1), D(m-1, n-1)) + 1
		int tmp = Math.min(editdistance_recursive(s1, s2, m-1, n), editdistance_recursive(s1, s2, m, n-1));
		return Math.min(tmp, editdistance_recursive(s1, s2, m-1, n-1)) + 1;
	}

	public static void main(String[] args) {
		String s1 = "horse";
		String s2 = "rs";
		int dist = editdistance_recursive_top(s1, s2);
		System.out.println(dist);
	}
}
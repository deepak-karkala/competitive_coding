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

	// Recursive
	// O(3^(m*n))
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

	// DP: Top down with memoisation
	// total of 3^m subproblems out of which only m*n are unique 
	// => Overlapping subproblems, => DP
	// Time: O(m*n), Space: O(m*n)
	private static int editdistance_dp_memo_top(String s1, String s2){
		int m = s1.length();
		int n = s2.length();

		int[][] memo = new int[m+1][n+1];
		//for(int i=0; i<=n; i++) memo[0][i] = i;
		//for(int j=0; j<=m; j++) memo[j][0] = j;

		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if (i==0) memo[i][j] = j;
				else if (j==0) memo[i][j] = i;
				else memo[i][j] = -1;
			}
		}

		return editdistance_dp_memo(s1, s2, m, n, memo);
	}
	private static int editdistance_dp_memo(String s1, String s2, int m, int n, int[][] memo){
		if (memo[m][n] != -1) return memo[m][n];

		if (s1.charAt(m-1) == s2.charAt(n-1)) {
			return memo[m][n] = editdistance_dp_memo(s1, s2, m-1, n-1, memo);
		}
		int tmp = Math.min(editdistance_dp_memo(s1, s2, m-1, n, memo), editdistance_dp_memo(s1, s2, m, n-1, memo));
		return memo[m][n] = Math.min(tmp, editdistance_dp_memo(s1, s2, m-1, n-1, memo)) + 1;
	}

	// DP: Bottom up iterative
	private static int editdistance_dp_bottomup(String s1, String s2){
		int m = s1.length();
		int n = s2.length();

		int[][] memo = new int[m+1][n+1];
		for(int i=0; i<=m; i++) memo[i][0] = i;
		for(int i=0; i<=n; i++) memo[0][i] = i;

		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					memo[i][j] = memo[i-1][j-1];
				} else {
					int left_dist = memo[i][j-1];
					int up_dist = memo[i-1][j];
					int diag_dist = memo[i-1][j-1];
					memo[i][j] = Math.min(Math.min(left_dist, up_dist), diag_dist) + 1;
				}
			}
		}
		return memo[m][n];
	}

	public static void main(String[] args) {
		String s1 = "horse";
		String s2 = "rs";
		//int dist = minDistance(s1, s2);
		int dist = editdistance_dp_bottomup(s1, s2);
		System.out.println(dist);
	}
}
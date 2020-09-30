package dynamic_programming;

import dynamic_programming.LongestCommonSubsequence.Path;

/*
 * Longest common subsequence
 * Given two strings text1 and text2, return the length of their
 * longest common subsequence. A subsequence of a string is a new
 * string generated from the original string with some characters(can be none)
 * deleted without changing the relative order of the remaining characters.
 * (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common
 * subsequence of two strings is a subsequence that is common to both strings.
 * If there is no common subsequence, return 0.
*/

public class LongestCommonSubsequence {

	enum Path {up, left, diag};

	public int longestCommonSubsequence(String text1, String text2) {
		// Get lengths of two strings
		int m = text1.length();
		int n = text2.length();
		
		// 2D matrix to keep track of common sequence
		Path[][] b = new Path[m][n];
		
        // 2D matrix of size text1.length+1 x text2.length+1
		int[][] c = new int[m+1][n+1];
		for (int i=0; i<=m; i++) {
			c[i][0] = 0;
		}
		for (int j=0; j<=n; j++) {
			c[0][j] = 0;
		}
		
		for (int i=1; i<=m; i++) {
			for (int j=1; j<=n; j++) {
				
				if (text1.charAt(i-1) == text2.charAt(j-1)) {
					c[i][j] = c[i-1][j-1] + 1;
					b[i-1][j-1] = Path.diag;
				} else if (c[i-1][j] >= c[i][j-1]) {
					c[i][j] = c[i-1][j];
					b[i-1][j-1] = Path.left;
				} else {
					c[i][j] = c[i][j-1];
					b[i-1][j-1] = Path.up;
				}
				
			}
		}
		
		return c[m][n];
    }
	
	public static void main(String[] args) {
		String text1 = "abc";
		String text2 = "def";
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		int lcs_length = lcs.longestCommonSubsequence(text1, text2);
		//String lcs_sequence = getLongestCommonSubsequence(text1, text2, )
		System.out.println(lcs_length);
	}
}
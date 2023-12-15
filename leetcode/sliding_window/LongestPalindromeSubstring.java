/*
5. Longest Palindromic Substring
Solved
Medium
Topics
Companies
Hint
Given a string s, return the longest palindromic substring in s.
 */

 class LongestPalindromeSubstring {
 	/*
 	Approach: DP
 		1. substring(i...j) is palindromic if s.at(i)==s.at(j) && substring(i+1...j-1) is a palindrome
 		2. For every pair of i,j check if above condition holds (O(n^2))
 		3. If condition holds and currLen > maxLen so far, record len and start index
 	Time: O(n^2) Space: O(n^2)
 	*/
    private static String longestPalindrome(String s) {
    	int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = Integer.MIN_VALUE, currLen = 0, maxLenStart = 0;

        for(int i=n-1; i>=0; i--) {
        	for(int j=i; j<n; j++) {

        		//substring(i...j) is palindromic if s.at(i)==s.at(j) && substring(i+1...j-1) is a palindrome
        		dp[i][j] = s.charAt(i)==s.charAt(j) && (j-i<3 || dp[i+1][j-1]);
        		currLen = j - i + 1;

        		if (dp[i][j] && currLen > maxLen) {
        			maxLen = currLen;
        			maxLenStart = i;
        		}
        	}
        }

        return s.substring(maxLenStart, maxLenStart + maxLen);
    }


    public static void main(String[] args) {
    	String s = "babad";
    	System.out.println(longestPalindrome(s));
    }
}
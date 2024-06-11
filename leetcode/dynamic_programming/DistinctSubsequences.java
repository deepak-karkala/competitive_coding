/*
115. Distinct Subsequences
Solved
Hard
Topics
Companies
Given two strings s and t, return the number of distinct subsequences of s which equals t.

The test cases are generated so that the answer fits on a 32-bit signed integer.
*/

class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int m = t.length();
        int n = s.length();
        int[][] memo = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++) Arrays.fill(memo[i], -1);
        return dp(s, t, m, n, memo);
    }

    public int dp(String s, String t, int i, int j, int[][] memo) {
        // Base cases
        // There is one way of forming [] subsequence
        if (i == 0) return 1;

        // Using [] number of elements in s, t can never be reached
        // Except for t = []
        if (j == 0) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        if (s.charAt(j - 1) == t.charAt(i - 1)) {
            memo[i][j] = dp(s, t, i, j - 1, memo) + dp(s, t, i - 1, j - 1, memo);
        } else {
            memo[i][j] = dp(s, t, i, j - 1, memo);
        }
        return memo[i][j];
    }
}
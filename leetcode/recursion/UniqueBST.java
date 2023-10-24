/*
96. Unique Binary Search Trees
Medium
Topics
Companies
Given an integer n, return the number of structurally unique BST's (binary search trees)
which has exactly n nodes of unique values from 1 to n
*/

class UniqueBST {
	/*
		Top down with memo
	*/
    private static int numTreesTopDown(int n) {
    	int[] memo = new int[n+1];
    	memo[0] = 1; memo[1] = 1;
    	return numTreesMemo(n, memo);
    }

    private static int numTreesMemo(int n, int[] memo) {
        if (memo[n] != 0) return memo[n];

        for(int i=1; i<=n; i++) {
        	memo[n] += numTreesMemo(i-1, memo) * numTreesMemo(n-i, memo);
        }
        return memo[n];
    }

    /* Bottom up*/
    private static int numTreesBottomUp(int n) {
    	int[] dp = new int[n+1];
    	dp[0] = 1;
    	dp[1] = 1;

    	for(int i=2; i<=n; i++) {
    		for(int j=1; j<=i; j++) {
    			dp[i] += dp[j-1] * dp[i-j];
    		}
    	}
    	return dp[n];
    }

    public static void main(String[] args) {
    	int n = 3;
    	System.out.println(numTreesBottomUp(n));
    }
}
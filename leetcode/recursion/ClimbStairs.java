/*
70. Climbing Stairs
Solved
Easy
Topics
Companies
Hint
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

class ClimbStairs {
    private static int climbStairs(int n) {
        int[] memo = new int[n+1];
        memo[n] = climbStairsRecurse(n, memo);
        return memo[n];
    }

    private static int climbStairsRecurse(int n, int[] memo) {
    	if (memo[n] != 0) return memo[n];

    	if (n <= 2) {
    		memo[n] = n;
    		return n;
    	}

    	memo[n] = climbStairsRecurse(n-1, memo) + climbStairsRecurse(n-2, memo);
    	return memo[n];
    }

    public static void main(String[] args) {
    	int n = 4;
    	System.out.println(climbStairs(n));
    }
}
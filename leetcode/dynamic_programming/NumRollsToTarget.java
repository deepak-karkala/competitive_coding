/*
1155. Number of Dice Rolls With Target Sum
Solved
Medium
Topics
Companies
Hint
You have n dice, and each dice has k faces numbered from 1 to k.

Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the dice, so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 109 + 7.
*/

class NumRollsToTarget {
    int MOD = 1000000000 + 7;

    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] count = new Integer[n + 1][target + 1];
        return dp(n, k, target, count);
    }

    public int dp(int n, int k, int rem, Integer[][] count) {
        // Base cases
        if (rem < 0) return 0;
        if (n == 0 && rem == 0) return 1;
        
        //if (n == 0 || rem == 0) return 0;
        if (n > rem || (n * k < rem)) return 0;

        if (count[n][rem] != null) return count[n][rem];

        count[n][rem] = 0;
        for(int i = 1; i <= k; i++) {
            if (i > rem) break;
            else count[n][rem] = (count[n][rem] + dp(n - 1, k, rem - i, count)) % MOD;
        }
        return (int) count[n][rem];
    }
}
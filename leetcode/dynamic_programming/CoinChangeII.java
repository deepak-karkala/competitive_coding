/*
518. Coin Change II
Solved
Medium
Topics
Companies
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.
*/

class CoinChangeII {
    // Time: O(n * amount) Space: O(amount)
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] memo = new int[amount + 1];

        // There is 1 way to reach amount = 0 (don't take any => empty subset)
        memo[0] = 1;

        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0) memo[j] += memo[j - coins[i]];
            }
        }
        return memo[amount];
    }
}
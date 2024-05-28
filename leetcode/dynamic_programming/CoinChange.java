/*
322. Coin Change
Solved
Medium
Topics
Companies
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
*/

class CoinChange {
    // Top Down
    public int coinChange1(int[] coins, int amount) {
        int[] memo = new int[amount];
        return dp(coins, amount, memo);
    }

    public int dp(int[] coins, int rem, int[] memo) {
        // Target cannot be reached, return -1
        if (rem < 0) return -1;
        // Target reached, no more coins needed
        if (rem == 0) return 0;
        // DP already computed for this amount, return that
        if (memo[rem - 1] != 0) return memo[rem - 1];

        int min = Integer.MAX_VALUE;

        // Try each coin and record the min
        for(int coin : coins) {
            int count = dp(coins, rem - coin, memo);
            if (count >= 0 && count < min) min = count + 1;
        }

        memo[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memo[rem - 1];
    }

    // Bottom up
    public int coinChange2(int[] coins, int amount) {
        int[] count = new int[amount + 1];

        // Compute min count required for 1,2...amount
        for(int i = 1; i <= amount; i++) {

            // Try each coin and record the min
            int min = Integer.MAX_VALUE;
            for(int coin : coins) {
                if (i - coin >= 0 && count[i - coin] != -1)
                    min = (count[i - coin] < min) ? count[i - coin] : min;
            }
            count[i] = (min == Integer.MAX_VALUE) ? -1 : min + 1;
        }
        return count[amount];
    }
}
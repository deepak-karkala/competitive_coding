/*
877. Stone Game
Solved
Medium
Topics
Companies
Alice and Bob play a game with piles of stones. There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].

The objective of the game is to end with the most stones. The total number of stones across all the piles is odd, so there are no ties.

Alice and Bob take turns, with Alice starting first. Each turn, a player takes the entire pile of stones either from the beginning or from the end of the row. This continues until there are no more piles left, at which point the person with the most stones wins.

Assuming Alice and Bob play optimally, return true if Alice wins the game, or false if Bob wins.
*/

class StoneGame {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] memo = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(memo[i], -1);

        // P1 score using DP
        int scoreAlice = dp(piles, 0, n - 1, memo);
        
        // Total score
        int scoreTotal = 0;
        for(int num: piles) scoreTotal += num;

        // P2 score
        int scoreBob = scoreTotal - scoreAlice;
        
        return scoreAlice >= scoreBob;
    }

    public int dp(int[] nums, int i, int j, int[][] memo) {
        if (i >= memo.length || j < 0 || i > j) return 0;
        if (i == j) return nums[i];
        if (memo[i][j] != -1) return memo[i][j];

        memo[i][j] = Math.max(
            nums[i] + Math.min(
                dp(nums, i + 2, j, memo),
                dp(nums, i + 1, j - 1, memo)
            ),
            nums[j] + Math.min(
                dp(nums, i, j - 2, memo),
                dp(nums, i + 1, j - 1, memo)
            )
        );
        
        return memo[i][j];
    }
}
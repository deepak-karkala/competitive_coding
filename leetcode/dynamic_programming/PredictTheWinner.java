/*
486. Predict the Winner
Solved
Medium
Topics
Companies
You are given an integer array nums. Two players are playing a game with this array: player 1 and player 2.

Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of 0. At each turn, the player takes one of the numbers from either end of the array (i.e., nums[0] or nums[nums.length - 1]) which reduces the size of the array by 1. The player adds the chosen number to their score. The game ends when there are no more elements in the array.

Return true if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner, and you should also return true. You may assume that both players are playing optimally.
*/

class PredictTheWinner {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        // Player 1's score for nums[i:j]
        int[][] memo = new int[n][n];

        /* Recursion
            For nums[i:j], following choices for player 1,
            1. If Player 1 chooses nums[i], Player 2 has two choices,
                a. => P2 chooses nums[i + 1]
                   => P1 has to choose from either end of nums[i + 2 : j]
                   => This is evaluated as P1 score dp[i + 2][j]
                b. => P2 chooses nums[j]
                   => P1 has to choose from either end of nums[i + 1 : j - 1]
                   => This is evaluated as P1 score dp[i + 1][j - 1]
                Since P2 chooses optimally (max(a, b)) => 
                c. P1 score for this choice will be nums[i] + Math.min(1.a, 1.b)
            2. If Player 1 chooses nums[j], ...
                ....
                a.
                b.
                c. P1 score for this choice will be nums[j] + Math.min(2.a, 2.b)
            3. So overall,to maximize P1's score,
                max(1.c, 2.c)
        */

        // DP Bottom up
        for(int len = 1; len <= n; len++) {
            for( int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                int choice1 = (i + 2 < n && j >= 0)     ? memo[i + 2][j]     : 0;
                int choice2 = (i + 1 < n && j - 1 >= 0) ? memo[i + 1][j - 1] : 0;
                int choice3 = (i < n && j - 2 >= 0)     ? memo[i][j - 2]     : 0;

                memo[i][j] = Math.max(nums[i] + Math.min(choice1, choice2), nums[j] + Math.min(choice2, choice3));
            }
        }

        int scoreP1 = memo[0][n - 1];
        // Total score
        int scoreTotal = 0;
        for(int num: nums) scoreTotal += num;
        int scoreP2 = scoreTotal - scoreP1;
        return scoreP1 >= scoreP2;

    }
}
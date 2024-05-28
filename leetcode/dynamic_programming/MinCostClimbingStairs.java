/*
746. Min Cost Climbing Stairs
Solved
Easy
Topics
Companies
Hint
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.
*/

class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        // dp[i] -> Min cost to go from i to last step
        int[] dp = new int[cost.length + 1];
        dp[cost.length] = 0;
        dp[cost.length - 1] = cost[cost.length - 1];

        for(int i = cost.length - 2; i >= 0; i--) {
            dp[i] = Math.min(dp[i + 1], dp[i + 2]) + cost[i];
        }

        return Math.min(dp[0], dp[1]);
    }
}
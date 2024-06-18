/*
188. Best Time to Buy and Sell Stock IV
Solved
Hard
Topics
Companies
You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
*/

class BestTimeBuySellStock4 {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        
        // Greedy solution for num transactions more than number of days
        if (k >= len / 2) return quickSolve(prices);

        // DP state: dp[i][j] Max profit with i transactions till jth day
        int[][] memo = new int[k + 1][len];

        // Base cases
        // memo[0][:] = 0  0 transactions => 0 profit
        // memo[:][0] = 0  Using first day, no transaction can be completed

        for(int i = 1; i <= k; i++) {
            int max_profit_till_jm1 = -prices[0];
            for(int j = 1; j < len; j++) {
                memo[i][j] = Math.max(memo[i][j - 1], max_profit_till_jm1 + prices[j]);
                max_profit_till_jm1 = Math.max(max_profit_till_jm1, memo[i - 1][j - 1] - prices[j]);
            }
        }

        return memo[k][len - 1];
    }

    public int quickSolve(int[] prices) {
        int profit = 0;

        for(int i = 1; i < prices.length; i++)
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
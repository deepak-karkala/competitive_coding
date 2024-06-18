/*
309. Best Time to Buy and Sell Stock with Cooldown
Medium
Topics
Companies
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
*/

class BestTimeBuySellStockCooldown {
    // DP
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int[] memo = new int[prices.length];
        int max_profit_till_jm1 = 0;

        // Till first day, profit = 0
        memo[0] = 0;
        max_profit_till_jm1 = -prices[0];

        memo[1] = Math.max(prices[1] - prices[0], 0);
        max_profit_till_jm1 = Math.max(-prices[0], -prices[1]);

        for(int i = 2; i < prices.length; i++) {
            memo[i] = Math.max(memo[i - 1], max_profit_till_jm1 + prices[i]);
            // i - 2 because i - 1 is a cooldown day
            max_profit_till_jm1 = Math.max(max_profit_till_jm1, memo[i - 2] - prices[i]);
        }
        return memo[prices.length - 1];
    }


    // State machine
    public int maxProfit2(int[] prices) {
        int sold = 0, rest = 0, hold = -prices[0];
        int prevSold = 0;

        for(int i = 0; i < prices.length; i++) {
            prevSold = sold;
            sold = hold + prices[i];
            hold = Math.max(hold, rest - prices[i]);
            rest = Math.max(rest, prevSold);
        }
        return Math.max(sold, rest);
    }
}
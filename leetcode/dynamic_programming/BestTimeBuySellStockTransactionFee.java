/*
714. Best Time to Buy and Sell Stock with Transaction Fee
Medium
Topics
Companies
Hint
You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
*/

class BestTimeBuySellStockTransactionFee {
    // State machine
    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) return 0;

        int len = prices.length;
        int[] buy = new int[len];
        int[] sell = new int[len];

        buy[0] = -(prices[0] + fee);

        for(int i = 1; i < len; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i] - fee);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[len - 1];
    }
}
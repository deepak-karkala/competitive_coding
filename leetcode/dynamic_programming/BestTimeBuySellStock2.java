/*
122. Best Time to Buy and Sell Stock II
Solved
Medium
Topics
Companies
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.
*/

class BestTimeBuySellStock2 {
    // State machine (DP)
    // 2 states - Total of 4 actions possible
    public int maxProfit1(int[] prices) {
        // Have to start with buying first, init to -inf
        int profit_till_last_buy = Integer.MIN_VALUE;
        int profit_till_last_sold = 0;

        for(int price: prices) {
            // Either keep lastbuy(remain in hold state) or 
            //  buy (move from nothold to hold, price[i] will be subtracted from profit_till_last_sold)
            int curbuy = Math.max(profit_till_last_buy, profit_till_last_sold - price);

            // Either remain in non-hold state (profit_till_last_sold) or
            //     sell (move from hold to non-hold, add price to profit_till_last_buy)
            int cursell = Math.max(profit_till_last_sold, profit_till_last_buy + price);

            profit_till_last_buy = curbuy;
            profit_till_last_sold = cursell;
        }
        return profit_till_last_sold;
    }

    // Greedy
    public int maxProfit2(int[] prices) {
        int profit = 0;

        for(int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1])
                profit += prices[i + 1] - prices[i];
        }
        return profit;
    }
}
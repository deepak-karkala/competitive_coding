/*
123. Best Time to Buy and Sell Stock III
Hard
Topics
Companies
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
*/

class BestTimeBuySellStock3 {
    public int maxProfit(int[] prices) {
        // Assume we only have 0 money at first
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;

        for(int price: prices) {
            // The maximum if we've just sold 2nd stock so far.
            release2 = Math.max(release2, hold2 + price);

            // The maximum if we've just buy  2nd stock so far.
            hold2 = Math.max(hold2, release1 - price);

            // The maximum if we've just sold 1nd stock so far.
            release1 = Math.max(release1, hold1 + price);

            // The maximum if we've just buy  1st stock so far.
            hold1 = Math.max(hold1, -price);
        }
        return release2;
    }
}
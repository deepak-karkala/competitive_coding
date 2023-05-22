/*
121. Best Time to Buy and Sell Stock
Easy
25.3K
797
Companies
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

*/

class MaxProfit {
    public static int maxProfit(int[] prices) {
        int maxFromThisDayTillEnd = 0;
        int maxFromNextDayTillEnd = prices[prices.length-1];
        int max = 0;

        for(int i=prices.length-2; i>=0; i--) {
        	maxFromThisDayTillEnd = Math.max(maxFromNextDayTillEnd, prices[i]);
        	max = Math.max(maxFromThisDayTillEnd - prices[i], max);
        	maxFromNextDayTillEnd = maxFromThisDayTillEnd;
        }
        return max;
    }

    public static void main(String[] args) {
    	int[] prices = {7,1,5,3,6,4};
    	System.out.println(maxProfit(prices));
    }
}
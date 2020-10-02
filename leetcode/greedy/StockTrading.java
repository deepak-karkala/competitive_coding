package greedy;

import greedy.StockTrading;

/*
Say you have an array prices for which the ith element is the price
of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as
many transactions as you like (i.e., buy one and sell one share of
the stock multiple times).

Note: You may not engage in multiple transactions at the same time
(i.e., you must sell the stock before you buy again)
*/


class StockTrading {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int i = 1;
        while (i<prices.length) {
        	if (prices[i] > prices[i-1]) {
        		//System.out.println(i + "-" + prices[i] + "-" + prices[i-1]);
        		profit += prices[i] - prices[i-1];	
        	} 
        	i++;
        }
        
        return profit;
    }
    
    public static void main(String[] args) {
    	StockTrading st = new StockTrading();

    	int[] prices = {1, 7, 2, 3, 6, 7, 6, 7};
    	int maxProfit = st.maxProfit(prices);
    	System.out.println(maxProfit);
    }
}
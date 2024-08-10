"""
121. Best Time to Buy and Sell Stock
Solved
Easy
Topics
Companies
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
"""


class BestTimeBuySellStock:
    def maxProfit(self, prices: List[int]) -> int:
        """
        maxSellingPriceFromHereOn = 0
        maxProfit = 0

        for i in range(len(prices)-1, -1, -1):
            maxSellingPriceFromHereOn = max(maxSellingPriceFromHereOn, prices[i])
            currProfit = maxSellingPriceFromHereOn - prices[i]
            maxProfit = max(maxProfit, currProfit)

        return maxProfit
        """

        minBuyingPriceTillNow = prices[0]
        maxProfit = 0

        for i in range(1, len(prices)):
            currProfit = prices[i] - minBuyingPriceTillNow
            minBuyingPriceTillNow = min(minBuyingPriceTillNow, prices[i])
            maxProfit = max(maxProfit, currProfit)

        return maxProfit

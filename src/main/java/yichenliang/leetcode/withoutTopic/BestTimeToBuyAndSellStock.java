package yichenliang.leetcode.withoutTopic;

/**
 * 121. Best Time to Buy and Sell Stock
 * 
 * time complexity: O(n)
 * space complexity: O(1)
 * 
 */

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}

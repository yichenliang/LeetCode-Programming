package yichenliang.leetcode.all;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * 
 *  DP
 *
 *  method 1
 *  time complexity: O(n)
 *  space complexity: O(n)
 *  
 *  method 2
 *  time complexity: O(n)
 *  space complexity: O(1)
 */

public class BestTimeToBuyAndSellStockWithCooldown {
	
	public int maxProfit(int[] prices) {
        
        if(prices == null || prices.length <= 1){
            return 0;
        }
        
        int n = prices.length;
        int[] hold = new int[n];
        int[] unhold = new int[n];
        
        hold[0] = -prices[0];
        unhold[0] = 0;
        
        for(int i = 1; i < n; i++){
            if(i == 1){
               hold[i] = Math.max(hold[i - 1], -prices[i]);
               unhold[i] = Math.max(unhold[i - 1], hold[i -1] + prices[i]);
            }
            else{
                hold[i] = Math.max(hold[i - 1], unhold[i - 2] - prices[i]);
                unhold[i] = Math.max(unhold[i - 1], hold[i -1] + prices[i]);
            }   
        }
        
        return unhold[n -1];
        
    }

}

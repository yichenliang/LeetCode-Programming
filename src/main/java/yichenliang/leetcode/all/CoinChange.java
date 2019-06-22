package yichenliang.leetcode.all;

/**
 * 322. Coin Change
 * 
 * dynamic programming
 * 
 * method 1
 * time complexity: O(nm)
 * space complexity: O(nm)
 * 
 * method 2
 * optimize space complexity: using 1-d array
 * time complexity: O(nm)
 * space complexity: O(m)
 * 
 */


public class CoinChange {
	
	// method 1
	public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 0;
        for(int j = 1; j <= amount; j++){
            dp[0][j] = Integer.MAX_VALUE;
        }
        
        // dp
        for(int i = 1; i <= coins.length; i++){
            for(int j = 0; j <= amount; j++){
                dp[i][j] = dp[i - 1][j];
                if(j - coins[i - 1] >= 0 && dp[i][j - coins[i - 1]] < Integer.MAX_VALUE){
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }   
            }
        }
        return dp[coins.length][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length][amount];
    }
	
	// method 2
		public int coinChange2(int[] coins, int amount) {
	        int[] dp = new int[amount + 1];
	        dp[0] = 0;
	        for(int j = 1; j <= amount; j++){
	            dp[j] = Integer.MAX_VALUE;
	        }
	        
	        // dp
	        for(int i = 1; i <= coins.length; i++){
	            for(int j = 0; j <= amount; j++){
	                dp[j] = dp[j];
	                if(j - coins[i - 1] >= 0 && dp[j - coins[i - 1]] < Integer.MAX_VALUE){
	                    dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1);
	                }   
	            }
	        }
	        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	    }
	
	
	
	public static void main(String[] args) {
		CoinChange solution = new CoinChange();
		int[] coins = {1, 2, 5};
		int amount = 11;
		int res = solution.coinChange(coins, amount);
		System.out.println(res);
	}

}

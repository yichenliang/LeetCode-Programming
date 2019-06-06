package yichenliang.leetcode.all;

/**
 * 518. Coin Change 2
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


public class CoinChange2 {
	
	public int change1(int amount, int[] coins) { 
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        dp[0][0] = 1;
        for(int numOfCoins = 1; numOfCoins <= len; numOfCoins++){
            for(int money = 0; money <= amount; money++){
                dp[numOfCoins][money] = dp[numOfCoins - 1][money] + (coins[numOfCoins - 1] <= money ? dp[numOfCoins][money - coins[numOfCoins - 1]] : 0);
            }
        }
        return dp[len][amount];
    }
	
	public int change2(int amount, int[] coins) {
        
        int len = coins.length;
        int[]dp = new int[amount + 1];
        dp[0]= 1;
        for(int numOfCoins = 1; numOfCoins <= len; numOfCoins++){
            for(int money = 0; money <= amount; money++){
                if(coins[numOfCoins - 1] <= money){
                  dp[money] += dp[money - coins[numOfCoins - 1]];
                }
                
            }
        }
        return dp[amount];
    }
	
	

}

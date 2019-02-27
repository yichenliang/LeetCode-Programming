package yichenliang.leetcode;

/**
 *  312. Burst Balloons
 * 
 *  dynamic programming
 *  
 *  time complexity: O(n^3)
 *  space complexity: O(n^2)
 */

public class BurstBalloons {
	public int maxCoins(int[] nums) {
        
        int[] coins = new int[nums.length + 2];
        int n = coins.length;
        coins[0] = 1;
        coins[n - 1] = 1;
        int index = 1;
        for(int num : nums){
            coins[index] = num;
            index++;
        }
        
        int[][] maxCoin = new int[n][n];
        
        for(int dis = 2; dis <= n - 1; dis++){
            for(int left = 0; left + dis < n; left++){
                int right = left + dis;
                for(int i = left + 1; i <= right - 1; i++){
                    maxCoin[left][right] = Math.max(maxCoin[left][right], 
                                coins[i]*coins[left]*coins[right] + maxCoin[left][i] + maxCoin[i][right]);
                }
                
            }
        }
        return maxCoin[0][n-1];
    }
}

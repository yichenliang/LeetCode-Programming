package yichenliang.leetcode.dp;

/**
 *  63. Unique Paths II
 *   
 *  time complexity: O(n)
 *  space complexity: O(n)
 * 
 */

public class UniquePathsII {
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int len = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        
        int[][] dp = new int[len][width];
        dp[len - 1][width - 1] = 1;
        
        for(int i = len - 1; i >=0; i--){
            for(int j = width - 1; j >= 0; j--){
                if(obstacleGrid[i][j] != 1){
                    if(i + 1 < len){
                        dp[i][j] += dp[i + 1][j];
                    }
                    
                    if(j + 1 < width){
                        dp[i][j] += dp[i][j + 1];
                    }
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[0][0];
    }

}

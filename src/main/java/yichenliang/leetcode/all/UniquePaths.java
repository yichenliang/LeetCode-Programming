package yichenliang.leetcode.all;

/**
 * 62. Unique Paths
 * 
 * dp
 * 
 * time complexity: O(n*m)
 * space complexity: O(n*m)
 */

public class UniquePaths {
	
	public int uniquePaths(int m, int n) {
        
        if(m == 0 || n == 0){
            return 0;
        }
        
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][n - 1] = 1;
        }
        for(int i = 0; i < n; i++){
            dp[m - 1][i] = 1;
        }
        
        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }
        return dp[0][0];
    }

}

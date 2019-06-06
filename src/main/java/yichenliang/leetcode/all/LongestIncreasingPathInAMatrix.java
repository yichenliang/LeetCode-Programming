package yichenliang.leetcode.all;

/**
 *  329. Longest Increasing Path in a Matrix
 *  
 *  dp + dfs
 *   
 *  time complexity: O(m*n)
 *  space complexity: O(m*n)
 * 
 */

public class LongestIncreasingPathInAMatrix {
	
	public int longestIncreasingPath(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0|| matrix[0].length == 0) return 0;
        
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
  
        int ans = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int current = dfs(matrix, i, j, dp);
                ans = Math.max(ans, current);
            }
        }
        return ans;   
    }
    
    
    private int dfs(int[][] matrix, int i, int j, int[][] dp){
        
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int[] dir = {0, -1, 0, 1, 0};
        dp[i][j] = 1;
        
        for(int n = 0; n < 4; n++){
            int ti = i + dir[n];
            int tj = j + dir[n + 1];
            if(ti < 0 || tj < 0 || ti >= matrix.length ||tj >= matrix[0].length || matrix[ti][tj] <= matrix[i][j]){
                continue;
            }
            
            dp[i][j] = Math.max(dp[i][j], 1 + dfs(matrix, ti, tj, dp));  
        }
        
        return dp[i][j];     
    }

}

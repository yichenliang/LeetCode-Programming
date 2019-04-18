package yichenliang.leetcode.withoutTopic;

/**
 * 221. Maximal Square
 * 
 * method1: dynamic programming
 * time complexity: O(n^3)
 * space complexity: O(n^2)
 * 
 * method2: dynamic programming
 * time complexity: O(n^2)
 * space complexity: O(n^2)
 */

public class MaximalSquare {
	
	public int maximalSquare1(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] sums = new int[m + 1][n + 1];
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                sums[i][j] = matrix[i - 1][j - 1] - '0' + sums[i - 1][j] + sums[i][j - 1] - sums[i -1][j - 1];
            }
        }
        
        int ans = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                for(int k = Math.min(m - i + 1, n - j + 1); k > 0; k--){
                    int sum = sums[i + k - 1][j + k - 1] - sums[i + k - 1][j - 1] - sums[i - 1][j + k - 1] + sums[i - 1][j - 1];
                    // full of 1 in this square
                    if(sum == k * k){
                        ans = Math.max(ans, sum);
                        break;
                    }
                }
                
            }   
        }
    
        return ans;
    }
	
	public int maximalSquare2(char[][] matrix) {
        
	       if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
	        
	        int m = matrix.length;
	        int n = matrix[0].length;
	        
	        int[][] sizes = new int[m][n];
	        
	        int ans = 0;
	        for(int i = 0; i < m; i++){
	            for(int j = 0; j < n; j++){
	                sizes[i][j] = matrix[i][j] - '0';
	                if(sizes[i][j] == 0) continue;
	                
	                if(i == 0 || j == 0){
	                    // do nothing: cannot form a square
	                }
	                else{
	                    sizes[i][j] = Math.min(Math.min(sizes[i - 1][j - 1], sizes[i - 1][j]), sizes[i][j - 1]) + 1;
	                }
	                ans = Math.max(ans, sizes[i][j] * sizes[i][j]);
	            }
	        }
	    
	        return ans;
	    }
}

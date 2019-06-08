package yichenliang.leetcode.dp;

/**
 * 64. Minimum Path Sum
 * 
 * dp
 * 
 * time complexity: O(n)
 * space complxity: O(1)
 */

public class MinimumPathSum {
	
	public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        
        for(int i = row - 1; i >= 0; i--){
            for(int j = col - 1; j >= 0; j--){
                if(i + 1 >= row && j + 1 < col){
                    grid[i][j] += grid[i][j + 1];
                }
                else if(j + 1 >= col && i + 1 < row){
                    grid[i][j] += grid[i + 1][j];
                }
                else if(i + 1 >= row && j + 1 >= col){
                    
                }
                else{
                     grid[i][j] += Math.min(grid[i][j + 1], grid[i + 1][j]); 
                }

            }
        }
        return grid[0][0];
    }

}

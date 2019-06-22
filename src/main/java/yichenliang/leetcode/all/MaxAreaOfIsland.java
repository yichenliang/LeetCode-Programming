package yichenliang.leetcode.all;

/**
 *  695. Max Area of Island
 *  
 *  method : dfs
 *  
 *  time complexity: O(n * m)
 *  space complexity: O(n * m)
 *  
 */

public class MaxAreaOfIsland {
	
	public int maxAreaOfIsland(int[][] grid) {
        
	      if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
	       
	       int maxResult = 0;
	       
	       for(int i = 0; i < grid.length; i++){
	           for(int j = 0; j < grid[0].length; j++){
	               if(grid[i][j] == 1){
	                   int[] curMax = {0};
	                   dfsHelper(grid, i, j, curMax);
	                   maxResult = Math.max(maxResult, curMax[0]);
	               }
	           }
	       }
	       return maxResult;
	   }
	   
	   private void dfsHelper(int[][] grid, int i, int j, int[] max){
	       
	       //end case
	       if(i < 0 || j < 0 || i == grid.length || j == grid[0].length) return;
	       
	       // normal case
	       if(grid[i][j] == 1){
	           max[0]++;
	           grid[i][j] = 0;
	           
	           // up
	           dfsHelper(grid, i - 1, j, max);
	               
	           // down
	           dfsHelper(grid, i + 1, j, max);
	           
	           // left
	           dfsHelper(grid, i, j - 1, max);
	           
	           // right
	           dfsHelper(grid, i, j + 1, max);
	       }
	       return;
	   }
}

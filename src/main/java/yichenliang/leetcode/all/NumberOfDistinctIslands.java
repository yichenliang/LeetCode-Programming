package yichenliang.leetcode.all;

import java.util.HashSet;
import java.util.Set;

/**
 *  694. Number of Distinct Islands
 *   DFS
 *   
 *   time complexity: O(m*n)
 *   space complexity: O(m*n)
 * 
 */

public class NumberOfDistinctIslands {
	
	public int numDistinctIslands(int[][] grid) {
        
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int len = grid.length;
        int wid = grid[0].length;
        
        Set<String> set = new HashSet<>();
        for(int i = 0; i < len; i++ ){
            for(int j = 0; j < wid; j++){
                if(grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, 0, 'o', sb);
                    String str = sb.toString();
                    set.add(str);
                }
            }
        }
        
        return set.size();
    }
    
    private void dfs(int[][] grid, int i, int j, int level, char direction, StringBuilder sb){
        // end case
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return;
        }
        
        // normal case
        grid[i][j] = 0;
        sb.append(level);
        sb.append(direction);
        // up down left right
        dfs(grid, i - 1, j, level + 1, 'u', sb);
        dfs(grid, i + 1, j, level + 1, 'd', sb);
        dfs(grid, i, j - 1, level + 1, 'l', sb);
        dfs(grid, i, j + 1, level + 1, 'r', sb);
    }

}

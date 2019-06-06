package yichenliang.leetcode.all;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 827. Making A Large Island
 * 
 * DFS
 * 
 * Time complexity : O(n^2)
 * Space complexity : O(n^2)
 * 
 */

public class MakingALargeIsland {
	
	public int largestIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        //diff each group
        int row = grid.length;
        int col = grid[0].length;
        int color = 2;
        int res = 0;
        HashMap<Integer, Integer> store = new HashMap<>();
        store.put(0, 0);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    int[] num = {0};
                    dfs(grid, i, j, color, num);
                    res = Math.max(res, num[0]);
                    store.put(color, num[0]);
                    color++;
                } 
            }
        }
        
        // try to connect
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0){
                   Set<Integer> set = new HashSet<>();
                   if(i - 1 >= 0) set.add(grid[i - 1][j]);
                   if(j - 1 >= 0) set.add(grid[i][j - 1]);
                   if(i + 1 < row) set.add(grid[i + 1][j]);
                   if(j + 1 < col) set.add(grid[i][j + 1]);
                    int current = 0;
                    for(int c : set){
                        current += store.get(c);
                    }
                    res = Math.max(current + 1, res);
                }
            }
        }
        return res;
    }
    
    private void dfs(int[][] grid, int i, int j, int color, int[] num){
        if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) return;
        if(grid[i][j] != 1) return;
        
        grid[i][j] = color;
        num[0]++;
        dfs(grid, i - 1, j, color, num);
        dfs(grid, i + 1, j, color, num);
        dfs(grid, i, j - 1, color, num);
        dfs(grid, i, j + 1, color, num);
    }

}

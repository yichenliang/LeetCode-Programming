package yichenliang.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  200. Number of Islands
 *  
 *  DFS
 *  time complexity: O(m*n)
 *  space complexity: O(m*n)
 *  
 *  BFS
 *  time complexity: O(m*n)
 *  space complexity: O(m*n)
 *  
 */

public class NumberOfIslands {
	
	// DFS
	public int numIslands1(char[][] grid) {
        
		 if (grid == null || grid.length == 0) {
		      return 0;
		    }

		    int nr = grid.length;
		    int nc = grid[0].length;
		    int num_islands = 0;
		    for (int r = 0; r < nr; ++r) {
		      for (int c = 0; c < nc; ++c) {
		        if (grid[r][c] == '1') {
		          ++num_islands;
		          dfs(grid, r, c);
		        }
		      }
		    }

		    return num_islands;
	}
	
	private void dfs(char[][] grid, int r, int c) {
	    int nr = grid.length;
	    int nc = grid[0].length;

	    if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
	      return;
	    }

	    grid[r][c] = '0';
	    dfs(grid, r - 1, c);
	    dfs(grid, r + 1, c);
	    dfs(grid, r, c - 1);
	    dfs(grid, r, c + 1);
	}
	
	// BFS
//	public int numIslands(char[][] grid) {
//	    if (grid == null || grid.length == 0) {
//	      return 0;
//	    }
//
//	    int nr = grid.length;
//	    int nc = grid[0].length;
//	    int num_islands = 0;
//
//	    for (int r = 0; r < nr; ++r) {
//	      for (int c = 0; c < nc; ++c) {
//	        if (grid[r][c] == '1') {
//	          ++num_islands;
//	          grid[r][c] = '0'; // mark as visited
//	          LinkedList<Integer> neighbors = new LinkedList<>();
//	          neighbors.add(r * nc + c);
//	          while (!neighbors.isEmpty()) {
//	            int id = neighbors.remove();
//	            int row = id / nc;
//	            int col = id % nc;
//	            if (row - 1 >= 0 && grid[row-1][col] == '1') {
//	              neighbors.add((row-1) * nc + col);
//	              grid[row-1][col] = '0';
//	            }
//	            if (row + 1 < nr && grid[row+1][col] == '1') {
//	              neighbors.add((row+1) * nc + col);
//	              grid[row+1][col] = '0';
//	            }
//	            if (col - 1 >= 0 && grid[row][col-1] == '1') {
//	              neighbors.add(row * nc + col-1);
//	              grid[row][col-1] = '0';
//	            }
//	            if (col + 1 < nc && grid[row][col+1] == '1') {
//	              neighbors.add(row * nc + col+1);
//	              grid[row][col+1] = '0';
//	            }
//	          }
//	        }
//	      }
//	    }
//	    return num_islands;
//	  }
	
	// bfs 
	public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int ans = 0;
        int row = grid.length, col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                   ans++;
                   bfs(i, j, grid);
                }
            }
        }
        return ans;
    }
    
    private void bfs(int i, int j, char[][] grid){
        int[] dir = {0, 1, 0, -1, 0};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});
        grid[i][j] = '0';
        while(q.size() > 0){
            int[] cur = q.poll();
            int ci = cur[0], cj = cur[1];
            for(int d = 0; d < 4; d++){
                int ni = ci + dir[d], nj = cj + dir[d + 1];
                if(ni < 0 || nj < 0 || ni >= grid.length || nj >= grid[0].length || grid[ni][nj] == '0') continue;
                q.offer(new int[] {ni, nj});
                grid[ni][nj] = '0';
            }
        }
    }
	
    public static void main(String[] args) {
    	NumberOfIslands solution = new NumberOfIslands();
    	char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    	solution.numIslands(grid);
    }
}

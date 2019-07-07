package yichenliang.leetcode.all;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  317. Shortest Distance from All Buildings
 *  
 *  bfs
 *  
 *  time complexity: O(m^2*n^2)
 *  space complexity: O(m*n)
 *  
 */

public class ShortestDistanceFromAllBuildings {
	
	int[] rowDir = {-1, 1, 0, 0};
    int[] colDir = {0, 0, 1, -1};
    
    public int shortestDistance(int[][] grid) {
        
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        
        int rows = grid.length, cols = grid[0].length;
        int[][] canReach = new int[rows][cols]; 
        int[][] dist = new int[rows][cols];
        int totalBuildings = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    totalBuildings++;
                    bfs(grid, canReach, dist, i, j);   
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(canReach[i][j] == totalBuildings){
                    ans = Math.min(dist[i][j], ans);
                }
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private void bfs(int[][] grid, int[][] canReach, int[][] dist, int row, int col){
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        int distance = 0;
        queue.offer(new int[] {row, col});
        visited[row][col] = true;
        
        while(queue.size() > 0){
            distance++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                for(int k = 0; k < 4; k++){
                    int currentRow = cur[0] + rowDir[k];
                    int currentCol = cur[1] + colDir[k];
                    if(!isValid(grid, currentRow, currentCol, visited)){
                        continue;
                    }
                    visited[currentRow][currentCol] = true;
                    dist[currentRow][currentCol] += distance;
                    canReach[currentRow][currentCol]++;
                    queue.offer(new int[]{currentRow, currentCol});
                }
            }   
        }     
    }
    
    private boolean isValid(int[][] grid, int row, int col, boolean[][] visited){
        if(row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1){
            return false;
        }
        
        if(visited[row][col] == true){
            return false;
        }
        
        if(grid[row][col] != 0){
            return false;
        }
        
        return true;
    }

}

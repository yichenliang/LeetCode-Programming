class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                   int area = 1;
                   grid[i][j] = 0;
                   area += dfs(grid, i - 1, j);
                   area +=  dfs(grid, i + 1, j);
                   area += dfs(grid, i, j + 1);
                   area +=  dfs(grid, i, j - 1); 
                   maxArea = Math.max(maxArea, area); 
                }
                
            }
        }
        return maxArea;
        
    }
    
    public int dfs(int[][] grid, int row, int col){
        if(row == -1 || row == grid.length || col == -1 || col == grid[0].length) return 0;
        
        if(grid[row][col] == 0){return 0;}
        
        int area = 0;
        if(grid[row][col] == 1){
            area = 1;
            grid[row][col] = 0;
            area += dfs(grid, row - 1, col);
            area +=  dfs(grid, row + 1, col);
            area += dfs(grid, row, col + 1);
            area +=  dfs(grid, row, col - 1);        
        }
        return area;
        
    }
    
    
}

// time complexity: O(M*N)
// space complexity: O(M*N)
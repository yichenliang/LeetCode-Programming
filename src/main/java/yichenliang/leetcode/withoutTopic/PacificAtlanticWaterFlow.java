package yichenliang.leetcode.withoutTopic;

import java.util.ArrayList;
import java.util.List;

/**
 * 417. Pacific Atlantic Water Flow
 *  
 *  dfs
 *  
 */

public class PacificAtlanticWaterFlow {
	
	int[] dir = {1, 0, -1, 0, 1};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        
        List<int[]> ans = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return ans;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int[][] pacific = new int[row][col];
        int[][] atlantic = new int[row][col];
        
        for(int i = 0; i < row; i++){
            dfs(i, 0, pacific, matrix);
        }
        
        for(int i = 0; i < row; i++){
            dfs(i, col - 1, atlantic, matrix);
        }
        
        for(int j = 0; j < col; j++){
            dfs(0, j, pacific, matrix);
        }
        
        for(int j = 0; j < col; j++){
            dfs(row - 1, j, atlantic, matrix);
        }
        
       
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(pacific[i][j] == 1 && atlantic[i][j] == 1){
                    ans.add(new int[]{i, j});
                }
            }
        }
        return ans;
    }
    
    void dfs(int x, int y, int[][] sea, int[][] matrix){
        sea[x][y] = 1;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        for(int k = 0; k < 4; k++){
            int tx = x + dir[k];
            int ty = y + dir[k + 1];
            if(tx < 0 || tx >= row || ty < 0 || ty >= col){
                continue;
            }
            if(sea[tx][ty] == 1){
                continue;
            }
            if(matrix[tx][ty] < matrix[x][y]){
                continue;
            }
            dfs(tx, ty, sea, matrix);
        }
        
    }

}

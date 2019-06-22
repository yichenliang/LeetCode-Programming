package yichenliang.leetcode.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 733. Flood Fill
 * 
 * method1: bfs
 * time complexity: O(m * n)
 * space complexity: O(m * n)
 * 
 * method2: dfs
 * time complexity: O(m * n)
 * space complexity: O(m * n)
 */

public class FloodFill {
	
	// bfs
   public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0 || image[0].length == 0) return image;
        if(image[sr][sc] == newColor) return image;
        
        int row = image.length;
        int col = image[0].length;
        
        int len = Math.max(row, col);
        
        Queue<Integer> q = new LinkedList<>();
        int[] dir = {0, -1, 0, 1, 0};
        q.offer(sr * len + sc);
        int oriCol = image[sr][sc];
 
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                int num = q.poll();
                int r = num / len, c = num % len;
                image[r][c] = newColor;
                for(int i = 0; i < 4; i++){
                    int tr = r + dir[i], tc = c + dir[i + 1];
                    int n = tr * len + tc;
                    if(tr >= 0 && tc >= 0 && tr < row && tc < col && image[tr][tc] == oriCol){
                        q.offer(n);
                    }
                }
                size--;
            }
        }
        return image;  
    }
	
	//dfs
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length == 0 || image[0].length == 0) return image;
        if(image[sr][sc] == newColor) return image;
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void dfs(int[][] image, int i, int j, int oldColor, int newColor){
        
        if(i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != oldColor) return;
        
        image[i][j] = newColor;
        dfs(image, i - 1, j, oldColor, newColor);
         dfs(image, i + 1, j, oldColor, newColor);
         dfs(image, i, j - 1, oldColor, newColor);
         dfs(image, i, j + 1, oldColor, newColor);
        
        
        
    }
	
	

    public static void main(String[] args) {
    	FloodFill solution = new FloodFill();
    	int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
    	int sr = 1, sc = 1; 
    	int newColor = 2;
    	solution.floodFill(image, sr, sc, newColor);
    }

}

package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 *  296. Best Meeting Point
 *  
 *  Math
 *  
 *  method 1: very slow
 *  time complexity: O(m*n)
 *  space complexity: O(m + n)
 *  
 *  method 2: optimize based on method1, this question can be solved in each dimension individually
 *  time complexity: O()
 *  space complexity: O()
 *  
 *  2019/8/3
 */

public class BestMeetingPoint {
	
	public int minTotalDistance1(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        int r = grid.length, c = grid[0].length;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 1){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
           for(int i = 0; i < r; i++){
              for(int j = 0; j < c; j++){
                    int curAns = findDis(row, col, i, j);
                    ans = Math.min(ans, curAns);
              }
            }  
        
        return ans;
    }
    
    private int findDis(List<Integer> row, List<Integer> col, int i, int j){
        int sumR = 0;
        for(int each : row){
            sumR += Math.abs(each - i);
        }
        int sumC = 0;
        for(int each : col){
            sumC += Math.abs(each - j);
        }
        return sumR + sumC;
    }

    /////////////
    public int minTotalDistance2(int[][] grid) {
        List<Integer> rows = collectRows(grid);
        List<Integer> cols = collectCols(grid);
        return minDistance1D(rows) + minDistance1D(cols);
    }
    private List<Integer> collectRows(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    rows.add(row);
                }
            }
        }
        return rows;
    }

    private List<Integer> collectCols(int[][] grid) {
        List<Integer> cols = new ArrayList<>();
        for (int col = 0; col < grid[0].length; col++) {
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] == 1) {
                    cols.add(col);
                }
            }
        }
        return cols;
    }
    private int minDistance1D(List<Integer> points) {
        int distance = 0;
        int i = 0;
        int j = points.size() - 1;
        while (i < j) {
            distance += points.get(j) - points.get(i);
            i++;
            j--;
        }
        return distance;
    }
        
        
}

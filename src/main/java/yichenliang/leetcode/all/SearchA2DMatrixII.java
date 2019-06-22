package yichenliang.leetcode.all;

/**
 *  240. Search a 2D Matrix II
 * 
 *  time complexity: O(m*n)
 *  space complexity: O(1)
 *  
 */

public class SearchA2DMatrixII {
	
	public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int row = matrix.length;
        int col = matrix[0].length;
        int curRow = 0;
        int curCol = col - 1;
        
        while(curRow < row && curCol >= 0){
            if(matrix[curRow][curCol] == target) return true;
            if(matrix[curRow][curCol] < target){
                curRow++;
            }
            else{
                curCol--;
            }
        }
        return false;
    }
}

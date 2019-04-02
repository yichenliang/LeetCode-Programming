package yichenliang.leetcode.withoutTopic;

/**
 * 48. Rotate Image
 * 
 * time complexity: O(n^2)
 * space complexity: O(1)
 */

public class RotateImage {
	
	public void rotate(int[][] matrix) {
	       if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
	        
	       int top = 0;
	       int bottom = matrix.length- 1;
	       int left = 0;
	       int right = matrix[0].length - 1;
	       int n = matrix.length; 
	        
	       while(n > 1){
	            for(int i = 0; i < n - 1; i++){
	                int temp = matrix[top][left + i];
	                matrix[top][left + i] = matrix[bottom - i][left];
	                matrix[bottom - i][left] = matrix[bottom][right - i];
	                matrix[bottom][right - i] = matrix[top + i][right];
	                matrix[top + i][right]= temp;
	            }
	           
	            top++;
	           left++;
	           right--;
	           bottom--;
	           n = n - 2;
	       }
	    }
	
	public static void main(String[] args) {
		
		RotateImage solution = new RotateImage();
		  int[][] matrix = {{1,2,3,4}, {5,6,7,8},{9,10,11,12},{13,14,15,16}};
		  solution.rotate(matrix);
		  //System.out.println(result);
	}
	

}

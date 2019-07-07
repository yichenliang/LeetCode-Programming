package yichenliang.leetcode.all;

/**
 *  283. Move Zeroes
 *  
 *  time complexity: O(n)
 *  space complexity: O(1)
 *  
 */

public class MoveZeroes {
	
	public void moveZeroes(int[] nums) {
		   
		   int index = 0;  //point to the current position to add some number
		   for (int num : nums) {
			   if(num != 0){
				   nums[index] = num;
				   index++;
			   }
		   }
	       
		   while (index < nums.length) {
			   nums[index] = 0;
			   index++;
		   }
		   
	}
}

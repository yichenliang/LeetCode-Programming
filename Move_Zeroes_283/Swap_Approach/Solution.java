//283. Move Zeroes
//Approach #2: swap the number 


class Solution {
   
   public void moveZeroes(int[] nums) {
	   
	   if(nums == null || nums.length == 0) {
		   return;
	   }
	  
	   int index = 0; 
	   int temp = 0;
	   for (int i = 0; i < nums.length; i++) {
		   if(nums[i] != 0) {
			   temp = nums[index];
			   nums[index] = nums[i];
			   nums[i] = temp;
			   index++;
		   }
	   }
	   
   }
	 
   public static void main(String args[])
    {
		Solution solution = new Solution();
		int[] inputA = {0,1,0,3,12};
		//int[] inputA = {1,2,3,4};
		
    	solution.moveZeroes(inputA);
    }
}



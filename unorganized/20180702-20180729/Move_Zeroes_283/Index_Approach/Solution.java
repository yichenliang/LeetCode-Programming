//283. Move Zeroes
//Approach #1: using index to point to the current position 


class Solution {
   
   public void moveZeroes(int[] nums) {
	   
	   //consider some special cases
	   if(nums == null || nums.length == 0) {
		   return;
	   }
	   
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
	

   public static void main(String args[])
    {
		Solution solution = new Solution();
		int[] inputA = {0,1,0,3,12};
		
    	solution.moveZeroes(inputA);
    }
}



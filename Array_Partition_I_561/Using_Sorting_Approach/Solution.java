//561. Array Partition I

//Approach #2 Using Sorting

import java.util.Arrays;
class Solution {
	  
	public int arrayPairSum(int[] nums) {
		
		int sum = 0;
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i += 2) {
			sum += nums[i];
		}
		return sum;
   }
    
    public static void main(String[] args) {
   	 
   	Solution solution = new Solution();
    int[] input = {1,4,3,2};
    int res = solution.arrayPairSum(input);
   	System.out.println(res);
  }

}


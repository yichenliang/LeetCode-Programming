package yichenliang.leetcode.all;

/**
 * 53. Maximum Subarray
 *
 * time complexity: O(n)
 * space complexity: O(1)
 */

public class MaximumSubarray {
	
	 public int maxSubArray(int[] nums) {
	        // edge case
	        if(nums == null){
	            return 0;
	        }
	        
	        if(nums.length == 1){
	            return nums[0];
	        }
	        
	        int max = nums[0];
	        int len = nums.length;
	        int current = nums[0];
	        for(int i = 1; i < len; i++){
	            if(current < 0){
	                current = nums[i];
	            }
	            else{
	               current += nums[i]; 
	            }
	            
	            max = Math.max(max, current);
	        }
	        
	        return max;
	    }

}

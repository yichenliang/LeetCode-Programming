package yichenliang.leetcode.all;

/**
 * 238. Product of Array Except Self
 * 
 * Math
 *  
 * time complexity: O(n)
 * space complexity: O(1)
 *  
 */

public class ProductOfArrayExceptSelf {
	
	public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        
        res[0] = 1;
        for(int i = 1; i < length; i++){
            res[i] = nums[i-1] * res[i-1];
        }
        
        int right = 1;
        for(int i = length - 1; i >= 0; i--){
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        return res;
    }
}

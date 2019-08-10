package yichenliang.leetcode.binarySearch;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * 
 * binary search
 * 
 * time complexity: O(logn)
 * space complexity: O(1)
 * 
 * 2019/8/10
 */

public class FindMinimumInRotatedSortedArray {
	
	public int findMin(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        // binary search
        int l = 0, r = nums.length;
        int first = nums[0];
        while(l < r){
            int m = l + (r - l) / 2;
            if(nums[m] >= first){
                l = m + 1;
            }
            else{
                r = m;
            }
        }
        
        if(l == nums.length){
            return nums[0];
        }
        return nums[l];   
    }

}

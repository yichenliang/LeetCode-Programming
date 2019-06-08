package yichenliang.leetcode.binarySearch;

/**
 *  540. Single Element in a Sorted Array
 *  
 *  Binary Search
 *  
 *  time complexity: O(logn)
 *  space complexity: O(1)
 *   
 */

public class SingleElementInASortedArray {
	
	public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        int l = 0;
        int r = nums.length;
        if(nums[r - 1] != nums[r - 2]) return nums[r - 1];
        
        while(l < r){
            int m = l + (r - l) / 2;
            if(m % 2 == 0){
                if(nums[m] == nums[m + 1]){
                    l = m + 1;
                }
                else{
                    r = m;
                }
             }
             else{
                if(nums[m] == nums[m - 1]){
                    l = m + 1;
                }
                else{
                    r = m;
                }
            }
        }
        return nums[l];
    }

}

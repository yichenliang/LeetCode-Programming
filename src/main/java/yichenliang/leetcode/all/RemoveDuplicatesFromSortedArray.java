package yichenliang.leetcode.all;

/**
 *  26. Remove Duplicates from Sorted Array
 *   
 *  time complexity: O(n)
 *  space complexity: O(1)
 * 
 */

public class RemoveDuplicatesFromSortedArray {
	
	public int removeDuplicates(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        
        if(nums.length == 1) return 1;
        
        int len = nums.length;
        int index = 0;
        for(int i = 1; i < len; i++){
            if(nums[i] > nums[index]){
                nums[index + 1] = nums[i];
                index++;
            }
        }
        return index + 1;
    }
}

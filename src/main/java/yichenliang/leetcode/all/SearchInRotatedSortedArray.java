package yichenliang.leetcode.all;

/**
 *  33. Search in Rotated Sorted Array
 *  
 *  binary search
 *  
 *  time complexity: O(logn)
 *  space complexity: O(1)
 * 
 */

public class SearchInRotatedSortedArray {
	
	public int search(int[] nums, int target) {
        
        if(nums == null || nums.length == 0) return -1;
        
        // find pivot
        int leftNum = nums[0];
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int m = l + (r - l) / 2;
            if(nums[m] < nums[m + 1]){
                if(nums[m] >= leftNum){
                    l = m + 1;
                }
                else{
                    r = m;
                }
            }
            else{
                r = m;
            }
        }
        int pivot = l;
        if(pivot == nums.length - 1) return binarySearch(nums, 0, nums.length - 1, target);
        if(target >= leftNum){
            return binarySearch(nums, 0, pivot, target);
        }
        else{
            return binarySearch(nums, pivot + 1, nums.length - 1, target);
        }
    }
    
    private int binarySearch(int[] nums, int l, int r, int target){
        while(l < r){
            int m = l + (r - l) / 2;
            if(nums[m] < target){
                l = m + 1;
            }
            else{
                r = m;
            }
        }
        if(nums[l] == target){
            return l;
        }
        else{
            return -1;
        }
    }

}

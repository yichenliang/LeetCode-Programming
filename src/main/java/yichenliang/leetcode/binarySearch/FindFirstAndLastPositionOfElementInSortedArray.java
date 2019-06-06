package yichenliang.leetcode.binarySearch;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * 
 * Binary Search
 * 
 * time complexity: O(logN)
 * space complexity: O(1)
 */

public class FindFirstAndLastPositionOfElementInSortedArray {
	
	public int[] searchRange(int[] nums, int target) {
        
        int[] ans = {-1, -1};
        
        if(nums == null || nums.length == 0){
            return ans;
        }
        
        if(nums.length == 1 && nums[0] == target){
            return new int[]{0, 0};
        }
        
        // normal case
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left <= right){
            
            mid = (left + right) / 2;
            
            if(nums[mid] == target){
                // check neighbor for first and last
                if(mid == 0 || nums[mid] != nums[mid - 1]){
                    ans[0] = mid;
                    left = mid + 1;
                }
                
                if(mid == nums.length - 1 || nums[mid] != nums[mid + 1]){
                    ans[1] = mid;
                    right = mid - 1;
                }
                else{ // in the middle of several target number
                    break;
                }   
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }   
        }
        
        // left, right, mid
        // find first
        int r = mid - 1;
        int m = 0;
        int l = left;
        while(l <= r){
            m = (l + r)/2;
            
            if(nums[m] == target){
                if(m == 0 || nums[m] != nums[m - 1]){
                    ans[0] = m;
                    break;
                }
                r = m - 1;
            }
            else{
                l = m + 1;
            }    
        }
        
        // find last
        l = mid + 1;
        r = right;
        while(l <= r){
            m = (l + r)/2; 
            if(nums[m] == target){
                if(m == nums.length - 1 || nums[m] != nums[m + 1]){
                    ans[1] = m;
                    break;
                }
                l = m + 1;
            }
            else{
                r = m - 1;
            }    
        }
        return ans;
    }

}

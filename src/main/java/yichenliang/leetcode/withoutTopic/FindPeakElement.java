package yichenliang.leetcode.withoutTopic;

/**
 * 162. Find Peak Element
 * 
 * binary search + recursion
 * 
 * time complexity: O(logN)
 * space complexity: O(logN)
 */

public class FindPeakElement {
	
	public int findPeakElement(int[] nums) {
        
        if(nums.length == 1){
            return 0;
        }
        
        if(nums.length == 2){
            if(nums[0] > nums[1]){
                return 0;
            }
            else{
                return 1;
            }
        }
        
        // normal case
        return binaryRecursion(nums, 0, nums.length - 1);
    }
    
    int binaryRecursion(int[] nums, int left, int right){
        
        int mid = (left + right) / 2;
        
        if(mid == 0 && nums[mid] > nums[mid + 1]){
            return mid;
        }
        else if(mid == nums.length - 1 && nums[mid] > nums[mid - 1]){
            return mid;
        }
        else if(nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]){
            return mid;
        }
        
        int a = -1;
        if(mid == 0 && mid + 1 <= right){
            a = binaryRecursion(nums, mid + 1, right);
            if(a >= 0){
                return a;
            }
        }
        else if(mid == nums.length - 1 && left <= mid - 1){
            a = binaryRecursion(nums, left, mid - 1);
            if(a >= 0){
                return a;
            }
        }
        else{
            if(left <= mid - 1) {
            	a = binaryRecursion(nums, left, mid - 1);
                if(a >= 0){
                    return a;
                }
            }
            if(mid + 1 <= right) {
            	a = binaryRecursion(nums, mid + 1, right);
            }
            
        }
        return a;
    }
    
    // better coding!
    // recursion
    public int findPeakElement2(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    public int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }
    
    // better coding
    // iteration
    public int findPeakElement3(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}

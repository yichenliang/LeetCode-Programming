package yichenliang.leetcode.withoutTopic;

/**
 *  287. Find the Duplicate Number
 *  
 *  binary search
 *  
 *  time complexity: O(nlogn)
 *  space complexity: O(1)
 * 
 */

public class FindTheDuplicateNumber {
	
	public int findDuplicate(int[] nums) {
        
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        int mid = 0;
        
        while(low < high){
            mid = (low + high) / 2;
            int count = 0;
            for(int num : nums){
                if(num <= mid){
                    count++;
                }
            }
            
            if(count <= mid){
                low = mid + 1;
            }
            else{ // count > mid
                high = mid;
            }
        }
        return low;
    }
}

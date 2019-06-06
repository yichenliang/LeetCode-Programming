package yichenliang.leetcode.binarySearch;

/**
 *  410. Split Array Largest Sum
 *  
 *  Binary Search
 *  
 *  time complexity: O(logN)
 *  space complexity: O(1)
 * 
 */

public class SplitArrayLargestSum {
	
	public int splitArray(int[] nums, int m) {
        
        long low = 0;
        long high = 0;
        for(int num : nums){
            low = Math.max(low, num);
            high += num;
        }
        
        while(low < high){
            long mid = (low + high) / 2;
            int part = split(nums, mid);
            
            if(part > m){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return (int)low;
    }
    
    int split(int[] nums, long largestSum){
        long tempSum = 0;
        int part = 1;
        for(int num : nums){
            
            if(tempSum + num > largestSum){
                part++;
                tempSum = num;
            }
            else{
                tempSum += num;
            }
        }
        return part;
    }

}

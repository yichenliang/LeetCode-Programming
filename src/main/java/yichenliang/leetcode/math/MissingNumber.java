package yichenliang.leetcode.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *  268. Missing Number
 *   
 *  method : sort first 
 *  time complexity: O(nlogn)
 *  space complexity: O(1)
 *  
 *  method : hashSet 
 *  time complexity: O(n)
 *  space complexity: O(n)
 *  
 *  method : math
 *  time complexity: O(n)
 *  space complexity: O(1) 
 * 
 */

public class MissingNumber {
	
	public int missingNumber1(int[] nums) {
        
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(i != nums[i]){
                return i;
            }
        }
        return len;
    }
	
	public int missingNumber2(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums){
            set.add(num);
        }
        
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(i)){
                return i;
            }
        }
        
        return nums.length;
    }
	
	public int missingNumber3(int[] nums) {
        
        int len = nums.length;
        int sum = (0 + len) * (len + 1) / 2;
        for(int num : nums){
            sum = sum - num;
        }
        return sum;
    }

}

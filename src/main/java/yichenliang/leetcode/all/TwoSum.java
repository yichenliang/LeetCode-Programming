package yichenliang.leetcode.all;

import java.util.HashMap;

/**
 * 1. Two Sum
 * 
 * Hash Table
 * 
 * time complexity: O(n)
 * space complexity: O(n)
 */

public class TwoSum {
	
	public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            int rest = target - nums[i];
            if(map.containsKey(rest)){
                return new int[] {map.get(rest), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}

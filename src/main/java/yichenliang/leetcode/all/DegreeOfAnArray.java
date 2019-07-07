package yichenliang.leetcode.all;

import java.util.HashMap;

/**
 *  697. Degree of an Array
 *  
 *  HashMap
 *   
 *  time complexity: O(n)
 *  space complexity: O(n)
 * 
 */

public class DegreeOfAnArray {
	
	public int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        if(nums.length == 1){
            return 1;
        }
        
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        int max = 0;
        for(int i= 0; i < nums.length; i++){
            if(!left.containsKey(nums[i])){
                left.put(nums[i], i);
            }
            
            right.put(nums[i], i);
            int num = count.getOrDefault(nums[i], 0) + 1;
            max = Math.max(max, num);
            count.put(nums[i], num);
        }
        
        // int max = 0;
        // for(int num : count.keySet()){
        //     int fre = count.get(num);
        //     if(fre > max){
        //         max = fre;
        //     }
        // }
        
        int ans = Integer.MAX_VALUE;
        for(int num : count.keySet()){
            int fre = count.get(num);
            if(fre == max){
                int start = left.get(num);
                int end = right.get(num);
                ans = Math.min(ans, end - start + 1);
            }
        }
        return ans;
    }
}

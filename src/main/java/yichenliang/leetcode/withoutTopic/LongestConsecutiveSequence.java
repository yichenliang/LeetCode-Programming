package yichenliang.leetcode.withoutTopic;

import java.util.HashSet;
import java.util.Set;

/**
 *  128. Longest Consecutive Sequence
 *  
 *  HashSet
 *  
 *  time complexity: O(n)
 *  space complexity: O(n)
 *  
 *  all elements in nums array actually are visited twice
 *  
 */

public class LongestConsecutiveSequence {
	
	public int longestConsecutive(int[] nums) {
        
        Set<Integer> store = new HashSet<>();
        
        for(int num : nums){
            store.add(num);
        }
        
        int res = 0;
        // find
        for(int num : nums){
            int i = 1;
            if(!store.contains(num - 1)){
                
                while(store.contains(num + i)){
                    i++;
                }
            }
            res = Math.max(res, i);
        }
        
        return res;
    }

}

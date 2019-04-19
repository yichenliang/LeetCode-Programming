package yichenliang.leetcode.withoutTopic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  403. Frog Jump
 * 
 *  dynamic programming
 * 
 *  time complexity: O(n^2)
 *  space complexity: O(n)
 */

public class FrogJump {
	
	public boolean canCross(int[] stones) {
        
        if(stones == null ||stones.length == 0){
            return false;
        }
        
        //dynamic programming
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int len = stones.length;
        for(int i = 0; i < len; i++){
            map.put(stones[i], new HashSet<>());
        }
        
        map.get(0).add(0);
        
        for(int i = 0; i < len; i++){
            for(int lastStep : map.get(stones[i])){
                // k - 1, k, k + 1
                for(int step = lastStep - 1; step <= lastStep + 1; step++){
                    if(step > 0 && map.containsKey(step + stones[i])){
                        map.get(step + stones[i]).add(step);
                    }
                }
            }    
        }
        return map.get(stones[len - 1]).size() > 0;
    }
}

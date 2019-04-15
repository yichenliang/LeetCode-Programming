package yichenliang.leetcode.withoutTopic;

import java.util.ArrayList;
import java.util.List;

/**
 *  78. Subsets
 *  
 *  time complexity: O(n^2)
 *  space complexity: O(1)
 */

public class Subsets {
	
	public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return ans;
        }
        
        int len = nums.length;
        List<Integer> empty = new ArrayList<>();
        ans.add(empty);
        
        for(int i = 0; i < len; i++){
            int size = ans.size();
            for(int j = 0; j < size; j++){
                List<Integer> temp = new ArrayList<>(ans.get(j));
                temp.add(nums[i]);
                ans.add(temp);
            }
        }
        return ans;
    }

}

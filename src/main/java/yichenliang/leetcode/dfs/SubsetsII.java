package yichenliang.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *  90. Subsets II
 *  
 *  dfs + backtracking
 *  
 *  time complexity:
 *  space compleixty:
 */

public class SubsetsII {
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        res.add(new ArrayList<Integer>(current));
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        
        // normal case
        helper(nums, res, current, 0);
        return res;
    }
    
    void helper(int[] nums, List<List<Integer>> res, List<Integer> current, int index){
      
        HashSet<Integer> set = new HashSet<>();
        // normal case
        for(int i = index; i < nums.length; i++){
                if(!set.contains(nums[i])){
                    set.add(nums[i]);
                    current.add(nums[i]);
                    res.add(new ArrayList<Integer>(current));
                    helper(nums, res, current, i + 1);
                    current.remove(current.size() - 1); 
                }   
        }
    }

}

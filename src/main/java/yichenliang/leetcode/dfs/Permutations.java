package yichenliang.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  46. Permutations
 *  
 *  method : dfs + backtracking
 * 
 *  
 */

public class Permutations {
	
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){return res;}
        
        Set<Integer> set = new HashSet<>();
        List<Integer> currentRes = new ArrayList<>();
        permuteHelper(nums, set, res, currentRes);
        
        return res;
    }
    
    private void permuteHelper(int[] nums, Set<Integer> set, List<List<Integer>> res, List<Integer> currentRes){
        
        // end case
        if(currentRes.size() == nums.length){
            res.add(new ArrayList<>(currentRes));
            return;
        }
        
        // normal case
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                continue;
            }
               
            currentRes.add(nums[i]);
            //int last = currentRes.size() - 1;
            set.add(nums[i]);
            permuteHelper(nums, set, res, currentRes);
            set.remove(nums[i]);
            currentRes.remove(currentRes.size() - 1);
        }
    }
    
    public static void main(String[] args) {
    	Permutations solution = new Permutations();
    	int[] nums = {1, 2, 3};
    	List<List<Integer>> res = solution.permute(nums);
    }

}

package yichenliang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *  39. Combination Sum
 *  
 *  // DFS
 * 
 */

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(candidates == null || candidates.length == 0) return res;
        
        Arrays.sort(candidates);
        int index = 0;
        List<Integer> curRes = new ArrayList<>();
        dfsHelper(candidates, target, index, res, curRes);
        return res;
    }
    
    void dfsHelper(int[] candidates, int target, int index, List<List<Integer>>res, List<Integer> curRes){
        
        if(target == 0){
            res.add(new ArrayList<Integer>(curRes));
        }
        else if(target >= 0){
            for(int i = index; i < candidates.length; i++){
                if(candidates[i] > target) break;
                curRes.add(candidates[i]);
                dfsHelper(candidates, target - candidates[i], i, res, curRes);
                curRes.remove(curRes.size() - 1);
            }
        }
    }
}

package yichenliang.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 *  39. Combination Sum
 *  
 *  DFS + backtracking
 *  
 * 
 */

public class CombinationSum {
	
//	public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        
//        if(candidates == null || candidates.length == 0) return res;
//        
//        Arrays.sort(candidates);
//        int index = 0;
//        List<Integer> curRes = new ArrayList<>();
//        dfsHelper(candidates, target, index, res, curRes);
//        return res;
//    }
//    
//    private void dfsHelper(int[] candidates, int target, int index, List<List<Integer>>res, List<Integer> curRes){
//        
//        if(target == 0){
//            res.add(new ArrayList<Integer>(curRes));
//        }
//        else if(target >= 0){
//            for(int i = index; i < candidates.length; i++){
//                if(candidates[i] > target) break;
//                curRes.add(candidates[i]);
//                dfsHelper(candidates, target - candidates[i], i, res, curRes);
//                curRes.remove(curRes.size() - 1);
//            }
//        }
//    }
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new LinkedList<>();
        if(candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        List<Integer> curRes = new LinkedList<>();
        dfs(candidates, 0, target, res, curRes);
        return res;
    }
    
    private void dfs(int[] candidates, int idx, int target, List<List<Integer>> res, List<Integer> curRes){
        // end case 
        if(target == 0){
            List<Integer> cR = new LinkedList<>(curRes);
            res.add(cR);
            return;
        }
        
        int len = candidates.length;
        for(int i = 0; i + idx < len; i++){
            if(candidates[idx + i] <= target){
                curRes.add(candidates[idx + i]);
                dfs(candidates, idx + i, target - candidates[idx + i], res, curRes);
                curRes.remove(curRes.size() - 1);
            }  
        }    
    }
    
    public static void main(String[] args) {
    	CombinationSum solution = new CombinationSum();
    	int[] c = {2, 3, 6, 7};
    	int t = 7;
    	solution.combinationSum(c, t);
   
    }
}

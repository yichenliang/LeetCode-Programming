package yichenliang.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 *  78. Subsets
 *  
 *  dfs
 *  
 *  time complexity: O(n^2)
 *  space complexity: O(n)
 */

public class Subsets {
	
//	public List<List<Integer>> subsets(int[] nums) {
//        
//        List<List<Integer>> ans = new ArrayList<>();
//        if(nums == null || nums.length == 0){
//            return ans;
//        }
//        
//        int len = nums.length;
//        List<Integer> empty = new ArrayList<>();
//        ans.add(empty);
//        
//        for(int i = 0; i < len; i++){
//            int size = ans.size();
//            for(int j = 0; j < size; j++){
//                List<Integer> temp = new ArrayList<>(ans.get(j));
//                temp.add(nums[i]);
//                ans.add(temp);
//            }
//        }
//        return ans;
//    }
	
//	public List<List<Integer>> subsets1(int[] nums) {
//        
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> current = new ArrayList<>();
//        res.add(new ArrayList<Integer>(current));
//        if(nums == null || nums.length == 0){
//            return res;
//        }
//        
//        // normal case
//        helper(nums, res, current, 0);
//        return res;
//    }
//    
//    void helper(int[] nums, List<List<Integer>> res, List<Integer> current, int index){
//      
//        // normal case
//        for(int i = index; i < nums.length; i++){
//            current.add(nums[i]);
//            res.add(new ArrayList<Integer>(current));
//            helper(nums, res, current, i + 1);
//            current.remove(current.size() - 1);
//        }
//        
//    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        res = dfs(nums, 0);
        return res;
    }
    
    private List<List<Integer>> dfs(int[] nums, int idx){
        // end case
        if(idx == nums.length){
            List<Integer> curRes = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            res.add(curRes);
            return res;
        }
        
        // normal case
        List<List<Integer>> r = dfs(nums, idx + 1);
        int len = r.size();
        for(int i = 0; i < len; i++){
            List<Integer> cur = new ArrayList<>(r.get(i));
            cur.add(nums[idx]);
            r.add(cur);
        }
        return r;
    }

}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){return res;}
        
        Set<Integer> set = new HashSet<>();
        List<Integer> currentRes = new ArrayList<>();
        permuteHelper(nums, set, res, currentRes);
        
        return res;
    }
    
    void permuteHelper(int[] nums, Set<Integer> set, List<List<Integer>> res, List<Integer> currentRes){
        
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
            int last = currentRes.size() - 1;
            set.add(nums[i]);
            permuteHelper(nums, set, res, currentRes);
            set.remove(nums[i]);
            currentRes.remove(last);
        
        }
    }
}

// time complexity:  ...
// space complexity: O(N!) 
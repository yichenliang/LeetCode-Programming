class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null) return 1;
        
        Arrays.sort(nums);
        int res = 1;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0){
                continue;
            }
            else{
                if(nums[i] <= res){
                    res = nums[i] + 1;
                }
                else{
                    break;
                }
            }
        }
        return res;
        
    }
}

// time complexity: O(N)
// space complexity: O(1)
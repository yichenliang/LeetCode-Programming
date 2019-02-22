class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null ||nums.length == 0) return;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                int start = i;
                i++;
                while(i < nums.length && nums[i] == 0){
                    i++;
                }
                // swap
                if(i < nums.length){
                  nums[start] = nums[i];
                  nums[i] = 0;
                  i = start;  
                }
                
            }
        }
        return;
    }
}

// time complexity: O(N)
// space complexity: O(1)
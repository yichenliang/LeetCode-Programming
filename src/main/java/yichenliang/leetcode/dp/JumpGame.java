package yichenliang.leetcode.dp;

/**
 * 55. Jump Game
 * 
 * method 1 : dynamic programming
 * time complexity: O(n^2)
 * space complexity: O(n)
 * 
 * method 2 : greedy
 * time complexity: O(n)
 * space complexity: O(1)
 */

public class JumpGame {
	
    // dynamic programming 
	public boolean canJump1(int[] nums) {
        
        if(nums == null || nums.length == 0){
            return true;
        }
        
        //dp
        int len = nums.length;
        boolean[] res = new boolean[len];
        
        res[len - 1] = true;
        
        for(int i = len - 2; i >= 0; i--){
            int index = i;
            int steps = nums[i];
            if(steps == 0){
                res[i] = false;
                continue;
            }
            while(index < len){
                if(steps >= index - i && res[index] == true){
                    res[i] = true;
                    break;
                }
                index++;
            }
        }
        return res[0];
    }
	
	// greedy, much more faster!
	public boolean canJump2(int[] nums) {
		
		if(nums == null || nums.length == 0){
            return true;
        }
        
        int maxReach = 0;
        int len = nums.length;
        
        for(int i = 0; i < len && i <= maxReach; i++){
            maxReach = Math.max(maxReach, nums[i] + i);
            if(maxReach >= len - 1){
                return true;
            }
        }
        
        return false;	
	}

}

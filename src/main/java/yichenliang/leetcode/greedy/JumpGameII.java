package yichenliang.leetcode.greedy;

/**
 * 45. Jump Game II
 * 
 * method1 : DP
 * time complexity: O(n^2)
 * space complexity: O(1)
 * 
 * method2 : Greedy
 * time complexity: O(n)
 * space complexity: O(1)
 */

public class JumpGameII {
	
	// DP
	public int jump1(int[] nums) {
        int len = nums.length;
        nums[len - 1] = 0;
        for(int i = len - 2; i >= 0; i--){
            int num = nums[i];
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= num; j++){
                if(i + j < len){
                   if(nums[i + j] != Integer.MAX_VALUE){
                        min = Math.min(min, nums[i + j] + 1); 
                   } 
                }
                else{
                    break;
                }
            }
            nums[i] = min;
        }
        return nums[0];
    }
	
	// Greedy
	public int jump(int[] nums) {
        
        if(nums == null || nums.length <= 1){
            return 0;
        }
        
        int curMax = 0;
        int nextMax = 0;
        int step = 0;
        int index = 0;
        
        while(index <= curMax){
            while(index <= curMax){
                nextMax = Math.max(nextMax, index + nums[index]);
                index++;
            }
            curMax = nextMax;
            step++;
            if(curMax >= nums.length - 1){
                return step;
            }
        }
        
        return 0;
    }

}

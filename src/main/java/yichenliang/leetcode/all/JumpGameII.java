package yichenliang.leetcode.all;

public class JumpGameII {
	
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

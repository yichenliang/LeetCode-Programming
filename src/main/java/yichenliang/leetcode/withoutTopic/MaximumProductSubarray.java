package yichenliang.leetcode.withoutTopic;

/**
 * 152. Maximum Product Subarray
 * 
 * time complexity: O(n)
 * space complxity: O(1)
 */

public class MaximumProductSubarray {
	
	public int maxProduct(int[] nums) {
        
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int maxArrUntil = nums[0];
        int minArrUntil = nums[0];
        int ans = nums[0];
        int len = nums.length;
        for(int i = 1; i < len; i++){
            int nextMaxUntil = maxArrUntil * nums[i];
            int nextMinUntil = minArrUntil * nums[i];
            maxArrUntil = Math.max(nums[i], Math.max(nextMaxUntil, nextMinUntil));
            minArrUntil = Math.min(nums[i], Math.min(nextMaxUntil, nextMinUntil));
            ans = Math.max(ans, maxArrUntil);
            
        }
        return ans;
    }

}

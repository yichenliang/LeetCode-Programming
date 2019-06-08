package yichenliang.leetcode.dp;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 * 
 * Time complexity : O(n^2)
 * Space complexity : O(n)
 * 
 * dynamic programming, binary search
 */



public class LongestIncreasingSubsequence {
	
	// dynamic programming approach
	 public int lengthOfLIS(int[] nums) {
	        if (nums.length == 0) {
	            return 0;
	        }
	        int[] dp = new int[nums.length];
	        dp[0] = 1;
	        int maxans = 1;
	        for (int i = 1; i < dp.length; i++) {
	            int maxval = 0;
	            for (int j = 0; j < i; j++) {
	                if (nums[i] > nums[j]) {
	                    maxval = Math.max(maxval, dp[j]);
	                }
	            }
	            dp[i] = maxval + 1;
	            maxans = Math.max(maxans, dp[i]);
	        }
	        return maxans;
	    }
	 
	 public int lengthOfLIS2(int[] nums) {
		 if(nums == null || nums.length == 0) return 0;
	        
	        int n = nums.length;
	        int[] res = new int[n];
	        Arrays.fill(res, 1);
	        
	        for(int i = 1; i < n; i++){
	            for(int j = 0; j < i; j++){
	                if(nums[i] > nums[j]){
	                    res[i] = Math.max(res[i], res[j] + 1);
	                }
	            }
	        }
	        
	        int ans = 0;
	        for(int r : res){
	            ans = Math.max(ans, r);
	        }
	        return ans;
	 }
	
	// binary search approach: want to be done 
}

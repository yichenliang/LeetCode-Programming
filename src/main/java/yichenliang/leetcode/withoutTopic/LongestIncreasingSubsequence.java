package yichenliang.leetcode.withoutTopic;

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
	
	// binary search approach: want to be done 
}

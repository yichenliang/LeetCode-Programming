package yichenliang.leetcode.all;

/**
 * 338. Counting Bits
 * 
 * Math
 * 
 * time complexity: O(n)
 * space complexity: O(n)
 * 
 */

public class CountingBits {
	public int[] countBits(int num) {
	      int[] ans = new int[num + 1];
	      for (int i = 1; i <= num; ++i)
	        ans[i] = ans[i / 2] + (i % 2); 
	        // ans[i] = ans[i >> 1] + (i & 1); same meaning as above
	      return ans;
	  }
}

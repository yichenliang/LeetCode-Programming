package yichenliang.leetcode.dp;

/**
 *  96. Unique Binary Search Trees
 *  
 *  dynamic programming 
 *  
 *  time complexity: O(n^2)
 *  space complexity: O(n)
 *  
 *  2019/8/14
 * 
 */

public class UniqueBinarySearchTrees {	
	public int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i <= n; i++){
            int sum = 0;
            for(int j = 0; j <= i - 1; j++){
                sum += res[j] * res[i - 1 - j];
            }
            res[i] = sum;
        }
        return res[n];
    }
}

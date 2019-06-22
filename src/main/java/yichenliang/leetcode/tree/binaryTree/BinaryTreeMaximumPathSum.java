package yichenliang.leetcode.tree.binaryTree;

/**
 *  124. Binary Tree Maximum Path Sum
 * 
 *  Binary Tree
 * 
 *  time complexity: O(n)
 *  space complexity: O(logn)
 */

public class BinaryTreeMaximumPathSum {
	
	public int maxPathSum(TreeNode root) {
        
        if(root == null) return 0;
        
        int[] result = {Integer.MIN_VALUE};
        
        dfsHelper(root, result);     
        
        return result[0];
    }
    
    int dfsHelper(TreeNode root, int[] max){
        
       // end case
       if(root == null) return 0;
        
       // normal case
       int leftMax = Math.max(dfsHelper(root.left, max), 0);
       int rightMax = Math.max(dfsHelper(root.right, max), 0);
       int curVal = root.val + leftMax + rightMax;
       max[0] = Math.max(curVal, max[0]);
       return root.val + Math.max(leftMax, rightMax);
       
    }

}

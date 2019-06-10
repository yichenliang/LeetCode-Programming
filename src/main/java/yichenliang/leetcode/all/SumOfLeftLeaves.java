package yichenliang.leetcode.all;

/**
 * 404. Sum of Left Leaves
 * 
 * method: recursion
 * 
 * time complexity: O(n)
 * space complexity: O(height)
 */

public class SumOfLeftLeaves {
	   public int sumOfLeftLeaves(TreeNode root) {
	       int[] ans = {0};
	        helper(ans, root);
	        return ans[0];
	    }
	    
	    private void helper(int[] ans, TreeNode root){
	        if(root == null) return;
	        
	        if(root.left != null && (root.left.left == null && root.left.right == null)){
	            ans[0] += root.left.val;
	        }
	        
	        helper(ans, root.left);
	        helper(ans, root.right);
	    }
}

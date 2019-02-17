/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
	        if(root == null) return 0;
	        
	        int[] result = {Integer.MIN_VALUE};
	        dfs(root, result);
	        return result[0];
	        
	    }
	    
	 
	 int dfs(TreeNode root, int[] result){
	        
	     if(root == null) return 0;   
		 
		 int left = Math.max(dfs(root.left, result),0);
	     int right = Math.max(dfs(root.right, result),0);
	        
	     int current = root.val + left + right;
	     
	     result[0] = Math.max(result[0], current);
	     return root.val + Math.max(left, right);
	    }
}

// time complexity: O(N)  N is the number of node in this tree
// space complexity: O(height)  O(log(N))
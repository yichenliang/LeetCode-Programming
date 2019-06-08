package yichenliang.leetcode.tree.binaryTree;

/**
 * 543. Diameter of Binary Tree
 * 
 * DFS, recursion
 * 
 * time complexity: O(n)
 * space complexity: O(n)
 *
 */

public class DiameterOfBinaryTree {
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] ans = {0};   
        findLongest(root, ans);
        return ans[0]; 
    }
    
    int findLongest(TreeNode root, int[] ans){
        if(root == null){
            return -1;
        }
        
        int left = findLongest(root.left, ans) + 1;
        int right = findLongest(root.right, ans) + 1;
        int curDiameter = left + right;
        ans[0] = Math.max(curDiameter, ans[0]);
        return left >= right ? left : right;
        
    }

}

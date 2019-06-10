package yichenliang.leetcode.tree.binaryTree;

/**
 * 543. Diameter of Binary Tree
 * 
 * DFS, recursion
 * 
 * time complexity: O(n)
 * space complexity: O(height)
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
	
//	public int diameterOfBinaryTree(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//        int[] ans = {0};   
//        findLongest(root, ans);
//        return ans[0]; 
//    }
//    
//    int findLongest(TreeNode root, int[] ans){
//        if(root == null){
//            return -1;
//        }
//        
//        int left = findLongest(root.left, ans) + 1;
//        int right = findLongest(root.right, ans) + 1;
//        int curDiameter = left + right;
//        ans[0] = Math.max(curDiameter, ans[0]);
//        return left >= right ? left : right;
//        
//    }
	
	public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null) return 0;
        int[] max = {0};
        helper(root, max);
        return max[0];
    }
    
    private int helper(TreeNode root, int[] max){
        if(root == null) return 0;
        int leftMax = helper(root.left, max);
        int rightMax = helper(root.right, max);
        int currentMax = leftMax + rightMax;
        max[0] = Math.max(currentMax, max[0]);
        return Math.max(leftMax, rightMax) + 1;
    }

}

package yichenliang.leetcode.tree.binaryTree;

/**
 *  236. Lowest Common Ancestor of a Binary Tree
 *  
 *  Binary Tree + Recursion
 *  
 *  time complexity: O(n)
 *  space complexity: O(height) = O(logn)
 * 
 */

public class LowestCommonAncestorOfABinaryTree {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return null;
        
        if(root.val == p.val || root.val == q.val) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null) return root;
        if(right != null) return right;
        if(left != null) return left;
        return null;
        
    }
}

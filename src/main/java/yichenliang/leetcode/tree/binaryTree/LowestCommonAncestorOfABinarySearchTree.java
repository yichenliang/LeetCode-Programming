package yichenliang.leetcode.tree.binaryTree;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 *
 * Tree
 * 
 * method: Recursion
 * time complexity: O(N)
 * space complexity: O(N)
 * 
 * method: Iteration
 * time complexity: O(N)
 * space complexity: O(1)
 * 
 */

public class LowestCommonAncestorOfABinarySearchTree {
	
	// recursion
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root.val == p.val || root.val == q.val || (root.val - p.val)*(root.val - q.val) < 0) return root;
        
        if(q.val < root.val && p.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if(q.val > root.val && p.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return null;
    }
	
	// iteration
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        
        while(root != null){
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            }
            else if(root.val < p.val && root.val < q.val){
                root = root.right;
            }
            else{
                return root;
            }
        }
        return null;
    }

}

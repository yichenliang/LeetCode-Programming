package yichenliang.leetcode.all;

/**
 *  98. Validate Binary Search Tree
 *  
 *  Binary Tree
 *  
 *  time complexity: O(n)
 *  space complexity: O(logn)
 * 
 */

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
        return check(root, null, null);
    }
    
    private boolean check(TreeNode root, Integer left, Integer right){
        if(root == null) return true;
        if(left != null && left >= root.val) return false;
        if(right != null && right <= root.val) return false;
        return check(root.left, left, root.val) && check(root.right, root.val, right);
    }
}

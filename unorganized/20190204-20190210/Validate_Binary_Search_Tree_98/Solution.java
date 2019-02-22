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
    public boolean isValidBST(TreeNode root) {
        
        return isValidHelper(root, null, null);
    }
    
    public boolean isValidHelper(TreeNode root, Integer leftBound, Integer rightBound){
        if(root == null) return true;
        
        if(leftBound != null && leftBound >= root.val){
           return false;
        }
        
        if(rightBound != null && root.val >= rightBound){
            return false;
        }
        
     return isValidHelper(root.left, leftBound, root.val) && isValidHelper(root.right, root.val, rightBound);
        
    }
}

// time complexity: O(n)
// space complexity: O(height)
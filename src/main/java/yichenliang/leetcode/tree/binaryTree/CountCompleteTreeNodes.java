package yichenliang.leetcode.tree.binaryTree;

/**
 * 222. Count Complete Tree Nodes
 * 
 */

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
 

public class CountCompleteTreeNodes {
	
	public int countNodes(TreeNode root) {
        
        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);
        
        if(leftHeight == rightHeight){
            return (1 << leftHeight) - 1;
        }
        
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    int findLeftHeight(TreeNode root){
        
        if(root == null){
            return 0;
        } 
            
        return 1 + findLeftHeight(root.left);  
    }
    
    int findRightHeight(TreeNode root){
        if(root == null){
            return 0;
        }
            
        return 1 + findRightHeight(root.right);
    }

}

package yichenliang.leetcode.withoutTopic;

/**
 *  105. Construct Binary Tree from Preorder and Inorder Traversal
 *  
 *  method : DFS recursion
 *  
 *  time complexity: O(n)
 *  space complexity: O(1)
 *  
 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder == null || inorder == null || preorder.length == 0 ||inorder.length == 0){
            return null;
        }
        
        // dfs
        TreeNode ansRoot = dfs(preorder, inorder, 0, 0, inorder.length - 1);
        return ansRoot;   
    }
    
    TreeNode dfs(int[] preorder, int[] inorder, int preRoot, int start, int end){
        // end case
        if(start > end || preRoot >= preorder.length){
            return null;
        }
        
        // normal case
        TreeNode currentRoot = new TreeNode(preorder[preRoot]);
        int i = start;
        while(i <= end){
            if(inorder[i] == preorder[preRoot]){
                break;
            }
            i++;
        }
        
        currentRoot.left = dfs(preorder, inorder, preRoot + 1, start, i - 1);
        currentRoot.right = dfs(preorder, inorder, preRoot + (i - start + 1), i + 1, end);
        return currentRoot;
    }

}

package yichenliang.leetcode.tree.binaryTree;

import java.util.HashMap;

/**
 *  106. Construct Binary Tree from Inorder and Postorder Traversal
 * 
 *  Recursion
 *  
 *  time complexity: O(n)
 *  space complexity: O(n)
 */

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length){
            return null;
        }
        
        HashMap<Integer, Integer> store = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++){
            store.put(inorder[i], i);
        }
        
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, store);
    }
    
    TreeNode buildTreeHelper(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend, HashMap<Integer, Integer> store){
        if(istart > iend || pstart > pend){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[pend]);
        
        int index = store.get(postorder[pend]);
        
        root.left = buildTreeHelper(inorder, istart, index - 1, postorder, pstart, pstart + index - istart - 1, store);
        root.right = buildTreeHelper(inorder, index + 1, iend, postorder, pstart + index - istart, pend - 1, store);
        
        return root;    
    }

}

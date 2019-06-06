package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  94. Binary Tree Inorder Traversal
 * 
 *  Method 1: recursion
 *  time complexity: O(n)
 *  space complexity: O(height)
 *  
 *  Method 2: iteration
 *  time complexity: O(n)
 *  space complexity: O(height)
 */

public class BinaryTreeInorderTraversal {
	
	// method 1
	public List<Integer> inorderTraversal1(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        // if(root == null){
        //     return ans;
        // }
        
        // recursion 
        dfsHelper(root, ans);
        return ans;
    }
    
    void dfsHelper(TreeNode root, List<Integer> ans){
        if(root == null){
            return;
        }
        
        dfsHelper(root.left, ans);
        ans.add(root.val);
        dfsHelper(root.right, ans);
    }
    
    
    // method 2
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            ans.add(current.val);
            current = current.right;
        }
       return ans; 
    }
}

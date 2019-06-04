package yichenliang.leetcode.withoutTopic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  545. Boundary of Binary Tree
 *  
 *  time complexity: O(n)
 *  space complexity: O(N)
 */

public class BoundaryOfBinaryTree {
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        if(!isLeaf(root)){
            res.add(root.val);
        }
        
        TreeNode t = root.left;
        while(t != null){
            if(!isLeaf(t)){
                res.add(t.val);
            }
            
            if(t.left != null){
                t = t.left;
            }
            else{
                t = t.right;
            }
        }
        addAllLeaf(root, res);
        Stack<Integer> stack = new Stack<>();
        t = root.right;
        while(t != null){
            if(!isLeaf(t)){
                stack.push(t.val);
            }
            if(t.right != null){
                t = t.right;
            }
            else{
                t = t.left;
            }
        }
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
    
    private boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
    
    private void addAllLeaf(TreeNode root, List<Integer> res){
        if(isLeaf(root)){
            res.add(root.val);
        }
        else{
            if(root.left != null){
                addAllLeaf(root.left, res);
            }
            if(root.right != null){
                addAllLeaf(root.right, res);
            }
        }
    }

}

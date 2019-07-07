package yichenliang.leetcode.design;

import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator
 * 
 * next() : 
 * time complexity: O(logn) = O(height)
 * space complexity: O(height)
 * 
 * hasNext()
 * time complexity: O(1)
 * space complexity: O(1)
 *   
 */

public class BinarySearchTreeIterator {
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	class BSTIterator {
	    
	    Stack<TreeNode> stack;
	    public BSTIterator(TreeNode root) {
	        stack = new Stack<>();
	        TreeNode current = root;
	        while(current != null){
	            stack.push(current);
	            current = current.left;
	        }
	    }
	    
	    /** @return the next smallest number */
	    public int next() {
	        TreeNode node = stack.pop();
	        TreeNode current= node;
	        if(current.right != null){
	            current = current.right;
	            while(current != null){
	                stack.push(current);
	                if(current.left != null){
	                    current = current.left;
	                }
	                else{
	                    break;
	                }
	            }
	        }
	        return node.val;
	    }
	    
	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !stack.isEmpty();
	    }
	}

}

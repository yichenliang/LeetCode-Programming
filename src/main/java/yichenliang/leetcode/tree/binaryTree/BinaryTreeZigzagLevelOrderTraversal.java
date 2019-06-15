package yichenliang.leetcode.tree.binaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 *  103. Binary Tree Zigzag Level Order Traversal
 *  
 *  Binary Tree + BFS
 *  
 *  time complexity: O(n)
 *  space complexity: O(n)
 */

public class BinaryTreeZigzagLevelOrderTraversal {
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        boolean leftToRight = true;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()){
            int size = list.size();
            LinkedList<Integer> cres = new LinkedList<>();
            if(leftToRight){
                for(int i = 0; i < size; i++){
                   TreeNode cNode = list.remove();
                   cres.add(cNode.val);
                   if(cNode.left != null) list.add(cNode.left);
                   if(cNode.right != null) list.add(cNode.right);
                }        
            }
            else{
                for(int i = 0; i < size; i++){
                   TreeNode cNode = list.remove();
                   cres.addFirst(cNode.val);
                   if(cNode.left != null) list.add(cNode.left);
                   if(cNode.right != null) list.add(cNode.right);
                }    
            }
            leftToRight = !leftToRight;
            res.add(cres);
        
        }
        return res;
    }
}

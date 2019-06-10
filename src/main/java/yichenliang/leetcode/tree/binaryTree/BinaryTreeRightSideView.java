package yichenliang.leetcode.tree.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 * 
 * Binary Tree
 * 
 * method1: DFS
 * time complexity: O(n)
 * space complexity: O(logN)
 * 
 * method2: BFS
 * time complexity: O(n)
 * space complexity: O(n)
 */

public class BinaryTreeRightSideView {

	// method 1 : DFS
	public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if(root == null) return res;
        
        dfsHelper(res, root, 0);
        
        return res;
    }
    
    void dfsHelper(List<Integer> res, TreeNode root, int level){
        if(root == null){
            return;
        }
        if(level == res.size()){
            res.add(root.val);
        }
        
        // visit right first, left second
        dfsHelper(res, root.right, level + 1);
        dfsHelper(res, root.left, level + 1);
    }
    
    // method2 : BFS
    public List<Integer> rightSideView2(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode ptr = root;
        
        while(queue.size() > 0){
            int size = queue.size();
            res.add(queue.peek().val);
            for(int i = 0; i < size; i++){
                ptr = queue.poll();
                if(ptr.right != null){
                    queue.offer(ptr.right);
                }
            
                if(ptr.left != null){
                    queue.offer(ptr.left);
                }       
            }
           
        }
        return res;
    }
    
}

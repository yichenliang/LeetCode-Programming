package yichenliang.leetcode.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  572. Subtree of Another Tree
 *  
 *  Tree + BFS + recursion
 *  
 *  time complexity: O(n*logn)
 *  space complexity: O(logn)
 * 
 */

public class SubtreeOfAnotherTree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
        
        if(t == null && s == null) return true;
        if(t == null && s != null) return false;
        if(s == null) return true;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(s);
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                TreeNode cur = q.poll();
                if(cur.val == t.val){
                    if(dfs(cur, t)) return true;
                }
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
                size--;
            }
        }
        return false;
    }
    
    private boolean dfs(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s == null && t != null) return false;
        if(s != null && t == null) return false;
        
        if(s.val != t.val) return false;
        return s.val == t.val && dfs(s.left, t.left) && dfs(s.right, t.right);
    }
}

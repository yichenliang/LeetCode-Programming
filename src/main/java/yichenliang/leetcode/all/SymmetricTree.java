package yichenliang.leetcode.all;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  101. Symmetric Tree
 *  
 *  Method 1  my solution
 *  iteration
 *  time complexity: O(n)
 *  space complexity: O(n)
 * 
 *  Method 2
 *  iteration
 *  time complexity: O(n)
 *  space complexity: O(n)
 *  
 *  Method 3
 *  recursion
 *  time complexity: O(n)
 *  space complexity: O(n)
 */

public class SymmetricTree {
	
	public boolean isSymmetric1(TreeNode root) {
        
        if(root == null){
            return true;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
       
        
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            Deque<String> deque = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                if(current != null){
                    String str = Integer.toString(current.val);
                    deque.addLast(str);
                    queue.offer(current.left);
                    queue.offer(current.right);
                }
                else{
                    deque.addLast("*");
                }
            }
            if(!isSymmetric(deque)){
                return false;
            }
        }
        return true;
    }
    
    boolean isSymmetric(Deque<String> deque){
        
        while(!deque.isEmpty()){
            if(deque.size() == 1){
                break;
            }
            String first = deque.removeFirst();
            String last = deque.removeLast();
            if(!first.equals(last)){
                return false;
            }
        }
        return true;
    }
    
    
    // method 2 iteration
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
    
    
    // method 3 recursion
    public boolean isSymmetric3(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
    }
    

}

package yichenliang.leetcode.all;

import java.util.LinkedList;

/**
 *  449. Serialize and Deserialize BST
 *  
 *  method : BFS
 *  
 *  time complexity: O(n)
 *  space complexity: O(n)
 *  
 */


public class SerializeAndDeserializeBST {
	
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder ans = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        
        if(root == null){
            ans.append('*');
        }
        else{
            queue.offer(root);
        }
        
        // bfs
        while(queue.size() > 0){
            TreeNode current = queue.poll();
        
            if(current != null){
                ans.append(current.val);
                queue.offer(current.left);
                queue.offer(current.right);
            }
            else{
                ans.append('*');
            }
            ans.append(' ');
        }
        
        return ans.toString();   
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data.equals("*")){
            return null;
        }
        
        String[] node = data.split(" ");
        int len = node.length;
        LinkedList<TreeNode> queue = new LinkedList<>();
        int v = Integer.parseInt(node[0]);
        TreeNode root = new TreeNode(v);
        queue.offer(root);
        int i = 1;
        while(i < len){
            TreeNode current = queue.poll();
            if(current == null) continue;
            TreeNode l = null;
            if(!node[i].equals("*")){
                int val = Integer.parseInt(node[i]);
                l = new TreeNode(val);
            }
            i++;
            TreeNode r = null;
            if(!node[i].equals("*")){
                int val = Integer.parseInt(node[i]);
                 r = new TreeNode(val);
            }
            i++;
            current.left = l;
            current.right = r;
            queue.offer(l);
            queue.offer(r);
        }
        return root;
        
    }

}

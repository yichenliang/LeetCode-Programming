//226. Invert Binary Tree
//Approach #2 Iterative

import java.util.LinkedList;
import java.util.Queue;

class TreeNode 
//implements Comparable<TreeNode>{
{     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
//	@Override
//	public int compareTo(TreeNode o) {
//		return Integer.compare(this.val, o.val);
//	}
}
 
class Solution {
  
	public TreeNode invertTree(TreeNode root) {
		
		if(root == null) return null;  
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			
			if(currentNode.left != null) queue.add(currentNode.left);
			if(currentNode.right != null) queue.add(currentNode.right);
			
			TreeNode temp = currentNode.left;
			currentNode.left = currentNode.right;
			currentNode.right = temp;
		}
		return root;
	}
    
    public static void main(String[] args) {
    	
    	Solution solution = new Solution();
    	
    	TreeNode input = new TreeNode(4);
    	         input.left = new TreeNode(2);
                 input.right = new TreeNode(7);
                 input.left.left = new TreeNode(1);
                 input.left.right = new TreeNode(3);
                 input.right.left = new TreeNode(6);
                 input.right.right = new TreeNode(9);
       
       TreeNode res = solution.invertTree(input);
       
       System.out.println(res);
       
    }
}
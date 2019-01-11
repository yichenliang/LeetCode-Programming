//101. Symmetric Tree
// Approach Iterative

import java.util.Queue;
import java.util.LinkedList;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
      
      @Override
      public String toString() {
          return "TreeNode{" +
                  "val=" + val +
                  '}';
      }
  }




class Solution {
    
	public boolean isSymmetric(TreeNode root) {
		
		Queue<TreeNode> element = new LinkedList<>();
   
		if(root == null) return true;  //!!!!!!
		element.add(root.left);
		element.add(root.right);
		
		
//		element.add(root);   // from the solution in leetcode
//		element.add(root);
		
		while(!element.isEmpty()) {
			TreeNode t1 = element.poll();
			TreeNode t2 = element.poll();
			if(t1 == null && t2 == null) continue;
			if(t1 == null || t2 == null) return false;
			if(t1.val != t2.val) return false;
			element.add(t1.left);
			element.add(t2.right);
			element.add(t1.right);
			element.add(t2.left);
			}
	    return true;
	}
		
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	
    	TreeNode treeA = new TreeNode(1);
    	treeA.left = new TreeNode(2);
    	treeA.right = new TreeNode(2);
    	treeA.left.left = new TreeNode(3);
    	treeA.left.right = new TreeNode(4);
    	treeA.right.left = new TreeNode(4);
    	treeA.right.right = new TreeNode(3);
    	treeA.left.left.left = new TreeNode(5);
    	treeA.left.left.right = new TreeNode(6);
    	treeA.left.right.left = new TreeNode(7);
    	treeA.left.right.right = new TreeNode(8);
    	treeA.right.left.left = new TreeNode(8);
    	treeA.right.left.right = new TreeNode(7);
    	treeA.right.right.left = new TreeNode(6);
    	treeA.right.right.right = new TreeNode(5);
//    	TreeNode treeB = new TreeNode(1);
//    	treeB.left = new TreeNode(2);
//    	treeB.right = new TreeNode(2);
//    	treeA.left.right = new TreeNode(3);
//    	treeB.right.right = new TreeNode(3);
    	
    	boolean res = solution.isSymmetric(treeA);
    	//boolean res = solution.isSymmetric(treeB);
    	
    	System.out.println(res);
    }
    
}
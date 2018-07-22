//101. Symmetric Tree
// Approach Recursive

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
		
		return isMirror(root, root);
	}
		
	public boolean isMirror(TreeNode t1, TreeNode t2) {
		
		if(t1 == null && t2 == null) return true;
		if(t1 == null || t2 == null) return false;
		
		return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left); 
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
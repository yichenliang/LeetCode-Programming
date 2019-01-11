//617. Merge Two Binary Trees
// Approach #1 Using Recursion
 
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
    
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    	
    	//TreeNode result;
    	//TreeNode ptr1;
    	//TreeNode ptr2;
    	
    	//ptr1 = t1;
    	//ptr2 = t2;
    	if(t1 == null) return t2;
    	if(t2 == null) return t1;
    	
    	t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        
        return t1;
     }
    
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	
    	TreeNode treeA = new TreeNode(1);
    	treeA.left = new TreeNode(3);
    	treeA.right = new TreeNode(2);
    	treeA.left.left = new TreeNode(5);
    	
    	TreeNode treeB = new TreeNode(2);
    	treeB.left = new TreeNode(1);
    	treeB.right = new TreeNode(3);
    	treeA.left.right = new TreeNode(4);
    	treeB.right.right = new TreeNode(7);
    	
    	TreeNode res = solution.mergeTrees(treeA, treeB);
    	
    	System.out.println(res);
    }
    
}
//226. Invert Binary Tree
//Approach #1 (Recursive)
 
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
class Solution {
  
	public TreeNode invertTree(TreeNode root) {
		
		if(root == null) return root;
		  
		  TreeNode left = invertTree(root.left);
	      TreeNode right = invertTree(root.right);
	      
	      root.left = right;
	      root.right = left;
	      
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
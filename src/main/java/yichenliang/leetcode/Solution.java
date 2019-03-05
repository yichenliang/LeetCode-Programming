package yichenliang.leetcode;

 class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
  }

public class Solution {
	
	public int maxPathSum(TreeNode root) {
        
        if(root == null) return 0;
        
        Integer result = Integer.MIN_VALUE;
        
        dfsHelper(root, result);     
        
        return result;
    }
    
    int dfsHelper(TreeNode root, Integer max){
        
       // end case
       if(root == null) return 0;
        
       // normal case
       int leftMax = dfsHelper(root.left, max);
       int rightMax = dfsHelper(root.right, max);
       int curVal = root.val + leftMax + rightMax;
       max = Math.max(curVal, max);
       return root.val + Math.max(leftMax, rightMax);
       
    }
    
    public static void main(String[] args) {
      	 
       	Solution solution = new Solution();
  
//       	TreeNode root = new TreeNode(-10);
//       	root.left = new TreeNode(9);
//       	root.right = new TreeNode(20);
//       	root.right.left = new TreeNode(15);
//       	root.right.right = new TreeNode(7);
       	
   	TreeNode root = new TreeNode(1);
   	root.left = new TreeNode(2);
   	root.right = new TreeNode(3);
        int res = solution.maxPathSum(root);
       	System.out.println(res);
      }
    
    

}

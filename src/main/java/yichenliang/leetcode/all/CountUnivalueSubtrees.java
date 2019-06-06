package yichenliang.leetcode.all;

/**
 * 250. Count Univalue Subtrees
 * 
 * method: DFS
 * 
 * time complexity:  O(n)
 * space complexity: O(height)
 */

public class CountUnivalueSubtrees {
	
	public int countUnivalSubtrees(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        
        int[] ans = {0};
        dfs(root, ans);
        return ans[0];
    }
    
    boolean dfs(TreeNode root, int[] ans){
        if(root == null){
            return true;
        }
        
        boolean leftSub = dfs(root.left, ans);
        boolean rightSub = dfs(root.right, ans);
        if(leftSub != true || rightSub != true){
            return false;
        }
        else{
            if(root.left != null && root.val != root.left.val){
                return false;
            }
            if(root.right != null && root.val != root.right.val){
                return false;
            }
        }
        ans[0]++;
        return true;
    }

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        boolean leftToRight = true;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()){
            int size = list.size();
            LinkedList<Integer> cres = new LinkedList<>();
            if(leftToRight){
                for(int i = 0; i < size; i++){
                   TreeNode cNode = list.remove();
                   cres.add(cNode.val);
                   if(cNode.left != null) list.add(cNode.left);
                   if(cNode.right != null) list.add(cNode.right);
                }        
            }
            else{
                for(int i = 0; i < size; i++){
                   TreeNode cNode = list.remove();
                   cres.addFirst(cNode.val);
                   if(cNode.left != null) list.add(cNode.left);
                   if(cNode.right != null) list.add(cNode.right);
                }    
            }
            leftToRight = !leftToRight;
            res.add(cres);
        
        }
        return res;
    }
}

// time complexity: O(N)
// space complexity: O(N)
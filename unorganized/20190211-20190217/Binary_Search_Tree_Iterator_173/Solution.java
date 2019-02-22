/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode current = root;
        while(current != null){
            stack.push(current);
            if(current != null){
               current = current.left;
            }
            else{
               break; 
            }
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode current= node;
        if(current.right != null){
            current = current.right;
            while(current != null){
                stack.push(current);
                if(current.left != null){
                    current = current.left;
                }
                else{
                    break;
                }
            }
        }
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
 
 
 // space complexity: O(h)
 
 // time complexity: hasNext: O(1)
                     next: O(h) 
package yichenliang.leetcode.all;

/**
 * 116. Populating Next Right Pointers in Each Node
 * 
 *  Tree
 *  
 *  method1: iteration
 *  time complexity: O(n)
 *  space complexity: O(1)
 *  
 *  method2: recursion
 *  time complexity: O(n)
 *  space complexity: O(n)
 * 
 */

public class PopulatingNextRightPointersInEachNode {
	
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}

	    public Node(int _val,Node _left,Node _right,Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	}
	
	public Node connect1(Node root) {
        if(root == null) return null;
        
        Node level = root;
        while(level != null){
            Node cur = level;
            while(cur != null){
                if(cur.left != null)cur.left.next = cur.right;
                if(cur.right != null && cur.next != null)cur.right.next = cur.next.left;
                cur = cur.next;
            }
            level = level.left;
        }
        return root;
    }
	
	// recursion
	public Node connect(Node root) {
        if(root == null) return null;
        
        if(root.left != null)root.left.next = root.right;
        if(root.right != null && root.next != null) root.right.next = root.next.left;
        
        connect(root.left);
        connect(root.right);
        return root;
    }

}

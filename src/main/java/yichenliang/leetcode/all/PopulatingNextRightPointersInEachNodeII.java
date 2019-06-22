package yichenliang.leetcode.all;

/**
 * 117. Populating Next Right Pointers in Each Node II
 * 
 * Binary Tree + iteration
 * 
 * time complexity: O(n)
 * space complexity: O(1)
 * 
 */

public class PopulatingNextRightPointersInEachNodeII {
	
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
	
	public Node connect(Node root) {
        Node p = root;
        Node dummy = new Node(-1, null, null, null); // alway point to the head of each level
        Node pre = dummy;
        
        while(p != null){
            if(p.left != null){
                pre.next = p.left;
                pre = pre.next;
            }
            if(p.right != null){
                pre.next = p.right;
                pre = pre.next;
            }
            p = p.next;
            if(p == null){  // reach the end of a level
                p = dummy.next;
                pre = dummy;
                dummy.next = null;
            }
        }
        return root;
    }

}

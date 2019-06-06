package yichenliang.leetcode.all;

import java.util.LinkedList;

/**
 * 426. Convert Binary Search Tree to Sorted Doubly Linked List
 * 
 * method: queue, DFS
 * 
 * time complexity: O(n)
 * space complexity: O(n)
 */

 

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
	
	public Node treeToDoublyList(Node root) {
        
        if(root == null){
            return root;
        }
        
        // put all elements in queue
        LinkedList<Node> queue = new LinkedList<>();
        dfs(queue, root);
    
        // build link between two nodes
        if(queue.size() == 1){
            Node  head = queue.poll();
            head.left = head;
            head.right = head;
            return head;
        }
        else if(queue.size() == 2){
            Node head = queue.poll();
            head.left = queue.peek();
            head.right = queue.peek();
            Node tail = queue.poll();
            tail.left = head;
            tail.right = head;
            return head;
        }
        
        // queue.size() >= 3
        Node head = queue.poll();
        Node current = head;
        while(queue.size() > 0){
            current.right = queue.peek();
            queue.peek().left = current;
            current = queue.poll();
        }
        
        current.right = head;
        head.left = current;
        return head;
    }
    
    void dfs(LinkedList<Node> q, Node root){
        
        if(root == null){
           return;
        }
        
        if(root.left != null){
            dfs(q, root.left);
        }
        
        q.add(root);
        
        if(root.right != null){
            dfs(q, root.right);
        }   
    }
    
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}

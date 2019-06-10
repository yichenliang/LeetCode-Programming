package yichenliang.leetcode.all;

/**
 * 708. Insert into a Cyclic Sorted List
 * 
 * LinkedList 
 * 
 * time complexity: O(n)
 * space complexity: O(1)
 * 
 */

public class InsertIntoACyclicSortedList {
	
	class Node {
	    int val;
	    Node next;

	    Node() {}

	    Node(int _val) {
	        val = _val;
	        //next = _next;
	    }
	};
	
public Node insert(Node head, int insertVal) {
	
        if(head == null){
            Node h = new Node(insertVal);
            h.next = h;
            return h;
        }
        
        Node prev = head;
        Node current = head.next;
        boolean find = false;
        
        while(current != head){
            int next = current.val;
            int pre = prev.val;
            if(pre == insertVal || (pre < insertVal && insertVal < next) || (pre > next && insertVal > pre) || (pre > next && insertVal < next)){
                find = true;
                Node newNode = new Node(insertVal);
                prev.next = newNode;
                newNode.next = current;
                break;
            }
            prev = prev.next;
            current = current.next;
        }
        if(!find){
            Node node = new Node(insertVal);
            prev.next = node;
            node.next = current;
        }
        return head;
    }

}

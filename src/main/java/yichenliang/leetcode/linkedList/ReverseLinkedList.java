package yichenliang.leetcode.linkedList;

/**
 * 206. Reverse Linked List
 * 
 * Linked List
 * 
 * iteration
 * time complexity: O(n)
 * space complexity: O(1)
 * 
 * recursion
 * time complexity: O(n)
 * space complexity: O(n)
 * 
 */

public class ReverseLinkedList {
	
	
	// iteration
	 public ListNode reverseList(ListNode head) {
	        
	        if(head == null){
	            return null;
	        }
	        
	        ListNode current = head;
	        ListNode pre = null;
	        ListNode after = current.next;
	        
	        while(current != null){
	            after = current.next;
	            current.next = pre;
	            pre = current;
	            current = after;
	            
	        }
	        return pre;
	 }
	
	 // recursion
	 public ListNode reverseList1(ListNode head) {
	        return reverseListInt(head, null);
	    }

	 private ListNode reverseListInt(ListNode head, ListNode newHead) {
	        if(head == null) return newHead;
	        ListNode next = head.next;
	        head.next = newHead;
	        return reverseListInt(next, head);
	 }

}

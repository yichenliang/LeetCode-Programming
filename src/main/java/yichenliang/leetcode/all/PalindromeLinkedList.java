package yichenliang.leetcode.all;

/**
 *  234. Palindrome Linked List
 *  
 *  linked list + two pointers
 *  
 *  time complexity: O(n)
 *  space complexity: O(1)
 * 
 */

public class PalindromeLinkedList {
	
    class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
    }
	
	public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null){
            return true;
        }
        
        if(head.next.next == null){
            if(head.val == head.next.val){
                return true;
            }
            return false;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode prev = slow;
        ListNode current = prev.next;
        ListNode next = current.next;
        
        while(next != null){
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }
        current.next = prev;
        
        ListNode p = head;
        while(p != slow){
            if(p.val != current.val){
                return false;
            }
            p = p.next;
            current = current.next;
        }
        return true;
    }
}

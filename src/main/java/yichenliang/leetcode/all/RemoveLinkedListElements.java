package yichenliang.leetcode.all;

/**
 *  203. Remove Linked List Elements
 *   
 *  time complexity: O(n)
 *  space complexity: O(1)
 * 
 */

public class RemoveLinkedListElements {
	
	public ListNode removeElements(ListNode head, int val) {
        
        if(head == null){
            return null;
        }
        if(head.val == val && head.next == null){
            return null;
        }
        if(head.val != val && head.next == null){
            return head;
        }
        
        // normal case
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        ListNode next = null;
        
        while(current != null){
            next = current.next;
            if(current.val == val){
                prev.next = next;
                current = next;
            }
            else{
                prev = current;
                current = next;
            }
        }
        return dummy.next;
    }

}

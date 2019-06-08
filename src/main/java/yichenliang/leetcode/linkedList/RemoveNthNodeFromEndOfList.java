package yichenliang.leetcode.linkedList;

/**
 * 19. Remove Nth Node From End of List
 * 
 * two pointers
 * 
 * time complexity: O(n)
 * space complexity: O(1)
 * 
 */

public class RemoveNthNodeFromEndOfList {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(n == 1 && head.next == null){
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        //ListNode ptr1 = head;
        ListNode ptr2 = head;
        for(int i = 0; i < n; i++){
            ptr2 = ptr2.next;
        }
        
        while(ptr2 != null){
            pre = pre.next;
            head = head.next;
            ptr2 = ptr2.next;
        }
        
        pre.next = head.next;
        return dummy.next;
    }

}

package yichenliang.leetcode.linkedList;

/**
 *  24. Swap Nodes in Pairs
 * 
 *  Linked List
 * 
 *  time complexity: O(n)
 *  space complexity: O(1)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode ptr1 = prev.next;
        ListNode ptr2 = ptr1.next;
        ListNode next = null;
        
        while(ptr1 != null && ptr2 != null){
            next = ptr2.next;
            prev.next = ptr2;
            ptr1.next = ptr2.next;
            ptr2.next = ptr1;
            
            prev = ptr1;
            ptr1 = next;
            if(ptr1 != null){
              ptr2 = ptr1.next;  
            }
            else{
               ptr2 = null; 
            }   
        }
        return dummy.next;
    }

}

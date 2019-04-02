package yichenliang.leetcode.withoutTopic;

/**
 * 143. Reorder List
 * 
 *  Linked List
 *  
 *  time complexity: O(n)
 *  space complexity: O(1)
 */


 
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 

public class ReorderList {
	public void reorderList(ListNode head) {
        
        if(head == null) return;
        
        ListNode mid = findMid(head);
        
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverse(l2);
        
        ListNode l1 = head;
        
        while(l1 != null && l2 != null){
            ListNode next = l1.next;
            l1.next = l2;
            l2 = l2.next;
            l1.next.next =next;
            l1 = next;   
        }
    }
    
    ListNode findMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    ListNode reverse(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}

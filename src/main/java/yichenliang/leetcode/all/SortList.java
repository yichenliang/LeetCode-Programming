package yichenliang.leetcode.all;

/**
 *  148. Sort List
 *  
 *  LinkedList + Merge Sort
 *   
 *  The space complexity of this solution 
 *  does not satisfy the requirement of problem 
 *  time complexity: O(nlogn)
 *  space complexity: O(nlogn)
 *  
 *  2019/8/5
 */

public class SortList {
	
	class ListNode {
		    int val;
		    ListNode next;
		    ListNode(int x) { val = x; }
	}
	
	public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        ListNode slow = head, fast = head;
        ListNode prev = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        ListNode result = merge(l1, l2);
        return result;
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while(l1 != null && l2 != null){
           if(l1.val < l2.val){
               cur.next = l1;
               l1 = l1.next;
           }
           else{
               cur.next = l2;
               l2 = l2.next;
           }
            cur = cur.next;
        }
        
        if(l1 == null){
            cur.next = l2;
        }
        else{
            cur.next = l1;
        }
        return dummy.next;
    }

}

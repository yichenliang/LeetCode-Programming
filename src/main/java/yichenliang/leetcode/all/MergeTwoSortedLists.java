package yichenliang.leetcode.all;

/**
 *  21. Merge Two Sorted Lists
 *  
 *  Linked List + Recursion / Iteration
 *  
 *  time complexity: O(n)
 *  space complexity: O(1)
 */

public class MergeTwoSortedLists {
	
	// recursion
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        
        if(l2 == null){
            return l1;
        }
        
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }
	
	// iteration
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        
        
        while(l1 != null && l2 !=null){
           if(l1.val <= l2.val){
              prev.next = l1;
              l1 = l1.next;
           }
           else{
              prev.next = l2;
              l2 = l2.next; 
           }
           prev = prev.next;
        }
        prev.next = l1 == null? l2: l1;
        return prehead.next;
   }

}

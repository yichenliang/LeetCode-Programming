package yichenliang.leetcode.all;

/**
 *  23. Merge k Sorted Lists
 *  
 *  link list + recursion
 *  
 *  time complexity: O(n)
 *  space complexity: O(n)
 * 
 */

public class MergeKSortedLists {
	
	class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists == null || lists.length == 0){
            return null;
        }
        
        return partition(lists, 0, lists.length - 1);
    }
    
    private ListNode partition(ListNode[] lists, int l, int r){
        // end case
        if(l == r){
            return lists[l];
        }
        
        // normal case
        if(l < r){
            int m = (l + r) / 2;
            ListNode l1 = partition(lists, l, m);
            ListNode l2 = partition(lists, m + 1, r);
            return merge(l1, l2);
        }
        return null;
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        
        if(l1 == null){
            return l2;
        }
        
        if(l2 == null){
            return l1;
        }
        
        if(l1.val < l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }
        else{
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }  
}

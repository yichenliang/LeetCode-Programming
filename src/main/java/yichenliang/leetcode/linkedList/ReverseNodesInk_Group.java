package yichenliang.leetcode.linkedList;

/**
 * 25. Reverse Nodes in k-Group
 * 
 * linked list
 * 
 * time complexity: O(n) 
 * space complexity: O(1)
 * 
 */

public class ReverseNodesInk_Group {
	
	public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(prev != null){
            prev = reverse(prev, k);
        }
        return dummy.next;     
    }
    
    public ListNode reverse(ListNode prev, int k){
        ListNode last = prev;
        for(int i = 0; i < k; i++){
            last = last.next;
            if(i != k && last == null){
                // remain some nodes shorter than K to reverse
                return null;
            }
        }
        
        ListNode curr = prev.next;
        ListNode tail = curr;
        while(curr != last){
            prev.next = curr.next;
            curr.next = last.next;
            last.next = curr;
            curr = prev.next;
        }
        return tail;
    }
}

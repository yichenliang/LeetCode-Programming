/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
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
        for(int i = 0; i < k + 1; i++){
            last = last.next;
            if(i != k && last == null){
                // remain some nodes shorter than K to reverse
                return null;
            }
        }
        ListNode tail = prev.next;
        ListNode curr = prev.next.next;
        while(curr != last){
            ListNode next = curr.next;
            
			curr.next = prev.next;
            tail.next = next;
			prev.next = curr;
            
            curr = next;
        }
        return tail;
    }
}

// time complexity: O(N)
// space complexity: O(1)
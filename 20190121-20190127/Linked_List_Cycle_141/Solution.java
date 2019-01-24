/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// two pointers: fast and run

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(slow != fast){
            if(fast.next == null || fast.next.next == null){
                return false;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
    }
}

// time complexity:  O(N)
// space complexity: O(1);
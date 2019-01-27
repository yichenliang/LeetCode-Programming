/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head == null){
            return null;
        }
        
        ListNode current = head;
        ListNode pre = null;
        ListNode after = current.next;
        
        while(current != null){
            after = current.next;
            current.next = pre;
            pre = current;
            current = after;
            
        }
        return pre;
    }
}

//time complexity: O(n);
//space complexity: O(1);
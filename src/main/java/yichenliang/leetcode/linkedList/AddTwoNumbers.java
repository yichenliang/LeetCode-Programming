package yichenliang.leetcode.linkedList;

/**
 * 2. Add Two Numbers
 * 
 *  Linked List
 *  
 *  time complexity: O(n)
 *  space complexity: O(1)
 * 
 */

public class AddTwoNumbers {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode current = dummy;
        int carry = 0;
        while(p1 != null && p2 != null){
            int sum = p1.val + p2.val + carry;
            ListNode node = new ListNode(sum  % 10);
            carry = sum / 10;
            current.next = node;
            current = current.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        
        if(p1 == null && p2 != null){
            while(carry != 0 && p2 != null){
                int sum = p2.val + carry;
                ListNode node = new ListNode(sum % 10);
                carry = sum / 10;
                current.next = node;
                current = current.next;
                p2 = p2.next;
            }
            current.next = p2;
        }
        else if(p2 == null && p1 != null){
            while(carry != 0 && p1 != null){
                int sum = p1.val + carry;
                ListNode node = new ListNode(sum % 10);
                carry = sum / 10;
                current.next = node;
                current = current.next;
                p1 = p1.next;
            }
            current.next = p1;
        }
    
            
        if(carry != 0){
               ListNode node = new ListNode(carry); 
                current.next = node;
        }
        
        return dummy.next;
    }
}

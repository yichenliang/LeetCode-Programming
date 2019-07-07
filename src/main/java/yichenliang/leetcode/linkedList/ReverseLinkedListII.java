package yichenliang.leetcode.linkedList;

/**
 *  92. Reverse Linked List II
 *  
 *  time complexity: O(n)
 *  space complexity: O(1)
 * 
 */

public class ReverseLinkedListII {
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
        
        if(head == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // find m node pre
        ListNode preM = dummy;
        ListNode mNode = head;
        ListNode nNode = head;
        
        // find m node 
        for(int i = 1; i < m; i++){
            preM = preM.next;
            mNode = mNode.next;
        }
        
        // find n node
        for(int i = 1; i< n; i++){
            nNode = nNode.next;
        }
        
        while(mNode != nNode){
             preM.next = mNode.next;
             mNode.next = nNode.next;
             nNode.next = mNode;
             mNode = preM.next;     
        }
        
        return dummy.next;     
    }

}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


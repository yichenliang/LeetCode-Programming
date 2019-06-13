package yichenliang.leetcode.linkedList;

/**
 * 138. Copy List with Random Pointer
 *
 *  Link List
 * 
 * time complexity: O(n)
 * space complexity: O(1)
 * 
 */

public class CopyListWithRandomPointer {
	
	class RandomListNode {
	    int label;
	    RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
	}
	
	public RandomListNode copyRandomList(RandomListNode head) {
        
		if (head == null) {
            return null;
        }
		
		// create a new linked list, and interweave it with the old linked list
		RandomListNode ptr = head;
		while(ptr != null){
			RandomListNode newNode = new RandomListNode(ptr.label);
			newNode.next = ptr.next;
			ptr.next = newNode;
			ptr = newNode.next;
		}
		
		ptr = head;
		
		// add the random point to the interweaving linked list
		while(ptr != null){
			ptr.next.random = ptr.random != null ? ptr.random.next : null;
			ptr = ptr.next.next;
		}
		
		// Unweave the linked list to get back the original linked list and the new cloned list.
		ptr = head;
		RandomListNode ptr_new = head.next;
		RandomListNode head_new = head.next;
		while(ptr != null){
			ptr.next = ptr_new.next;
			ptr_new.next = ptr.next != null ? ptr.next.next : null;
			ptr = ptr.next;
			ptr_new = ptr_new.next;
			
		}
			
		return head_new;	
    }
	
}

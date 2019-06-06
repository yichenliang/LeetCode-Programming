package yichenliang.leetcode.all;

/**
 *  160. Intersection of Two Linked Lists
 *  
 *  time complexity: O(n)
 *  space complexity: O(1)
 */

public class IntersectionOfTwoLinkedLists {
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lenA = 0;
        int lenB = 0;
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        
        while(ptr1 != null){
            ptr1 = ptr1.next;
            lenA++;
        }
        
        while(ptr2 != null){
            ptr2 = ptr2.next;
            lenB++;
        }
        
        ListNode p1 = headA;
        ListNode p2 = headB;
        if(lenA > lenB){
            int diff = lenA - lenB;
            for(int i = 0; i < diff; i++){
                p1 = p1.next;
            }
        }
        else if(lenA < lenB){
            int diff = lenB - lenA;
            for(int i = 0; i < diff; i++){
                p2 = p2.next;
            }
        }
        
        while(p1 != null){
            if(p1 != p2){
                p1 = p1.next;
                p2 = p2.next;
            }
            else{
                return p1;
            }
        }
        return null;
    }

}

package yichenliang.leetcode.all;

import java.util.Stack;

/**
 *  445. Add Two Numbers II
 * 
 *  Math, Linked List, stack
 * 
 *  time complexity: O(n)
 *  space complexity: O(n)
 */

public class AddTwoNumbersII {
	
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        long num1 = deriveNumber(l1);
        long num2 = deriveNumber(l2);
        long ans = num1 + num2;
        ListNode res = formList(ans);
        
        return res;
    }
    
    long deriveNumber(ListNode head){
        long res = 0;
        ListNode ptr = head;
        while(ptr != null){
           res = res * 10 + ptr.val;
            ptr = ptr.next;
        }
        return res;
    }
    
    ListNode formList(long ans){
        ListNode head = null;
        
        if(ans == 0){
            ListNode newNode = new ListNode(0);
            newNode.next = head;
            head = newNode;
        }
        
        while(ans != 0){
            long num = ans % 10;
            ListNode newNode = new ListNode((int)num);
            newNode.next = head;
            head = newNode;
            ans = ans / 10;
        }
        return head;
    }
    
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        
        if(l1 == null){
            return l2;
        }
        
        if(l2 == null){
            return l1;
        }
        
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        ListNode ptr = l1;
        while(ptr != null){
            s1.push(ptr.val);
            ptr = ptr.next;
        }
        
        ptr = l2;
        while(ptr != null){
            s2.push(ptr.val);
            ptr = ptr.next;
        }
        
        // calculate sum
        ListNode head = null;
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            int sum = 0;
            if(!s1.isEmpty() && !s2.isEmpty()){
                sum = s1.pop() + s2.pop() + carry;
                ListNode node = new ListNode(sum % 10);
                node.next = head;
                head = node;
                carry = sum / 10;
            }
            else if(!s1.isEmpty() && s2.isEmpty()){
                sum = s1.pop() + carry;
                ListNode node = new ListNode(sum % 10);
                node.next = head;
                head = node;
                carry = sum / 10;
            }
            else if(s1.isEmpty() && !s2.isEmpty()){
                sum = s2.pop() + carry;
                ListNode node = new ListNode(sum % 10);
                node.next = head;
                head = node;
                carry = sum / 10;
                
            }
            
        }
        
        if(carry != 0){
            ListNode node = new ListNode(carry);
            node.next = head;
            head = node;
        }
        
        return head;
    }

}

package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.all.AddTwoNumbersII;
import yichenliang.leetcode.all.ListNode;

public class AddTwoNumbersIITest {
	
	private AddTwoNumbersII solution;

    @BeforeEach
    void beforeEach() {
        solution = new AddTwoNumbersII();
    }

    @Test
    void test1() {
    	ListNode l1 = new ListNode(3);
    	l1.next = new ListNode(9);
    	l1.next.next = new ListNode(9);
    	l1.next.next.next = new ListNode(9);
    	l1.next.next.next.next = new ListNode(9);
    	l1.next.next.next.next.next = new ListNode(9);
    	l1.next.next.next.next.next.next = new ListNode(9);
    	l1.next.next.next.next.next.next.next = new ListNode(9);
    	l1.next.next.next.next.next.next.next.next = new ListNode(9);
    	l1.next.next.next.next.next.next.next.next.next = new ListNode(9);
    	
    	ListNode l2 = new ListNode(7);
    	
    	ListNode ans = new ListNode(2);
        Assertions.assertEquals(ans, solution.addTwoNumbers1(l1, l2));
       
    }
	
	

}

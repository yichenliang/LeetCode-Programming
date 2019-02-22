//21. Merge Two Sorted Lists
//Approach 1: Recursion

//Definition for singly-linked list. 
class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	      
	      @Override
	      public String toString() {
	          return "ListNode{" +
	                  "val=" + val +
	                  ", next=" + next +
	                  '}';
	      }
	 }    


class Solution {
  
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	  
	  if(l1 == null) {
		  return l2;
	  }
	  
	  if(l2 == null) {
		  return l1;
	  }
	  
	  if (l1.val < l2.val) {
		  l1.next = mergeTwoLists(l1.next, l2);
		  return l1;
		  }
	  else {
		  l2.next = mergeTwoLists(l1, l2.next);
		  return l2;
	  }
	  
  }
    
	
 public static void main(String args[])
    {
		Solution solution;
		
		
		solution = new Solution();
		
		ListNode input1 = new ListNode(1);
		input1.next = new ListNode(3);
		
		ListNode input2 = new ListNode(2);
		input2.next = new ListNode(4);
		
//		ListNode input1 = new ListNode(1);
//		input1.next = new ListNode(4);
//		input1.next.next = new ListNode(5);
//		
//		ListNode input2 = new ListNode(1);
//		input2.next = new ListNode(2);
//		input2.next.next = new ListNode(3);
//		input2.next.next.next = new ListNode(6);
		
		
		
		ListNode rep = solution.mergeTwoLists(input1, input2);
		
    	System.out.println(rep);
    }
}
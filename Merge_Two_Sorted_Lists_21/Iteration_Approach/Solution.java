//21. Merge Two Sorted Lists
// Approach 2: Iteration with an extra new ListNode


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
	  
	  ListNode prehead = new ListNode(-1);
	  ListNode pre = prehead;  //**********point to the current node of linked list prehead.
	  while(l1 != null && l2 != null) {
	  if(l1.val <= l2.val) {
		  pre.next = l1;
		  l1 = l1.next;
	  }
	  else {
		  pre.next = l2;
		  l2 = l2.next;
	  }
	  pre = pre.next;  //**********
	  }
	  
	  pre.next = l1 == null? l2 : l1;    //**********
	  
	  return prehead.next; //*****
  }
    
	
 public static void main(String args[])
    {
		Solution solution;
		
		
		solution = new Solution();
		
		ListNode input1 = new ListNode(1);
		input1.next = new ListNode(2);
		input1.next.next = new ListNode(4);
		
		ListNode input2 = new ListNode(1);
		input2.next = new ListNode(3);
		input2.next.next = new ListNode(4);
		
		ListNode rep = solution.mergeTwoLists(input1, input2);
		
    	System.out.println(rep);
    }
}
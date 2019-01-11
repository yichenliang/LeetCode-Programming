//21. Merge Two Sorted Lists
//Approach 3: Iteration without an extra new ListNode

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
  
   
	// method 1     in this case pointer ptr1 and ptr2 actually are unnecessary, so in method 2, I get rid of pointer ptr1 and ptr2. Also, in method2, ptr1 and ptr2 means l1 and l2 in method1 

//	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//	 
//    if (l1 == null && l2 == null){
//		return null;
//	}
//	else if(l1 == null){
//		return l2;
//	}
//    else if (l2 == null){
//		return l1;
//	}	
//	 
//	 ListNode res, ptr0, ptr1, ptr2;
//	//res: always point to the head of newly merged linked list
//	// ptr1: point to the current node want to be merged in list1
//	//ptr2: point to the current node want to be merged in list2
//    //ptr0: point to the newly merged node 
//    
//	// initialize
//	ptr1 = l1;
//	ptr2 = l2;
//	
//	if (ptr1.val > ptr2.val){
//		ptr0 = ptr2;
//		res = ptr0;
//		ptr2 = ptr2.next;
//	}
//	 else{
//		 ptr0 = ptr1;
//		 res = ptr0;
//		 ptr1 = ptr1.next;
//		 } 
//		 
//    // merge
//	while(true){
//		
//		if (ptr1 == null){
//			ptr0.next = ptr2;
//			break;
//		}
//		else if (ptr2 == null){
//		    ptr0.next = ptr1;
//            break;			
//		}
//		else{
//		    if(ptr1.val < ptr2.val){
//			   ptr0.next = ptr1;
//			   ptr0 = ptr0.next;
//			   ptr1 = ptr1.next;
//	        }
//		    else{
//			   ptr0.next = ptr2;
//			   ptr0 = ptr0.next;
//			   ptr2 = ptr2.next;
//		    }
//		}
//	}
//	
//	return res;
//}
    
	
   //method 2	
   public ListNode mergeTwoLists(ListNode ptr1, ListNode ptr2) {
	 
   if (ptr1 == null && ptr2 == null){
		return null;
	}
	else if(ptr1 == null){
		return ptr2;
	}
   else if (ptr2 == null){
		return ptr1;
	}	
	 
	 ListNode res, ptr0;
	 //ListNode ptr1, ptr2;
	//res: always point to the head of newly merged linked list
	//ptr1: point to the current node want to be merged in list1
	//ptr2: point to the current node want to be merged in list2
    //ptr0: point to the newly merged node 
   
	// initialize

	 if (ptr1.val > ptr2.val){
		ptr0 = ptr2;
		res = ptr0;
		ptr2 = ptr2.next;
	}
	 else{
		 ptr0 = ptr1;
		 res = ptr0;
		 ptr1 = ptr1.next;
		 } 
		 
   // merge
	while(true){
		
		if (ptr1 == null){
			ptr0.next = ptr2;
			break;
		}
		else if (ptr2 == null){
		    ptr0.next = ptr1;
           break;			
		}
		else{
		    if(ptr1.val < ptr2.val){
			   ptr0.next = ptr1;
			   ptr0 = ptr0.next;
			   ptr1 = ptr1.next;
	        }
		    else{
			   ptr0.next = ptr2;
			   ptr0 = ptr0.next;
			   ptr2 = ptr2.next;
		    }
		}
	}
	
	return res;
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


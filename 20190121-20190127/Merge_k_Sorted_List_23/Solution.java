
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


public class Solution {
	    
	public ListNode mergeKLists(ListNode[] lists){
	    return partion(lists,0,lists.length-1);
	}

	public  ListNode partion(ListNode[] lists,int s,int e){
	    if(s==e)  return lists[s];
	    if(s<e){
	        int q=(s+e)/2;
	        ListNode l1=partion(lists,s,q);
	        ListNode l2=partion(lists,q+1,e);
	        return merge(l1,l2);
	    }else
	        return null;
	}

	//This function is from Merge Two Sorted Lists.
	public ListNode merge(ListNode l1,ListNode l2){
	    if(l1==null) return l2;
	    if(l2==null) return l1;
	    if(l1.val<l2.val){
	        l1.next=merge(l1.next,l2);
	        return l1;
	    }else{
	        l2.next=merge(l1,l2.next);
	        return l2;
	    }
	}
	

		public static void main(String[] args) {
		Solution solution = new Solution();
		
		ListNode list1 = new ListNode(1);
		         list1.next = new ListNode(4);
		         list1.next.next = new ListNode(5);
		ListNode list2 = new ListNode(1);
		         list2.next = new ListNode(3);
		         list2.next.next = new ListNode(4);  
		ListNode list3 = new ListNode(2);
		         list3.next = new ListNode(6);
		
		ListNode[] input = {list1, list2, list3};
		
		ListNode result = solution.mergeKLists(input);
		
		System.out.println(result);
     }
}


// time complexity: O(NlogK)
// space complexity: O(NlogK)



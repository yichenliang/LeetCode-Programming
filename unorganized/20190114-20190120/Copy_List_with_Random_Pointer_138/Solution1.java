/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
  
    HashMap<RandomListNode, RandomListNode> visited = new HashMap<>();
  
  RandomListNode getCloneNode(RandomListNode inputNode){
	  if(inputNode != null){
		  if(this.visited.containsKey(inputNode)){
			  return this.visited.get(inputNode);
		  }
		  else{
			RandomListNode copy = new RandomListNode(inputNode.label);
			this.visited.put(inputNode, copy);
			return this.visited.get(inputNode);
		  }
	  }
	  return null;
	  
  }
  

  public RandomListNode copyRandomList(RandomListNode head) {
	  
	  if(head == null){
		  return null;
	  }
	  
	  RandomListNode oldNode = head;
	  RandomListNode newNode = new RandomListNode(oldNode.label);
	  
	  this.visited.put(oldNode, newNode);
	  
	  while(oldNode != null){
		  newNode.next = this.getCloneNode(oldNode.next);
		  newNode.random = this.getCloneNode(oldNode.random);
		  
		  oldNode = oldNode.next;
		  newNode = newNode.next;
	    } 
    return this.visited.get(head);
    }
}

// time complexity: O(n)
// space complexity:  O(N)
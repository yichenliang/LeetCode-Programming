package yichenliang.leetcode.design;

import java.util.Stack;

/**
 *  232. Implement Queue using Stacks
 *  
 *  time complexity: O(n)
 *  space complexity: O(n)
 *   
 */

public class ImplementQueueUsingStacks {
	
	class MyQueue {
	    
	    Stack<Integer> current;
	    Stack<Integer> store;

	    /** Initialize your data structure here. */
	    public MyQueue() {
	        current = new Stack<>();
	        store = new Stack<>();
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        store.push(x);
	        
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	        if(!current.isEmpty()){
	            return current.pop();
	        }
	        
	        while(!store.isEmpty()){
	            current.push(store.pop());
	        }
	        
	        return current.pop();
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	        
	        if(!current.isEmpty()){
	            return current.peek();
	        }
	        
	        while(!store.isEmpty()){
	            current.push(store.pop());
	        }
	        
	        return current.peek();
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return current.isEmpty() && store.isEmpty();
	    }
	}


}

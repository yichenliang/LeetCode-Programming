package yichenliang.leetcode.all;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 * 
 * time complexity: O(n)
 * space complexity: O(n) 
 */

public class ImplementStackUsingQueues {
	
	class MyStack {

	    Queue<Integer> q1;
	    Queue<Integer> q2;
	    /** Initialize your data structure here. */
	    public MyStack() {
	        q1 = new LinkedList<>();
	        q2 = new LinkedList<>();
	    }
	    
	    /** Push element x onto stack. */
	    public void push(int x) {
	        if(!q1.isEmpty()){
	            q1.offer(x);
	        }
	        else{
	            q2.offer(x);
	        }
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
	        if(!q1.isEmpty()){
	            while(q1.size() > 1){
	                q2.offer(q1.poll());
	            }
	            return q1.poll();
	        }
	        
	        while(q2.size() > 1){
	            q1.offer(q2.poll());
	        }
	        return q2.poll();
	        
	    }
	    
	    /** Get the top element. */
	    public int top() {
	        
	        if(!q1.isEmpty()){
	            while(q1.size() > 1){
	                q2.offer(q1.poll());
	            }
	            
	            int current = q1.poll();
	            q2.offer(current);
	            return current;
	        }
	        
	        while(q2.size() > 1){
	            q1.offer(q2.poll());
	        }
	        int current = q2.poll();
	        q1.offer(current);
	        return current;
	        
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
	        return q1.isEmpty() && q2.isEmpty();
	    }
	}

}

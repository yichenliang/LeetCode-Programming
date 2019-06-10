package yichenliang.leetcode.stack;

import java.util.Stack;

/**
 *  155. Min Stack
 *   
 *  time complexity: O(1)
 *  space complexity: O(n)
 * 
 */

public class MinStack {
	 Stack<Integer> stack = new Stack<>();
	    Stack<Integer> minStack = new Stack<>();

	    /** initialize your data structure here. */
	    public MinStack() {
	        
	    }
	    
	    public void push(int x) {
	        stack.push(x);
	        if(minStack.isEmpty()){
	            minStack.push(x);
	        }
	        else{
	            if(x < minStack.peek()){
	                minStack.push(x);
	            }
	            else{
	                minStack.push(minStack.peek());
	            }
	        }
	    }
	    
	    public void pop() {
	        stack.pop();
	        minStack.pop();
	        
	    }
	    
	    public int top() {
	        return stack.peek();
	    }
	    
	    public int getMin() {
	        return minStack.peek();
	    }
}

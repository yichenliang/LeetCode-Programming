package yichenliang.leetcode.design;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 *  716. Max Stack
 * 
 *  Design
 *  
 */

public class MaxStack {
	LinkedList<Integer> stack;
    PriorityQueue<Integer> maxStack;

    /** initialize your data structure here. */
    public MaxStack() {
        stack = new LinkedList<>();
        maxStack = new PriorityQueue<>();
    }
    
    public void push(int x) {
        stack.add(x);
        maxStack.add(-x);       
    }
    
    public int pop() {
       int element = stack.removeLast();
       maxStack.remove(-element);
        return element;
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int peekMax() {
       return -maxStack.peek(); 
    }
    
    public int popMax() {
       int element = -maxStack.poll();
       stack.removeLastOccurrence(element);
       return element;
    }
}


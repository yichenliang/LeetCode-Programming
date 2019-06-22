package yichenliang.leetcode.design;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 341. Flatten Nested List Iterator
 * 
 * Design
 */

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class FlattenNestedListIterator {
	public interface NestedInteger {
		boolean isInteger() ;
		Integer getInteger();
		List<NestedInteger> getList();
	}
	
	public class NestedIterator implements Iterator<Integer> {
	    
	    Deque<NestedInteger> stack;

	    public NestedIterator(List<NestedInteger> nestedList) {
	        stack = new LinkedList<>();
	        for(int i = 0; i < nestedList.size(); i++){
	            stack.addFirst(nestedList.get(i));
	        }
	    }

	    @Override
	    public Integer next() {
	        return stack.removeLast().getInteger();
	    }

	    @Override
	    public boolean hasNext() {
	        while(!stack.isEmpty()){
	           NestedInteger curr = stack.peekLast(); 
	           if(curr.isInteger()){
	               return true;
	           }
	           else{
	               stack.removeLast();
	               for(int i = curr.getList().size() - 1; i >= 0 ; i--){
	                   stack.addLast(curr.getList().get(i));
	               }
	           }
	            
	        }
	        
	        return false;
	    
	        
	    }
	}
}

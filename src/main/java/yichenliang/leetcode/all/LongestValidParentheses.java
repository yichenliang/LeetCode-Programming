package yichenliang.leetcode.all;

import java.util.Stack;

/**
 *  32. Longest Valid Parentheses
 *  
 *  stack
 *  
 *  time complexity: O(n)
 *  space complexity: O(n)
 * 
 */

public class LongestValidParentheses {
	
	 public int longestValidParentheses(String s) {
	        
	        if(s==null || s.length() == 0) return 0;
	        
	        int max = 0;
	        Stack<Integer> stack = new Stack<>();
	        
	        int leftMost = -1;
	        
	        for(int i = 0; i < s.length(); i++){
	            if(s.charAt(i) == '('){
	                stack.push(i);
	            }
	            else if(s.charAt(i) == ')'){
	                if(!stack.isEmpty()){
	                    stack.pop();
	                    if(stack.isEmpty()){
	                       int currentMax = i - leftMost;
	                       max = Math.max(max, currentMax);  
	                    }
	                    else{
	                      int currentMax = i - stack.peek();
	                      max = Math.max(max, currentMax);  
	                    }
	                    
	                }
	                else{ // invalid ')'
	                    leftMost = i;   
	                }
	            }
	        }
	        return max;
	    }

}

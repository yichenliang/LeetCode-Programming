package yichenliang.leetcode.stack;

import java.util.Stack;

/**
 * 227. Basic Calculator II
 * 
 * method1: with stack
 * time complexity: O(n)
 * space complexity: O(n)
 * 
 * method2: without stack
 * time complexity: O(n)
 * space complexity: O(1)
 * 
 */

public class BasicCalculatorII {
	
	// with stack
	public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int res = 0; 
        int num = 0;
        char sign = '+';
        
        Stack<Integer> stack = new Stack<>();
        s = s.replaceAll(" ", "");
        
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num = s.charAt(i) - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){
                    num = num * 10 + s.charAt(i+1) - '0';
                    i++;
                }
            }
            
            if(i == s.length() - 1 || !Character.isDigit(s.charAt(i))){
                if(sign == '+') stack.push(num);
                if(sign == '-') stack.push(-num);
                if(sign == '*') stack.push(stack.pop() * num); 
                if(sign == '/') stack.push(stack.pop() / num);
                
                //num = 0;
                sign = s.charAt(i);
            }
        }
        
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
	
	// without stack
	public int calculate2(String s) {
	      if (s == null) return 0;
	        s = s.replaceAll(" ", "");
		    int len = s.length();
		    
		    int res = 0;
		    long preVal = 0; // initial preVal is 0
		    char sign = '+';
	        
	        int curVal = 0;
	        for(int i = 0; i < len; i++){
	            
	            while(i < s.length() && Character.isDigit(s.charAt(i))){
	                curVal = curVal * 10 + s.charAt(i) - '0';
	                i++;
	            }
	            
	            if (sign == '+') {
		            res += preVal;  // update res
		            preVal = curVal;
		        }
	            
	            if (sign == '-') {
		            res += preVal;  // update res
		            preVal = -curVal;
		        } 
	            
	            if (sign == '*') {
		            preVal = preVal * curVal; // not update res, combine preVal & curVal and keep loop
	                
		        }
	            
	            if (sign == '/') {
		            preVal = preVal / curVal; // not update res, combine preVal & curVal and keep loop
		        }
	            
	            if (i < len) { // getting new sign
		            sign = s.charAt(i);
		            curVal = 0;
		        }
	            
	        }
		    
		    res += preVal;
		    return res;  
	    }
}

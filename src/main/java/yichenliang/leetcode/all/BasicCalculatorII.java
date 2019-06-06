package yichenliang.leetcode.all;

import java.util.Stack;

/**
 * 227. Basic Calculator II
 * 
 * method1: with stack
 * 
 * method2: without stack
 */

public class BasicCalculatorII {
	public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int res = 0; 
        int num = 0;
        char sign = '+';
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num = s.charAt(i) - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){
                    num = num * 10 + s.charAt(i+1) - '0';
                    i++;
                }
            }
            
            if(!Character.isDigit(s.charAt(i))&& s.charAt(i) != ' ' || i == s.length() - 1){
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
}

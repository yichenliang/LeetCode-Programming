package yichenliang.leetcode.withoutTopic;

import java.util.Stack;

/**
 * 224. Basic Calculator
 * 
 */

public class BasicCalculator {
	
	public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0, sign = 1;
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                int num = s.charAt(i) - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){
                    num = num * 10 + s.charAt(i + 1)- '0';
                    i++;
                }
                result = result + num * sign;
            }
            else if(s.charAt(i) == '+'){
                sign = 1;
            }
            else if(s.charAt(i) == '-'){
                sign = -1;
            }
            else if(s.charAt(i) == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            else if(s.charAt(i) == ')'){
                result = result*stack.pop() + stack.pop();
            }
        }
        return result;
    }
}

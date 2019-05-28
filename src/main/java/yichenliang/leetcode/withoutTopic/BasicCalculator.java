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
	
public int calculate2(String s) {
        
        if(s == null || s.length() == 0){
            return 0;
        }
        
        // normal case
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int sign = 1;
        s = s.replaceAll(" ","");
        int len = s.length();
        
        for(int i = 0; i < len; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(s.charAt(i))){
                // find the whole number
                int num = 0;
                while(i < len && Character.isDigit(s.charAt(i))){
                    int n = s.charAt(i) - '0';
                    num = num * 10 + n;
                    i++;
                }
                sum += sign * num;
                i--;
                sign = 1;
            }
            else if(ch == '+'){
                sign = 1;
            }
            else if(ch == '-'){
                sign = -1;
            }
            else if(ch == '('){
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            }
            else{ // ')'
                int si = stack.pop();
                int formerSum = stack.pop();
                sum = formerSum + si * sum;
                sign = 1;
            }
            
        }
        
        return sum;
    }
}

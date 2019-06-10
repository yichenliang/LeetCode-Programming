package yichenliang.leetcode.stack;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 * 
 * stack
 * 
 *  time complexity: O(n)
 *  space complexity: O(n)
 */

public class EvaluateReversePolishNotation {
public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        for(String t : tokens){
            switch(t){
                case "+":
                    Integer op1 = stack.pop();
                    Integer op2 = stack.pop();
                    Integer res1 = op1 + op2;
                    stack.push(res1);
                    break;
                case "-":
                    Integer op3 = stack.pop();
                    Integer op4 = stack.pop();
                    Integer res2 = op4 - op3;
                    stack.push(res2);
                    break;
                case "*":
                    Integer op5 = stack.pop();
                    Integer op6 = stack.pop();
                    Integer res3 = op5 * op6;
                    stack.push(res3);
                    break;
                case "/":
                    Integer op7 = stack.pop();
                    Integer op8 = stack.pop();
                    Integer res4 = op8 / op7;
                    stack.push(res4);
                    break;  
                default:
                    Integer val = Integer.parseInt(t);
                    stack.push(val);
            }   
        }
        return stack.pop();
    }
	
}

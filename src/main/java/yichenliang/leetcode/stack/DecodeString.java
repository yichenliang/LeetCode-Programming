package yichenliang.leetcode.stack;

import java.util.Stack;

/**
 * 394. Decode String
 * 
 * stack
 * 
 * time complexity: O(n)
 * space complexity: O(n)
 * 
 */

public class DecodeString {
	
	public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String result = "";
        int index = 0;
        while(index < s.length()){
            if(s.charAt(index) == '['){
                stringStack.push(result);
                result = "";
                index++;
            }
            else if(s.charAt(index) == ']'){
                String formerResult = stringStack.pop();
                Integer number = numStack.pop();
                for(int i = 0; i < number; i++){
                    formerResult = formerResult + result;
                }
                result = formerResult;
                index++;
            }
            else if(Character.isDigit(s.charAt(index))){
                int count = 0;
                while(Character.isDigit(s.charAt(index))){
                    count = count * 10 + s.charAt(index) - '0';
                    index++;
                }
                numStack.push(count);
            }
            else{
                result += s.charAt(index);
                index++;
            }
        }
        return result;
    }

}

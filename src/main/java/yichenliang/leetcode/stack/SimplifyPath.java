package yichenliang.leetcode.stack;

import java.util.Stack;

/**
 * 71. Simplify Path
 * 
 * stack
 * 
 * time complexity: O(n)
 * space complexity: O(n)
 */

public class SimplifyPath {
	
	public String simplifyPath(String path) {
        
        if(path == null || path.length() <= 1){
            return path;
        }
        String[] each = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String str : each){
            if(str.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }    
            }
            else if(!str.equals(".") && !str.isEmpty()){
                stack.push(str);
            }
        }
        
        if(stack.size() == 0){
            return "/";
        }
        String res = "";
        while(!stack.isEmpty()){
            String newString = stack.pop();
            res = "/" + newString + res;
        }
        return res;
    }
}

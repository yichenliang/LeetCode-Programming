import java.util.Stack;

public class Solution {
	
	 public boolean isValid(String s) {
	        
	        if(s.length() == 0){
	            return true;
	        }
	        
	        Stack<Character> stack = new Stack<>();
	        
	        for(int i = 0; i < s.length(); i++){
	            
	            if(s.charAt(i) == '(' || s.charAt(i) == '{'|| s.charAt(i) == '['){
	                stack.push(s.charAt(i));
	            }
	            else if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']'){
	                if(stack.isEmpty()) {
	            		return false;
	            	}
	                char top = stack.peek();
	                if(s.charAt(i) == ')' && top == '('){
	                    stack.pop();
	                }
	                else if(s.charAt(i) == ']' && top == '['){
	                    stack.pop();
	                }
	                else if(s.charAt(i) == '}' && top == '{'){
	                    stack.pop();
	                }
	                else{
	                    return false;
	                }
	            }        
	                
	        }
	        if(!stack.isEmpty()){
	          return false;  
	        }
	        else{
	            return true;
	        }
	        
	    }
       
	
	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
		String input ="){";
		
		boolean result = solution.isValid(input);
		
		System.out.println(result);
     }
}


// time complexity: O(n)
// space complexity: O(n)



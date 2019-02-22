class Solution {
   public int myAtoi(String str) {
	        if(str == null || str.length() == 0) return 0;
	        
	        int sign = 1;
	        for(int i = 0; i < str.length(); i++){
	            char current = str.charAt(i);
	            if(current == ' '){
	                continue;
	            }
	            else if(current == '+'){
	                sign = 1;
                    if(i + 1 < str.length() && !Character.isDigit(str.charAt(i+1))) return 0;
	            }
	            else if(current == '-'){
	                sign = -1;
                    if(i + 1 < str.length() && !Character.isDigit(str.charAt(i+1))) return 0;
	            }
	            else if(Character.isDigit(current)){
	                int num = 0;
	                while(i < str.length() && Character.isDigit(str.charAt(i))){
	                    int newNum = num * 10 + str.charAt(i)- '0';
	                    // check the range
	                    boolean overflow = num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7);
	                    if(overflow){
	                        return sign == 1? Integer.MAX_VALUE: Integer.MIN_VALUE;
	                    }
	                    num = newNum;
	                    i++;      
	                }
	                return num * sign;
	            }
	            else{
	                return 0;
	            }
	            
	        }
	        return 0;
	    }
}

// time complexity: O(N)
// space complexity: O(1)
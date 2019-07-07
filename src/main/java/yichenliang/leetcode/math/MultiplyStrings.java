package yichenliang.leetcode.math;

/**
 * 43. Multiply Strings
 * 
 * String + Math
 * 
 * time complexity: O(m + n)
 * space complexity: O(m + n)
 * 
 */

public class MultiplyStrings {
	 public String multiply(String num1, String num2) {
	        
	        if(num1 == null || num2 == null) return "";
	        
	        int len1 = num1.length();
	        int len2 = num2.length();
	        
	        int len = len1 + len2;
	        
	        int[] result = new int[len];
	        
	        for(int i = len2 - 1; i>= 0; i--){
	            for(int j = len1 - 1; j >= 0; j--){
	                int number = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
	                int posLow = i + j + 1;
	                int posHigh = i + j;
	                int res = number + result[posLow];
	                result[posLow] = res % 10;
	                result[posHigh] += res / 10;
	            }
	        }
	        
	        // convert into string result
	        StringBuilder sb = new StringBuilder();
	        if(result[0] != 0) sb.append(result[0]);
	        for(int i = 1; i < len; i++){
	            // only skip leading zero
	            if(sb.length() == 0 && result[i]== 0){
	                break;
	            }
	            else{
	                sb.append(result[i]);
	            }
	        }
	        
	        return (sb.length() == 0)? "0" : sb.toString();  
	    }
}

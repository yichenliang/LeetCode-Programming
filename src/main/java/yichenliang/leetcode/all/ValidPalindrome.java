package yichenliang.leetcode.all;

/**
 * 125. Valid Palindrome
 * 
 * time complexity: O(n)
 * space complexity: O(n)
 * 
 */

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        if(s == null){
            return false;
        }
        
        if(s.length() == 0){
            return true;
        }
        
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for(int i = 0; i < len; i++){
            char current = s.charAt(i);
            if(current - 'a' >= 0 && current - 'a' <= 25){
                sb.append(current);
            }
            else if(current - 'A' >= 0 && current - 'A' <= 25){
                sb.append(current);
            }
            else if(current - '0' >= 0 && current - '0' <= 9){
                sb.append(current);
            }
        }
        
        String res = sb.toString().toLowerCase();
        
        return isPalindromeString(res);
    }
    
    boolean isPalindromeString(String str){
        if(str.length() == 0){
            return true;
        }
        
        int start = 0;
        int end = str.length() - 1;
        while(start <= end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

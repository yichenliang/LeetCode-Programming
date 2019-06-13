package yichenliang.leetcode.all;

/**
 * 5. Longest Palindromic Substring
 * 
 * method1: dp
 * time complexity: O(n^2)
 * space complexity: O(n^2)
 * 
 * method2: expand from center
 * time complexity: O(n^2)
 * space complexity: O(1)
 * 
 */

public class LongestPalindromicSubstring {
	
	public String longestPalindrome1(String s) {
        if(s == null ||s.length() == 0){
            return "";
        }
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        
        int start = 0;
        int end = 0;
        
        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if((i + 1 >= j - 1 || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    if(j - i > end - start){
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
	
	// expand from center
	public String longestPalindrome2(String s) {
        
        if(s == null || s.length() == 0 || s.length() == 1) return s;
        
        int start = 0;
        int end = 0;
        int len = 0;
        
        for(int i = 0; i < s.length(); i++){
            int len1 = findLongest(s, i, i);
            int len2 = findLongest(s, i, i+1);
            len = Math.max(len1, len2);
            if(len > end - start + 1){
                // update end and start
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        
        return s.substring(start, end + 1);    
    }
    
    private int findLongest(String s, int left, int right){
        
        while(left >= 0 && right < s.length()){
            if(s.charAt(left) == s.charAt(right)){
              left--;
              right++;    
            }
            else{
                break;
            }
        }
        
        return right - left - 1;
    }

}

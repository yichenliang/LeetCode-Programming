package yichenliang.leetcode.dp;

/**
 * 5. Longest Palindromic Substring
 * 
 * dp
 * 
 * time complexity: O(n^2)
 * space complexity: O(n^2)
 */

public class LongestPalindromicSubstring {
	
	public String longestPalindrome(String s) {
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

}

package yichenliang.leetcode.dp;

/**
 * 647. Palindromic Substrings
 * 
 * method 1 : expand from center
 * time complexity: O(n)
 * space complexity: O(1)
 * 
 * method 2: dp
 * time complexity: O(n^2)
 * space complexity: O(n^2)
 */

public class PalindromicSubstrings {
	
	public int countSubstrings1(String s) {
        
        if(s == null || s.length() == 0){
            return 0;
        }
        
        if(s.length() == 1){
            return 1;
        }
        
        // normal case
        int len = s.length();
        int ans = 0;
        for(int i = 0; i < len; i++){
            ans += countPalindromic(i, s);
        }
        return ans;
    }
    
    int countPalindromic(int center, String str){
        int start = center;
        int end = center;
        int ans = 0;
        int len = str.length();
        // count odd
        while(start >= 0 && end < len){
            if(isPalindromic(start, end, str)){
                ans++;
                start--;
                end++;
            }
            else{
                break;
            }
        }
        
        start = center;
        end = center + 1;
        // count even
        while(start >= 0 && end < len){
            if(isPalindromic(start, end, str)){
                ans++;
                start--;
                end++;
            }
            else{
                break;
            }
        }
        return ans;
    }
    
    boolean isPalindromic(int s, int e, String str){
        while(s <= e){
            if(str.charAt(s) != str.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
    
    
    // dp
    public int countSubstrings2(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int ans = 0;
        
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
            ans++;
        }
        
        for(int d = 1; d <= len - 1; d++){
            for(int i = 0; i + d < len; i++){
                if(s.charAt(i) == s.charAt(i + d)){
                    if(d == 1){
                        dp[i][i + d] = true;
                        ans++;
                    }
                    else{
                        if(dp[i + 1][i + d - 1] == true){
                            dp[i][i + d] = true;
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
    
}


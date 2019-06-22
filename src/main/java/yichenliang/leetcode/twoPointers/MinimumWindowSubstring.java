package yichenliang.leetcode.twoPointers;

/**
 *  76. Minimum Window Substring
 *  
 *  two pointers
 *  
 *  time complexity: o(n)
 *  space complexity: o(1)
 *  
 */

public class MinimumWindowSubstring {
	
	public String minWindow(String s, String t) {
        
        if(s == null || t == null || s.length() == 0 ||t.length() == 0) return "";
        
        int count = 0;
        int[] T = new int[256];
        for(char c : t.toCharArray()){
            T[c]++;
        }
        int[] S = new int[256];
        int left = findNext(T, 0, s);
        if(left == s.length()) return "";
        int right = left;
        String res = "";
        int len = s.length();
        while(right < len){
            char rightChar = s.charAt(right);
            if(S[rightChar] < T[rightChar]) count++;
            S[rightChar]++;
            
            while(count == t.length()){
                if(res.isEmpty() || res.length() > right - left + 1) res = s.substring(left, right + 1);
                char leftChar = s.charAt(left);
                if(S[leftChar] <= T[leftChar]) count--;
                S[leftChar]--;
                left = findNext(T, left + 1, s);
            }
            right = findNext(T, right + 1, s);
        }
        return res;
    }
    
    private int findNext(int[] T, int start, String s){
        while(start < s.length()){
            char ch = s.charAt(start);
            if(T[ch] != 0) return start;
            start++;
        }
        return start;
    }

}

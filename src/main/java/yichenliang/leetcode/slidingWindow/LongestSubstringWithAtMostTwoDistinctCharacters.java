package yichenliang.leetcode.slidingWindow;

import java.util.HashMap;

/**
 * 159. Longest Substring with At Most Two Distinct Characters
 * 
 * sliding window
 * 
 * time complexity: O(n)
 * space complexity: O(1)
 * 
 */

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	
public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        if(s == null || s.length() == 0) return 0;
        if(s.length() <= 2) return s.length();
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int start = 0, end = 1;
        map.put(s.charAt(start), 1);
        while(end < len){
            char cur = s.charAt(end);
            if(map.containsKey(cur)){
                map.put(cur, map.get(cur) + 1);
            }
            else{
                map.put(cur, 1);
            }
            
            if(map.size() == 2){
                res = Math.max(res, end - start + 1);
            }
            
            while(map.size() > 2){
                char r = s.charAt(start);
                if(map.get(r) == 1){
                    map.remove(r);
                }
                else{
                    map.put(r, map.get(r) - 1);
                }
                start++;
            }
            end++;
        }
        
        if(map.size() <= 2){
            res = Math.max(res, end - start);
        }
        return res;
    }

}

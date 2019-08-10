package yichenliang.leetcode.all;

import java.util.HashMap;
import java.util.Map;

/**
 *  340. Longest Substring with At Most K Distinct Characters
 * 
 * sliding window
 * time complexity: O(n)
 * space complexity: O(n)
 * 
 */

public class LongestSubstringWithAtMostKDistinctCharacters {
	
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        if(s == null || s == "" || k == 0){
            return 0;
        }
        
        if(s.length() < k){
            return s.length();
        }
        
        int start = 0;
        int end = 0;
        int len = s.length();
        
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        while(end < len){
            char ch = s.charAt(end);
            
            if(!map.containsKey(ch)){
                if(map.size() < k){
                    map.put(ch, 1);
                }
                else{ // find a candidate 
                    int curLen = end - start;
                    maxLen = Math.max(curLen, maxLen);
                    
                    // remove start pointer
                    while(map.size() >= k){
                        char charStart = s.charAt(start);
                        //if(map.contains(charStart)){
                            if(map.get(charStart) == 1){
                                map.remove(charStart);
                            }
                            else{
                                map.put(charStart, map.get(charStart) - 1);
                            }
                            start++;
                        //}
                    }
                    map.put(ch, 1);
                }
            }
            else {
            	//map.contains(ch)
                map.put(ch, map.get(ch) + 1);
            }
            end++;
        }
        
        return Math.max(maxLen, end - start);    
    }
}

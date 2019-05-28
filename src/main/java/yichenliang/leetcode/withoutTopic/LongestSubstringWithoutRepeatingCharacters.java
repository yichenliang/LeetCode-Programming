package yichenliang.leetcode.withoutTopic;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	
	 public int lengthOfLongestSubstring(String s) {
	       int s_length = s.length();
	       int ans = 0;
	       Map<Character, Integer> record = new HashMap<>();
	       for(int i = 0, j = 0; j < s_length; j++){
	    	   char c = s.charAt(j);
	    
	    	   if(record.containsKey(c)){
	        
	    		   i = Math.max(record.get(c) + 1, i);
	    	   }
	    	   ans = Math.max(ans, j - i + 1);
	    	   record.put(c,j);
	       }
	       return ans;  
	    }
}

package yichenliang.leetcode;

import java.util.Arrays;

/**
 * 242. Valid Anagram
 * 
 * method 1
 * time complexity: O(NlongN)
 * space complexity: O(n)
 * 
 * method 2
 * time complexity: O(N)
 * space complexity: O(1)
 * 
 * in this question, all char are lower case alphabets, 
 * if some of them are unicode character, use hashMap instead of array
 */

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
        
		   char[] sa =  s.toCharArray();
	       char[] ta = t.toCharArray();
	       Arrays.sort(sa);
	       Arrays.sort(ta);
	       s = String.valueOf(sa);
	       t = String.valueOf(ta);
	      
	       return s.equals(t);
	}
	
	public boolean isAnagram2(String s, String t) {
	        
		      if(s.length() != t.length()) return false;
		      
		      int len = s.length();
		      int[] store = new int[26];
		    
		      for(int i = 0; i < len; i++){
		          int index = s.charAt(i) - 'a';
		          store[index]++;
		          index = t.charAt(i) - 'a';
		          store[index]--;
		      }
		    
		      for(int k = 0; k < 26; k++){
		          if(store[k] != 0) return false;
		      }
		        
		      return true;
   }
		      
}

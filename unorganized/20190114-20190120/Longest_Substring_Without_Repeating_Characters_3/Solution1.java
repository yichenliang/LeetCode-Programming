import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	public int lengthOfLongestSubstring(String s) {
	    int s_length = s.length();
	    int ans = 0;
	    Map<Character, Integer> record = new HashMap<>();
	    for(int i = 0, j = 0; j < s_length; j++){
	        char c = s.charAt(j);
	        
	        if(record.containsKey(c)){
	            //ans = Math.max(ans, j - i + 1);
	            i = Math.max(record.get(c) + 1, i);
	        }
	        ans = Math.max(ans, j - i + 1);
	        record.put(c,j);
	    }
	    return ans;

    }
	  

	
	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
		//String s = "pwabpc";
		//String s = "abcabcbb";
		String s = "abcabcbb";
		
		int result = solution.lengthOfLongestSubstring(s);
		
		System.out.println(result);
     }
}



// time complexity: O (n): n is the length of string
// space complexity: O(m), m is the size of HashMap





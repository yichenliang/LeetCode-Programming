
public class Solution {
	
	public int lengthOfLongestSubstring(String s) {
		 
		        int n = s.length(), ans = 0;
		       // characters in string can only be ASCII
		        int[] index = new int[128]; // current index of character
		        // try to extend the range [i, j]
		        for (int j = 0, i = 0; j < n; j++) {
		            i = Math.max(index[s.charAt(j)], i);
		            ans = Math.max(ans, j - i + 1);
		            index[s.charAt(j)] = j + 1;
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
// space complexity: O(m), m is the size of Charset (char array)





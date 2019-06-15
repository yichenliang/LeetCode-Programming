package yichenliang.leetcode.twoPointers;


/**
 *  3. Longest Substring Without Repeating Characters
 *   
 *   two pointers
 *   
 *   when char convert into integer, it use ASCII numbers
 *   
 *  time complexity: O(n)
 *  space complexity: O(1)
 * 
 */

public class LongestSubstringWithoutRepeatingCharacters {
	
	public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() == 0) return 0;
        int left = 0;
        int right = 0;
        boolean[] used = new boolean[128];
        int max = 0;
        int len = s.length();
        while(right < len){
            char ch = s.charAt(right);
            if(used[ch] == false){
                used[ch] = true;
                right++;
            }
            else{
                max = Math.max(max, right - left);
                while(left < right && s.charAt(left) != ch){
                    used[s.charAt(left)] = false;
                    left++;
                }
                left++;
                right++;
            }
        }
        max = Math.max(max, right - left);
        return max;
    }
	 
	 public static void main(String[] args) {
		 LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
		 String s = "abba";
		 int res = solution.lengthOfLongestSubstring(s);
		 System.out.println(res);
	 }
}

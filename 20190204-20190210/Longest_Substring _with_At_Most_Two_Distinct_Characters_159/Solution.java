//Sliding Window 

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() < 1) return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, len = 0, count = 0;
        
        while(end < s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }
            else{
                map.put(c, 1);
            }
            
            if(map.get(c) == 1){
                // we just add a new char
                count++;
            }
            end++;
            
            while(count > 2){
                char ch = s.charAt(start);
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0){
                    count--;
                }
                start++;           
            }
            
            len = Math.max(len, end - start);
        }
        
        return len; 
    }
}

// time complexity: O(n)
// space complexity: O(n)

// useful resource: https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/discuss/49708/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.

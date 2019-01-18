
public class Solution {
	
	int expandAroundCenter(String str, int start, int end){
        int left = start, right = end;
        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
        
    }
    
    
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
         
        int start = 0, end = 0; // start, end is the index to indicate the substring for answer
        for(int i = 0; i < s.length(); i++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }
    
    
    
	
	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
		String input ="abcbadd";
		
		String result = solution.longestPalindrome(input);
		
		System.out.println(result);
     }
}


// time complexity: O(n^2)
// space complexity: O(1)



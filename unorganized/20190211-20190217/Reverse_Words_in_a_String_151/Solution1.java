public class Solution {
    public String reverseWords(String s) {
        String res = "";
        if(s == null || s.length() == 0) return res;
        int end = s.length();
        int start = s.length();
        
        for(int i = s.length() - 1; i >=0; i--){
            if(s.charAt(i) == ' '){
                continue;
            }
            else{
                end = i;
                while(i >= 0 && s.charAt(i) != ' '){
                    i--;
                }
                start = i + 1;
                res += s.substring(start, end + 1);
                res += " ";
            }
        }
        
        int len = res.length();
        if(len == 0){
            return res;
        }
        else{
            return res.substring(0, len - 1);
        }
    
    }
}

// time complexity: O(N)
// space complexity: O(1)
// dp

class Solution {
    public int numDecodings(String s) {
        
        if(s == null || s.length()==0 || s.charAt(0) == '0'){return 0;}
        if(s.length() == 1){return 1;}
        
        // initial dp state
        int dp1 = 1;
        int dp2 = 1;
        
        for(int i = 1; i < s.length(); i++){
            int w = 0;
            if( !isValid(s.charAt(i)) && !isValid(s.charAt(i), s.charAt(i-1))) return 0;
            if(isValid(s.charAt(i))) w = dp1;
            if(isValid(s.charAt(i), s.charAt(i-1))) w+=dp2;
            dp2 = dp1;
            dp1 = w;           
        }
        
        return dp1;
        
    }
    
    public boolean isValid(char ch){return ch != '0';}
    public boolean isValid(char ch1, char ch2){
        int number = (ch2 -'0')*10 + (ch1 -'0');
        if(number>= 10 && number <= 26) return true;
        return false;
    }
}

// time complexity: O(N)
// space complexity: O(1)
package yichenliang.leetcode;

/**
 * 443. String Compression
 * 
 * time complexity: O(n)
 * space complexity: O(1)
 * 
 */

public class StringCompression {
	
	public int compress(char[] chars) {
        
        int len = chars.length;
        if(len == 1) return 1;
        
        char curChar = chars[0];
        int curLen = 1;
        int ptr = 0;
        int res = 0;
        
        for(int i = 1; i < len; i++){
            
            if(chars[i] == curChar){
                curLen++;
            }
            else{
                if(curLen == 1){
                    res++;
                    chars[ptr] = curChar;
                    ptr++;
                    curLen = 1;
                    curChar = chars[i];
                }
                else{
                    // curLen : int -> String
                    String str = String.valueOf(curLen);
                    res += str.length() + 1;
                    chars[ptr] = curChar;
                    ptr++;
                    for(int j = 0; j < str.length(); j++){
                        chars[ptr] = str.charAt(j);
                        ptr++;
                    }
                    curLen = 1;
                    curChar = chars[i];
                }
            }     
        }
        
        // last case
        if(curLen == 1){
            res++;
            chars[ptr] = curChar;
        }
        else{
          String str = String.valueOf(curLen);
          res += str.length() + 1;  
          chars[ptr] = curChar;
          ptr++;
          for(int j = 0; j < str.length(); j++){
             chars[ptr] = str.charAt(j);
            ptr++;
           }
            
        }
       return res; 
    }
}

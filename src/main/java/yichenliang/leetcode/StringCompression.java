package yichenliang.leetcode;

/**
 * 443. String Compression
 * 
 */

public class StringCompression {
	
public int compress(char[] chars) {
        
        if(chars.length == 1) return 1;
        
        int ans = 0;
        int curLen = 1;
        char curChar = chars[0];
        
        for(int i = 1; i < chars.length; i++){
            
            if(curChar == chars[i]){
                curLen++;
            }
            else{
                curChar = chars[i];
                //
                if(curLen == 1){
                    ans++;
                }
                else{
                  String str = String.valueOf(curLen); 
                  ans = ans + str.length() + 1;
                }
                curLen = 1;
            }
        }
        
        if(curLen == 1) {
        	return ans++;
        }
        else {
        	String str = String.valueOf(curLen);
        	return ans + 1 + str.length();
        }
    }

}

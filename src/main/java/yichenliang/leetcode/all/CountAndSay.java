package yichenliang.leetcode.all;

/**
 * 38. Count and Say
 * 
 * String
 *
 * time complexity:O(n) 
 * space complexity: O(n)
 * 
 */

public class CountAndSay {
	
	public String countAndSay(int n) {
        
        String str = "1";
        if(n == 1) return str;
        
        for(int i = 2; i <= n; i++){
            int count = 0;
            char prev = '.';
            StringBuilder sb = new StringBuilder();
            for(int idx = 0; idx < str.length(); idx++){
                if(str.charAt(idx) == prev || prev == '.'){
                    count++;
                }
                else{
                    sb.append(count);
                    sb.append(prev);
                    count = 1;
                    
                }
                prev = str.charAt(idx);
            }
            sb.append(count);
            sb.append(prev);
            str = sb.toString();  
        }
        return str;
    }

}

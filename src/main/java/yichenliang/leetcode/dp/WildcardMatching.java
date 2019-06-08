package yichenliang.leetcode.dp;

/**
 * 44. Wildcard Matching
 * 
 * method: dynamic programming
 * 
 * time complexity: O(s*p)
 * space complexity: O(s*p)
 */

public class WildcardMatching {
	
	public boolean isMatch(String s, String p) {
		
        int slen = s.length();
        int plen = p.length();
        
        boolean[][] res = new boolean[slen + 1][plen + 1];
        
        // initial
        res[0][0] = true;
        for(int i = 1; i <= plen; i++){
            if(p.charAt(i - 1) == '*'){
                res[0][i] = true;
            }
            else{
                break;
            }
        }
        
        // dp
        for(int i = 1; i <= slen; i++){
            for(int j = 1; j <= plen; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1)){
                    res[i][j] = res[i - 1][j - 1];
                }
                else if(p.charAt(j - 1) == '?'){
                    res[i][j] = res[i - 1][j - 1];
                }
                else if(p.charAt(j - 1) == '*'){
                    if(res[i - 1][j - 1] || res[i][j - 1] || res[i - 1][j]){
                        res[i][j] = true;
                    }
                }
            }
        }
        
        return res[slen][plen];  
    }

}

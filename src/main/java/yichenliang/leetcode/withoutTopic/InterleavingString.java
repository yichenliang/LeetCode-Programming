package yichenliang.leetcode.withoutTopic;

/**
 * 97. Interleaving String
 * 
 * dp
 * 
 * time complexity: O(k*n)
 * space complexity: O(n*m)
 */

public class InterleavingString {
	
	public boolean isInterleave(String s1, String s2, String s3) {
        
        if(s1 == null || s2 == null || s3 == null){
            return false;
        }
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        
        int len1 = s1.length();
        int len2 = s2.length();
        boolean[][] match = new boolean[len1 + 1][len2 + 1];
        match[0][0] = true;
        
        for(int curLen3 = 0; curLen3 < len1 + len2; curLen3++){
            for(int curLen1 = 0; curLen1 <= curLen3 + 1 && curLen1 <= len1; curLen1++){
                int curLen2 = curLen3 + 1 - curLen1;
                if(curLen2 > len2){
                    continue;
                }
                if((curLen2 > 0 && match[curLen1][curLen2 - 1] && s3.charAt(curLen3) == s2.charAt(curLen2 - 1)) || (curLen1 > 0 && match[curLen1 - 1][curLen2] && s3.charAt(curLen3) == s1.charAt(curLen1 - 1))){
                    match[curLen1][curLen2] = true;
                }   
            }   
        }
        return match[len1][len2];
    }

}

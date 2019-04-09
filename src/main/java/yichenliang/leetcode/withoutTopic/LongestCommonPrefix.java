package yichenliang.leetcode.withoutTopic;

/**
 *  14. Longest Common Prefix
 *  
 *  time complexity: O(n)
 *  space complexity: O(1)
 */

public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
        
        if(strs == null || strs.length == 0){
            return "";
        }
        
        if(strs.length == 1){
            return strs[0];
        }
      
        int size = strs.length;
        String curPrefix = strs[0];
        if(curPrefix.equals("")){
            return "";
        }
        
        for(int i = 1; i < size; i++){
            if(strs[i].equals("")){
                return "";
            }
            else if(strs[i].charAt(0) != curPrefix.charAt(0)){
                return "";
            }
            else{ // update the curPrefix
                int len = Math.min(curPrefix.length(), strs[i].length());
                String temp = "";
                for(int j = 0; j < len; j++){
                    if(curPrefix.charAt(j) == strs[i].charAt(j)){
                        temp += curPrefix.charAt(j);
                    }
                    else{
                        break;
                    }
                }
                curPrefix = temp;
            }
        }
        return curPrefix;
    }

}

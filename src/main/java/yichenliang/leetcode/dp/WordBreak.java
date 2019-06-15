package yichenliang.leetcode.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. Word Break
 * 
 * dp
 * 
 * time complexity: O(n^2)
 * space complexity: O(n)
 */

public class WordBreak {
	
	public boolean wordBreak(String s, List<String> wordDict) {
        // edge case!!
       if(wordDict == null|| s == null) return false;
        
       Set<String> store = new HashSet<>();
       for(String str: wordDict){
           store.add(str);
       }
       
       boolean[] result = new boolean[s.length() + 1];
       result[0]= true;
       
       for(int i = 1; i <= s.length(); i++){
           for(int j = i - 1; j>=0; j--){
               String sub = s.substring(j,i);
               if(wordDict.contains(sub)){
                   if(result[j]){
                        result[i] = true;
                        break;
                   }   
               }
           }
       }
       return result[s.length()];   
   }
}

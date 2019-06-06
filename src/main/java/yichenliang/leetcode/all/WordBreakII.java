package yichenliang.leetcode.all;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 *  140. Word Break II
 *  
 *  method : DFS
 * 
 *  
 */

public class WordBreakII {
	
	public List<String> wordBreak(String s, List<String> wordDict) {
        
        List<String> res = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }
        HashMap<String, List<String>> used = new HashMap<>();
        res = dfs(s, set, used);
        return res;
    }
    
    public List<String> dfs(String s, HashSet<String> set, HashMap<String, List<String>> used){
        if(used.containsKey(s)){
            return used.get(s);
        }
        
        if(s.length() == 0){
            return null;
        }
        
        List<String> res = new LinkedList<>();
        for(int i = 1; i <= s.length(); i++){
            String sub = s.substring(0, i);
            List<String> restResult = null;
            if(set.contains(sub)){
                restResult = dfs(s.substring(i), set, used);
                if(restResult == null){
                    res.add(sub);
                }
                else{
                    for(String str : restResult){
                        res.add(sub + " " + str);
                    }
                } 
            }
        }
        used.put(s, res);
        return res;
    }

}

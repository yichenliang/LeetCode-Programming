package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  609. Find Duplicate File in System
 *  
 *  String
 *  
 *  time complexity: O(n)
 *  space complexity: O(n)
 */

public class FindDuplicateFileInSystem {
	
	public List<List<String>> findDuplicate(String[] paths) {
        
        List<List<String>> res = new ArrayList<>();
        if(paths == null || paths.length < 1){
            return res; 
        }
        
        Map<String, List<String>> store = new HashMap<>();
        
        for(String str : paths){
            String[] p = str.split(" ");
            for(int i = 1; i < p.length; i++){
                String[] element = p[i].split("\\(");
                String key = element[1].replace(")", "");
                if(store.containsKey(key)){
                    String value = p[0] + "/" + element[0];
                    store.get(key).add(value);
                }
                else{
                    List<String> valueSet = new ArrayList<>();
                    String value = p[0] + "/" + element[0];
                    valueSet.add(value);
                    store.put(key, valueSet);
                }
            } 
        }
        
        // build the res
        for(String k : store.keySet()){
            res.add(store.get(k));
        }
        
        return res;
    }

}

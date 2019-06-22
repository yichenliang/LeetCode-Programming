package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. Group Anagrams
 * 
 *  String
 * 
 *  time complexity: O(n * mlogm)
 *  space complexity: O(n)
 */

public class GroupAnagrams {
	
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs == null || strs.length == 0) return result;
        
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] current = strs[i].toCharArray();
            Arrays.sort(current);
            String key = String.valueOf(current);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<List<String>>(map.values());
        
    }

}

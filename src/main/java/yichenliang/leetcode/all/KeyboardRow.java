package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  500. Keyboard Row
 * 
 *  time complexity: O(n)
 *  space complexity: O(1)
 */

public class KeyboardRow {
	
	public String[] findWords(String[] words) {
	       
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i<strs.length; i++){
            for(char c: strs[i].toCharArray()){
                map.put(c, i);//put <char, rowIndex> pair into the map
            }
        }
        
        List<String> res = new ArrayList<>();
        for(String w: words){
            int index = map.get(w.toUpperCase().charAt(0));
            for(char c: w.toUpperCase().toCharArray()){
                if(map.get(c)!=index){
                    index = -1; //don't need a boolean flag. 
                    break;
                }
            }
            if(index!=-1) res.add(w);//if index != -1, this is a valid string
        }
        
        String[] ans = new String[res.size()];
        return res.toArray(ans);
    }

}

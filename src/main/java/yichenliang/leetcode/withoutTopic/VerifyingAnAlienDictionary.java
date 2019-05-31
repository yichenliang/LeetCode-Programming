package yichenliang.leetcode.withoutTopic;

import java.util.HashMap;

/**
 * 953. Verifying an Alien Dictionary
 * 
 * time complexity: O(n)
 * space complexity: O(1)
 * 
 */

public class VerifyingAnAlienDictionary {
	
	public boolean isAlienSorted(String[] words, String order) {
        if(words.length == 1) return true;
        
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('#', 0);
        int len = order.length();
        for(int i = 0; i < len; i++){
            char ch = order.charAt(i);
            map.put(ch, i + 1);
        }
        
        int size = words.length;
        for(int i = 0; i < size - 1; i++){
            String w1 = words[i];
            String w2 = words[i + 1];
            if(!find(w1, w2, map)){
                return false;
            }
        }
        return true;
    }
    
    boolean find(String w1, String w2, HashMap<Character, Integer> map){
            if(w1.length() < w2.length()){
                w1 = w1 + "#";
            }
            else{
                w2 = w2 + "#";
            }
        
           int l = Math.min(w1.length(), w2.length());
            for(int j = 0; j < l; j++){
                char ch1 = w1.charAt(j);
                char ch2 = w2.charAt(j);
                if(map.get(ch1) > map.get(ch2)){
                    return false;
                }
                else if(map.get(ch1) == map.get(ch2)){
                    continue;
                }
                else{
                    break;
                }
            }
        return true;
    }

}

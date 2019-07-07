package yichenliang.leetcode.all;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *  387. First Unique Character in a String
 *  
 *  method : HashMap, Queue
 *  
 *  time complexity: O(n)
 *  space complexity: O(n)
 */

public class FirstUniqueCharacterInAString {
	
	public int firstUniqChar(String s) {
        if(s == null || s.length() == 0){
            return -1;
        }
        
        // key: character, value : index of this character
        Map<Character, Integer> map = new HashMap<>();
        LinkedList<Character> queue = new LinkedList<>();
        
        int len = s.length();
        
        for(int i = 0; i < len; i++){
            Character c = s.charAt(i);
            if(map.containsKey(c)){
                if(queue.contains(c)){
                   queue.remove(c);
                }
                
            }
            else{
                queue.offer(c);
                map.put(c, i);
                
            }   
        }
        
        if(queue.size()>0){
        	char key = queue.pollFirst();
            return map.get(key);
        }
        return -1;
    }	
}

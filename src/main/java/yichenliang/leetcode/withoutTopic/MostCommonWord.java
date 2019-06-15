package yichenliang.leetcode.withoutTopic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  819. Most Common Word
 *  
 *  method1 : Regular expression + HashMap
 *  time complexity: O(n)
 *  space complexity: O(n + m)
 *  
 *  method2 : stringBuilder + HashMap
 *  time complexity: O(n)
 *  space complexity: O(n + m)
 *  
 */

public class MostCommonWord {
	
	public String mostCommonWord1(String paragraph, String[] banned) {
        
        // Regular Expressions
	        // [abc]	a, b, or c (simple class)
	        // X+	    X,one or more times
	
      	String[] para = paragraph.toLowerCase().split("[^a-zA-Z]+");
	        
	        Map<String, Integer> store = new HashMap<>();  // key: word; value: frequency of this word
	        
	        Set<String> banWord = new HashSet<>();
	        for(String str : banned){
	            banWord.add(str.toLowerCase());
	        }
	        
	        for(String word : para){
	            if(!banWord.contains(word)){
	                store.put(word, store.getOrDefault(word, 0) + 1);
	            }
	        }
	        
	        int max = 0;
	        String ans = "";
	        for(String key : store.keySet()){
	           int fre = store.get(key);
	           if(fre > max){
	               ans = key;
	               max = fre;
	           }   
	        }
	        return ans;        
  }
	
	public String mostCommonWord2(String paragraph, String[] banned) {
        
        paragraph = paragraph +  ".";
        
        Set<String> bannedWords = new HashSet<>();
        
        for(String word : banned){
            bannedWords.add(word);
        }
        
        char[] para = paragraph.toCharArray();
        
        Map<String, Integer> store = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(char ch : para){
            if(Character.isLetter(ch)){
                sb.append(Character.toLowerCase(ch));
            }
            else{
                if(sb.length() > 0){
                    String currentWord = sb.toString();
                    if(!bannedWords.contains(currentWord)){
                        store.put(currentWord, store.getOrDefault(currentWord, 0) + 1);
                    }   
                }
                sb = new StringBuilder();
            }
        }
        
        // find the most comment word
       int max = 0;
	   String ans = "";
	   for(String key : store.keySet()){
	        int fre = store.get(key);
	        if(fre > max){
	             ans = key;
	             max = fre;
	         }   
	    }
	        
        return ans;
    }

}

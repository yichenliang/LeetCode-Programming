package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 642. Design Search Autocomplete System
 * 
 * Design + HashMap + String
 * 
 * input() : 
 * time complexity: O(m)
 * space complexity: O(n)
 *  
 */

public class DesignSearchAutocompleteSystem {
	
	class AutocompleteSystem {

	    HashMap<String, Integer>[] arr;
	    String curStr;
	    
	    class Pair{
	        String sentence;
	        int times;
	        Pair(String s, int t){
	            sentence = s;
	            times = t;
	        }   
	    }
	    
	    public AutocompleteSystem(String[] sentences, int[] times) {
	        arr = new HashMap[26];
	        for(int i = 0; i < 26; i++){
	            arr[i] = new HashMap<String, Integer>();
	        }
	        int len = sentences.length;
	        for(int i = 0; i < len; i++){
	            arr[sentences[i].charAt(0) - 'a'].put(sentences[i], times[i]);
	        }
	        curStr = "";
	    }
	    
	    public List<String> input(char c) {
	       if(c == '#'){
	           arr[curStr.charAt(0) - 'a'].put(curStr, arr[curStr.charAt(0) - 'a'].getOrDefault(curStr, 0) + 1);
	           curStr = "";
	           return new ArrayList<>();
	       }
	       else{
	           curStr += c;
	           PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
	           for(String s : arr[curStr.charAt(0) - 'a'].keySet()){
	               if(s.startsWith(curStr)){
	                   q.offer(new Pair(s, arr[curStr.charAt(0) - 'a'].get(s)));
	               }
	           }
	           
	           List<String> result = new ArrayList<>();
	           while(!q.isEmpty() && result.size() < 3){
	               result.add(q.poll().sentence);
	           }
	           return result;
	       }
	    }
	}
}

package yichenliang.leetcode.twoPointers;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 244. Shortest Word Distance II
 * 
 * method1: HashMap
 * Time complexity: O(n^2)  --> O(m + n)
 * Space complexity: O(n)
 *  
 * 2019/8/6
 */

public class ShortestWordDistanceII {

// method1
class WordDistance {

	private HashMap<String, LinkedList<Integer>> store;
	    
	public WordDistance(String[] words) {
		store = new HashMap<>();
	    int len = words.length;
	    for(int i = 0; i < len; i++){
	    	String w = words[i];
	        if(!store.containsKey(w)){
	        	LinkedList<Integer> l = new LinkedList<>();
	            l.add(i);
	            store.put(w, l);
	        }
	        else{
	            store.get(w).add(i);
	        }
	    }
	}
	
	// naive solution, time complexity: O(n^2)
	// optimize it with two pointer method
//	public int shortest(String word1, String word2) {
//		LinkedList<Integer> l1 = store.get(word1);
//	    LinkedList<Integer> l2 = store.get(word2);
//	    int len1 = l1.size();
//	    int len2 = l2.size();
//	    int res = Integer.MAX_VALUE;
//	    for(int i = 0; i < len1; i++){
//	    	for(int j = 0; j < len2; j++){
//	    		int cur = Math.abs(l1.get(i) - l2.get(j));
//	            res = Math.min(res, cur);
//	        }
//	    }
//	        return res;
//	}
	
	// optimized solution: two pointers 
	//time complexity: O(m + n)
	public int shortest(String word1, String word2) {
        LinkedList<Integer> l1 = store.get(word1);
        LinkedList<Integer> l2 = store.get(word2);
        int res = Integer.MAX_VALUE;
        int len1 = l1.size();
        int len2 = l2.size();
        int ptr1 = 0, ptr2 = 0;
        while(ptr1 < len1 && ptr2 < len2){
            int pos1 = l1.get(ptr1);
            int pos2 = l2.get(ptr2);
            if(pos1 < pos2){
                int cur = pos2 - pos1;
                res = Math.min(res, cur);
                ptr1++;
            }
            else{
                int cur = pos1 - pos2;
                res = Math.min(res, cur);
                ptr2++;
            }
        }
        
        return res;
    }	
}

}

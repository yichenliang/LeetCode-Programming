package yichenliang.leetcode.binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 *  792. Number of Matching Subsequences
 * 
 *  Binary Search
 * 
 *  time complexity: O(S) + O(N*L*logS)
 *  space complexity: O(n)
 */

public class NumberOfMatchingSubsequences {
	
	public int numMatchingSubseq(String S, String[] words) {
        
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int len = S.length();
        for(int i = 0; i < len; i++){
            char ch = S.charAt(i);
            if(!map.containsKey(ch)){
                List<Integer> cur = new ArrayList<>();
                map.put(ch, cur);
            }
            map.get(ch).add(i);
        }
        
        int ans = 0;
        for(String word : words){
            ans += findWord(word, map);
        }
        return ans;
    }
    
    private int findWord(String word, HashMap<Character, List<Integer>> map){
        int prev = -1;
        int len = word.length();
        for(int i = 0; i < len; i++){
            char ch = word.charAt(i);
            List<Integer> list = map.get(ch);
            if(list == null) return 0;
            int next = binarySearch(list, prev);
            if(next == -1) return 0;
            prev = next;
        }
        return 1;
    }
    
    private int binarySearch(List<Integer> list, int target){
        int l = 0;
        int r = list.size();
        while(l < r){
            int m = l + (r - l) / 2;
            int number = list.get(m);
            if(number <= target){
                l = m + 1;
            }
            else{
                r = m;
            }
            
        }
        if(l >= list.size()) return -1;
        return list.get(l);
    }

	
}

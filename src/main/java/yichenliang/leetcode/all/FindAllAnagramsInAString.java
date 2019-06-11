package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 *  
 *  method : sliding window + HashMap(Array)
 * 
 *  time complexity: O(n)
 *  space complexity: O(1)
 *  
 */

public class FindAllAnagramsInAString {
	
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int lenS = s.length();
        int lenP = p.length();
        
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        
        for(int i = 0; i < lenP; i++){
            char c = p.charAt(i);
            int index = c - 'a';
            pArr[index]++;
        }
        
        for(int i = 0; i < lenS; i++){
            if(i >= lenP){
                int index =  s.charAt(i - lenP) - 'a';
                sArr[index]--;
            }
            int in = s.charAt(i) - 'a';
            sArr[in]++;
            if(Arrays.equals(sArr, pArr)){
                ans.add(i - lenP + 1);
            }  
        }
        return ans;
    }
	
}

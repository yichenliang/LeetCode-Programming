package yichenliang.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 1002. Find Common Characters
 * 
 * Array
 * 
 * time complexity: O(n)
 * space complexity: O(1)
 * 
 * 2019/8/12
 */

public class FindCommonCharacters {
	
	public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        // use the first letter as a target
        int[] dict = new int[26];
        for (int j = 0; j < A[0].length(); j++) {
            dict[A[0].charAt(j) - 'a']++;
        }
        // comparing the rest words with target
        for (int i = 1; i < A.length; i++) {
            int[] curr = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                curr[A[i].charAt(j) - 'a']++;
            }
            // Update the common dictionary
            for (int j = 0; j < 26; j++) {
                dict[j] = Math.min(curr[j], dict[j]);
            }
        }
        // create the result from array
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < dict[i]; j++) {
                ans.add(Character.toString((char) ('a' + i)));
            }
        }
        return ans;
    }

}

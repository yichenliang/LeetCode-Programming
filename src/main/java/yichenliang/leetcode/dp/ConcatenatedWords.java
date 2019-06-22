package yichenliang.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 472. Concatenated Words
 * 
 * dp
 * This is solution is every similar to 139. Word Break
 * time complexity: O(m * n^2)
 * space complexity: O(m)
 */

public class ConcatenatedWords {
	
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, new Comparator<String>() {
            public int compare (String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        
        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], preWords)) {
                result.add(words[i]);
            }
            preWords.add(words[i]);
        }
        
        return result;
    }
	
    private boolean canForm(String word, Set<String> dict) {
        if (dict.isEmpty()) return false;
	    boolean[] dp = new boolean[word.length() + 1];
	    dp[0] = true;
	    for (int i = 1; i <= word.length(); i++) {
	        for (int j = 0; j < i; j++) {
		        if (!dp[j]) continue;
		        if (dict.contains(word.substring(j, i))) {
		            dp[i] = true;
		            break;
		        }
	        }
	    }
	    return dp[word.length()];
    }

}

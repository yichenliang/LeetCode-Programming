package yichenliang.leetcode.withoutTopic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 127. Word Ladder
 * 
 * BFS
 * 
 * time complexity: O(n * 26^l)  l is the length of begin word, n is the size of word list
 * space complexity: O(n)
 * 
 */

public class WordLadder {
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();
        Set<String> wordListt = new HashSet<>(wordList);
		if(!wordListt.contains(endWord)){return 0;}
        
        int len = 1;
		
		HashSet<String> visited = new HashSet<String>();
		
		beginSet.add(beginWord);
		endSet.add(endWord);
		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			if (beginSet.size() > endSet.size()) {
				Set<String> set = beginSet;
				beginSet = endSet;
				endSet = set;
			}

			Set<String> temp = new HashSet<String>();
			for (String word : beginSet) {
				char[] chs = word.toCharArray();

				for (int i = 0; i < chs.length; i++) {
                    char old = chs[i];
					for (char c = 'a'; c <= 'z'; c++) {
						chs[i] = c;
						String target = String.valueOf(chs);

						if (endSet.contains(target)) {
							return len + 1;
						}

						if (!visited.contains(target) && wordListt.contains(target)) {
							temp.add(target);
							visited.add(target);
						}	
					}
                    chs[i] = old;
				}
			}

			beginSet = temp;
			len++;
		}
		
		return 0;
	}

}

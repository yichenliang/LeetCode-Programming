import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
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
					for (char c = 'a'; c <= 'z'; c++) {
						char old = chs[i];
						chs[i] = c;
						String target = String.valueOf(chs);

						if (endSet.contains(target)) {
							return len + 1;
						}

						if (!visited.contains(target) && wordListt.contains(target)) {
							temp.add(target);
							visited.add(target);
						}
						chs[i] = old;
					}
				}
			}

			beginSet = temp;
			len++;
		}
		
		return 0;
	}
	
	
    public static void main(String[] args) {
		Solution solution = new Solution();
		String beginWord = "hit";
		String endWord = "cog";
		String[] wordL = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<>();
		for(int i = 0; i < wordL.length; i++){
			wordList.add(wordL[i]);
		}
		int result =  solution.ladderLength(beginWord, endWord, wordList);
		System.out.println(result);
		
    }
}


// space complexity: o(n)
package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 *  212. Word Search II
 *  
 *  DFS + Trie
 */

public class WordSearchII {
	public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        // end case
        char c = board[i][j];
        if(c == '#' || p.next[c - 'a'] == null){
            return;
        }
        p = p.next[c - 'a'];
        if(p.word != null){ // found one
            res.add(p.word);
            p.word = null;  // de-duplicate
        }
        
        board[i][j] = '#';
        if(i - 1 >= 0) dfs(board, i - 1, j, p, res);
        if(j - 1 >= 0) dfs(board, i, j - 1, p, res);
        if(i + 1 < board.length) dfs(board, i + 1, j, p, res);
        if(j + 1 < board[0].length) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        TrieNode p = root;
        for(String str : words){
            char[] arr = str.toCharArray();
            int len = arr.length;
            p = root;
            for(int i = 0; i < len; i++){
                char ch = arr[i];
                if(p.next[ch - 'a'] == null){
                    p.next[ch - 'a'] = new TrieNode();
                }
                p = p.next[ch - 'a'];
            }
            p.word = str;
        }
        return root;
    }
    
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}

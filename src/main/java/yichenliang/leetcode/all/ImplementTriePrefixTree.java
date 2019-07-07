package yichenliang.leetcode.all;

/**
 * 208. Implement Trie (Prefix Tree)
 * 
 */

public class ImplementTriePrefixTree {
	
	class TrieNode{
	    TrieNode[] next = new TrieNode[26];
	    String word;
	}
	
	// Implement Trie (Prefix Tree)
	class Trie {
	    
	    TrieNode node;

	    /** Initialize your data structure here. */
	    public Trie() {
	        node = new TrieNode();
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        char[] arr = word.toCharArray();
	        int len = arr.length;
	        TrieNode p = node;
	        for(int i = 0; i < len; i++){
	            int ptr = arr[i] - 'a';
	            if(p.next[ptr] == null){
	                p.next[ptr] = new TrieNode();
	            }
	            p = p.next[ptr];
	        }
	        p.word = word;
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	        TrieNode p = node;
	        return search(p, word);
	    }
	    
	    private boolean search(TrieNode p, String word){
	       if(word.length() == 0){
	           if(p.word != null) return true;
	           return false;
	       }
	        char ch = word.charAt(0);
	        if(p.next[ch - 'a'] == null) return false;
	        return search(p.next[ch - 'a'], word.substring(1));
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	        TrieNode p = node;
	        return startsWith(p, prefix);
	    }
	    
	    private boolean startsWith(TrieNode p, String prefix){
	        if(prefix.length() == 0){
	            for(int i = 0; i < 26; i++){
	                if(p.next[i] != null || p.word != null) return true;
	            }
	            return false;
	        }
	        char ch = prefix.charAt(0);
	        if(p.next[ch - 'a'] == null) return false;
	        return startsWith(p.next[ch - 'a'], prefix.substring(1));
	    }
	}

}

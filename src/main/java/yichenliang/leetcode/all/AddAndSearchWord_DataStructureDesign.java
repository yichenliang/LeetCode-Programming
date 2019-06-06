package yichenliang.leetcode.all;

/**
 * 211. Add and Search Word - Data structure design
 * 
 *  Trie
 *  
 *  add
 *  time complexity: O(n)
 *  space complexity: O(n)
 *  
 *  search
 *  time complexity: O(n)
 *  space complexity: O(n)
 */

public class AddAndSearchWord_DataStructureDesign {
	
	class WordDictionary {
	    TrieNode node;

	    /** Initialize your data structure here. */
	    public WordDictionary() {
	        node = new TrieNode();
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        char[] arr = word.toCharArray();
	        int len = arr.length;
	        TrieNode p = node;
	        for(int i = 0; i < len; i++){
	            int index = arr[i] - 'a';
	            if(p.next[index] == null){
	                p.next[index] = new TrieNode();
	            }
	            p = p.next[index];
	        }
	        p.word = word;
	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	       TrieNode p = node;
	       return search(word, p);
	    }
	    
	    private boolean search(String word, TrieNode p){
	        if(word.length() == 0){
	            if(p.word != null){
	                return true;
	            }
	            return false;
	        }
	        if(word.charAt(0) != '.'){
	            int index = word.charAt(0) - 'a';
	            if(p.next[index] == null){
	                return false;
	            }
	            return search(word.substring(1), p.next[index]);
	        }
	        else{
	            for(int i = 0; i < 26; i++){
	                if(p.next[i] != null && search(word.substring(1), p.next[i])){
	                    return true;
	                }
	            }
	            return false;
	        }
	    }
	}

	class TrieNode{
	    TrieNode[] next = new TrieNode[26];
	    String word;
	}

}

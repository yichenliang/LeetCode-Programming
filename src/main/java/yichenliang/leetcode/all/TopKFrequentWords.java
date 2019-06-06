package yichenliang.leetcode.all;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *  692. Top K Frequent Words
 *  
 *  Comparator
 *  
 *  time complexity: O(nlogk)
 *  space complexity: O(n)
 * 
 */

public class TopKFrequentWords {
	
	public List<String> topKFrequent(String[] words, int k) {
        
        Map<String, Integer> store = new HashMap<>();
        
        for(String word : words){
            if(store.containsKey(word)){
                store.put(word, store.get(word) + 1);
            }
            else{
                store.put(word, 1);
            }
        }
        
        // create a min heap with size K
        Comparator<Node> comparator = new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b) {
             return a.freq == b.freq ? b.word.compareTo(a.word) : a.freq - b.freq;
            }
        };
        
        PriorityQueue<Node> minHeap = new PriorityQueue<>(comparator);
        
        for(String key : store.keySet()){
            minHeap.offer(new Node(key, store.get(key)));
            if(minHeap.size() > k) minHeap.poll();
        }
        
        List<String> res = new LinkedList<>();
        
        while(!minHeap.isEmpty()){
            res.add(0, minHeap.poll().word);
        }
        
        return res;    
    }

}

class Node{
    String word;
    int freq;
    Node(String w, int f){
        word = w;
        freq = f;
    }
}


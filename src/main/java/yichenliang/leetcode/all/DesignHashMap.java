package yichenliang.leetcode.all;

import java.util.Arrays;

/**
 *  706. Design HashMap
 *  
 *  method2: more like real life hashamp
 *  time complexity: 
 *  get: O(1)
 *  put: O(1)
 *  remove: O(1)
 *  
 *  space complexity:
 *  get: O(n)
 *  put: O(n)
 *  space: O(n)
 *  
 */

public class DesignHashMap {
	
	// method 1 brute force
	class MyHashMap1 {

		   int [] map;
		    /** Initialize your data structure here. */
		    public MyHashMap1() {
		        map = new int[1000001];
		        Arrays.fill(map,-1);  // initial all value to be -1
		    }
		    
		    /** value will always be non-negative. */
		    public void put(int key, int value) {
		        map[key]=value;
		    }
		    
		    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
		    public int get(int key) {
		        return map[key];
		    }
		    
		    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
		    public void remove(int key) {
		        map[key]=-1;
		    }
		}
	
	
	// method 2: using array + linked list
    // first map a key from a large area[1000000] into a smaller area[1000]
	// find the value from the smaller area by scanning each element
	class MyHashMap {

	    ListNode[] nodes;
	    
	    /** Initialize your data structure here. */
	    public MyHashMap() {
	        nodes = new ListNode[1000];
	    }
	    
	    /** value will always be non-negative. */
	    public void put(int key, int value) {
	        int i = idx(key);
		    if (nodes[i] == null) nodes[i] = new ListNode(-1, -1);
		    ListNode prev = find(nodes[i], key);
		    if (prev.next == null){
               prev.next = new ListNode(key, value);  // put new key-value pair 
            } 
            else{
               prev.next.val = value;  // update 
            }  
	    }
	    
	    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	    public int get(int key) {
	        int i = idx(key);
		    if (nodes[i] == null) return -1;
		    ListNode node = find(nodes[i], key);
		    return node.next == null ? -1 : node.next.val;
	        
	    }
	    
	    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
	    public void remove(int key) {
	        int i = idx(key);
		    if (nodes[i] == null) return;
		    ListNode prev = find(nodes[i], key);
		    if (prev.next == null) return;
		    prev.next = prev.next.next;
	        
	    }
	    
	    private int idx(int key) { 
            return key % nodes.length;
        }
	    
	    private ListNode find(ListNode bucket, int key) {
		    ListNode node = bucket, prev = null;
		    while (node != null && node.key != key) {
		        prev = node;
		        node = node.next;
		    }
		    return prev;
		}
	    
	    
	}
	
	class ListNode {
	    int key, val;
	    ListNode next;

	    ListNode(int key, int val) {
	        this.key = key;
	        this.val = val;
	    }
	}
}

 



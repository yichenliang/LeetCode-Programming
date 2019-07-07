package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *  380. Insert Delete GetRandom O(1)
 *  
 *  Design
 *  
 *  time complexity: O(1)
 *  space complexity: O(n)
 * 
 */

public class InsertDeleteGetRandomO_1 {
	
	class RandomizedSet {
	    Map<Integer, Integer> map;
	    List<Integer> array;
	    Random rand = new Random();

	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	        map = new HashMap<>();
	        array = new ArrayList<>();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        if(map.containsKey(val)) return false;
	        int size = array.size();
	        map.put(val, size);
	        array.add(val);
	        return true;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        if(!map.containsKey(val)) return false;
	        int index = map.get(val);
	        if(index < array.size() - 1){
	            int lastElement = array.get(array.size() - 1);
	            map.put(lastElement, index);
	            array.set(index, lastElement);
	        }
	        map.remove(val);
	        array.remove(array.size() - 1);
	        return true;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	        return array.get(rand.nextInt(array.size()));
	    }
	}


}

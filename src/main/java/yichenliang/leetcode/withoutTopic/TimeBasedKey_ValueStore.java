package yichenliang.leetcode.withoutTopic;

import java.util.HashMap;
import java.util.TreeMap;

/**
 *  981. Time Based Key-Value Store
 *  
 *  Design HashMap TreeMap
 *  
 *  time complexity: O(1) for set; O(logN) for get
 *  space complexity: O(n)
 */

public class TimeBasedKey_ValueStore {
	
	HashMap<String, TreeMap<Integer, String>> store;

    /** Initialize your data structure here. */
    public TimeBasedKey_ValueStore() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(store.containsKey(key)){
            TreeMap<Integer, String> temp = store.get(key);
            temp.put(timestamp, value);
            //store.put(key, temp);
        }
        else{
            TreeMap<Integer, String> tMap = new TreeMap<>();
            tMap.put(timestamp, value);
            store.put(key, tMap);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key)){
           return ""; 
        }
        else{
            
            TreeMap<Integer, String> tMap = store.get(key);
            Integer ts = tMap.floorKey(timestamp);
            if(ts == null){
                return "";
            }
            else{
                return tMap.get(ts);
            }
        }   
    }

}

package yichenliang.leetcode.withoutTopic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 347. Top K Frequent Elements
 */

public class TopKFrequentElements {
	
public List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> store = new HashMap<>();
        for(int n : nums){
            store.put(n, store.getOrDefault(n, 0) + 1);
        }
        
        // busket sort
        // largest possible frequency : nums.length
        int len = nums.length + 1;
        List<Integer>[] bucket = new List[len];
        
        for(int key : store.keySet()){
            int freq = store.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
                bucket[freq].add(key);
            }
            else{
                bucket[freq].add(key);
            }
        }
        
        // return Top K Frequent result
        
        List<Integer> res = new ArrayList<>();
        
        for(int j = bucket.length - 1; j >= 0 && res.size() < k; j--){
            if(bucket[j] != null){
                res.addAll(bucket[j]);
            }
        }
        
        return res;
        
    }

}

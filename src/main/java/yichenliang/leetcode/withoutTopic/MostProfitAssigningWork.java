package yichenliang.leetcode.withoutTopic;

import java.util.TreeMap;

/**
 * 826. Most Profit Assigning Work
 * 
 * TreeMap
 * 
 * time complexity: O(dlogd + wlogd)  put + find
 * space complexity: O(d)
 * 
 * 2019/7/13
 */

public class MostProfitAssigningWork {
	
	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        for (int i = 0; i < difficulty.length; i++) {
            map.put(difficulty[i], Math.max(profit[i], map.getOrDefault(difficulty[i], 0)));
        }
        int best = 0, res = 0;
        for (Integer key : map.keySet()) {
            best = Math.max(map.get(key), best);
            map.put(key, best);
        }
        for (int i = 0; i < worker.length; i++) {
            Integer key = map.floorKey(worker[i]);
            if(key != null) res += map.get(key);
        }
        return res;
    }

}

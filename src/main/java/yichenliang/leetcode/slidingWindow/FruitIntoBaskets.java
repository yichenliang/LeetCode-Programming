package yichenliang.leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 904. Fruit Into Baskets
 * 
 * sliding window
 * 
 * time complexity: O(n)
 * space complexity: O(2)
 * 
 */

public class FruitIntoBaskets {
	
//	public int totalFruit(int[] tree) {
//        
//        HashSet<Integer> set = new HashSet<>();
//        
//        if(tree == null || tree.length == 0){
//            return 0;
//        }
//        
//        int start = 0; 
//        int end = 0;
//        int len = tree.length;
//        int res = Integer.MIN_VALUE;
//        while(start < len){
//            if(end == len){
//                res = Math.max(res, end - start);
//                break;
//            }
//            
//            if(set.contains(tree[end])){
//                
//            }
//            else{
//                if(set.size() < 2){
//                    set.add(tree[end]);
//                }
//                else if(set.size() == 2){
//                    res = Math.max(res, end - start);
//                    start++;
//                    end = start;
//                    set = new HashSet<Integer>();
//                    end--;
//                }
//                
//            }
//            end++;
//        }
//        return res;
//    }
	
	public int totalFruit(int[] tree) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int res = 0, i = 0;
        for (int j = 0; j < tree.length; ++j) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
            while (count.size() > 2) {
                count.put(tree[i], count.get(tree[i]) - 1);
                if (count.get(tree[i]) == 0) count.remove(tree[i]);
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

}

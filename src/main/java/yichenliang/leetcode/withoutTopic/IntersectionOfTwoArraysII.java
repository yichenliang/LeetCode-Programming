package yichenliang.leetcode.withoutTopic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  350. Intersection of Two Arrays II
 *   
 *  time complexity: O(n)
 *  space complexity: O(n + m)
 * 
 */

public class IntersectionOfTwoArraysII {
	
	public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> map1 = new HashMap<>();
         HashMap<Integer, Integer> map2 = new HashMap<>();
        
        int[] temp = null;
        if(nums1.length > nums2.length){
            temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        for(int i = 0; i < nums1.length; i++){
            if(map1.containsKey(nums1[i])){
                map1.put(nums1[i], map1.get(nums1[i]) + 1);
            }
            else{
                map1.put(nums1[i], 1);
            }
        }
        
        for(int i = 0; i < nums2.length; i++){
            if(map2.containsKey(nums2[i])){
                map2.put(nums2[i], map2.get(nums2[i]) + 1);
            }
            else{
                map2.put(nums2[i], 1);
            }
        }
        
        // find intersection
        List<Integer> ans = new ArrayList<>();
        for(Integer key : map1.keySet()){
            if(map2.containsKey(key)){
                int n1 = map1.get(key);
                int n2 = map2.get(key);
                int n = Math.min(n1, n2);
                for(int i = 0; i < n; i++){
                    ans.add(key);
                }
            }
        }
        
        int size = ans.size();
        int[] res = new int[size];
        for(int i = 0; i < size; i++){
            res[i] = ans.get(i);
        }
        return res;
    }

}

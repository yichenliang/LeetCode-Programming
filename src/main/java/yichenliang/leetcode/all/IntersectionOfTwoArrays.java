package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  349. Intersection of Two Arrays
 *  
 *  HashSet
 *  
 *  time complexity: O(n)
 *  space complexity: O(n)
 */

public class IntersectionOfTwoArrays {
	
	public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> store = new HashSet<>();
        
        for(int num : nums1){
            if(!store.contains(num)) store.add(num);
        }
        
        List<Integer> res = new ArrayList<>();
        for(int num : nums2){
            if(store.contains(num)){
                res.add(num);
                store.remove(num);
            }
        }
        
        int size = res.size();
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
            ans[i] = res.get(i);
        }
        return ans;
    }

}

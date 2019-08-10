package yichenliang.leetcode.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  992. Subarrays with K Different Integers
 *  
 * 
 * method1: TLE
 * time complexity: o(n^2)
 * space complexity: o(k)
 * 
 * method2: sliding window
 * time complexity: O(n)
 * space complexity: O(n)
 * 
 * 2019/8/9 
 */

public class SubarraysWithKDifferentIntegers {
	
	// method1 : naive solution, TLE
	public int subarraysWithKDistinct(int[] A, int K) {
        Set<Integer> set; 
        int len = A.length;
        int res = 0;
        for(int i = 0; i <= len - K; i++){
            set = new HashSet<>();
            int cur = 0;
            for(int j = i; j < len; j++){
                set.add(A[j]);
                if(set.size() == K){
                   cur++; 
                }
                else if(set.size() > K){
                    break;
                }
            }
            res += cur;
        }
        return res;
    }
	
	
	// method 2: sliding window
	public int subarraysWithKDistinct2(int[] A, int K) {
        return subarrayAtMostK(A, K) - subarrayAtMostK(A, K - 1);   
    }
    
    private int subarrayAtMostK(int[] A, int K){
        int res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        int start = 0, end = 0;
        int len = A.length;
        for(end = 0; end < len; end++){
            if(count.containsKey(A[end])){
                count.put(A[end], count.get(A[end]) + 1);
            }
            else{
                count.put(A[end], 1);
            }
            
            while(count.size() > K){
                count.put(A[start], count.get(A[start]) - 1);
                if(count.get(A[start]) == 0){
                    count.remove(A[start]);
                }
                start++;           
            }
            res += end - start + 1;    
        }
        return res;     
    }

}

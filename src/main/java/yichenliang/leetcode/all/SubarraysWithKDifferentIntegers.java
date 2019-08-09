package yichenliang.leetcode.all;

import java.util.HashSet;
import java.util.Set;

/**
 *  992. Subarrays with K Different Integers
 * 
 * method1: TLE
 * time complexity: o(n^2)
 * space complexity: o(k)
 * 
 * method2: 
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

}

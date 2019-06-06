package yichenliang.leetcode.all;

import java.util.TreeMap;

/**
 * 975. Odd Even Jump
 * 
 * time complexity: O(NlogN)
 * space complexity: O(n)
 * 
 * dynamic programming, TreeMap
 */

public class OddEvenJump {
public int oddEvenJumps(int[] A) {
        
        int len = A.length;
        int[][] dp = new int[len][2];
        
        // dp initial
        dp[len - 1][0] = 1;
        dp[len - 1][1] = 1;
        
        int result = 1; // the last number is always the answer
        
        TreeMap<Integer, Integer> map = new TreeMap<>(); // key : number  value: the samllest index of this value in array A
        
        // dp initial
        map.put(A[len - 1], len - 1);
        
        // dp transfer
        for(int i = len - 2; i >= 0; i--){
            
            // odd dump result
            Integer oddIndex = map.ceilingKey(A[i]);
            if(oddIndex != null){
                dp[i][0] = dp[map.get(oddIndex)][1];
            }
            // else{
            //    dp[i][0] = 0; 
            // }
            
            if(dp[i][0] == 1) result++;
            
            // even dump result
            Integer evenIndex = map.floorKey(A[i]);
            if(evenIndex != null){
                dp[i][1] = dp[map.get(evenIndex)][0];
            }
            // else{
            //     dp[i][1] = 0;
            // }
            
            // update map
            map.put(A[i],i);
        }
       
        return result;
    }
}

package yichenliang.leetcode.withoutTopic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  935. Knight Dialer
 *  
 *  method : dynamic programming
 *  
 *  time complexity: O(n)
 *  space complexity: O(1)
 *  
 */

public class KnightDialer {
	
	public int knightDialer(int N) {
        
        int[] former = new int[10];
        Arrays.fill(former, 1);
        
        Map<Integer, int[]> store = new HashMap<>();
        store.put(0, new int[] {4, 6});
        store.put(1, new int[] {6, 8});
        store.put(2, new int[] {7, 9});
        store.put(3, new int[] {4, 8});
        store.put(4, new int[] {3, 9, 0});
        //store.put(5, null);
        store.put(6, new int[] {1, 7, 0});
        store.put(7, new int[] {2, 6});
        store.put(8, new int[] {1, 3});
        store.put(9, new int[] {2, 4});
        
        for(int i = 2; i <= N; i++){
            int[] current = new int[10];
            for(int k : store.keySet()){
                int[] temp = store.get(k);
                int sum = 0;
                for(int element : temp){
                    sum = (int) ((int)(sum + former[element]) % (1e9 + 7));
                }
                current[k] = sum;
            }
            former = current;
        }
        
        int ans = 0;
        for(int e : former){
            ans = (int) ((int)(ans + e) % (1e9 + 7));
        }
        return ans;
    }
}

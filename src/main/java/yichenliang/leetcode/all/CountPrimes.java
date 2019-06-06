package yichenliang.leetcode.all;

import java.util.Arrays;

/**
 * 204. Count Primes
 * 
 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 * 
 * time complexity: O(n log log n) 
 * space complexity: O(n)
 * 
 */

public class CountPrimes {
	
	public int countPrimes(int n) {
        
        if(n < 3){
            return 0;
        }
        
        int[] store = new int[n];
        Arrays.fill(store, 1);
        store[0] = 0;
        store[1] = 0;
        
        double dn = (double) n;
        int ni = (int) Math.sqrt(dn);
        for(int i = 2; i <= ni; i++){
            if(store[i] == 0){
                continue;
            }
            else{
                for(int j = i*i; j < n; j += i){
                    store[j] = 0;
                }
            }
        }
        
        int ans = 0;
        for(int element : store){
            if(element != 0){
                ans++;
            }
        }
        return ans;
    }

}

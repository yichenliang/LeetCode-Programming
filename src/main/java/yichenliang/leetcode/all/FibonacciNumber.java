package yichenliang.leetcode.all;

/**
 * 509. Fibonacci Number
 * 
 * time complexity: O(n)
 * space complxity: O(1)
 */

public class FibonacciNumber {
	
	public int fib(int N) {
        
        if(N == 0){
            return 0;
        }
        
        if(N == 1){
            return 1;
        }
        
        int a = 0;
        int b = 1;
        int ans = 0;
        for(int i = 2; i <= N; i++){
            ans = a + b;
            a = b;
            b = ans;
        }
        
        return ans;
    }

}

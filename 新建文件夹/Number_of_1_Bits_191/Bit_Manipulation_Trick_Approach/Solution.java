//191. Number of 1 Bits
//Approach #2 Bit Manipulation Trick

// The key idea here is to realize that for any number n, 
//doing a bit-wise AND of n and n-1 flips the least-significant 11-bit in n to 0.

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	
    	  int sum = 0;
    	  while(n!=0) {
    		  sum++;
    		  n = n & (n - 1); 
    	  }
    	    return sum;
    	
    }
    
    public static void main(String[] agrs) {
    	Solution solution = new Solution();
    	int a =   11;
    	int res = solution.hammingWeight(a);
    	System.out.println(res);
    }
    
}



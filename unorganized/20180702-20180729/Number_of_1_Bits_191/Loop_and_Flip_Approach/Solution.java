//191. Number of 1 Bits
//Approach #1 (Loop and Flip) 

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
    	
//      int mask = 1;
//    	for(int i = 0; i < 32; i++) {
//    		if ((mask & n) != 0) sum += 1;
//    		mask = mask << 1;
//    	}
//    	return sum;
    	
    	for(int i = 0; i < 32; i++) {
    		sum += (n & 1);
    		n = n >> 1;
    	}
    	
    	return sum;
    	
    }
    
    public static void main(String[] agrs) {
    	Solution solution = new Solution();
    	int a =   1073741824 ;
    	int res = solution.hammingWeight(a);
    	System.out.println(res);
    }
    
}



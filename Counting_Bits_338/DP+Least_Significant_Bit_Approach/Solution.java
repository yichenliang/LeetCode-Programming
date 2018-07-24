//338. Counting Bits
//Approach #3 DP + Least Significant Bit

public class Solution {
 
	 public int[] countBits(int num) {
	     int[] res = new int[num + 1];
	     res[0] = 0;
	     for(int i = 1; i < num + 1; i++) {
	    	 res[i] =res[i >> 1] + i % 2;    // i % 2 can be written as i & 1
	     }
	     return res;
	 }
    
    public static void main(String[] agrs) {
    	Solution solution = new Solution();
    	int a = 5;
    	int[] rep = solution.countBits(a);
    	System.out.println(rep);
    }
    
}



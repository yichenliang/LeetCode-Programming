//338. Counting Bits
//Approach #4 DP + Last Set Bit

public class Solution {
 
	 public int[] countBits(int num) {
	     int[] res = new int[num + 1];
	     for(int i = 1; i < num + 1; i++) {
	    	 res[i] = res[i & (i - 1)] + 1;
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



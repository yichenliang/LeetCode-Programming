//338. Counting Bits
//Approach 

public class Solution {
 
	public int[] countBits(int num) {
        int bits = 0;
		int[] res = new int[num + 1];
		for(int i = 0; i < num + 1; i++) {
        	bits = bitCount(i);
        	res[i] = bits;
        }
		return res;
    }
    

    public int bitCount(int n) {
    	int sum  = 0; 
    	while(n != 0) {
    		sum++;
    		n = n & (n-1);
    	}
    	return sum;
    }
    
    public static void main(String[] agrs) {
    	Solution solution = new Solution();
    	int a =   5;
    	int[] rep = solution.countBits(a);
    	System.out.println(rep);
    }
    
}



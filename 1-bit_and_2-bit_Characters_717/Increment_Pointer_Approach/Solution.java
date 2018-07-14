//717. 1-bit and 2-bit Characters
//Approach #1: Increment Pointer

class Solution {
    
	   public boolean isOneBitCharacter(int[] bits) {
	        
	    	int i = 0;
	    	while (i < bits.length - 1) {
	    		i += bits[i] + 1;   //!!!  when bits[i] == 1: jump two steps; when bits[i] == 0: jump one step 
	    	} 
	    	return i == bits.length - 1;
	    }
	
       public static void main(String args[]) {
		Solution solution = new Solution();
		int[] bits = {1, 0, 0};  //true
		//int[] bits = {1, 1, 1, 0};  //false
		//int[] bits = {0, 0};       //true
        boolean res = solution.isOneBitCharacter(bits);  
		System.out.println(res);
    }
}

//717. 1-bit and 2-bit Characters
// Approach



class Solution {
    
     public boolean isOneBitCharacter(int[] bits) {
    	 
    	 if(bits.length == 0 || bits == null) return false;
    	 
    	 for(int i = 0; i < bits.length; i++) {
    		 
    		 if(bits[i] == 1) {
    			 if(i < bits.length - 1 && (bits[i + 1] == 1 || bits[i + 1] == 0)) {
    				 i++;
    			 }
    		 }
    		 else if (bits[i] == 0 && i == bits.length - 1) {
    			 return true;
    	     }
    	 }
    	 
    	 return false;
        
    }

	  public static void main(String args[]) {
		
		Solution solution = new Solution();
		int[] bits = {1, 0, 0};
		//int[] bits = {1, 1, 1, 0};
		//int[] bits = {0, 0};
        boolean res = solution.isOneBitCharacter(bits);  
		System.out.println(res);
    }
}

//760. Find Anagram Mappings
//Approach #1: Hash Table (do not consider the case of duplicate)

import java.util.HashMap;

class Solution {
   
      public int[] anagramMappings(int[] A, int[] B) {
    	  HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	  for(int i = 0; i < B.length; i++) {
    		  map.put(B[i], i);
    		 }

    	  int size = A.length;
    	  int[] mapResult = new int[size];	
    	  
    	  for(int i = 0; i < A.length; i++) {
    		  int val = map.get(A[i]);
    		  mapResult[i] = val;
    	  }
        
    	  return mapResult;
    }
	

   public static void main(String args[])
    {
		Solution solution = new Solution();
		int[] inputA = {12, 28, 46, 32, 50};
		int[] inputB = {50, 12, 32, 46, 28};
    	int[] res = solution.anagramMappings(inputA, inputB);
    	System.out.println(res);
    }
}
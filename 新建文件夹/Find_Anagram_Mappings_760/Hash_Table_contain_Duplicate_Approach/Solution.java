//760. Find Anagram Mappings
//Approach #2: Hash Table (consider the case of duplicate)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
   
	public int[] anagramMappings(int[] A, int[] B) {
	    int[] result = new int [A.length];
	    Map<Integer, List<Integer>> map = new HashMap<>();
	    for(int i = 0; i < B.length; i++) {
	        map.computeIfAbsent(B[i], k -> new ArrayList<>()).add(i);
	    }
	    for(int i = 0; i < A.length; i++) {
	        result[i] = map.get(A[i]).remove(map.get(A[i]).size()-1);
	    }
	    return result;
	}
	

   public static void main(String args[])
    {
		Solution solution = new Solution();
		int[] inputA = {10,20,10};
		int[] inputB = {10,10,20};
    	int[] res = solution.anagramMappings(inputA, inputB);
    	System.out.println(res);
    }
}


// computeIfAbsent Example: http://www.topjavatutorial.com/java-8/java-8-map-computeifabsent/

//in inputB, when the first 10 is tested by computeIfAbsent, 
//the function(k -> new ArrayList<>()) is activated and create a new ArrayList as the value of 10(key)
//the return value of computIfAbsent is this newly created ArrayList, then add i to this ArrayList.
 
//then in inputB, the second 10 comes to the computeIfAbsent test, because the key of 10 is already existed, 
//the function is not activated. Only add i to the existed ArrayList.

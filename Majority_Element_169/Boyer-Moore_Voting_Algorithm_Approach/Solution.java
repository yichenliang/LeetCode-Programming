//169. Majority Element
//Approach 6: Boyer-Moore Voting Algorithm

public class Solution {
    
       public int majorityElement(int[] nums) {
    	
    	        int count = 0;
    	        Integer candidate = null;
    	       // int candidate = 0;

    	        for (int num : nums) {
    	            if (count == 0) {
    	                candidate = num;
    	            }
    	            count += (num == candidate) ? 1 : -1;
    	        }

    	        return candidate;
    	    }
        
   
    public static void main(String[] agrs) {
    	Solution solution = new Solution();
    	int[] input = {2,2,1,1,1,2,2};
    	int rep = solution.majorityElement(input);
    	System.out.println(rep);
    }
    
}


//169. Majority Element
//Approach 3: Sorting

import java.util.Arrays;
public class Solution {
    
    public int majorityElement(int[] nums) {
        
    	Arrays.sort(nums);
        return nums[nums.length/2];
        
    }
   
    
    public static void main(String[] agrs) {
    	Solution solution = new Solution();
    	int[] input = {2,2,1,1,1,2,2};
    	int rep = solution.majorityElement(input);
    	System.out.println(rep);
    }
    
}

// Time complexity : O(nlgn)
// Sorting the array costs O(nlgn) time in Java, so it dominates the overall runtime.
//217. Contains Duplicate
//HashMap Approach 


import java.util.Map;
import java.util.HashMap;
class Solution {
  
    public boolean containsDuplicate(int[] nums) {
      
     if (nums == null || nums.length == 0 || nums.length == 1) return false;
      
      //Arrays.sort(nums);  // unnecessary
      Map<Integer, Integer> map = new HashMap<>();
      map.put(nums[0],nums[0]);
      
      for(int i = 1; i < nums.length; i++) {
    	  
    	  if(map.containsKey(nums[i])) return true;
    	  else {
    		  map.put(nums[i],nums[i]);
    	  }
    	
    	  
      }
      return false;	
    
    }
    
    
    public static void main(String[] args) {
    	
    	Solution solution = new Solution();
    	int[] input = {3,3};
    	//int[] input = {1,2,3,1};
    	//int[] input = {1,2,3,4};
    	//int[] input = {1,1,1,3,3,4,3,2,4,2};
       boolean res = solution.containsDuplicate(input);
       System.out.println(res);
       
    }
}
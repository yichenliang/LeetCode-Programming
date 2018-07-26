import java.util.HashMap;
import java.util.Map;

//169. Majority Element
//Approach 2: HashMap

public class Solution {
    
	public int majorityElement(int[] nums) {
	   
		Map<Integer,Integer> countNumber = new HashMap<>();
	   
		for(int num : nums) {
		   if(!countNumber.containsKey(num)) {
			   countNumber.put(num, 1);
			   }
		   else {
			   countNumber.put(num, countNumber.get(num) + 1);
		       }
		   }
		
		
		Map.Entry<Integer, Integer> majorityE = null;
		for(Map.Entry<Integer, Integer> entry: countNumber.entrySet()) {      //!!!!!!Map.Entry
			if(majorityE == null || (entry.getValue() > majorityE.getValue())) {
				majorityE = entry;
			}
		}
		
		return majorityE.getKey();
	   }
	   
	
   
    
    public static void main(String[] agrs) {
    	Solution solution = new Solution();
    	int[] input = {2,2,1,1,1,2,2};
    	int rep = solution.majorityElement(input);
    	System.out.println(rep);
    }
    
}



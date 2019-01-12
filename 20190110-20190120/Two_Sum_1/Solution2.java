// Approach 3: One-pass Hash Table
public int[] twoSum(int[] nums, int target) {
   Map<Integer, Integer> map = new HashMap<>();
   for (int i = 0; i < nums.length; i++){
	  int rest_value = target - nums[i];
	  if(map.containsKey(rest_value)){
		  return new int[]{i, map.get(rest_value)};
	  }
	  else{
		  map.put(nums[i], i);
	  }
   }
   return null;
}

// Time complexity: O(n)
// Space complexity: O(n)
// Approach 2: Two-pass Hash Table

public int[] twoSum(int[] nums, int target) {
	Map<Integer, Integer> map = new HashMap<>();
	for(int i = 0; i < nums.length; i++) {
		map.put(nums[i], i);
	}
	
	for(int i = 0; i < nums.length; i++){
		rest_value = target - nums[i];
		if(map.containsKey(rest_value) && map.get(rest_value) != i){
			return new int[] {i, map.get(rest_value)};
		}
	}
	return new IllegalArgumentException("No two sum solution");
	
}
    
// Time complexity: O(N)
// Space complexity: O(N)
class Solution {
	
	public int threeSumClosest(int[] nums, int target) {
        
		if(nums == null || nums.length == 0) return target;        

        Arrays.sort(nums);
        int delta = nums[0] + nums[1] + nums[2] - target;
        
        
        for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int newDelta = nums[i] + nums[left] + nums[right] - target;
                if(newDelta == 0) return target;
                if(Math.abs(newDelta) < Math.abs(delta)) delta = newDelta;
                if(newDelta < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        
        return target + delta;
        
    }
}

// time complexity: O(n^2)
// space complexity: O(1)
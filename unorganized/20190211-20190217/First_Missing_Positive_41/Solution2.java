
public class Solution {
	
	public int firstMissingPositive(int[] nums) {
		if(nums == null || nums.length == 0) return 1;
		for(int i = 0; i < nums.length; i++) {
			while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		}
	      
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}
  
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		
		//int[] nums = {99, 100, 101};
		//int[] nums = {1,2,0};
		//int[] nums = {3,4,-1,1};
		int[] nums = {1,3,4};
		//int[] nums = {1,98,97};
		int result =  solution.firstMissingPositive(nums);
		
		System.out.println(result);
    }
}

// time complexity: o(n)
// space complexity: o(1)
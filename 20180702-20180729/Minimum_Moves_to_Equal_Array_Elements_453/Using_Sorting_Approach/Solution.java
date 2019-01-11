import java.util.Arrays;

//453. Minimum Moves to Equal Array Elements
//Approach

class Solution {
    
	public int minMoves(int[] nums) {
		
		Arrays.sort(nums);
		int size = nums.length;
		int count = 0;
		for(int i = size - 1; i > 0; i--) {
			count += nums[i] - nums[0];
		}
        return count; 
		
		}
	
	
       public static void main(String args[]) {
		Solution solution = new Solution();
		int[] input = {7,9,12,13};
		//int[] input = {1,2,3,4,5};
		//int[] input = {1,2,3};
		//int[] input = {1,1,1};  //the answer produced by this approach is wrong!!
        int res = solution.minMoves(input);  
		System.out.println(res);
    }
}

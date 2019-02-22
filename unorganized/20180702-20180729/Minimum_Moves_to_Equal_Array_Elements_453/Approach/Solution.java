import java.util.Arrays;

//453. Minimum Moves to Equal Array Elements
//Approach

class Solution {
    
	public int minMoves(int[] nums) {
      
		int count = 0; // count the number of minMoves
		int size = nums.length;
		int increment = 0;
		int i = 0;
		
		if(size == 1) {
			return 0;
		}
		
		if(size == 2) {
			return nums[1]-nums[0];
		}
		
		while (true) {
			
			Arrays.sort(nums);
			
			if( nums[size-1] - 1 == nums[0] && nums[0] == nums[size-2]) {
				count++;
				return count;
			}
			
			else if(nums[size-1] > nums[size-2]){
				increment = nums[size-1] - nums[size-2] + 1;
				for (i = 0; i < size - 1; i++) {
					nums[i] = nums[i] + increment;
				}
				count = count + increment;
			}
			
			else if(nums[size - 1] == nums[size - 2]) {
			   for(i = 0; i < size - 1; i++) {
				  nums[i] += 1;  
			   }
			   count += 1; 
			}
			
		  }
		}
	
	
	
       public static void main(String args[]) {
		Solution solution = new Solution();
		//int[] input = {7,9,12,13};
		//int[] input = {1,2,3,4,5};
		//int[] input = {1,2,3};
		int[] input = {1,1,1};  //the answer produced by this approach is wrong!!
        int res = solution.minMoves(input);  
		System.out.println(res);
    }
}

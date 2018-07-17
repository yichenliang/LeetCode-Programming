//280. Wiggle Sort
//dumb Approach

import java.util.Arrays;
public class Solution {
	 
	public void wiggleSort(int[] nums) {
	    
		if(nums == null) return;
		
	    Arrays.sort(nums);
		int size = nums.length;
		int[] wiggleNums = new int[size];
		
		if(size == 1 || size == 0) return;
		
			int mid = size/2;
			int point = 0;
			if(size % 2 != 0) mid = mid + 1;
			for(int i = 0; i < size; i+=2) {
				wiggleNums[i] = nums[point];
				if(i == size - 1) break;
				wiggleNums[i+1] = nums[point + mid];
				point++;
				}
			for(int i = 0; i < size; i++) {
				nums[i] = wiggleNums[i];
			}
			
			}

		
		
		
	  public static void main(String args[]) {
		
		Solution solution = new Solution();
		int[] input = {1,2,4,3,7,6,5};
		solution.wiggleSort(input);
		System.out.println(input);
    }
}

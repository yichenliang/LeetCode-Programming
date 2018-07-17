//280. Wiggle Sort
//Approach #2 One-pass Swap considering even-odd position

public class Solution {
	 
	public void wiggleSort(int[] nums) {
	    
		for(int i = 0; i < nums.length - 1; i++) {
			if( ( (i % 2 == 0) && (nums[i] > nums[i+1]) ) || ( (i % 2 == 1) && (nums[i] < nums[i+1]) ) ) {
				swap(nums, i, i+1);
			}
		}
	}
	
	private void swap(int[] nums, int i, int j) {
	    int temp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = temp;
	}
		
	  public static void main(String args[]) {
		
		Solution solution = new Solution();
		int[] input = {3,1,2,6,7,5,4};
		solution.wiggleSort(input);
		System.out.println(input);
    }
}

package yichenliang.leetcode.withoutTopic;

/**
 *  75. Sort Colors
 *  
 *  time complexity: O(n)
 *  space complexity: O(1)
 *  
 */

public class SortColors {
	public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        int len = nums.length;
        int p0 = 0;
        while(p0 < len && nums[p0] == 0){
            p0++;
        }
        int p2 = len - 1;
        while(p2 >= 0 && nums[p2] == 2){
            p2--;
        }
        int index = p0;
        while(index <= p2){
            if(nums[index] == 1){
                index++;
            }
            else if(nums[index] == 0){
                swapNumber(index, p0, nums);
                p0++;
                index++;
            }
            else{
                swapNumber(index, p2, nums);
                p2--;
            }    
        }
    }
    
    private void swapNumber(int n1, int n2, int[] nums){
        int temp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = temp; 
    }

}

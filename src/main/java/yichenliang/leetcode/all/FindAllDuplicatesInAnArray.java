package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 * 
 * Array
 * 
 * time complexity: O(n)
 * space complexity: O(1)
 * 
 */

public class FindAllDuplicatesInAnArray {
	
	public List<Integer> findDuplicates(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < len; i++){
            int index = i;
            while(nums[index] != -1 && nums[index] != index + 1){
                if(nums[nums[index] - 1] == nums[index]){
                    res.add(nums[index]);
                    nums[index] = -1;
                }
                else{ // swap
                    int temp = nums[index];
                    nums[index] = nums[temp - 1];
                    nums[temp - 1] = temp;
                }     
            }
        }
        return res;
    }
}

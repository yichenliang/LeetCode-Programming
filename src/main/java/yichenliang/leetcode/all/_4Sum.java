package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 * 
 *  two pointers
 *
 *  time complexity: O(n^3)
 *  space complexity: O(1)
 */

public class _4Sum {
	
public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length < 4){
            return ans;
        }
        
        Arrays.sort(nums);
        int len = nums.length;
        // change to 3 sum
        for(int i = 0; i < len - 3; i++){
            if(i == 0 || nums[i] != nums[i - 1]){
                // change to 2 sum
                for(int j = i + 1; j < len - 2; j++){
                    if(j == i + 1 || nums[j] != nums[j - 1]){
                        // two sum problem
                        int low = j + 1;
                        int high = len - 1;
                        int newTarget = target - nums[i] - nums[j];
                        while(low < high){
                            if(nums[low] + nums[high] == newTarget){
                                // find one
                                ans.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                                while(low < high && nums[low] == nums[low + 1]) low++;
                                while(low < high && nums[high] == nums[high - 1]) high--;
                                low++;
                                high--;
                            }
                            else if(nums[low] + nums[high] > newTarget){
                                high--;
                            }
                            else{
                                low++;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

}

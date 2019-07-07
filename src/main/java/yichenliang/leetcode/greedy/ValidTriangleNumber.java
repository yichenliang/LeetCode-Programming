package yichenliang.leetcode.greedy;

import java.util.Arrays;

/**
 *  611. Valid Triangle Number
 *  
 *  Greedy
 *  
 *  time complexity: O(n^2)
 *  space complexity: O(1)
 */

public class ValidTriangleNumber {
	
	public int triangleNumber(int[] nums) {
        
        if(nums == null || nums.length <= 2){
            return 0;
        }
        Arrays.sort(nums);
        int ans = 0;
        int a, b, c;
        int len = nums.length;
        for(int i = len - 1; i >= 2; i--){
            c = nums[i];
            b = i - 1;
            a = 0;
            while(b > a){
                int numb = nums[b];
                int numa = nums[a];
                if(c < numb + numa){
                    ans += b - a;
                    b--;
                }
                else{
                    a++;
                }
            }
        }
        return ans;
    }

}

package yichenliang.leetcode.all;

import java.util.Arrays;

/**
 *  480. Sliding Window Median
 *   
 *  time complexity: O((n - k + 1)*k)
 *  space complexity: O(k)
 * 
 */

public class SlidingWindowMedian {
	
	public double[] medianSlidingWindow(int[] nums, int k) {
	      
        int len = nums.length;
        double[] ans = new double[len - k + 1];
        long[] window = new long[k];
        for(int i = 0; i < k; i++){
            window[i] = (long)nums[i];
        }
        
        Arrays.sort(window);
        
        int mid = k / 2;
        int index = 0;
        
        
        for(int i = k; i < len; i++){
        	if(k % 2 == 0){
                ans[index] = (double)(window[mid - 1] + window[mid]) / 2;
            }
            else{
                ans[index] = (double) window[mid];
            }
        	index++;
            remove(window, nums[i - k]);
            insert(window, nums[i]);
            
        }
        
        if(k % 2 == 0){
            ans[index] = (double) (window[mid] + window[mid - 1]) / 2;
        }
        else{
            ans[index] = (double)window[mid];
        }
        
        return ans;    
    }
    
    void remove(long[] w, int number){
        int index = 0;
        for(int i = 0; i < w.length; i++){
            if(number == w[i]){
                index = i;
                break;
            }
        }
        
        for(int i = index; i < w.length - 1; i++){
            w[i] = w[i + 1];
        }
        
    }
    
    void insert(long[] w, int number){
        int index = 0;
        if(number < w[0]){
            index = 0;
        }
        else if(number >= w[w.length - 1]){
            index = w.length - 1;
        }
        else{
            for(int i = 0; i < w.length; i++){
                if(number < w[i]){
                    index = i;
                    break;
                }
            }
        }
        
        
        for(int i = w.length - 1; i > index; i--){
            w[i] = w[i - 1];
        }
        w[index] = number;
    }    
}

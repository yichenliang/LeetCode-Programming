package yichenliang.leetcode.design;

import java.util.Random;

/**
 *  384. Shuffle an Array
 *  
 *  Design + Random
 *  
 *  time complexity: O(n)
 *  space complexity: O(n)
 *  
 */

public class ShuffleAnArray {
	
	class Solution {
	    private int[] oriArr;
	    private Random rand;
	    private int[] arr;
	    private int len = 0;
	    
	    public Solution(int[] nums) {
	        len = nums.length;
	        arr = new int[len];
	        oriArr = new int[len];
	        for(int i = 0; i < len; i++){
	            oriArr[i] = nums[i];
	            arr[i] = nums[i];
	        }
	        rand = new Random();
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	       for(int i = 0; i < len; i++){
	          arr[i] = oriArr[i];
	       }
	       return arr;  
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	        int len = arr.length;
	        for(int i = 0; i < len; i++){
	            int j = randRange(i, len);
	            swap(i, j);
	        }
	        return arr;
	    }
	    
	    private int randRange(int i, int j){
	        return rand.nextInt(j - i) + i;
	    }
	    
	    private void swap(int i, int j){
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }
	}

}

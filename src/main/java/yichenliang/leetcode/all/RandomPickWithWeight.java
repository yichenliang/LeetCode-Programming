package yichenliang.leetcode.all;

import java.util.Random;

/**
 *  528. Random Pick with Weight
 *  
 *  binary search
 *  
 *  time complexity: O(logn)
 *  space complexity: O(n)
 * 
 */

public class RandomPickWithWeight {
	
	class Solution {
	    
	    Random randGenerate;
	    int[] wSum;
	    
	    public Solution(int[] w) {
	        this.randGenerate = new Random();
	        for(int i = 1; i < w.length; i++){
	            w[i] = w[i] + w[i-1];
	        }
	        this.wSum = w;
	    }
	    
	    public int pickIndex() {
	        int len = wSum.length;
	        int randIdx = randGenerate.nextInt(wSum[len-1]) + 1;
	        int left = 0, right = len - 1;
	        
	        // search position
	        while(left < right){
	            int mid = left + (right - left)/2;
	            
	           if(wSum[mid] < randIdx){
	                left = mid + 1;
	            }
	            else if(wSum[mid] >= randIdx){
	                right = mid;
	            }
	        }
	        return left;
	    }
	}
}

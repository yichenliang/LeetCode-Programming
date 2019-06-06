package yichenliang.leetcode.all;

/**
 * 135. Candy
 * 
 * Greedy
 * 
 * time complexity: O(n)
 * 
 */

public class Candy {
	
	 public int candy(int[] ratings) {
	        
	        int len = ratings.length;
	        int[] candies = new int[len];
	        
	        for(int i = 1; i < len; i++){
	            if(ratings[i] > ratings[i - 1]){
	                candies[i] = candies[i - 1] + 1;
	            }
	        }
	        
	        for(int i = len - 2; i >= 0; i--){
	            if(ratings[i] > ratings[i + 1]){
	                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
	            }
	        }
	        
	        int res = 0;
	        for(int i = 0; i < len; i++){
	            res += candies[i] + 1;
	        }
	        return res;
	    }
}

//122. Best Time to Buy and Sell Stock II

//Approach 3: Simple One Pass
class Solution {
    public int maxProfit(int[] prices) {
    	
      int current = 0;
      int profit = 0;
      
      while (current < prices.length -1) {
    	  
    	  if (prices[current] <= prices[current +1]) {
    		  profit += prices[current +1] - prices[current];
    		  current++;
    	  }
    	  else {
    		  current++;
    	  }
      }

       return profit;
        
    }
    
    public static void main(String[] args) {
   	 
   	Solution solution = new Solution();
   	
   	int[] input = {7,1,5,3,6,4};    //7
   	
//   	int[] input = {2,4,9,11};      //9
   	
//   	int[] input = {3,1,1,1,2,1,1,1,7};    //7
   	
//   	   int[] input = {7,6,5,4,3,2};
   	
   	int output = solution.maxProfit(input);
   	
   	System.out.println(output);
  }
}
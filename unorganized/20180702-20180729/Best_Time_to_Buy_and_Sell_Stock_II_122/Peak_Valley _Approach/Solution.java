//122. Best Time to Buy and Sell Stock II

//Approach 2: Peak Valley Approach
class Solution {
    public int maxProfit(int[] prices) {
    	
      int current = 0;
      int buy = 0;
      int sell = 0;
      int profit = 0;
      while (current < prices.length - 1) {
    	  
    	  while (current < prices.length - 1 && prices[current] >= prices[current + 1]) {
    		 current++;
    	  }
    	 buy = prices[current];
    	 
    	 while (current < prices.length - 1 && prices[current] <= prices[current + 1]) {
    		 current++;
    	  }
    	 sell = prices[current];
    	 
    	profit += sell - buy;
    	  
      }
      
      return profit;
        
    }
    
    public static void main(String[] args) {
   	 
   	Solution solution = new Solution();
   	
 //  	int[] input = {7,1,5,3,6,4};    //7
   	
//   	int[] input = {2,4,9,11};      //9
   	
   	int[] input = {3,1,1,1,2,1,1,1,7};    //7
   	 
   	int output = solution.maxProfit(input);
   	
   	System.out.println(output);
  }
}

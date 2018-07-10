//198. House Robber
//Approach #1 (Dynamic Programming)


class Solution {
	
    public int rob(int[] nums) {
    	
    	//f(k) = max(f(n ¨C 2) + An, f(n ¨C 1))
    	int preMax = 0; // f(n-2)
    	int curMax = 0; // f(n-1)
    	
    	for(int num : nums) {
    		//preMax = curMax;
    		int temp = curMax;
    		curMax = Math.max(num + preMax, curMax);
            preMax = temp;
    	}
    	return curMax;
        
    }
	
//	public int rob(int[] num) {
//	    int prevMax = 0;
//	    int currMax = 0;
//	    for (int x : num) {
//	        int temp = currMax;
//	        currMax = Math.max(prevMax + x, currMax);
//	        prevMax = temp;
//	    }
//	    return currMax;
//	}
   
//   public int rob(int[] nums) {
//	   
//	   int i = 0;
//	   int sum = 0;
//	   int formerSum = 0;
//	   for (i = 0; i < nums.length / 2; i++) {
//		   formerSum = sum;
//		   sum = nums[i] + restSum(nums, i+2, sum);
//		   sum = Math.max(formerSum, sum);
//		   }
//	   
//	   return sum;
//     }
//   
//    int restSum(int[] numsArr, int j, int result) {
//    	int k = 0;
//    	//int result = 0;
//    	int formerResult = 0;
//        for (k = j; k < numsArr.length; k++ ) {
//        	
//            formerResult = result;     // last round result
//        	
//        	if(k == numsArr.length - 1) {
//        		return numsArr[k];
//        	}
//        	
//        	else if(k == numsArr.length - 2) {
//        		return Math.max(numsArr[k], numsArr[k+1]);
//        	}
//        	
//        	else{result = numsArr[k] + restSum(numsArr, k+2, result);   // newly created result
//        	result = Math.max(formerResult, result);
//        	}
//        	}
//        return result;
//    }

   public static void main(String args[])
    {
		Solution solution = new Solution();
		//int[] input = {1,2,3,1};
		int[] input = {2,7,9,3,1};
		int res = solution.rob(input);
		System.out.println(res);
    }
}



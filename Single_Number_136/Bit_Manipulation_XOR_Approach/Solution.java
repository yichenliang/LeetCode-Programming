//136. Single Number

//Approach 4: Bit Manipulation (XOR)

class Solution {
	
    public int singleNumber(int[] nums) {
        
    	int res = nums[0];
    	for(int i =1; i < nums.length; i++) {
    		res = res^nums[i];
    	}
    	return res;
    }
	
	
	
    public static void main(String[] args) {
   	 
   	Solution solution = new Solution();
    int[] input = {2,2,1};
    //int[] input = {2,2,3,4,3,4,5};
    //int[] input = {1};   
    int res = solution.singleNumber(input);
   	System.out.println(res);
  }

}


/*
 * properties of XOR:
 * X^0 = X
 * X^X = 0
 * X^Y = Y^X
 * X^(Y^Z) = (X^Y)^z
 * https://www.lijinma.com/blog/2014/05/29/amazing-xor/
 * 
 * when zero or one XOR with one, they will get the opposite number.
 * 0 ^ 1 = 1
 * 1 ^ 1 = 0 
 * 
 * when zero or one XOR with zero, they will remain the same.
 * 0 ^ 0 = 0
 * 1 ^ 0 = 1  
 */






















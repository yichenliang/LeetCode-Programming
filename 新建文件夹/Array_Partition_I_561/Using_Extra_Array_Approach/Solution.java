//561. Array Partition I

//Approach #3 Using Extra Array

//import java.util.Arrays;
class Solution {
	
	    public int arrayPairSum(int[] nums) {
	        int[] arr = new int[20001];               // -10000, -9999, ... ,     0,     1,     2, ... , 10000    (10000+10000+1 = 20001)          
	        int lim = 10000; //lim: help mapping      //   0        1 , ... , 10000, 10001, 10002, ... , 20000
	        for (int num: nums)
	            arr[num + lim]++;
	        int d = 0, sum = 0;
	        for (int i = -10000; i <= 10000; i++) {      //d = 0 : do not have impact on the following result; d = 1: have impact on the following result  
	            sum += (arr[i + lim] + 1 - d) / 2 * i;
	            d = (2 + arr[i + lim] - d) % 2;          //the value of d depends on the frequent of certain number and the former value of d
	        }
	        return sum;
	    }
	
	
    public static void main(String[] args) {
   	 
   	Solution solution = new Solution();
    //int[] input = {1,4,3,2};
   	//int[] input = {1,1,1,2,2,2};
   	int[] input = {1,1,1,2,2,2,2,3};
    int res = solution.arrayPairSum(input);
   	System.out.println(res);
  }

}
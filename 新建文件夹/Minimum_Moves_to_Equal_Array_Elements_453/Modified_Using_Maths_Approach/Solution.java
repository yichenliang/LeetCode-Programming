//453. Minimum Moves to Equal Array Elements
//Approach #6 Modified Approach Using Math 

class Solution {
    
	
	    public int minMoves(int[] nums) {
	        int moves = 0, min = Integer.MAX_VALUE;
	        for (int i = 0; i < nums.length; i++) {
	            min = Math.min(min, nums[i]);
	        }
	        for (int i = 0; i < nums.length; i++) {
	            moves += nums[i] - min;
	        }
	        return moves;
	    }
	
	
	
       public static void main(String args[]) {
		Solution solution = new Solution();
		//int[] input = {9,12,7,13};
		//int[] input = {1,2,3,4,5};
		int[] input = {1,2,3};
		//int[] input = {1,1,1};  //the answer produced by this approach is wrong!!
        int res = solution.minMoves(input);  
		System.out.println(res);
    }
}

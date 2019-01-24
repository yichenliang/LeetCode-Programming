public class Solution {
	
		public int reverse(int x) {
            int result = 0;
            int tail = 0;
            int newResult = 0;
            while(x != 0) {
            	tail =x % 10;
            	newResult = result*10 + tail;
            	if((newResult - tail)/10 != result) {
            		return 0;
            	}
            	result = newResult;
            	x = x/10;
            }
            return result;
		}
      	
	    
	
		public static void main(String[] args) {
		Solution solution = new Solution();
		
		int i = -123;
		
		int result = solution.reverse(i);
		
		System.out.println(result);
     }
}


// time complexity: O(N)
// space complexity: O(1)



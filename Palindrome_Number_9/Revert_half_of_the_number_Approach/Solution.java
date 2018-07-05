
class Solution {
    public boolean isPalindrome(int x) {
    	
    	
    	if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
    	
    	int reverse = 0;
    	while (reverse < x) {
    		reverse = x % 10 + reverse * 10;
    		x = x / 10;
    	}
    	
     	return reverse == x || reverse/10 == x;
    }
    
//     after the while loop, x and reverse become the following number:
//      example:  1 2 3 2 1         
//                --->
//                x=12    
//                    <----
//                     reverse = 123
//
//  When the example number is odd, we can get rid of the middle digit by reverse/10
//  For example when the input is 12321, at the end of the while loop we get x = 12, reverse = 123,
//  since the middle digit doesn't matter in palindrome(it will always equal to itself), we can simply get rid of it.
//
//  when the input number is even: 1221, then x = 12, reverse = 12.
    
	
	public static void main(String args[])
    {
		Solution solution = new Solution();
		int input = 23432;
    	boolean res = solution.isPalindrome(input);
    	System.out.println(res);
    }
}
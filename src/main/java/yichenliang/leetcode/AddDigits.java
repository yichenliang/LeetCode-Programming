package yichenliang.leetcode;

/**
 * 258. Add Digits
 * 
 *  Math
 *
 *  any number that is divisible by 9, 
 *  the sum of the digits in the number is also divisible by 9
 */

public class AddDigits {
	
	public int addDigits(int num) {
        
        if(num < 9) return num;
        
        if(num%9 == 0) return 9;
        
        return num%9;
        
    }

}

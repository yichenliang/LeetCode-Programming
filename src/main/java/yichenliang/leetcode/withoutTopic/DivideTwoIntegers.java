package yichenliang.leetcode.withoutTopic;

/**
 *  29. Divide Two Integers
 * 
 *  Math + Binary Search
 *  
 *  time complexity: O(logN)
 *  space complexity: O(1)
 */

public class DivideTwoIntegers {
	
	public int divide(int dividend, int divisor) {
        
        if(dividend == 0){
            return 0;
        }
        
        if(dividend == Integer.MIN_VALUE){
            if(divisor == 1){
                return dividend;
            }
            if(divisor == -1){
                return Integer.MAX_VALUE;
            }
        }
        
        if(divisor == 1){
            return dividend;
        }
        
        long divid = (long) dividend;
        long divis = (long) divisor;
        
        int sign = 1;
        if(divid < 0){
            divid = -divid;
            sign = -sign;
        }
        
        if(divis < 0){
            divis = -divis;
            sign = -sign;
        }
        
        int res = 0;
        while(divid >= divis){
            long num = 1;
            long currentDivis = divis;
            while(divid >= currentDivis){
                num = num << 1;
                currentDivis = currentDivis << 1;
            }
            num = num >> 1;
            res += num;
            divid = divid - (currentDivis >> 1);  
        }
        
        if(sign > 0){
            return res;
        }
        return -res;
    }

}

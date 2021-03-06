package yichenliang.leetcode.all;

/**
 * 50. Pow(x, n)
 * 
 * Math
 * 
 * time complexity: O(longN)
 * space complexity: O(1)
 */

public class PowXN{
	public double myPow(double num, int power) {
        //egde case
        if(num == 1 || power == 0) return 1;
        if(power == 1) return num;
        
        // normal case 
        if(power < 0){
            return 1/(num*myPow(num, -(power+1)));
        }
        
        double res = 1;
        while(power > 1){
            if(power%2 == 1){
                res = res * num;
                power = power - 1;
            }
            num = num * num;
            power = power / 2;
        }
        res = res * num * 1;
        return res;
    }
	
}

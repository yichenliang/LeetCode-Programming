package yichenliang.leetcode.binarySearch;

/**
 *  69. Sqrt(x)
 *  
 *  Binary Search
 *  
 *  time complexity: O(n)
 *  space complexity: O(n)
 * 
 */

public class Sqrt_x {
	
	// best method, use the binary search template
	public int mySqrt(int x) {
        int l = 1;
        int r = Integer.MAX_VALUE / 2;
        while(l < r){
            int m = l + (r - l) / 2;
            if(m > x/m){
                r = m;
            }
            else{
                l = m + 1;
            }
        }
        return l - 1;
    }
	
	public int mySqrt2(int x) {
        int cur = 0;
        int res = 0;
        int add = 1;
        while(cur <= x){
            if(cur > Integer.MAX_VALUE - add){
                return res;
            }
            cur += add;
            res++;
            add += 2;
        }
        return res - 1;
    }

}

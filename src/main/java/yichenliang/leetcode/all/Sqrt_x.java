package yichenliang.leetcode.all;

/**
 *  767. Reorganize String
 *  
 *  time complexity: O(n)
 *  space complexity: O(n)
 * 
 */

public class Sqrt_x {
	
	public int mySqrt1(int x) {
        if(x == 0){
            return 0;
        }
        int end = (int) Math.sqrt(Integer.MAX_VALUE);
        int start = 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(mid * mid == x) return mid;
            if(mid * mid < x){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(end * end <= x){
            return end;
        }
        else{
            return start;
        }
        
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

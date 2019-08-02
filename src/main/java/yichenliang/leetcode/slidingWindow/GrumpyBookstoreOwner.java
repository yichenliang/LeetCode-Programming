package yichenliang.leetcode.slidingWindow;

/**
 *  1052. Grumpy Bookstore Owner
 *  
 *  Sliding Window
 *  
 *  time complexity: O(n)
 *  space complexity: O(1)
 *  
 *  2019/7/13
 */

public class GrumpyBookstoreOwner {

	// naive solution
	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int base = 0;
        int len = customers.length;
        for(int i = 0; i < len; i++){
            if(grumpy[i] == 0) base += customers[i];
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0; i <= len - X; i++){
            int extra = 0;
            for(int j = i; j < i + X; j++){
                if(grumpy[j] == 1) extra += customers[j];
            }
            res = Math.max(res, base + extra);
        }
        return res;
    }
	
	// sliding window
	public int maxSatisfied1(int[] customers, int[] grumpy, int X) {
        int base = 0;
        int len = customers.length;
        for(int i = 0; i < len; i++){
            if(grumpy[i] == 0) base += customers[i];
        }
        int res = Integer.MIN_VALUE;
        int extra = 0;
        for(int i = 0; i < X; i++){
            if(grumpy[i] == 1) extra += customers[i];
        }
        res = Math.max(res, base + extra);
        for(int i = 1; i <= len - X; i++){
            if(grumpy[i - 1] == 1) extra -= customers[i - 1];
            if(grumpy[i + X - 1] == 1) extra += customers[i + X - 1];
            res = Math.max(res, base + extra);
        }
        return res;
    }
}

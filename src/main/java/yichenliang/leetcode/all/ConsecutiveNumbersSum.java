package yichenliang.leetcode.all;

/**
 *  829. Consecutive Numbers Sum
 * 
 *  https://leetcode.com/problems/consecutive-numbers-sum/discuss/209317/topic
 */

public class ConsecutiveNumbersSum {
	
	public int consecutiveNumbersSum(int N) {
        
        int ans = 0;
        
        int m = 1;
        
        while(true){
            int mx = N - m*(m-1)/2;
            
            if(mx <= 0){
                break;
            }
            
            if(mx % m == 0){  // means there are exist a valid starting number x
                ans++;
            }
            m++;
        }
        
        return ans;
    }

}

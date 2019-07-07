package yichenliang.leetcode.math;

/**
 *  829. Consecutive Numbers Sum
 *  
 *  Math + using the equation of Arithmetic progression
 * 
 *  https://leetcode.com/problems/consecutive-numbers-sum/discuss/209317/topic
 *  
 *  time complexity: O(sqrt(N))
 *  space complexity: O(1)
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

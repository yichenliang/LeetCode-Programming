package yichenliang.leetcode.all;

/**
 *  202. Happy Number
 *  
 *  time complexity: O(logN)
 *  space complexity: O(1)
 * 
 */

public class HappyNumber {
	
	
	// could pass all testcases, but the method is wrong
	public boolean isHappy1(int n) {
        
        if( n == 1){
            return true;
        }
        
        if(n == 7){
            return true;
        }
        
        if(n >= 2 && n <= 9){
            return false;
        }
        
        int num = 0;
        while(n > 0){
            int temp = n % 10;
            num += temp*temp;
            n = n / 10;
        }
        
        return isHappy1(num);
        
    }
	
	// correct method using two pointer: slow and fast
	public boolean isHappy(int n) {
        
        if(n == 1){
            return true;
        }
        
        int slow = n;
        int fast = n;
        slow = calculate(slow);
        fast = calculate(fast);
        fast = calculate(fast);
        while(slow != fast){
            slow = calculate(slow);
            fast = calculate(fast);
            fast = calculate(fast);
        }
        
        return slow == 1;
        
    }
    
    int calculate(int num){
        int sum = 0;
        while(num != 0){
            int temp = num % 10;
            sum += temp * temp;
            num = num / 10;
        }
        return sum;
    }

}

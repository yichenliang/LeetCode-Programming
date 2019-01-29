public class Solution {
	   
public boolean isPalindrome(int x) {
        
        if(x<0) return false;
        
       int tail = 0;
        int result = 0;
        int newresult = 0;
        int original = x;
        while(x > 0){
            tail = x%10;
            newresult = result*10 + tail;
            if((newresult - tail)/10 != result){
                return false;
            }
            result = newresult;
            x=x/10;
        }
        if(result == original){
            return true;
        }else{
            return false;
        }
    }

		public static void main(String[] args) {
			Solution solution = new Solution();
			
			int input = 121;
			boolean result = solution.isPalindrome(input);
	
			System.out.println(result);
     }
}


// time complexity: o(n)
// space complexity: o(1)

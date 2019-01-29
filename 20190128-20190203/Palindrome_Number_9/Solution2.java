// only deal with half of the number

public class Solution {
	   
	public boolean isPalindrome(int x) {
	    if (x<0 || (x!=0 && x%10==0)) return false;
	    int rev = 0;
	    while (x>rev){
	    	rev = rev*10 + x%10;
	    	x = x/10;
	    }
	    return (x==rev || x==rev/10);
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

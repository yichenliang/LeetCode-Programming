import java.util.ArrayList;

class Solution {
    public boolean isPalindrome(int x) {
    	
    	ArrayList<Integer> arrL = new ArrayList<>();
    	
    	if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
    	
    	do {
    		arrL.add(x % 10);
    		x /= 10;
    	}while(x != 0);
    	
    	int s = arrL.size();
    	for (int i = 0; i <= s/2; i++) {
    		if(arrL.get(i) == arrL.get(s-1-i)) {
    			continue;
    		}
    		else {return false;}
    	}
    	
    	return true;
        
    }
	
	public static void main(String args[])
    {
		Solution solution = new Solution();
		int input = 23432;
    	boolean res = solution.isPalindrome(input);
    	System.out.println(res);
    }
}
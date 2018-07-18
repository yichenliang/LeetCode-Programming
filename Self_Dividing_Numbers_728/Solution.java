//728. Self Dividing Numbers
//Approach 

import java.util.List;
import java.util.ArrayList;
public class Solution {
	 
	boolean isSelfDividingNumbers(int num) {
		  
	      int originNum = num;
	      int digit = 0;
	      
	      if( (num/10 == 0) && (num%10 != 0)) return true;
		  
	      while(num != 0) {
			digit = num % 10;
			if(digit == 0) return false;
			if(originNum % digit != 0) return false;
			num = num / 10;
		  }
		  return true;
	  } 
	
	public List<Integer> selfDividingNumbers(int left, int right) {
    	  
    	  List<Integer> result = new ArrayList<>(); 
    	  for(int i = left; i < right + 1; i++) {
    		  if(isSelfDividingNumbers(i)) {
    			  result.add(i);
    		  }
    	  }
        return result;
    }
	
		
	  public static void main(String args[]) {
		
		Solution solution = new Solution();
		int leftBound = 1;
		int rightBound = 22;
		List<Integer> res;
		res = solution.selfDividingNumbers(leftBound, rightBound);
		System.out.println(res);
    }
}

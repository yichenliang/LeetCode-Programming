//118. Pascal's Triangle
//Approach 0 

import java.util.ArrayList;
import java.util.List;

class Solution {
    
	 public List<List<Integer>> generate(int numRows) {
		 
		 List<List<Integer>> pascalTriangle = new ArrayList<List<Integer>>(numRows);  
		 
		 if(numRows == 0 ) return pascalTriangle;
		 
		 List<Integer> l1 = new ArrayList<Integer>();
		 l1.add(1);
		 pascalTriangle.add(l1);
		 if(numRows == 1 ) return pascalTriangle;
		 
		 List<Integer> l2 = new ArrayList<Integer>();
		 l2.add(1);
		 l2.add(1);
		 pascalTriangle.add(l2);
		 if(numRows == 2 ) return pascalTriangle;
		 		 
		 for(int i = 2; i < numRows; i++ ) {
			 
			 List<Integer> li = new ArrayList<Integer>();
			 List<Integer> liFormer = pascalTriangle.get(i-1);
			 
			 for(int j = 0; j < i + 1; j++) {
				 if(j == 0) {
					 li.add(1);
				 }
				 else if(j == i) {
					 li.add(1);
				 }
				 else {
					 li.add(liFormer.get(j-1) + liFormer.get(j));
				 }
			}
			  pascalTriangle.add(li);
		 }
		 
		 return pascalTriangle;  
	     
	    }


	  public static void main(String args[]) {
		Solution solution = new Solution();
		int input = 5;
		List<List<Integer>>res = solution.generate(input);
    	System.out.println(res);
    }
}
